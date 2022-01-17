package net.alchemycraft.recipes;

import net.alchemycraft.inventories.InventoryCraftingMortar;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class RecipesMortar implements Recipe<InventoryCraftingMortar> {
    private final DefaultedList<Ingredient> recipeItems;
    // private final Ingredient pestleSlot;
    private final ItemStack outputStack;
    private final Identifier identifier;

    public RecipesMortar(DefaultedList<Ingredient> recipeItems, /*Ingredient pestleSlot, */ItemStack outputStack, Identifier identifier) {
        // this.pestleSlot = pestleSlot;
        this.recipeItems = recipeItems;
        this.outputStack = outputStack;
        this.identifier = identifier;
    }

    // public Ingredient getPestleSlot() { return pestleSlot; }

    @Override
    public boolean matches(InventoryCraftingMortar inventory, World world) {
        if (recipeItems.get(0).test(inventory.getStack(0))) {
            return recipeItems.get(1).test(inventory.getStack(1));
        }

        return false;
    }

    @Override
    public ItemStack craft(InventoryCraftingMortar inventory) {
        return outputStack.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return outputStack.copy();
    }

    @Override
    public Identifier getId() {
        return identifier;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerMortar.INSTANCE;
    }

    public static class Type implements RecipeType<RecipesMortar> {
        private Type() {}
        public static final RecipesMortar.Type INSTANCE = new RecipesMortar.Type();

        public static final String ID = "mortar";
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }
}
