package net.cerebruscraft.registry;

import static net.cerebruscraft.util.RegistryList.registerBlock;

import net.cerebruscraft.block.CerebrusClusterBlock;
import net.cerebruscraft.block.CerebrusMortarBlock;
import net.cerebruscraft.block.CerebrusOreBlock;
import net.cerebruscraft.block.CerebrusOreCompactBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class CerebrusBlocks {
        // Руды
        public static final Block SALT_ORE = registerBlock("salt_ore",
                        new CerebrusOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY)
                                        .breakByTool(FabricToolTags.PICKAXES, 1).requiresTool().strength(3.0f, 3.0f)));

        // Кристаллы
        public static final Block SALT_CRYSTAL = registerBlock("salt_crystal",
                        new CerebrusClusterBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE_GRAY)
                                        .breakByTool(FabricToolTags.PICKAXES, 0).strength(1.5f, 1.5f)));

        // Блоки
        public static final Block SALT_BLOCK = registerBlock("salt_block",
                        new CerebrusOreCompactBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE_GRAY)
                                        .breakByTool(FabricToolTags.PICKAXES, 0).strength(1.5f, 1.5f)));

        // Ступка
        public static final Block MORTAR_BLOCK = registerBlock("mortar",
                        new CerebrusMortarBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.GRAY).strength(1.5f, 1.5f)));

        public static void init() {
        }
}
