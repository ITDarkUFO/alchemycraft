package net.alchemycraft.registry;

import static net.alchemycraft.util.RegistryList.registerItem;

import net.alchemycraft.item.AlchemyBowlOfSalt;
import net.alchemycraft.item.AlchemyBrainInJar;
import net.alchemycraft.item.AlchemySaltCrystal;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class AlchemyItems {
        // Мозг в банке
        public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
                        new AlchemyBrainInJar(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

        // Соль
        // Соляная руда
        public static final Item SALT_ORE = registerItem("salt_ore", new BlockItem(AlchemyBlocks.SALT_ORE,
                        new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

        // Соляной кластер
        public static final Item SALT_CLUSTER = registerItem("salt_cluster", new BlockItem(AlchemyBlocks.SALT_CLUSTER,
                        new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

        // Соляной кристалл
        public static final Item SALT_CRYSTAL = registerItem("salt_crystal",
                        new AlchemySaltCrystal(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

        // Миска с солью
        public static final Item BOWL_OF_SALT = registerItem("bowl_of_salt",
                        new AlchemyBowlOfSalt(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

        // Блок соли
        public static final Item SALT_BLOCK = registerItem("salt_block", new BlockItem(AlchemyBlocks.SALT_BLOCK,
                        new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

        // Ступка
        public static final Item MORTAR = registerItem("mortar", new BlockItem(AlchemyBlocks.MORTAR,
                        new FabricItemSettings().group(AlchemyItemsGroups.DECORATIONS)));

        public static void init() {
        }
}