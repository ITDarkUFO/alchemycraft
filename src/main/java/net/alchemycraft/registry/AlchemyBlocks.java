package net.alchemycraft.registry;

import static net.alchemycraft.util.AlchemyRegistryList.registerBlock;

import net.alchemycraft.block.AlchemyClusterBlock;
import net.alchemycraft.block.AlchemyOreBlock;
import net.alchemycraft.block.AlchemyOreCompactBlock;
import net.alchemycraft.block.mortar.AlchemyMortarBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class AlchemyBlocks {
        // Руды
        public static final Block SALT_ORE = registerBlock("salt_ore",
                        new AlchemyOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY)
                                        .breakByTool(FabricToolTags.PICKAXES, 1).requiresTool().strength(3.0f, 3.0f)));

        // Кристаллы
        public static final Block SALT_CLUSTER = registerBlock("salt_cluster",
                        new AlchemyClusterBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE_GRAY)
                                        .breakByTool(FabricToolTags.PICKAXES, 0).strength(1.5f, 1.5f).nonOpaque()));

        // Блоки
        public static final Block SALT_BLOCK = registerBlock("salt_block",
                        new AlchemyOreCompactBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE_GRAY)
                                        .breakByTool(FabricToolTags.PICKAXES, 0).strength(1.5f, 1.5f)));

        // Ступка
        public static final Block MORTAR = registerBlock("mortar", new AlchemyMortarBlock(
                        FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(1.5f, 1.5f)));

        public static void init() {
        }
}
