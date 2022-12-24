package net.alchemycraft.inventory.alchemybook;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;

public final class AlchemynomiconInventory implements Inventory {
    private final ItemStack instance;

    private Integer pages;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public AlchemynomiconInventory(ItemStack instance) {
        this.instance = instance;

        NbtCompound pages_tag = instance.getSubNbt("Pages");

        if (pages_tag != null) {
            pages = pages_tag.getInt("Pages");
        }
    }

    @Override
    public void clear() {
        this.items.clear();
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.items.get(slot);
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public void markDirty() {
        NbtCompound pages_tag = instance.getSubNbt("Pages");
        pages_tag.putInt("Pages", pages);
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(items, slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = Inventories.splitStack(this.items, slot, amount);
        return itemStack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.items.set(slot, stack);
    }

    @Override
    public int size() {
        return this.items.size();
    }
}
