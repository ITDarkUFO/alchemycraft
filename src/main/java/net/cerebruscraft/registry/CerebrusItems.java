package net.cerebruscraft.registry;

import static net.cerebruscraft.util.RegistryList.registerItem;

import net.cerebruscraft.item.BrainInJar;
import net.cerebruscraft.item.BowlOfSalt;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class CerebrusItems {
        // Мозг в банке
        public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
                        new BrainInJar(new FabricItemSettings().group(CerebrusItemsGroups.MISC)));

        // Соль
        // Соляная руда
        public static final Item SALT_ORE = registerItem("salt_ore", new BlockItem(CerebrusBlocks.SALT_ORE,
                        new FabricItemSettings().group(CerebrusItemsGroups.BLOCKS)));

        // Соляной кристалл
        public static final Item SALT_CRYSTAL = registerItem("salt_crystal", new BlockItem(CerebrusBlocks.SALT_CRYSTAL,
                        new FabricItemSettings().group(CerebrusItemsGroups.CRYSTALS)));

        // Миска с солью
        public static final Item BOWL_OF_SALT = registerItem("bowl_of_salt",
                        new BowlOfSalt(new FabricItemSettings().group(CerebrusItemsGroups.MISC)));

        // Соляной блок
        public static final Item SALT_BLOCK = registerItem("salt_block", new BlockItem(CerebrusBlocks.SALT_BLOCK,
                        new FabricItemSettings().group(CerebrusItemsGroups.BLOCKS)));

        // Ступка
        public static final Item MORTAR_BLOCK = registerItem("mortar", new BlockItem(CerebrusBlocks.MORTAR_BLOCK, new FabricItemSettings().group(CerebrusItemsGroups.MISC)));
        
        public static void init() {
        }
}

