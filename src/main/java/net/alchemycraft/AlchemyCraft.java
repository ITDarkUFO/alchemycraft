package net.alchemycraft;

import net.alchemycraft.config.BlocksConfig;
import net.alchemycraft.config.FeaturesConfig;
import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.config.ItemGroupsConfig;
import net.alchemycraft.config.ItemsConfig;
import net.alchemycraft.config.RecipesConfig;
import net.alchemycraft.config.TagsConfig;
import net.fabricmc.api.ModInitializer;

public class AlchemyCraft implements ModInitializer {
	@Override
	public void onInitialize() {
		ItemGroupsConfig.init();
		ItemsConfig.init();
		BlocksConfig.init();
		FeaturesConfig.init();
		HandlersConfig.init();
		RecipesConfig.init();
		TagsConfig.init();
	}
}