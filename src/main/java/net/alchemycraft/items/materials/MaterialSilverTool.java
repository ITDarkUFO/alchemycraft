package net.alchemycraft.items.materials;

import net.alchemycraft.configs.ConfigItems;
import net.alchemycraft.configs.ConfigItemsGroups;
import net.alchemycraft.items.customtools.CustomAxeItem;
import net.alchemycraft.items.customtools.CustomHoeItem;
import net.alchemycraft.items.customtools.CustomPickaxeItem;
import net.alchemycraft.items.customtools.CustomShovelItem;
import net.alchemycraft.items.customtools.CustomSwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialSilverTool implements ToolMaterial {
    public static final MaterialSilverTool INSTANCE = new MaterialSilverTool();

    @Override
    public float getAttackDamage() {
        return 0F; // Should be as Iron
    }

    @Override
    public int getDurability() {
        return 170; // Less than Iron
    }

    @Override
    public int getEnchantability() {
        return 27; // Better than Gold
    }

    @Override
    public int getMiningLevel() {
        return 2; // As Iron tool
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.5F; // More than Stone, less than Iron
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ConfigItems.SILVER_INGOT);
    }

    public static ToolItem SILVER_PICKAXE = new CustomPickaxeItem(MaterialSilverTool.INSTANCE, 3, -2.8F,
            new Item.Settings().group(ConfigItemsGroups.TOOLS));

    public static ToolItem SILVER_SWORD = new CustomSwordItem(MaterialSilverTool.INSTANCE, 5, 1.6F,
            new Item.Settings().group(ConfigItemsGroups.TOOLS));

    public static ToolItem SILVER_SHOVEL = new CustomShovelItem(MaterialSilverTool.INSTANCE, 3, -3F,
            new Item.Settings().group(ConfigItemsGroups.TOOLS));

    public static ToolItem SILVER_HOE = new CustomHoeItem(MaterialSilverTool.INSTANCE, 0, -1F,
            new Item.Settings().group(ConfigItemsGroups.TOOLS));

    public static ToolItem SILVER_AXE = new CustomAxeItem(MaterialSilverTool.INSTANCE, 8, 0.9F,
            new Item.Settings().group(ConfigItemsGroups.TOOLS));

}
