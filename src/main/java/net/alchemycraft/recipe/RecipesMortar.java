package net.alchemycraft.recipe;

import net.alchemycraft.inventory.mortar.MortarCraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class RecipesMortar implements Recipe<MortarCraftingInventory> {
    private final Ingredient pestleSlot;
    private final DefaultedList<Ingredient> recipeItems;
    private final ItemStack outputStack;
    private final Identifier identifier;

    public RecipesMortar(Ingredient pestleSlot, DefaultedList<Ingredient> recipeItems, ItemStack outputStack,
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
            if (recipeItems.get(0).test(inventory.getStack(1)))
                return recipeItems.get(1).test(inventory.getStack(2));

        return false;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack craft(MortarCraftingInventory inventory, DynamicRegistryManager registryManager) {
        return getResult(registryManager);
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    public Identifier getIdentifier() {
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

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return outputStack;
    }
}
