package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerBlock;

import net.alchemycraft.block.CinnabarOreBlock;
import net.alchemycraft.block.DisappearingChestBlock;
import net.alchemycraft.block.MortarBlock;
import net.alchemycraft.block.SaltOreBlock;
import net.alchemycraft.block.SulfurOreBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlocksConfig {
	// hardness, resistance
	// Ores 3.0f, 3.0f
	// Deepslate ores 4.5f, 3.0f
	public static final Block SALT_ORE = registerBlock("salt_ore",
			new SaltOreBlock(FabricBlockSettings.create(Material.STONE, MapColor.STONE_GRAY)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_SALT_ORE = registerBlock("deepslate_salt_ore",
			new SaltOreBlock(FabricBlockSettings.copyOf(SALT_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block CINNABAR_ORE = registerBlock("cinnabar_ore",
			new CinnabarOreBlock(FabricBlockSettings.create(Material.STONE, MapColor.STONE_GRAY)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_CINNABAR_ORE = registerBlock("deepslate_cinnabar_ore",
			new CinnabarOreBlock(FabricBlockSettings.copyOf(CINNABAR_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
			new SulfurOreBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_RED)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block SILVER_ORE = registerBlock("silver_ore",
			new ExperienceDroppingBlock(FabricBlockSettings.create().mapColor(MapColor.DARK_RED)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
			new ExperienceDroppingBlock(FabricBlockSettings.copyOf(SILVER_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.requiresTool().strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	public static final Block LEAD_ORE = registerBlock("lead_ore",
			new ExperienceDroppingBlock(FabricBlockSettings.create(Material.STONE, MapColor.DARK_RED)
					.requiresTool().strength(3.0f, 3.0f)));

	public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
			new ExperienceDroppingBlock(FabricBlockSettings.copyOf(LEAD_ORE).mapColor(MapColor.DEEPSLATE_GRAY)
					.strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE)));

	// Raw Metal Blocks hardness 5.0f, resistance 6.0f
	public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
			new Block(FabricBlockSettings.create(Material.STONE, MapColor.DARK_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
			new Block(FabricBlockSettings.create(Material.STONE, MapColor.DARK_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	// Blocks
	// Ores blocks - hardness 5.0f, resistance 6.0f
	public static final Block SALT_BLOCK = registerBlock("salt_block",
			new Block(FabricBlockSettings.create(Material.STONE, MapColor.OFF_WHITE)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block CINNABAR_BLOCK = registerBlock("cinnabar_block",
			new Block(FabricBlockSettings.create(Material.STONE, MapColor.DULL_RED)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
			new Block(FabricBlockSettings.create(Material.STONE, MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block SILVER_BLOCK = registerBlock("silver_block",
			new Block(FabricBlockSettings.create(Material.METAL, MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	public static final Block LEAD_BLOCK = registerBlock("lead_block",
			new Block(FabricBlockSettings.create(Material.METAL, MapColor.PALE_YELLOW)
					.requiresTool().strength(5.0f, 6.0f)));

	// Mortars
	public static final Block GRANITE_MORTAR = registerBlock("granite_mortar", new MortarBlock(
			FabricBlockSettings.create(Material.STONE, MapColor.DIRT_BROWN).strength(2.0F, 3.0F),
			"block.alchemycraft.granite_mortar"));

	public static final Block DIORITE_MORTAR = registerBlock("diorite_mortar", new MortarBlock(
			FabricBlockSettings.create(Material.STONE, MapColor.OFF_WHITE).strength(2.0F, 3.0F),
			"block.alchemycraft.diorite_mortar"));

	public static final Block ANDESITE_MORTAR = registerBlock("andesite_mortar", new MortarBlock(
			FabricBlockSettings.create(Material.STONE, MapColor.STONE_GRAY).strength(2.0F, 3.0F),
			"block.alchemycraft.andesite_mortar"));

	// Dissapiaring Block
	public static final Block DISAPPEARING_CHEST = registerBlock("disappearing_chest", new DisappearingChestBlock(
			FabricBlockSettings.create(Material.WOOD, MapColor.CLEAR).strength(2.5f)));

	public static void init() {
	}
}
