package net.alchemycraft.registry;

import static net.alchemycraft.util.AlchemyRegistryList.registerBlock;

import net.alchemycraft.block.AlchemyMercuryBlock;
import net.alchemycraft.block.AlchemyOreBlock;
import net.alchemycraft.block.AlchemySaltBlock;
import net.alchemycraft.block.AlchemySulfurBlock;
import net.alchemycraft.block.mortar.AlchemyMortarBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class AlchemyBlocks {
        // Salt
        public static final Block SALT_ORE = registerBlock("salt_ore",
                        new AlchemyOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
                                        .requiresTool().strength(3.0f, 3.0f)));

        public static final Block SALT_BLOCK = registerBlock("salt_block",
                        new AlchemySaltBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.OFF_WHITE)
                                        .requiresTool().strength(1.5f, 1.5f)));

        // Mercury
        public static final Block MERCURY_ORE = registerBlock("mercury_ore",
                        new AlchemyOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
                                        .requiresTool().strength(3.0f, 3.0f)));

        public static final Block MERCURY_BLOCK = registerBlock("mercury_block",
                        new AlchemyMercuryBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DULL_RED)
                                        .requiresTool().strength(1.5f, 1.5f)));

        // Sulfur
        public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
                        new AlchemyOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
                                        .requiresTool().strength(3.0f, 3.0f)));

        public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
                        new AlchemySulfurBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PALE_YELLOW)
                                        .requiresTool().strength(1.5f, 1.5f)));
        
        // Mortars
        public static final Block GRANITE_MORTAR = registerBlock("granite_mortar", new AlchemyMortarBlock(
                        FabricBlockSettings.of(Material.STONE).mapColor(MapColor.BROWN).strength(0.5f, 0.5f)));

        public static final Block DIORITE_MORTAR = registerBlock("diorite_mortar", new AlchemyMortarBlock(
                FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE).strength(0.5f, 0.5f)));
        
        public static final Block ANDESITE_MORTAR = registerBlock("andesite_mortar", new AlchemyMortarBlock(
                FabricBlockSettings.of(Material.STONE).mapColor(MapColor.WHITE_GRAY).strength(0.5f, 0.5f)));                
        public static void init() {
        }
}
