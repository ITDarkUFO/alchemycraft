package net.alchemycraft.entity;

import java.util.ArrayList;
import java.util.List;

import net.alchemycraft.config.BlockEntityTypesConfig;
import net.alchemycraft.libs.utils.TickTimer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestLidAnimator;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DisappearingChestBlockEntity
        extends LootableContainerBlockEntity
        implements LidOpenable {

    public BlockPos neighborBlockPos = null;
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
    private final ChestLidAnimator lidAnimator = new ChestLidAnimator();
    public final TickTimer destructionTimer = new TickTimer(5);

    private final ViewerCountManager stateManager = new ViewerCountManager() {

        @Override
        protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
            playSound(world, pos, state, SoundEvents.BLOCK_CHEST_OPEN);
        }

        @Override
        protected void onContainerClose(World world, BlockPos pos, BlockState state) {
            playSound(world, pos, state, SoundEvents.BLOCK_CHEST_CLOSE);
        }

        @Override
        protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount,
                int newViewerCount) {
            onInvOpenOrClose(world, pos, state, oldViewerCount, newViewerCount);
        }

        @Override
        protected boolean isPlayerViewing(PlayerEntity player) {
            if (player.currentScreenHandler instanceof GenericContainerScreenHandler) {
                Inventory inventory = ((GenericContainerScreenHandler) player.currentScreenHandler).getInventory();
                return inventory == DisappearingChestBlockEntity.this || inventory instanceof DoubleInventory
                        && ((DoubleInventory) inventory).isPart(DisappearingChestBlockEntity.this);
            }
            return false;
        }
    };

    public DisappearingChestBlockEntity(BlockPos pos, BlockState state) {
        this(BlockEntityTypesConfig.DISAPPEARING_CHEST, pos, state);
    }

    protected DisappearingChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos,
            BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        ChestType chestType = state.get(ChestBlock.CHEST_TYPE);
        if (chestType == ChestType.LEFT) {
            return;
        }
        double d = (double) pos.getX() + 0.5;
        double e = (double) pos.getY() + 0.5;
        double f = (double) pos.getZ() + 0.5;
        if (chestType == ChestType.RIGHT) {
            Direction direction = ChestBlock.getFacing(state);
            d += (double) direction.getOffsetX() * 0.5;
            f += (double) direction.getOffsetZ() * 0.5;
        }
        world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
    }

    protected void onInvOpenOrClose(World world, BlockPos pos, BlockState state, int oldViewerCount,
            int newViewerCount) {
        Block block = state.getBlock();
        world.addSyncedBlockEvent(pos, block, 1, newViewerCount);
    }

    @Override
    public int size() {
        return 27;
    }

    @Override
    public float getAnimationProgress(float tickDelta) {
        return this.lidAnimator.getProgress(tickDelta);
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.alchemycraft.disappearing_chest");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inventory);
        }

        List<Integer> neighborPos1 = new ArrayList<>();

        for (var item : nbt.getIntArray("NeighborPosition")) {
            neighborPos1.add(item);
        }

        neighborBlockPos = new BlockPos(neighborPos1.get(0), neighborPos1.get(1), neighborPos1.get(2));
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory);
        }

        nbt.putIntArray("NeighborPosition", new ArrayList<Integer>(
                List.of(neighborBlockPos.getX(), neighborBlockPos.getY(), neighborBlockPos.getZ())));
    }

    public static void tick(World world, BlockPos pos, BlockState state,
            DisappearingChestBlockEntity blockEntity) {
        blockEntity.lidAnimator.step();
        blockEntity.destructionTimer.step();

        if (blockEntity.destructionTimer.isComplete())
            world.breakBlock(pos, true);
    }

    @Override
    public boolean onSyncedBlockEvent(int type, int data) {
        if (type == 1) {
            this.lidAnimator.setOpen(data > 0);
            return true;
        }
        return super.onSyncedBlockEvent(type, data);
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());

            Inventory doubleInventory = ((GenericContainerScreenHandler) player.currentScreenHandler).getInventory();
            Boolean isEmpty = true;

            if (doubleInventory == DisappearingChestBlockEntity.this
                    || doubleInventory instanceof DoubleInventory
                            && ((DoubleInventory) doubleInventory).isPart(DisappearingChestBlockEntity.this)) {
                if (!doubleInventory.isEmpty()) {
                    isEmpty = false;
                }
            } else {
                for (ItemStack itemStack : inventory) {
                    if (itemStack.getItem() != Items.AIR) {
                        isEmpty = false;
                        break;
                    }
                }
            }

            if (isEmpty && !player.isCreative())
                this.destructionTimer.start();
        }
    }

    public static int getPlayersLookingInChestCount(BlockView world, BlockPos pos) {
        BlockEntity blockEntity;
        BlockState blockState = world.getBlockState(pos);
        if (blockState.hasBlockEntity()
                && (blockEntity = world.getBlockEntity(pos)) instanceof DisappearingChestBlockEntity) {
            return ((DisappearingChestBlockEntity) blockEntity).stateManager.getViewerCount();
        }
        return 0;
    }

    public static void copyInventory(DisappearingChestBlockEntity from, DisappearingChestBlockEntity to) {
        DefaultedList<ItemStack> defaultedList = from.getInvStackList();
        from.setInvStackList(to.getInvStackList());
        to.setInvStackList(defaultedList);
    }

    public void onScheduledTick() {
        if (!this.removed) {
            this.stateManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }
    }
}
