package net.alchemycraft.recipe;

import net.alchemycraft.inventory.mortar.MortarCraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class RecipesMortar implements Recipe<MortarCraftingInventory> {
    private final Ingredient pestleSlot;
    private final DefaultedList<ItemStack> recipeItems;
    private final ItemStack outputStack;
    private final Identifier identifier;

    public RecipesMortar(Ingredient pestleSlot, DefaultedList<ItemStack> recipeItems, ItemStack outputStack,
            Identifier identifier) {
        this.pestleSlot = pestleSlot;
        this.recipeItems = recipeItems;
        this.outputStack = outputStack;
        this.identifier = identifier;
    }

    public Ingredient getPestleSlot() {
        return pestleSlot;
    }

    @Override
    public boolean matches(MortarCraftingInventory inventory, World world) {
        if (pestleSlot.test(inventory.getStack(0)))
            if (recipeItems.get(0).getItem() == inventory.getStack(1).getItem() && recipeItems.get(0).getCount() <= inventory.getStack(1).getCount())
                return recipeItems.get(1).getItem() == inventory.getStack(2).getItem() && recipeItems.get(1).getCount() <= inventory.getStack(2).getCount();

        return false;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(0);

        for (ItemStack itemStack : recipeItems) 
            for (int i = 0; i < itemStack.getCount(); i++)
                ingredients.add(Ingredient.ofStacks(itemStack));

        return ingredients;
    }

    @Override
    public ItemStack craft(MortarCraftingInventory inventory) {
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
        private Type() {
        }

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
