package net.alchemycraft;

import net.alchemycraft.config.ConfigBlockEnities;
import net.alchemycraft.config.ConfigBlocks;
import net.alchemycraft.config.ConfigFeatures;
import net.alchemycraft.config.ConfigHandlers;
import net.alchemycraft.config.ConfigItems;
import net.alchemycraft.config.ConfigItemsGroups;
import net.fabricmc.api.ModInitializer;

public class AlchemyCraft implements ModInitializer {
	public static final String MOD_ID = "alchemycraft";

	@Override
	public void onInitialize() {
		ConfigItemsGroups.init();
		ConfigItems.init();
		ConfigBlocks.init();
		ConfigBlockEnities.init();
		ConfigFeatures.init();
		ConfigHandlers.init();
	}
}