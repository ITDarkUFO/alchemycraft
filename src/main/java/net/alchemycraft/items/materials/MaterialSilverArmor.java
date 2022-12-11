package net.alchemycraft.items.materials;

import net.alchemycraft.configs.ConfigItems;
import net.alchemycraft.configs.ConfigItemsGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MaterialSilverArmor implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 120, 200, 170, 145 }; // More than Gold, less than Iron and
                                                                                   // Chainmail
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
        return 27; // More than Gold
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

    public static Item SILVER_HELMET = new ArmorItem(MaterialSilverArmor.INSTANCE, EquipmentSlot.HEAD,
            new FabricItemSettings().group(ConfigItemsGroups.COMBAT));

    public static Item SILVER_CHESTPLATE = new ArmorItem(MaterialSilverArmor.INSTANCE, EquipmentSlot.CHEST,
            new FabricItemSettings().group(ConfigItemsGroups.COMBAT));

    public static Item SILVER_LEGGINGS = new ArmorItem(MaterialSilverArmor.INSTANCE, EquipmentSlot.LEGS,
            new FabricItemSettings().group(ConfigItemsGroups.COMBAT));

    public static Item SILVER_BOOTS = new ArmorItem(MaterialSilverArmor.INSTANCE, EquipmentSlot.FEET,
            new Item.Settings().group(ConfigItemsGroups.COMBAT));
}
