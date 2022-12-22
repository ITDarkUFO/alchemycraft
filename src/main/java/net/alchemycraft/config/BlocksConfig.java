package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerBlock;

import net.alchemycraft.block.CinnabarOreBlock;
import net.alchemycraft.block.MortarBlock;
import net.alchemycraft.block.SaltOreBlock;
import net.alchemycraft.block.SulfurOreBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;

public class BlocksConfig {
	// hardness, resistance
	// Ores 3.0f, 3.0f
	// Deepslate ores 4.5f, 3.0f
	public static final Block SALT_ORE = registerBlock("salt_ore",
			new SaltOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
			new SaltOreBlock(FabricBlockSettings.copyOf(SALT_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block CINNABAR_ORE = registerBlock("cinnabar_ore",
			new CinnabarOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_CINNABAR_ORE = registerBlock("deepslate_cinnabar_ore",
			new CinnabarOreBlock(FabricBlockSettings.copyOf(CINNABAR_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
			new SulfurOreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block SILVER_ORE = registerBlock("silver_ore",
			new OreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
			new OreBlock(FabricBlockSettings.copyOf(SILVER_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block LEAD_ORE = registerBlock("lead_ore",
			new OreBlock(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
			new OreBlock(FabricBlockSettings.copyOf(LEAD_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	// Raw Metal Blocks hardness 5.0f, resistance 6.0f
	public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
			new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
			new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	// Blocks
	// Ores blocks - hardness 5.0f, resistance 6.0f
	public static final Block SALT_BLOCK = registerBlock("salt_block",
			new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.OFF_WHITE)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block CINNABAR_BLOCK = registerBlock("cinnabar_block",
			new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DULL_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
			new Block(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block SILVER_BLOCK = registerBlock("silver_block",
			new Block(FabricBlockSettings.of(Material.METAL).mapColor(MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block LEAD_BLOCK = registerBlock("lead_block",
			new Block(FabricBlockSettings.of(Material.METAL).mapColor(MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	// Mortars
	public static final Block GRANITE_MORTAR = registerBlock("granite_mortar", new MortarBlock(
			FabricBlockSettings.of(Material.STONE, MapColor.DIRT_BROWN).strength(2.0F, 3.0F),
			"block.alchemycraft.granite_mortar"));

	public static final Block DIORITE_MORTAR = registerBlock("diorite_mortar", new MortarBlock(
			FabricBlockSettings.of(Material.STONE, MapColor.OFF_WHITE).strength(2.0F, 3.0F),
			"block.alchemycraft.diorite_mortar"));

	public static final Block ANDESITE_MORTAR = registerBlock("andesite_mortar", new MortarBlock(
			FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(2.0F, 3.0F),
			"block.alchemycraft.andesite_mortar"));

	public static void init() {
	}
}
