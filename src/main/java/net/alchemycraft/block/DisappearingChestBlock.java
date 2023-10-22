package net.alchemycraft.block;

import java.util.Optional;
import java.util.function.BiPredicate;

import org.jetbrains.annotations.Nullable;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.alchemycraft.config.BlockEntityTypesConfig;
import net.alchemycraft.entity.DisappearingChestBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class DisappearingChestBlock
        extends AbstractChestBlock<DisappearingChestBlockEntity> {

    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final EnumProperty<ChestType> CHEST_TYPE = Properties.CHEST_TYPE;

    protected static final VoxelShape DOUBLE_NORTH_SHAPE = Block.createCuboidShape(1.0, 0.0, 0.0, 15.0, 14.0, 15.0);
    protected static final VoxelShape DOUBLE_SOUTH_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 14.0, 16.0);
    protected static final VoxelShape DOUBLE_WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 1.0, 15.0, 14.0, 15.0);
    protected static final VoxelShape DOUBLE_EAST_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 16.0, 14.0, 15.0);
    protected static final VoxelShape SINGLE_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 14.0, 15.0);

    private static final DoubleBlockProperties.PropertyRetriever<DisappearingChestBlockEntity, Optional<Inventory>> INVENTORY_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<DisappearingChestBlockEntity, Optional<Inventory>>() {

        @Override
        public Optional<Inventory> getFromBoth(DisappearingChestBlockEntity chestBlockEntity,
                DisappearingChestBlockEntity chestBlockEntity2) {
            return Optional.of(new DoubleInventory(chestBlockEntity, chestBlockEntity2));
        }

        @Override
        public Optional<Inventory> getFrom(DisappearingChestBlockEntity chestBlockEntity) {
            return Optional.of(chestBlockEntity);
        }

        @Override
        public Optional<Inventory> getFallback() {
            return Optional.empty();
        }
    };

    private static final DoubleBlockProperties.PropertyRetriever<DisappearingChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<DisappearingChestBlockEntity, Optional<NamedScreenHandlerFactory>>() {

        @Override
        public Optional<NamedScreenHandlerFactory> getFromBoth(final DisappearingChestBlockEntity chestBlockEntity,
                final DisappearingChestBlockEntity chestBlockEntity2) {
            final DoubleInventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
            return Optional.of(new NamedScreenHandlerFactory() {

                @Override
                @Nullable
                public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                        chestBlockEntity.checkLootInteraction(playerInventory.player);
                        chestBlockEntity2.checkLootInteraction(playerInventory.player);
                        return GenericContainerScreenHandler.createGeneric9x6(i, playerInventory, inventory);
                    }
                    return null;
                }

                @Override
                public Text getDisplayName() {
                    if (chestBlockEntity.hasCustomName())
                        return chestBlockEntity.getDisplayName();

                    if (chestBlockEntity2.hasCustomName())
                        return chestBlockEntity2.getDisplayName();

                    return Text.translatable("container.alchemycraft.disappearing_chest_double");
                }
            });
        }

        @Override
        public Optional<NamedScreenHandlerFactory> getFrom(DisappearingChestBlockEntity chestBlockEntity) {
            return Optional.of(chestBlockEntity);
        }

        @Override
        public Optional<NamedScreenHandlerFactory> getFallback() {
            return Optional.empty();
        }
    };

    public DisappearingChestBlock(Settings settings) {
        super(settings, () -> BlockEntityTypesConfig.DISAPPEARING_CHEST);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH).with(CHEST_TYPE, ChestType.SINGLE));
    }

    public static DoubleBlockProperties.PropertyRetriever<DisappearingChestBlockEntity, Float2FloatFunction> getAnimationProgressRetriever(
            final LidOpenable progress) {
        return new DoubleBlockProperties.PropertyRetriever<DisappearingChestBlockEntity, Float2FloatFunction>() {

            @Override
            public Float2FloatFunction getFromBoth(DisappearingChestBlockEntity chestBlockEntity,
                    DisappearingChestBlockEntity chestBlockEntity2) {
                return tickDelta -> Math.max(chestBlockEntity.getAnimationProgress(tickDelta),
                        chestBlockEntity2.getAnimationProgress(tickDelta));
            }

            @Override
            public Float2FloatFunction getFrom(DisappearingChestBlockEntity chestBlockEntity) {
                return chestBlockEntity::getAnimationProgress;
            }

            @Override
            public Float2FloatFunction getFallback() {
                return progress::getAnimationProgress;
            }
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction3;
        ChestType chestType = ChestType.SINGLE;
        Direction direction = ctx.getHorizontalPlayerFacing().getOpposite();
        // FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = ctx.shouldCancelInteraction();
        Direction direction2 = ctx.getSide();
        if (direction2.getAxis().isHorizontal() && bl
                && (direction3 = this.getNeighborChestDirection(ctx, direction2.getOpposite())) != null
                && direction3.getAxis() != direction2.getAxis()) {
            direction = direction3;
            // ChestType chestType2 =
            chestType = direction.rotateYCounterclockwise() == direction2.getOpposite()
                    ? ChestType.RIGHT
                    : ChestType.LEFT;
        }
        if (chestType == ChestType.SINGLE && !bl) {
            if (direction == this.getNeighborChestDirection(ctx, direction.rotateYClockwise())) {
                chestType = ChestType.LEFT;
            } else if (direction == this.getNeighborChestDirection(ctx, direction.rotateYCounterclockwise())) {
                chestType = ChestType.RIGHT;
            }
        }

        return this.getDefaultState().with(FACING, direction).with(CHEST_TYPE, chestType);
    }

    @Nullable
    private Direction getNeighborChestDirection(ItemPlacementContext ctx, Direction dir) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));
        return blockState.isOf(this) && blockState.get(CHEST_TYPE) == ChestType.SINGLE ? blockState.get(FACING) : null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, CHEST_TYPE);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DisappearingChestBlockEntity(pos, state);
    }

    public static boolean isChestBlocked(WorldAccess world, BlockPos pos) {
        return false;
    }

    public static Direction getFacing(BlockState state) {
        Direction direction = state.get(FACING);
        return state.get(CHEST_TYPE) == ChestType.LEFT ? direction.rotateYClockwise()
                : direction.rotateYCounterclockwise();
    }

    public static DoubleBlockProperties.Type getDoubleBlockType(BlockState state) {
        ChestType chestType = state.get(CHEST_TYPE);
        if (chestType == ChestType.SINGLE) {
            return DoubleBlockProperties.Type.SINGLE;
        }
        if (chestType == ChestType.RIGHT) {
            return DoubleBlockProperties.Type.FIRST;
        }
        return DoubleBlockProperties.Type.SECOND;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof DisappearingChestBlockEntity) {
            var blockEntity = (DisappearingChestBlockEntity) world.getBlockEntity(pos);

            if (blockEntity.destructionTimer.isActive())
                return ActionResult.FAIL;
        }

        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        NamedScreenHandlerFactory namedScreenHandlerFactory = this.createScreenHandlerFactory(state, world, pos);
        if (namedScreenHandlerFactory != null) {
            player.openHandledScreen(namedScreenHandlerFactory);
            PiglinBrain.onGuardedBlockInteracted(player, true);
        }

        return ActionResult.CONSUME;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        DisappearingChestBlockEntity blockEntity = this.getBlockEntity(world, pos);

        if (blockEntity.neighborBlockPos != null && !player.isCreative()) {
            if (this.getBlockEntity(world, blockEntity.neighborBlockPos) != null) {
                var neighborBlockEntity = this.getBlockEntity(world, blockEntity.neighborBlockPos);
                neighborBlockEntity.neighborBlockPos = null;
                world.breakBlock(blockEntity.neighborBlockPos, true);
            }
        }

        super.onBreak(world, pos, state, player);
    }

    @Override
    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER).orElse(null);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(CHEST_TYPE) == ChestType.SINGLE) {
            return SINGLE_SHAPE;
        }
        switch (DisappearingChestBlock.getFacing(state)) {
            default: {
                return DOUBLE_NORTH_SHAPE;
            }
            case SOUTH: {
                return DOUBLE_SOUTH_SHAPE;
            }
            case WEST: {
                return DOUBLE_WEST_SHAPE;
            }
            case EAST:
        }
        return DOUBLE_EAST_SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler
                .calculateComparatorOutput(DisappearingChestBlock.getInventory(this, state, world, pos, false));
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        DisappearingChestBlockEntity blockEntity = this.getBlockEntity(world, pos);

        if (itemStack.hasCustomName()) {
            blockEntity.setCustomName(itemStack.getName());
        }

        var chestType = state.get(CHEST_TYPE);

        if (chestType != ChestType.SINGLE && blockEntity != null) {
            var facing = state.get(FACING);

            if (chestType == ChestType.LEFT) {
                if (facing == Direction.EAST)
                    blockEntity.neighborBlockPos = pos.south();
                else if (facing == Direction.WEST)
                    blockEntity.neighborBlockPos = pos.north();
                else if (facing == Direction.NORTH)
                    blockEntity.neighborBlockPos = pos.east();
                else if (facing == Direction.SOUTH)
                    blockEntity.neighborBlockPos = pos.west();

            } else if (chestType == ChestType.RIGHT) {
                if (facing == Direction.EAST)
                    blockEntity.neighborBlockPos = pos.north();
                else if (facing == Direction.WEST)
                    blockEntity.neighborBlockPos = pos.south();
                else if (facing == Direction.NORTH)
                    blockEntity.neighborBlockPos = pos.west();
                else if (facing == Direction.SOUTH)
                    blockEntity.neighborBlockPos = pos.east();
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.isOf(newState.getBlock())) {
            return;
        }
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof Inventory) {
            ItemScatterer.spawn(world, pos, (Inventory) ((Object) blockEntity));
            world.updateComparators(pos, this);
        }

        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof DisappearingChestBlockEntity) {
            ((DisappearingChestBlockEntity) blockEntity).onScheduledTick();
        }
    }

    public BlockEntityType<? extends DisappearingChestBlockEntity> getExpectedEntityType() {
        return this.entityTypeRetriever.get();
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
            WorldAccess world, BlockPos pos, BlockPos neighborPos) {

        DisappearingChestBlockEntity blockEntity = this.getBlockEntity(world, pos);

        if (neighborState.isOf(this) && direction.getAxis().isHorizontal()) {
            ChestType chestType = neighborState.get(CHEST_TYPE);

            if (state.get(CHEST_TYPE) == ChestType.SINGLE
                    && chestType != ChestType.SINGLE
                    && state.get(FACING) == neighborState.get(FACING)
                    && DisappearingChestBlock.getFacing(neighborState) == direction.getOpposite()) {

                if (blockEntity != null) {
                    blockEntity.neighborBlockPos = neighborPos;
                }

                return (BlockState) state.with(CHEST_TYPE, chestType.getOpposite());
            }
        } else if (DisappearingChestBlock.getFacing(state) == direction) {
            return (BlockState) state.with(CHEST_TYPE, ChestType.SINGLE);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Nullable
    public static Inventory getInventory(DisappearingChestBlock block, BlockState state, World world, BlockPos pos,
            boolean ignoreBlocked) {
        return block.getBlockEntitySource(state, world, pos, ignoreBlocked).apply(INVENTORY_RETRIEVER).orElse(null);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state,
            BlockEntityType<T> type) {
        return DisappearingChestBlock.validateTicker(type, this.getExpectedEntityType(),
                DisappearingChestBlockEntity::tick);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public DoubleBlockProperties.PropertySource<? extends DisappearingChestBlockEntity> getBlockEntitySource(
            BlockState state, World world2, BlockPos pos2, boolean ignoreBlocked) {
        BiPredicate<WorldAccess, BlockPos> biPredicate = ignoreBlocked ? (world, pos) -> false
                : DisappearingChestBlock::isChestBlocked;
        return DoubleBlockProperties.toPropertySource(this.entityTypeRetriever.get(),
                DisappearingChestBlock::getDoubleBlockType, DisappearingChestBlock::getFacing, FACING, state, world2,
                pos2, biPredicate);
    }

    public DisappearingChestBlockEntity getBlockEntity(WorldAccess world, BlockPos pos) {
        BlockEntity abstractBlockEntity = null;
        DisappearingChestBlockEntity blockEntity = null;

        if ((abstractBlockEntity = world.getBlockEntity(pos)) instanceof DisappearingChestBlockEntity) {
            blockEntity = (DisappearingChestBlockEntity) abstractBlockEntity;
        }

        return blockEntity;
    }
}
