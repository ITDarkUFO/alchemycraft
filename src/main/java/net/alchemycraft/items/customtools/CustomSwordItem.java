package net.alchemycraft.items.customtools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CustomSwordItem extends SwordItem {
    public CustomSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
