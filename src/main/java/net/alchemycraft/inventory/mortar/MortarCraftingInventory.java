package net.alchemycraft.inventory.mortar;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import java.util.List;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;

public class MortarCraftingInventory implements Inventory, RecipeInputProvider {

    DefaultedList<ItemStack> items = DefaultedList.ofSize(4, ItemStack.EMPTY);
    ScreenHandler screenHandler;

    public MortarCraftingInventory(ScreenHandler screenHandler) {
        this.screenHandler = screenHandler;
    }

    @Override
    public void clear() {
        this.items.clear();
    }

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {
        this.items.forEach((finder::addInput));
    }

    List<ItemStack> getInputStacks() {
        //TODO: Проверить, что выводит
        // return items.subList(1, 3);
        return List.of(items.get(1), items.get(2));
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
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(items, slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = Inventories.splitStack(this.items, slot, amount);

        if (!itemStack.isEmpty()) {
            this.screenHandler.onContentChanged(this);
        }
        return itemStack;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.items.set(slot, stack);
        this.screenHandler.onContentChanged(this);
    }

    @Override
    public int size() {
        return this.items.size();
    }

}
