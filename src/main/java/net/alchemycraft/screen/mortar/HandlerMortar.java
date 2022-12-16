package net.alchemycraft.screen.mortar;

import java.util.Optional;

import net.alchemycraft.config.BlocksConfig;
import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.inventory.mortar.MortarCraftingInventory;
import net.alchemycraft.inventory.mortar.MortarResultSlot;
import net.alchemycraft.inventory.slot.PestleSlot;
import net.alchemycraft.inventory.slot.PowderStorageSlot;
import net.alchemycraft.recipe.RecipesMortar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class HandlerMortar extends AbstractRecipeScreenHandler<MortarCraftingInventory> {
    private final MortarCraftingInventory input;
    private final CraftingResultInventory result;
    public final PlayerInventory playerInventory;
    private final ScreenHandlerContext screenHandlerContext;

    public HandlerMortar(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public HandlerMortar(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(HandlersConfig.MORTAR_HANDLER, syncId);
        this.playerInventory = playerInventory;
        this.input = new MortarCraftingInventory(this);
        this.result = new CraftingResultInventory();
        this.screenHandlerContext = context;

        checkSize(this.input, 4);
        this.input.onOpen(playerInventory.player);

        // Mortar Inventory
        // Pestle Slot - 0
        this.addSlot(new PestleSlot(this.input, 0, 17, 35));

        // Input Slot
        this.addSlot(new Slot(this.input, 1, 44, 26));

        // Input Slot for powder storage item
        this.addSlot(new PowderStorageSlot(this.input, 2, 44, 44));

        // Output slot - 3
        this.addSlot(new MortarResultSlot(playerInventory.player, this.input, this.result, 3, 116, 35));

        // Player Inventory
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int y = 0; y < 3; ++y)
            for (int x = 0; x < 9; ++x)
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    protected static void updateResult(ScreenHandler handler, World world, PlayerEntity playerEntity,
            MortarCraftingInventory craftingInventory, CraftingResultInventory resultInventory) {
        if (!world.isClient) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) playerEntity;
            ItemStack itemStack = ItemStack.EMPTY;
            Optional<RecipesMortar> optional = world.getServer().getRecipeManager()
                    .getFirstMatch(RecipesMortar.Type.INSTANCE, craftingInventory, world);
            if (optional.isPresent()) {
                RecipesMortar recipeMortar = optional.get();
                if (resultInventory.shouldCraftRecipe(world, serverPlayerEntity, recipeMortar)) {
                    itemStack = recipeMortar.craft(craftingInventory);
                }
            }

            resultInventory.setStack(3, itemStack);
            handler.setPreviousTrackedSlot(3, itemStack);
            serverPlayerEntity.networkHandler.sendPacket(
                    new ScreenHandlerSlotUpdateS2CPacket(handler.syncId, handler.nextRevision(), 3, itemStack));
        }
    }

    public void onContentChanged(Inventory inventory) {
        this.screenHandlerContext
                .run((world, pos) -> updateResult(this, world, this.playerInventory.player, this.input, this.result));
    }

    public void close(PlayerEntity player) {
        super.close(player);
        this.screenHandlerContext.run((world, pos) -> this.dropInventory(player, this.input));
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasStack()) {
            ItemStack oldStack = slot.getStack();
            newStack = oldStack.copy();

            if (index == 3) {
                this.screenHandlerContext.run((world, pos) -> oldStack.getItem().onCraft(oldStack, world, player));
                if (!this.insertItem(oldStack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickTransfer(oldStack, newStack);
            } else if (index >= 4 && index <= 30) {
                if (!this.insertItem(oldStack, 0, 3, false)) {
                    if (!this.insertItem(oldStack, 31, 40, false))
                        return ItemStack.EMPTY;
                }
            } else if (index >= 31 && index <= 39) {
                if (!this.insertItem(oldStack, 0, 3, false)) {
                    if (!this.insertItem(oldStack, 4, 31, false))
                        return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(oldStack, 4, 40, false)) {
                return ItemStack.EMPTY;
            }

            if (oldStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (oldStack.getCount() == newStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, oldStack);
            if (index == 3) {
                player.dropItem(oldStack, false);
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.screenHandlerContext, player, BlocksConfig.GRANITE_MORTAR) ||
                canUse(this.screenHandlerContext, player, BlocksConfig.ANDESITE_MORTAR) ||
                canUse(this.screenHandlerContext, player, BlocksConfig.DIORITE_MORTAR);
    }

    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {
        this.input.provideRecipeInputs(finder);
    }

    @Override
    public void clearCraftingSlots() {
        this.input.clear();
        this.result.clear();
    }

    @Override
    public boolean matches(Recipe<? super MortarCraftingInventory> recipe) {
        return recipe.matches(this.input, this.playerInventory.player.world);
    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 3;
    }

    @Override
    public int getCraftingWidth() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getCraftingHeight() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getCraftingSlotCount() {
        return 3;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return null;
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        return index != this.getCraftingResultSlotIndex();
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.result && super.canInsertIntoSlot(stack, slot);
    }
}