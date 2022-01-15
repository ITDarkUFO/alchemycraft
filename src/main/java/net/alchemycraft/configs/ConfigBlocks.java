package net.alchemycraft.configs;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerBlock;

import net.alchemycraft.blocks.BlockMercury;
import net.alchemycraft.blocks.BlockMercuryOre;
import net.alchemycraft.blocks.BlockMortar;
import net.alchemycraft.blocks.BlockRawSilver;
import net.alchemycraft.blocks.BlockSalt;
import net.alchemycraft.blocks.BlockSaltOre;
import net.alchemycraft.blocks.BlockSilver;
import net.alchemycraft.blocks.BlockSilverOre;
import net.alchemycraft.blocks.BlockSulfur;
import net.alchemycraft.blocks.BlockSulfurOre;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class ConfigBlocks {
        // Ores
        public static final Block SALT_ORE = registerBlock("salt_ore",
                        new BlockSaltOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
                                        .requiresTool().strength(3.0f, 3.0f)));

        public static final Block MERCURY_ORE = registerBlock("mercury_ore",
                        new BlockMercuryOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
                                        .requiresTool().strength(3.0f, 3.0f)));

        public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
                        new BlockSulfurOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
                                        .requiresTool().strength(3.0f, 3.0f)));

        public static final Block SILVER_ORE = registerBlock("silver_ore",
                        new BlockSilverOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
                                        .requiresTool().strength(3.0f, 3.0f)));

        // Raw Metal Blocks
        public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
                        new BlockRawSilver(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
                                        .requiresTool().strength(3.0f, 3.0f)));

        // Blocks
        public static final Block SALT_BLOCK = registerBlock("salt_block",
                        new BlockSalt(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.OFF_WHITE)
                                        .requiresTool().strength(1.5f, 1.5f)));

        public static final Block MERCURY_BLOCK = registerBlock("mercury_block",
                        new BlockMercury(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DULL_RED)
                                        .requiresTool().strength(1.5f, 1.5f)));

        public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
                        new BlockSulfur(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PALE_YELLOW)
                                        .requiresTool().strength(1.5f, 1.5f)));

        public static final Block SILVER_BLOCK = registerBlock("silver_block",
                        new BlockSilver(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PALE_YELLOW)
                                        .requiresTool().strength(1.5f, 1.5f)));

        // Mortars
        public static final Block GRANITE_MORTAR = registerBlock("granite_mortar", new BlockMortar(
                        FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(0.5f, 0.5f)));

        public static final Block DIORITE_MORTAR = registerBlock("diorite_mortar", new BlockMortar(
                        FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE).strength(0.5f, 0.5f)));

        public static final Block ANDESITE_MORTAR = registerBlock("andesite_mortar", new BlockMortar(
                        FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE_GRAY).strength(0.5f, 0.5f)));

        public static void init() {
        }
}
