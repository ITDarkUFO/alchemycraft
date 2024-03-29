package net.alchemycraft.inventories.slots;

import net.alchemycraft.configs.ConfigTags;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SlotPestle extends Slot {

    public SlotPestle(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }
    
    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getRegistryEntry().isIn(ConfigTags.Items.PESTLES);
    }
}
