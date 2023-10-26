package net.alchemycraft.item.material;

import net.alchemycraft.config.ItemsConfig;
import net.alchemycraft.item.customtool.AxeItemCustom;
import net.alchemycraft.item.customtool.HoeItemCustom;
import net.alchemycraft.item.customtool.PickaxeItemCustom;
import net.alchemycraft.item.customtool.ShovelItemCustom;
import net.alchemycraft.item.customtool.SwordItemCustom;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SilverToolMaterial implements ToolMaterial {
    public static final SilverToolMaterial INSTANCE = new SilverToolMaterial();

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
        return Ingredient.ofItems(ItemsConfig.SILVER_INGOT);
    }

    public static ToolItem SILVER_PICKAXE = new PickaxeItemCustom(SilverToolMaterial.INSTANCE, 3, -2.8F,
            new Item.Settings());

    public static ToolItem SILVER_SWORD = new SwordItemCustom(SilverToolMaterial.INSTANCE, 5, 1.6F,
            new Item.Settings());

    public static ToolItem SILVER_SHOVEL = new ShovelItemCustom(SilverToolMaterial.INSTANCE, 3, -3F,
            new Item.Settings());

    public static ToolItem SILVER_HOE = new HoeItemCustom(SilverToolMaterial.INSTANCE, 0, -1F,
            new Item.Settings());

    public static ToolItem SILVER_AXE = new AxeItemCustom(SilverToolMaterial.INSTANCE, 8, 0.9F,
            new Item.Settings());

}
