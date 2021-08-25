package net.alchemycraft.block.mortar.handler;

import net.alchemycraft.registry.AlchemyHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.LiteralText;

public class AlchemyMortarHandler extends ScreenHandler {
    private final Inventory inventory;

    public AlchemyMortarHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3));
    }

    public AlchemyMortarHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(AlchemyHandlers.MORTAR_HANDLER, syncId);
        checkSize(inventory, 3);
        this.inventory = inventory;

        inventory.onOpen(playerInventory.player);

        // Our inventory
        int sizeY = 2, sizeX = 1;
        for (int y = 0; y < sizeY; ++y) {
            for (int x = 0; x < sizeX; ++x) {
                this.addSlot(new Slot(inventory, x + y * 1, 44 + x * 18, 26 + y * 18));
            }
        }

        // Output slot (The last one)
        this.addSlot(new Slot(inventory, sizeY * sizeX, 116, 35));

        // The player inventory
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // The player Hotbar
        for (int m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }

    // Logic
    @Override
    public void onSlotClick(int slotId, int button, SlotActionType actionType, PlayerEntity player) {
        if (inventory.size() > slotId && slotId != 2) {
            if (inventory.getStack(slotId) != null) {
                player.sendMessage(new LiteralText("input slots"), false);
                super.onSlotClick(slotId, button, actionType, player);

                player.sendMessage(new LiteralText("output slot"), false);
            }
        }
        else if (slotId == 2) {
            player.sendMessage(new LiteralText("output slot"), false);
            super.onSlotClick(slotId, button, actionType, player);
        }
        else super.onSlotClick(slotId, button, actionType, player);
    }

    @Override
    public boolean canInsertIntoSlot(Slot slot) {
        if (slot.id == 2)
            return false;
        else
            return true;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}