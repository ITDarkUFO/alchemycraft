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

public class RecipeSerializerMortar implements RecipeSerializer<RecipesMortar>{

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

        return new RecipesMortar(inputs, output, recipeId);
    }

    @Override // Turns Recipe into PacketByteBuf
    public void write(PacketByteBuf packetData, RecipesMortar recipe) {
        packetData.writeInt(recipe.getIngredients().size());

        for (Ingredient ing : recipe.getIngredients()) {
            ing.write(packetData);
        }
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override // Turns PacketByteBuf into Recipe
    public RecipesMortar read(Identifier recipeId, PacketByteBuf packetData) {
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(packetData.readInt(), Ingredient.EMPTY);

        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromPacket(packetData));
        }

        ItemStack output = packetData.readItemStack();
        return new RecipesMortar(inputs, output, recipeId);
    }
}
