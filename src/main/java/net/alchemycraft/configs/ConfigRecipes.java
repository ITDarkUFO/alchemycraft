package net.alchemycraft.configs;

import net.alchemycraft.recipes.RecipesMortar;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ConfigRecipes {
    public static void init() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Config.MOD_ID, RecipesMortar.Serializer.ID),
                RecipesMortar.Serializer.INSTANCE);

        Registry.register(Registry.RECIPE_TYPE, new Identifier(Config.MOD_ID, RecipesMortar.Type.ID),
                RecipesMortar.Type.INSTANCE);
    }
}
