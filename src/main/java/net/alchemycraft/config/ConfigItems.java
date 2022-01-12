package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerItem;

import net.alchemycraft.items.ItemBowlOfMercury;
import net.alchemycraft.items.ItemBowlOfSalt;
import net.alchemycraft.items.ItemBowlOfSulfur;
import net.alchemycraft.items.ItemBrainInJar;
import net.alchemycraft.items.ItemMercuryCrystal;
import net.alchemycraft.items.ItemRawSilver;
import net.alchemycraft.items.ItemSaltCrystal;
import net.alchemycraft.items.ItemSaltedCod;
import net.alchemycraft.items.ItemSaltedSalmon;
import net.alchemycraft.items.ItemSilverIngot;
import net.alchemycraft.items.ItemSulfurCrystal;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ConfigItems {
	// Ores
	public static final Item SALT_ORE = registerItem("salt_ore",
			new BlockItem(ConfigBlocks.SALT_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	public static final Item MERCURY_ORE = registerItem("mercury_ore",
			new BlockItem(ConfigBlocks.MERCURY_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	public static final Item SULFUR_ORE = registerItem("sulfur_ore",
			new BlockItem(ConfigBlocks.SULFUR_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	public static final Item SILVER_ORE = registerItem("silver_ore",
			new BlockItem(ConfigBlocks.SILVER_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	// Crystals & Raw Metals 
	public static final Item SALT_CRYSTAL = registerItem("salt_crystal",
			new ItemSaltCrystal(new FabricItemSettings()));
	
	public static final Item MERCURY_CRYSTAL = registerItem("mercury_crystal",
			new ItemMercuryCrystal(new FabricItemSettings()));

	public static final Item SULFUR_CRYSTAL = registerItem("sulfur_crystal",
			new ItemSulfurCrystal(new FabricItemSettings()));
	
	public static Item RAW_SILVER = registerItem("raw_silver",
			new ItemRawSilver(new FabricItemSettings()));

	// Raw Metal Blocks
	public static final Item RAW_SILVER_BLOCK = registerItem("raw_silver_block",
			new BlockItem(ConfigBlocks.RAW_SILVER_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	// Ingots
	public static Item SILVER_INGOT = registerItem("silver_ingot",
			new ItemSilverIngot(new FabricItemSettings()));

	// Blocks
	public static final Item SALT_BLOCK = registerItem("salt_block",
			new BlockItem(ConfigBlocks.SALT_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));
		
	public static final Item MERCURY_BLOCK = registerItem("mercury_block",
			new BlockItem(ConfigBlocks.MERCURY_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	public static final Item SULFUR_BLOCK = registerItem("sulfur_block",
			new BlockItem(ConfigBlocks.SULFUR_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	public static final Item SILVER_BLOCK = registerItem("silver_block",
			new BlockItem(ConfigBlocks.SILVER_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

	// Bowl of Powder
	public static Item BOWL_OF_SALT = registerItem("bowl_of_salt",
			new ItemBowlOfSalt(new FabricItemSettings()));
			
	public static Item BOWL_OF_MERCURY = registerItem("bowl_of_mercury",
			new ItemBowlOfMercury(new FabricItemSettings()));

	public static Item BOWL_OF_SULFUR = registerItem("bowl_of_sulfur",
			new ItemBowlOfSulfur(new FabricItemSettings()));

	// Mortars
	public static final Item GRANITE_MORTAR = registerItem("granite_mortar",
			new BlockItem(ConfigBlocks.GRANITE_MORTAR, new FabricItemSettings().group(ConfigItemsGroups.DECORATIONS)));

	public static final Item DIORITE_MORTAR = registerItem("diorite_mortar",
			new BlockItem(ConfigBlocks.DIORITE_MORTAR, new FabricItemSettings().group(ConfigItemsGroups.DECORATIONS)));

	public static final Item ANDESITE_MORTAR = registerItem("andesite_mortar",
			new BlockItem(ConfigBlocks.ANDESITE_MORTAR, new FabricItemSettings().group(ConfigItemsGroups.DECORATIONS)));		
	
	// Food
	public static final Item SALTED_COD = registerItem("salted_cod", new ItemSaltedCod(new FabricItemSettings()));

	public static final Item SALTED_SALMON = registerItem("salted_salmon",
			new ItemSaltedSalmon(new FabricItemSettings()));

	// Other
	public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
			new ItemBrainInJar(new FabricItemSettings()));

	public static void init() {
	}
}