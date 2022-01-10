package net.alchemycraft.item.material;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AlchemyBowlOfPowderMaterial implements ToolMaterial {
    public static final AlchemyBowlOfPowderMaterial INSTANCE = new AlchemyBowlOfPowderMaterial();

    @Override
    public int getDurability() {
        return 4;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
