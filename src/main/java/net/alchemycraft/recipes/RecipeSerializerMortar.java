package net.alchemycraft.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.alchemycraft.configs.Config;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class RecipeSerializerMortar implements RecipeSerializer<RecipesMortar> {

    private RecipeSerializerMortar() {
    }

    public static final RecipeSerializerMortar INSTANCE = new RecipeSerializerMortar();

    public static final Identifier ID = new Identifier(Config.MOD_ID, "mortar");

    @Override // Turns json into Recipe
    public RecipesMortar read(Identifier recipeId, JsonObject json) {
        ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
        JsonArray ingredients = JsonHelper.getArray(json, "ingredients");

        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
        }

        Ingredient pestle = Ingredient.fromJson(ingredients.get(2));

        return new RecipesMortar(inputs, pestle, output, recipeId);
    }

    @Override // Turns Recipe into PacketByteBuf
    public void write(PacketByteBuf packetData, RecipesMortar recipe) {
        // Create packetData vector of n + 1 size (n for ingridients, +1 for pestle
        // slot)
        packetData.writeInt(recipe.getIngredients().size() + 1);

        for (Ingredient ing : recipe.getIngredients()) {
            ing.write(packetData);
        }

        Ingredient pestle = recipe.getPestleSlot();
        pestle.write(packetData);

        packetData.writeItemStack(recipe.getOutput());
    }

    @Override // Turns PacketByteBuf into Recipe
    public RecipesMortar read(Identifier recipeId, PacketByteBuf packetData) {
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(packetData.readInt(), Ingredient.EMPTY);

        for (int i = 0; i < inputs.size() - 1; i++) {
            inputs.set(i, Ingredient.fromPacket(packetData));
        }

        Ingredient pestle = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new RecipesMortar(inputs, pestle, output, recipeId);
    }
}
