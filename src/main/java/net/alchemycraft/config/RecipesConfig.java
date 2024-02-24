package net.alchemycraft.config;

import net.alchemycraft.recipe.RecipeSerializerMortar;
import net.alchemycraft.recipe.RecipesMortar;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RecipesConfig {
    public static void init() {
        Registry.register(Registries.RECIPE_SERIALIZER, RecipeSerializerMortar.ID, RecipeSerializerMortar.INSTANCE);

        Registry.register(Registries.RECIPE_TYPE, new Identifier(Config.MOD_ID, RecipesMortar.Type.ID),
                RecipesMortar.Type.INSTANCE);
    }
}
