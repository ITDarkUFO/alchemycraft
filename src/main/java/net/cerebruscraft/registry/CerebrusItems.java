package net.cerebruscraft.registry;

import static net.cerebruscraft.util.RegistryList.registerItem;

import net.cerebruscraft.item.BrainInJar;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class CerebrusItems {
        // Мозг в банке
        public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
                        new BrainInJar(new FabricItemSettings().group(CerebrusItemsGroups.MISC)));
        // Соляная руда
        public static final Item SALT_ORE = registerItem("salt_ore", new BlockItem(CerebrusBlocks.SALT_ORE,
                        new FabricItemSettings().group(CerebrusItemsGroups.MISC)));
        // Соляной кристалл
        public static final Item SALT_CRYSTAL = registerItem("salt_crystal", new BlockItem(CerebrusBlocks.SALT_CRYSTAL,
                        new FabricItemSettings().group(CerebrusItemsGroups.MISC)));

        public static void init() {
        }
}
