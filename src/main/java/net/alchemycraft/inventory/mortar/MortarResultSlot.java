package net.alchemycraft.inventory.mortar;

import java.util.Optional;

import net.alchemycraft.recipe.RecipesMortar;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;

public class MortarResultSlot extends Slot {

    private final MortarCraftingInventory input;
    private final PlayerEntity player;
    private int amount;

    public MortarResultSlot(PlayerEntity player, MortarCraftingInventory input, Inventory inventory, int index, int x,
            int y) {
        super(inventory, index, x, y);
        this.player = player;
        this.input = input;
        this.amount = 0;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }

        return super.takeStack(amount);
    }

    @Override
    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        this.onCrafted(stack);
    }

    @Override
    protected void onTake(int amount) {
        this.amount += amount;
    }

    @Override
    protected void onCrafted(ItemStack stack) {
        if (amount > 0) {
            stack.onCraft(player.world, player, amount);
        }
        if (inventory instanceof RecipeUnlocker) {
            ((RecipeUnlocker) inventory).unlockLastRecipe(player);
        }
        amount = 0;
    }

    @Override
    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);

        DefaultedList<ItemStack> defaultedList = player.world.getRecipeManager()
                .getRemainingStacks(RecipesMortar.Type.INSTANCE, this.input, player.world);
            
        Optional<RecipesMortar> ingredients = player.world.getRecipeManager().getFirstMatch(RecipesMortar.Type.INSTANCE, this.input, player.world);

        // Decrease Pestle Durability
        ItemStack pestleSlot = this.input.getStack(0);

        if (pestleSlot.getDamage() != pestleSlot.getMaxDamage() - 1) {
            int currentDamage = pestleSlot.getDamage();
            this.input.getStack(0).setDamage(currentDamage + 1);
        } else
            this.input.setStack(0, ItemStack.EMPTY);

        // Remove recipe items
        for (int i = 1; i < defaultedList.size() - 1; ++i) {
            ItemStack oldStack = this.input.getStack(i);
            ItemStack newStack = defaultedList.get(i);
            if (!oldStack.isEmpty()) {
                int removed_items_counter = 0;
                for (Ingredient ingredient : ingredients.get().getIngredients()) {
                    if (ingredient.test(oldStack))
                        removed_items_counter++;
                }
                this.input.removeStack(i, removed_items_counter);
                oldStack = this.input.getStack(i);
            }
            if (!newStack.isEmpty()) {
                if (oldStack.isEmpty()) {
                    this.input.setStack(i, newStack);
                } else if (ItemStack.areItemsEqualIgnoreDamage(oldStack, newStack)
                        && ItemStack.areNbtEqual(oldStack, newStack)) {
                    newStack.increment(oldStack.getCount());
                    this.input.setStack(i, newStack);
                } else if (!this.player.getInventory().insertStack(newStack)) {
                    this.player.dropItem(newStack, false);
                }
            }
        }
    }
}
