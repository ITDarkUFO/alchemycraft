package net.alchemycraft.configs;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerBlock;

import net.alchemycraft.blocks.BlockMercury;
import net.alchemycraft.blocks.BlockMercuryOre;
import net.alchemycraft.blocks.BlockRawLead;
import net.alchemycraft.blocks.BlockAndesiteMortar;
import net.alchemycraft.blocks.BlockDioriteMortar;
import net.alchemycraft.blocks.BlockGraniteMortar;
import net.alchemycraft.blocks.BlockLead;
import net.alchemycraft.blocks.BlockRawSilver;
import net.alchemycraft.blocks.BlockSalt;
import net.alchemycraft.blocks.BlockSaltOre;
import net.alchemycraft.blocks.BlockSilver;
import net.alchemycraft.blocks.BlockSulfur;
import net.alchemycraft.blocks.BlockSulfurOre;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;

public class ConfigBlocks {
	// hardness, resistance
	// Ores 3.0f, 3.0f
	// Deepslate ores 4.5f, 3.0f
	public static final Block SALT_ORE = registerBlock("salt_ore",
			new BlockSaltOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
			new BlockSaltOre(FabricBlockSettings.copyOf(SALT_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block MERCURY_ORE = registerBlock("mercury_ore",
			new BlockMercuryOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.STONE_GRAY)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_MERCURY_ORE = registerBlock("deepslate_mercury_ore",
			new BlockMercuryOre(FabricBlockSettings.copyOf(MERCURY_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
			new BlockSulfurOre(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
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
			new BlockRawSilver(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
			new BlockRawLead(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DARK_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	// Blocks
	// Ores blocks - hardness 5.0f, resistance 6.0f
	public static final Block SALT_BLOCK = registerBlock("salt_block",
			new BlockSalt(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.OFF_WHITE)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block MERCURY_BLOCK = registerBlock("mercury_block",
			new BlockMercury(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.DULL_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
			new BlockSulfur(FabricBlockSettings.of(Material.STONE).mapColor(MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block SILVER_BLOCK = registerBlock("silver_block",
			new BlockSilver(FabricBlockSettings.of(Material.METAL).mapColor(MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block LEAD_BLOCK = registerBlock("lead_block",
			new BlockLead(FabricBlockSettings.of(Material.METAL).mapColor(MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	// Mortars
	public static final Block GRANITE_MORTAR = registerBlock("granite_mortar", new BlockGraniteMortar(
			FabricBlockSettings.of(Material.STONE, MapColor.DIRT_BROWN).strength(2.0F, 3.0F)));

	public static final Block DIORITE_MORTAR = registerBlock("diorite_mortar", new BlockDioriteMortar(
			FabricBlockSettings.of(Material.STONE, MapColor.OFF_WHITE).strength(2.0F, 3.0F)));

	public static final Block ANDESITE_MORTAR = registerBlock("andesite_mortar", new BlockAndesiteMortar(
			FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).strength(2.0F, 3.0F)));

	public static void init() {
	}
}
