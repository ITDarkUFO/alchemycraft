package net.alchemycraft.inventory.slot;

import net.alchemycraft.config.TagsConfig;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class PowderStorageSlot extends Slot {
    
    public PowderStorageSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    
    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isIn(TagsConfig.Items.POWDER_STORAGES);
    }
}
