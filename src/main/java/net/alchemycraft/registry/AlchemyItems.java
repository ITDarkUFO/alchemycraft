package net.alchemycraft.registry;

import static net.alchemycraft.util.AlchemyRegistryList.registerItem;

import net.alchemycraft.item.AlchemyBowlOfMercury;
import net.alchemycraft.item.AlchemyBowlOfSalt;
import net.alchemycraft.item.AlchemyBrainInJar;
import net.alchemycraft.item.AlchemyMercuryCrystal;
import net.alchemycraft.item.AlchemySaltCrystal;
import net.alchemycraft.item.material.AlchemyBowlOfPowderMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;

public class AlchemyItems {
	// Brain in Jar
	public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
			new AlchemyBrainInJar(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

	// Salt
	public static final Item SALT_ORE = registerItem("salt_ore",
			new BlockItem(AlchemyBlocks.SALT_ORE, new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

	// public static final Item SALT_CLUSTER = registerItem("salt_cluster", new
	// BlockItem(AlchemyBlocks.SALT_CLUSTER,
	// new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

	public static final Item SALT_CRYSTAL = registerItem("salt_crystal",
			new AlchemySaltCrystal(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

	public static ToolItem BOWL_OF_SALT = registerItem("bowl_of_salt", new AlchemyBowlOfSalt(
			AlchemyBowlOfPowderMaterial.INSTANCE, new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

	public static final Item SALT_BLOCK = registerItem("salt_block",
			new BlockItem(AlchemyBlocks.SALT_BLOCK, new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

	// Mercury
	public static final Item MERCURY_ORE = registerItem("mercury_ore",
			new BlockItem(AlchemyBlocks.MERCURY_ORE, new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

	public static final Item MERCURY_CRYSTAL = registerItem("mercury_crystal",
			new AlchemyMercuryCrystal(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

	public static ToolItem BOWL_OF_MERCURY = registerItem("bowl_of_mercury", new AlchemyBowlOfMercury(
			AlchemyBowlOfPowderMaterial.INSTANCE, new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

	public static final Item MERCURY_BLOCK = registerItem("mercury_block",
			new BlockItem(AlchemyBlocks.MERCURY_BLOCK, new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

	// Sulfur
	public static final Item SULFUR_ORE = registerItem("sulfur_ore",
			new BlockItem(AlchemyBlocks.SULFUR_ORE, new FabricItemSettings().group(AlchemyItemsGroups.BLOCKS)));

	public static final Item SULFUR_CRYSTAL = registerItem("sulfur_crystal",
			new AlchemyMercuryCrystal(new FabricItemSettings().group(AlchemyItemsGroups.MISC)));

	// Mortar
	public static final Item MORTAR = registerItem("mortar",
			new BlockItem(AlchemyBlocks.MORTAR, new FabricItemSettings().group(AlchemyItemsGroups.DECORATIONS)));

	public static void init() {
	}
}