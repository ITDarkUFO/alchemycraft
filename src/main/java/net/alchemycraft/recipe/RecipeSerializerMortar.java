package net.alchemycraft.recipe;

import java.lang.reflect.Array;

import com.ibm.icu.impl.locale.LocaleDistance.Data;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.alchemycraft.config.Config;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCodecs;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;

public class RecipeSerializerMortar implements RecipeSerializer<RecipesMortar> {
    // Ingredient pestleSlot, DefaultedList<Ingredient> recipeItems, ItemStack
    // outputStack, Identifier identifier

    private static final Codec<RecipesMortar> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredients").forGetter((recipe) -> {
                    return recipe.getPestleSlot();
                }),
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").flatXmap((ingredients) -> {
                    Ingredient[] ingredients2 = (Ingredient[]) ingredients.stream().filter((ingredient) -> {
                        return !ingredient.isEmpty();
                    }).toArray((i) -> {
                        return new Ingredient[i];
                    });
                    if (ingredients2.length == 0) {
                        return DataResult.error(() -> {
                            return "No ingredients for mortar recipe";
                        });
                    } else {
                        return ingredients2.length > 3 ? DataResult.error(() -> {
                            return "Too many ingredients for mortar recipe";
                        }) : DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, ingredients2));
                    }
                }, DataResult::success).forGetter((recipe) -> {
                    return recipe.getIngredients();
                }),
                RecipeCodecs.CRAFTING_RESULT.fieldOf("output").forGetter((recipe) -> {
                    return recipe.getResult(null);
                }),
                Identifier.CODEC.fieldOf("identifier").forGetter(RecipesMortar::getIdentifier))
                .apply(instance, RecipesMortar::new);
    });

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
        return CODEC;
    }
}
