package net.alchemycraft.inventory.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

public class ItemSlot extends Slot {

    private Item item;
    private TagKey<Item> tag;
    private DefaultedList<ItemStack> list;

    private Boolean takeable;

    /**
     * Constructor for a slot that only accepts specified item.
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, Item item) {
        this(inventory, index, x, y, item, true);
    }

    /**
     * Constructor for a slot that only accepts specified item.
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, Item item, Boolean takeable) {
        this(inventory, index, x, y);
        this.item = item;
        this.takeable = takeable;
    }

    /**
     * Constructor for a slot that only accepts items with specified tag.
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, TagKey<Item> tag) {
        this(inventory, index, x, y, tag, true);
    }

    /**
     * Constructor for a slot that only accepts items with specified tag.
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, TagKey<Item> tag, Boolean takeable) {
        this(inventory, index, x, y);
        this.tag = tag;
        this.takeable = takeable;
    }

    /**
     * Constructor for a slot that only accepts items from specified list.
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, DefaultedList<ItemStack> list) {
        this(inventory, index, x, y, list, true);
    }

    /**
     * Constructor for a slot that only accepts items from specified list.
     */
    public ItemSlot(Inventory inventory, int index, int x, int y, DefaultedList<ItemStack> list, Boolean takeable) {
        this(inventory, index, x, y);
        this.list = list;
        this.takeable = takeable;
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
        else if (list != null)
            for (ItemStack itemStack : list)
                if (stack == itemStack)
                    return true;

        return false;
    }

    @Override
    public boolean canTakeItems(PlayerEntity playerEntity) {
        return takeable;
    }
}
