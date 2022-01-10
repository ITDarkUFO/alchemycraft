package net.alchemycraft;

import net.alchemycraft.registry.AlchemyBlockEnities;
import net.alchemycraft.registry.AlchemyBlocks;
import net.alchemycraft.registry.AlchemyFeatures;
import net.alchemycraft.registry.AlchemyHandlers;
import net.alchemycraft.registry.AlchemyItems;
import net.alchemycraft.registry.AlchemyItemsGroups;
import net.fabricmc.api.ModInitializer;

public class AlchemyCraft implements ModInitializer {
	public static final String MOD_ID = "alchemycraft";

	@Override
	public void onInitialize() {
		AlchemyItemsGroups.init();
		AlchemyItems.init();
		AlchemyBlocks.init();
		AlchemyBlockEnities.init();
		AlchemyFeatures.init();
		AlchemyHandlers.init();
	}
}