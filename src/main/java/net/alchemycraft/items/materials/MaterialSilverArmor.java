package net.alchemycraft.items.materials;

import net.alchemycraft.configs.ConfigItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MaterialSilverArmor implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 165, 240, 225, 195 };  // Same as Chainmail and Iron
    private static final int[] PROTECTION_VALUES = new int[] { 2, 5, 4, 1 }; // Same as Chainmail

    public static final ArmorMaterial INSTANCE = new MaterialSilverArmor();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 25; // Same as Iron Armor
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ConfigItems.SILVER_INGOT);
    }

    @Override
    public String getName() {
        return "silver";
    }

    @Override
    public float getToughness() {
        return 0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0F;
    }

}
