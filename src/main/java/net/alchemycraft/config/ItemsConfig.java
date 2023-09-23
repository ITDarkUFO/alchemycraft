package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerItem;

import net.alchemycraft.item.AlchemynomiconItem;
import net.alchemycraft.item.BowlOfPowderItem;
import net.alchemycraft.item.BowlOfSaltItem;
import net.alchemycraft.item.BrainInJarItem;
import net.alchemycraft.item.InfinityPestleItem;
import net.alchemycraft.item.PestleItem;
import net.alchemycraft.item.SaltedCodItem;
import net.alchemycraft.item.SaltedSalmonItem;
import net.alchemycraft.item.material.SilverArmorMaterial;
import net.alchemycraft.item.material.SilverToolMaterial;
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
public final class ItemsConfig {
        public static final Item SALT_ORE = registerItem("salt_ore",
                        new BlockItem(BlocksConfig.SALT_ORE, new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item DEEPSLATE_SALT_ORE = registerItem("deepslate_salt_ore",
                        new BlockItem(BlocksConfig.DEEPSLATE_SALT_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item CINNABAR_ORE = registerItem("cinnabar_ore",
                        new BlockItem(BlocksConfig.CINNABAR_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item DEEPSLATE_CINNABAR_ORE = registerItem("deepslate_cinnabar_ore",
                        new BlockItem(BlocksConfig.DEEPSLATE_CINNABAR_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item SULFUR_ORE = registerItem("sulfur_ore",
                        new BlockItem(BlocksConfig.SULFUR_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item SILVER_ORE = registerItem("silver_ore",
                        new BlockItem(BlocksConfig.SILVER_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item DEEPSLATE_SILVER_ORE = registerItem("deepslate_silver_ore",
                        new BlockItem(BlocksConfig.DEEPSLATE_SILVER_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item LEAD_ORE = registerItem("lead_ore",
                        new BlockItem(BlocksConfig.LEAD_ORE, new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item DEEPSLATE_LEAD_ORE = registerItem("deepslate_lead_ore",
                        new BlockItem(BlocksConfig.DEEPSLATE_LEAD_ORE,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        // Crystals & Raw Metals
        public static final Item SALT_CRYSTAL = registerItem("salt_crystal",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static final Item CINNABAR_CRYSTAL = registerItem("cinnabar_crystal",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static final Item SULFUR_CRYSTAL = registerItem("sulfur_crystal",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static Item RAW_SILVER = registerItem("raw_silver",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static Item RAW_LEAD = registerItem("raw_lead",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        // Raw Metal Blocks
        public static final Item RAW_SILVER_BLOCK = registerItem("raw_silver_block",
                        new BlockItem(BlocksConfig.RAW_SILVER_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item RAW_LEAD_BLOCK = registerItem("raw_lead_block",
                        new BlockItem(BlocksConfig.RAW_LEAD_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        // Ingots
        public static Item SILVER_INGOT = registerItem("silver_ingot",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static Item LEAD_INGOT = registerItem("lead_ingot",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        // Nuggets
        public static Item SILVER_NUGGET = registerItem("silver_nugget",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static Item LEAD_NUGGET = registerItem("lead_nugget",
                        new Item(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        // Blocks
        public static final Item SALT_BLOCK = registerItem("salt_block",
                        new BlockItem(BlocksConfig.SALT_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item CINNABAR_BLOCK = registerItem("cinnabar_block",
                        new BlockItem(BlocksConfig.CINNABAR_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item SULFUR_BLOCK = registerItem("sulfur_block",
                        new BlockItem(BlocksConfig.SULFUR_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item SILVER_BLOCK = registerItem("silver_block",
                        new BlockItem(BlocksConfig.SILVER_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        public static final Item LEAD_BLOCK = registerItem("lead_block",
                        new BlockItem(BlocksConfig.LEAD_BLOCK,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        // Bowl of Powder
        public static Item BOWL_OF_SALT = registerItem("bowl_of_salt",
                        new BowlOfSaltItem(new FabricItemSettings()));

        public static Item BOWL_OF_CINNABAR = registerItem("bowl_of_cinnabar",
                        new BowlOfPowderItem(new FabricItemSettings()));

        public static Item BOWL_OF_SULFUR = registerItem("bowl_of_sulfur",
                        new BowlOfPowderItem(new FabricItemSettings()));

        public static Item BOWL_OF_LAPIS_LAZULI = registerItem("bowl_of_lapis_lazuli",
                        new BowlOfPowderItem(new FabricItemSettings()));

        // Mortars
        public static final Item GRANITE_MORTAR = registerItem("granite_mortar",
                        new BlockItem(BlocksConfig.GRANITE_MORTAR,
                                        new FabricItemSettings().group(ItemGroupsConfig.DECORATIONS)));

        public static final Item DIORITE_MORTAR = registerItem("diorite_mortar",
                        new BlockItem(BlocksConfig.DIORITE_MORTAR,
                                        new FabricItemSettings().group(ItemGroupsConfig.DECORATIONS)));

        public static final Item ANDESITE_MORTAR = registerItem("andesite_mortar",
                        new BlockItem(BlocksConfig.ANDESITE_MORTAR,
                                        new FabricItemSettings().group(ItemGroupsConfig.DECORATIONS)));

        // Food
        public static final Item SALTED_COD = registerItem("salted_cod", new SaltedCodItem(new FabricItemSettings()));

        public static final Item SALTED_SALMON = registerItem("salted_salmon",
                        new SaltedSalmonItem(new FabricItemSettings()));

        // Armors
        public static final Item SILVER_HELMET = registerItem("silver_helmet", SilverArmorMaterial.SILVER_HELMET);
        public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
                        SilverArmorMaterial.SILVER_CHESTPLATE);
        public static final Item SILVER_LEGGINGS = registerItem("silver_leggings", SilverArmorMaterial.SILVER_LEGGINGS);
        public static final Item SILVER_BOOTS = registerItem("silver_boots", SilverArmorMaterial.SILVER_BOOTS);

        // Tools
        public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", SilverToolMaterial.SILVER_PICKAXE);
        public static final Item SILVER_SWORD = registerItem("silver_sword", SilverToolMaterial.SILVER_SWORD);
        public static final Item SILVER_SHOVEL = registerItem("silver_shovel", SilverToolMaterial.SILVER_SHOVEL);
        public static final Item SILVER_HOE = registerItem("silver_hoe", SilverToolMaterial.SILVER_HOE);
        public static final Item SILVER_AXE = registerItem("silver_axe", SilverToolMaterial.SILVER_AXE);

        // Pestles
        public static final Item WOODEN_PESTLE = registerItem("wooden_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(32)));

        public static final Item STONE_PESTLE = registerItem("stone_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(64)));

        public static final Item DIORITE_PESTLE = registerItem("diorite_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(80)));

        public static final Item ANDESITE_PESTLE = registerItem("andesite_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(96)));

        public static final Item GRANITE_PESTLE = registerItem("granite_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(128)));

        public static final Item SILVER_PESTLE = registerItem("silver_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(160)));

        public static final Item IRON_PESTLE = registerItem("iron_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(192)));

        public static final Item GOLD_PESTLE = registerItem("gold_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(20)));

        public static final Item DIAMOND_PESTLE = registerItem("diamond_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(320)));

        public static final Item NETHERITE_PESTLE = registerItem("netherite_pestle",
                        new PestleItem(new FabricItemSettings().maxDamage(512)));

        public static final Item INFINITY_PESTLE = registerItem("infinity_pestle",
                        new InfinityPestleItem(new FabricItemSettings()));

        // Other
        public static Item ALCHEMYNOMICON = registerItem("alchemynomicon",
                        new AlchemynomiconItem(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        public static final Item BRAIN_IN_JAR = registerItem("brain_in_jar",
                        new BrainInJarItem(new FabricItemSettings().group(ItemGroupsConfig.MISC)));

        //
        public static Item DISAPPEARING_CHEST = registerItem("disappearing_chest",
                        new BlockItem(BlocksConfig.DISAPPEARING_CHEST,
                                        new FabricItemSettings().group(ItemGroupsConfig.BLOCKS)));

        private ItemsConfig() {
        }

        public static void init() {
        }
}
