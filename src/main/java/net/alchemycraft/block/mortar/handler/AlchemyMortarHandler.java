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
    public Slot getSlot(int index) {
        // DEBUG
        System.out.println("getSlot: " + index);
        return super.getSlot(index);
    }

    @Override
    public boolean canInsertIntoSlot(Slot slot) {
        // DEBUG
        System.out.println("canInsertIntoSlot: " + slot.id);
        if (slot.id >= inventory.size())
            return true;
        if (slot.id == 0 || slot.id == 1)
            return true;
        return false;
    }

    public boolean isOutputSlot(Slot slot) {
        // DEBUG
        System.out.println("isOutputSlot: " + slot.id);
        if (slot.id == inventory.size() - 1)
            return true;
        return false;
    }

    @Override
    public void onSlotClick(int index, int button, SlotActionType actionType, PlayerEntity player) {
        // DEBUG
        System.out.println("onSlotClick: " + index + " " + button + " " + actionType.name());
        player.sendMessage(new LiteralText("Inventory size: " + inventory.size() + ", Index: " + index), false);
        if (index == -999 || index == -1) {
            super.onSlotClick(index, button, actionType, player);
            return;
        }
        if (canInsertIntoSlot(getSlot(index))) {
            super.onSlotClick(index, button, actionType, player);
        } else {
            if (isOutputSlot(getSlot(index))) {
                if (inventory.getStack(index) != ItemStack.EMPTY) {
                    super.onSlotClick(index, button, actionType, player);
                }
            }
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
        if (!isOutputSlot(slot))
        {
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
    
                if (originalStack.isEmpty()) {
                    slot.setStack(ItemStack.EMPTY);
                } else {
                    slot.markDirty();
                }
            }
            return newStack;
        }
        return newStack;
    }
}