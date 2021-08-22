package net.alchemycraft.registry;

import static net.alchemycraft.util.RegistryList.registerItem;

import net.alchemycraft.item.BowlOfSalt;
import net.alchemycraft.item.BrainInJar;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class AlchemyItems {
        // Мозг в банке
        public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
                        new BrainInJar(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

        // Соль
        // Соляная руда
        public static final Item SALT_ORE = registerItem("salt_ore", new BlockItem(AlchemyBlocks.SALT_ORE,
                        new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

        // Соляной кристалл
        public static final Item SALT_CRYSTAL = registerItem("salt_crystal", new BlockItem(AlchemyBlocks.SALT_CRYSTAL,
                        new FabricItemSettings().group(AlchemyItemsGroups.CRYSTALS)));

        // Миска с солью
        public static final Item BOWL_OF_SALT = registerItem("bowl_of_salt",
                        new BowlOfSalt(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

        // Блок соли
        public static final Item SALT_BLOCK = registerItem("salt_block", new BlockItem(AlchemyBlocks.SALT_BLOCK,
                        new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

        // Ступка
        public static final Item MORTAR = registerItem("mortar", new BlockItem(AlchemyBlocks.MORTAR, new FabricItemSettings().group(AlchemyItemsGroups.MISC)));
        
        public static void init() {
        }
}

