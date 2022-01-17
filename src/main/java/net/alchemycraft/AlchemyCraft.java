package net.alchemycraft;

import net.alchemycraft.configs.ConfigBlocks;
import net.alchemycraft.configs.ConfigFeatures;
import net.alchemycraft.configs.ConfigHandlers;
import net.alchemycraft.configs.ConfigItems;
import net.alchemycraft.configs.ConfigItemsGroups;
import net.alchemycraft.configs.ConfigRecipes;
import net.fabricmc.api.ModInitializer;

public class AlchemyCraft implements ModInitializer {
	@Override
	public void onInitialize() {
		ConfigItemsGroups.init();
		ConfigItems.init();
		ConfigBlocks.init();
		ConfigFeatures.init();
		ConfigHandlers.init();
		ConfigRecipes.init();
	}
}