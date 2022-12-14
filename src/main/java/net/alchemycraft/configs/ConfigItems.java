package net.alchemycraft.configs;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerItem;

import net.alchemycraft.items.ItemBowlOfPowder;
import net.alchemycraft.items.ItemBowlOfSalt;
import net.alchemycraft.items.ItemBrainInJar;
import net.alchemycraft.items.ItemInfinityPestle;
import net.alchemycraft.items.ItemLeadIngot;
import net.alchemycraft.items.ItemMercuryCrystal;
import net.alchemycraft.items.ItemPestle;
import net.alchemycraft.items.ItemRawLead;
import net.alchemycraft.items.ItemRawSilver;
import net.alchemycraft.items.ItemSaltCrystal;
import net.alchemycraft.items.ItemSaltedCod;
import net.alchemycraft.items.ItemSaltedSalmon;
import net.alchemycraft.items.ItemSilverIngot;
import net.alchemycraft.items.ItemSulfurCrystal;
import net.alchemycraft.items.materials.MaterialSilverArmor;
import net.alchemycraft.items.materials.MaterialSilverTool;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

/**
 * Registration of all modification items.
 *
 * @author ITDarkUFO
 * @version 1.0
 * @since 1.0
 */
public final class ConfigItems {
    /**
     * Salt Ore Block
     */
    public static final Item SALT_ORE = registerItem("salt_ore",
            new BlockItem(ConfigBlocks.SALT_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    /**
     * Deepslate Salt Ore Block
     */
    public static final Item DEEPSLATE_SALT_ORE = registerItem("deepslate_salt_ore",
            new BlockItem(ConfigBlocks.DEEPSLATE_SALT_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    /**
     * Mercury Ore Block
     */
    public static final Item MERCURY_ORE = registerItem("mercury_ore",
            new BlockItem(ConfigBlocks.MERCURY_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item DEEPSLATE_MERCURY_ORE = registerItem("deepslate_mercury_ore",
            new BlockItem(ConfigBlocks.DEEPSLATE_MERCURY_ORE,
                    new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item SULFUR_ORE = registerItem("sulfur_ore",
            new BlockItem(ConfigBlocks.SULFUR_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item SILVER_ORE = registerItem("silver_ore",
            new BlockItem(ConfigBlocks.SILVER_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item DEEPSLATE_SILVER_ORE = registerItem("deepslate_silver_ore",
            new BlockItem(ConfigBlocks.DEEPSLATE_SILVER_ORE,
                    new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item LEAD_ORE = registerItem("lead_ore",
            new BlockItem(ConfigBlocks.LEAD_ORE, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item DEEPSLATE_LEAD_ORE = registerItem("deepslate_lead_ore",
            new BlockItem(ConfigBlocks.DEEPSLATE_LEAD_ORE,
                    new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    // Crystals & Raw Metals
    public static final Item SALT_CRYSTAL = registerItem("salt_crystal",
            new ItemSaltCrystal(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static final Item MERCURY_CRYSTAL = registerItem("mercury_crystal",
            new ItemMercuryCrystal(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static final Item SULFUR_CRYSTAL = registerItem("sulfur_crystal",
            new ItemSulfurCrystal(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static Item RAW_SILVER = registerItem("raw_silver",
            new ItemRawSilver(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static Item RAW_LEAD = registerItem("raw_lead",
            new ItemRawLead(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    // Raw Metal Blocks
    public static final Item RAW_SILVER_BLOCK = registerItem("raw_silver_block",
            new BlockItem(ConfigBlocks.RAW_SILVER_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item RAW_LEAD_BLOCK = registerItem("raw_lead_block",
            new BlockItem(ConfigBlocks.RAW_LEAD_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    // Ingots
    public static Item SILVER_INGOT = registerItem("silver_ingot",
            new ItemSilverIngot(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static Item LEAD_INGOT = registerItem("lead_ingot",
            new ItemLeadIngot(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    // Nuggets
    public static Item SILVER_NUGGET = registerItem("silver_nugget",
            new Item(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static Item LEAD_NUGGET = registerItem("lead_nugget",
            new Item(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    // Blocks
    public static final Item SALT_BLOCK = registerItem("salt_block",
            new BlockItem(ConfigBlocks.SALT_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item MERCURY_BLOCK = registerItem("mercury_block",
            new BlockItem(ConfigBlocks.MERCURY_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item SULFUR_BLOCK = registerItem("sulfur_block",
            new BlockItem(ConfigBlocks.SULFUR_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item SILVER_BLOCK = registerItem("silver_block",
            new BlockItem(ConfigBlocks.SILVER_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    public static final Item LEAD_BLOCK = registerItem("lead_block",
            new BlockItem(ConfigBlocks.LEAD_BLOCK, new FabricItemSettings().group(ConfigItemsGroups.BLOCKS)));

    // Bowl of Powder
    public static Item BOWL_OF_SALT = registerItem("bowl_of_salt",
            new ItemBowlOfSalt(new FabricItemSettings()));

    public static Item BOWL_OF_MERCURY = registerItem("bowl_of_mercury",
            new ItemBowlOfPowder(new FabricItemSettings()));

    public static Item BOWL_OF_SULFUR = registerItem("bowl_of_sulfur",
            new ItemBowlOfPowder(new FabricItemSettings()));

    public static Item BOWL_OF_LAPIS_LAZULI = registerItem("bowl_of_lapis_lazuli",
            new ItemBowlOfPowder(new FabricItemSettings()));

    // Mortars
    public static final Item GRANITE_MORTAR = registerItem("granite_mortar",
            new BlockItem(ConfigBlocks.GRANITE_MORTAR, new FabricItemSettings().group(ConfigItemsGroups.DECORATIONS)));

    public static final Item DIORITE_MORTAR = registerItem("diorite_mortar",
            new BlockItem(ConfigBlocks.DIORITE_MORTAR, new FabricItemSettings().group(ConfigItemsGroups.DECORATIONS)));

    public static final Item ANDESITE_MORTAR = registerItem("andesite_mortar",
            new BlockItem(ConfigBlocks.ANDESITE_MORTAR, new FabricItemSettings().group(ConfigItemsGroups.DECORATIONS)));

    // Food
    public static final Item SALTED_COD = registerItem("salted_cod",
            new ItemSaltedCod(new FabricItemSettings().group(ConfigItemsGroups.FOOD)));

    public static final Item SALTED_SALMON = registerItem("salted_salmon",
            new ItemSaltedSalmon(new FabricItemSettings().group(ConfigItemsGroups.FOOD)));

    // Armors
    public static final Item SILVER_HELMET = registerItem("silver_helmet", MaterialSilverArmor.SILVER_HELMET);
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
            MaterialSilverArmor.SILVER_CHESTPLATE);
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings", MaterialSilverArmor.SILVER_LEGGINGS);
    public static final Item SILVER_BOOTS = registerItem("silver_boots", MaterialSilverArmor.SILVER_BOOTS);

    // Tools
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", MaterialSilverTool.SILVER_PICKAXE);
    public static final Item SILVER_SWORD = registerItem("silver_sword", MaterialSilverTool.SILVER_SWORD);
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", MaterialSilverTool.SILVER_SHOVEL);
    public static final Item SILVER_HOE = registerItem("silver_hoe", MaterialSilverTool.SILVER_HOE);
    public static final Item SILVER_AXE = registerItem("silver_axe", MaterialSilverTool.SILVER_AXE);

    // Pestles
    public static final Item WOODEN_PESTLE = registerItem("wooden_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(32)));

    public static final Item STONE_PESTLE = registerItem("stone_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(64)));

    public static final Item DIORITE_PESTLE = registerItem("diorite_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(80)));

    public static final Item ANDESITE_PESTLE = registerItem("andesite_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(96)));

    public static final Item GRANITE_PESTLE = registerItem("granite_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(128)));

    public static final Item SILVER_PESTLE = registerItem("silver_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(160)));

    public static final Item IRON_PESTLE = registerItem("iron_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(192)));

    public static final Item GOLD_PESTLE = registerItem("gold_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(20)));

    public static final Item DIAMOND_PESTLE = registerItem("diamond_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(320)));

    public static final Item NETHERITE_PESTLE = registerItem("netherite_pestle",
            new ItemPestle(new FabricItemSettings().maxDamage(512)));

    public static final Item INFINITY_PESTLE = registerItem("infinity_pestle",
            new ItemInfinityPestle(new FabricItemSettings()));

    // Other
    public static Item ALCHEMY_BOOK = registerItem("alchemy_book",
            new Item(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
            new ItemBrainInJar(new FabricItemSettings().group(ConfigItemsGroups.MISC)));

    private ConfigItems() {
    }

    public static void init() {
    }
}
