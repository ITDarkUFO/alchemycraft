package net.alchemycraft.items.materials;

import net.alchemycraft.configs.ConfigItems;
import net.alchemycraft.configs.ConfigItemsGroups;
import net.alchemycraft.items.customtools.CustomPickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialSilverTool implements ToolMaterial {
    public static final MaterialSilverTool INSTANCE = new MaterialSilverTool();

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getDurability() {
        return 180; // Less than iron 
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public int getMiningLevel() {
        return 2; // As iron tool
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5; // More than stone, less than iron
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ConfigItems.SILVER_INGOT);
    }

    public static ToolItem SILVER_PICKAXE = new CustomPickaxeItem(MaterialSilverTool.INSTANCE, 4, -2.8F,
			new Item.Settings().group(ConfigItemsGroups.TOOLS)); 
            
}
