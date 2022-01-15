package net.alchemycraft.screens;

import net.alchemycraft.configs.ConfigHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class HandlerMortar extends ScreenHandler {
    private final Inventory inventory;
    // private final ScreenHandlerContext context;

    public HandlerMortar(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(4));
    }

    public HandlerMortar(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ConfigHandlers.MORTAR_HANDLER, syncId);
        checkSize(inventory, 4);
        this.inventory = inventory;
        // this.context = context;
        inventory.onOpen(playerInventory.player);

        // Mortar Inventory - 0, 1
        int sizeY = 2, sizeX = 1;
        for (int y = 0; y < sizeY; ++y) {
            for (int x = 0; x < sizeX; ++x) {
                this.addSlot(new Slot(inventory, x + y * 1, 44 + x * 18, 26 + y * 18));
            }
        }

        int pestleSlot = 2;
        this.addSlot(new Slot(inventory, pestleSlot, 44 + 18 * 2, 26));

        // Output slot - 3
        this.addSlot(new Slot(inventory, sizeY * sizeX + 1, 116, 35));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    // 4 - ...
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

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty())
                slot.setStack(ItemStack.EMPTY);
            else
                slot.markDirty();
        }
        return newStack;
    }

    public boolean isOutputSlot(Slot slot) {
        if (slot.id == this.inventory.size() - 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        if (isOutputSlot(slot))
            return false;
        if (slot.id == 1 && stack.getItem() != Items.BOWL)
            return false;
        return true;
    }

    @Override
    public Slot getSlot(int index) {
        return super.getSlot(index);
    }
}