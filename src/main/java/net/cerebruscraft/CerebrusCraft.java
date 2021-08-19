package net.cerebruscraft;

import net.cerebruscraft.registry.CerebrusBlocks;
import net.cerebruscraft.registry.CerebrusItems;
import net.cerebruscraft.registry.CerebrusItemsGroups;
import net.fabricmc.api.ModInitializer;

public class CerebrusCraft implements ModInitializer {
	public static final String MOD_ID = "cerebruscraft";

	@Override
	public void onInitialize() {
		CerebrusItemsGroups.init();
		CerebrusItems.init();
		CerebrusBlocks.init();
	}
}