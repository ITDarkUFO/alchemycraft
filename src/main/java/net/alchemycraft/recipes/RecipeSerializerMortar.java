package net.alchemycraft.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.alchemycraft.configs.Config;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

public class RecipeSerializerMortar implements RecipeSerializer<RecipesMortar> {

    private RecipeSerializerMortar() {
    }

    public static final RecipeSerializerMortar INSTANCE = new RecipeSerializerMortar();

    public static final Identifier ID = new Identifier(Config.MOD_ID, "mortar");

    @Override // Turns json into Recipe
    public RecipesMortar read(Identifier recipeId, JsonObject json) {
        JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
        ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
        Ingredient pestle = Ingredient.fromJson(ingredients.get(0));

        DefaultedList<ItemStack> inputs = DefaultedList.ofSize(2, ItemStack.EMPTY);

        for (int i = 0; i < inputs.size(); i++) {
            JsonObject jsonObject = ingredients.get(i + 1).getAsJsonObject();

            Identifier itemID = new Identifier(jsonObject.get("item").getAsString());
            Item ingredientItem = null;
            int itemCount = 0;

            if (jsonObject.size() == 2) {
                itemCount = jsonObject.get("count").getAsInt();
            } else if (jsonObject.size() == 1) {
                itemCount = 1;
            } else {
                throw new JsonSyntaxException("Recipe {" + jsonObject + "} is broken.");
            }

            ingredientItem = Registry.ITEM.get(itemID);
            ItemStack ingredientItemStack = new ItemStack(ingredientItem, itemCount);
            inputs.set(i, ingredientItemStack);
        }

        return new RecipesMortar(pestle, inputs, output, recipeId);
    }

    @Override // Turns Recipe into PacketByteBuf
    public void write(PacketByteBuf packetData, RecipesMortar recipe) {
        // Create packetData vector of n + 1 size (n for ingridients, +1 for pestle
        // slot)
        packetData.writeInt(recipe.getIngredients().size() + 1);

        Ingredient pestle = recipe.getPestleSlot();
        pestle.write(packetData);

        for (Ingredient ing : recipe.getIngredients()) {
            ing.write(packetData);
        }

        packetData.writeItemStack(recipe.getOutput());
    }

    @Override // Turns PacketByteBuf into Recipe
    public RecipesMortar read(Identifier recipeId, PacketByteBuf packetData) {
        Ingredient pestle = Ingredient.fromPacket(packetData);

        DefaultedList<ItemStack> inputs = DefaultedList.ofSize(packetData.readInt(), ItemStack.EMPTY);

        for (int i = 0; i < inputs.size() - 1; i++) {
            inputs.set(i, packetData.readItemStack());
        }

        ItemStack output = packetData.readItemStack();
        return new RecipesMortar(pestle, inputs, output, recipeId);
    }
}
