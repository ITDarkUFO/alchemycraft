package net.alchemycraft.inventories;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;

public class InventoryCraftingMortar implements Inventory, RecipeInputProvider {

    DefaultedList<ItemStack> stacks = DefaultedList.ofSize(4, ItemStack.EMPTY);
    ScreenHandler screenHandler;

    public InventoryCraftingMortar(ScreenHandler screenHandler) {
        this.screenHandler = screenHandler;
    }

    @Override
    public void clear() {
        this.stacks.clear();
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {
        this.stacks.forEach((finder::addInput));
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.stacks.get(slot);
    }

    @Override
    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    @Override
    public void markDirty() {
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(stacks, slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = Inventories.splitStack(this.stacks, slot, amount);

        if (!itemStack.isEmpty()) {
            this.screenHandler.onContentChanged(this);
        }
        return itemStack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.stacks.set(slot, stack);
        this.screenHandler.onContentChanged(this);
    }

    @Override
    public int size() {
        return this.stacks.size();
    }

}
