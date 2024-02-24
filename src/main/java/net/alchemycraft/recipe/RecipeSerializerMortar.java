package net.alchemycraft.recipe;

import com.mojang.serialization.Codec;

import net.alchemycraft.config.Config;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class RecipeSerializerMortar implements RecipeSerializer<RecipesMortar> {

    private RecipeSerializerMortar() {
    }

    public static final RecipeSerializerMortar INSTANCE = new RecipeSerializerMortar();

    public static final Identifier ID = new Identifier(Config.MOD_ID, "mortar");

    @Override
    public RecipesMortar read(PacketByteBuf buf) {
        Ingredient pestle = Ingredient.fromPacket(buf);

        int i = buf.readVarInt();
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(i, Ingredient.EMPTY);

        for (int j = 0; j < inputs.size(); ++j) {
            inputs.set(j, Ingredient.fromPacket(buf));
        }
        
        ItemStack output = buf.readItemStack();
        Identifier recipeId = buf.readIdentifier();

        return new RecipesMortar(pestle, inputs, output, recipeId);
    }

    @Override // Turns Recipe into PacketByteBuf
    public void write(PacketByteBuf packetData, RecipesMortar recipe) {
        // Create packetData vector of n + 1 size (n for ingridients, +1 for pestle
        // slot)
        Ingredient pestle = recipe.getPestleSlot();
        pestle.write(packetData);

        packetData.writeInt(recipe.getIngredients().size() + 1);

        for (Ingredient ing : recipe.getIngredients()) {
            ing.write(packetData);
        }

        packetData.writeItemStack(recipe.getResult(null));

        packetData.writeIdentifier(recipe.getIdentifier());
    }

    @Override
    public Codec<RecipesMortar> codec() {
        return null;
    }
}
