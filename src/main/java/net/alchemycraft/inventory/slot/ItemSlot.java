package net.alchemycraft.inventory.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.tag.TagKey;
import net.minecraft.util.collection.DefaultedList;

public class ItemSlot extends Slot {

    private Item item;
    private TagKey<Item> tag;
    private DefaultedList<ItemStack> list;

    /**
     * Constructor for a slot that only accepts specified item.
     * 
     * @param inventory
     * @param index
     * @param x
     * @param y
     * @param item
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, Item item) {
        this(inventory, index, x, y);
        this.item = item;
    }

    /**
     * Constructor for a slot that only accepts items with specified tag.
     * 
     * @param inventory
     * @param index
     * @param x
     * @param y
     * @param tag
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, TagKey<Item> tag) {
        this(inventory, index, x, y);
        this.tag = tag;
    }

    /**
     * Constructor for a slot that only accepts items from specified list.
     * 
     * @param inventory
     * @param index
     * @param x
     * @param y
     * @param list
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, DefaultedList<ItemStack> list) {
        this(inventory, index, x, y);
        this.list = list;
    }

    /**
     * Private constructor.
     */
    private ItemSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (item != null)
            return stack.getItem() == item;
        else if (tag != null)
            return stack.getRegistryEntry().isIn(tag);
        else if (list != null) {
            for (ItemStack itemStack : list) {
                if (stack == itemStack)
                    return true;
            }
        }

        return false;
    }

}
