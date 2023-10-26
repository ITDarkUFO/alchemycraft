package net.alchemycraft.item.material;

import net.alchemycraft.config.ItemsConfig;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SilverArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] { 120, 200, 170, 145 }; // More than Gold, less than Iron and
                                                                                   // Chainmail
    private static final int[] PROTECTION_VALUES = new int[] { 2, 5, 4, 1 }; // Same as Chainmail

    public static final ArmorMaterial INSTANCE = new SilverArmorMaterial();

    @Override
    public int getDurability(Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getProtection(Type type) {
        return PROTECTION_VALUES[type.getEquipmentSlot().getEntitySlotId()];
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
        return Ingredient.ofItems(ItemsConfig.SILVER_INGOT);
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

    public static Item SILVER_HELMET = new ArmorItem(SilverArmorMaterial.INSTANCE, Type.HELMET,
            new FabricItemSettings());

    public static Item SILVER_CHESTPLATE = new ArmorItem(SilverArmorMaterial.INSTANCE, Type.CHESTPLATE,
            new FabricItemSettings());

    public static Item SILVER_LEGGINGS = new ArmorItem(SilverArmorMaterial.INSTANCE, Type.LEGGINGS,
            new FabricItemSettings());

    public static Item SILVER_BOOTS = new ArmorItem(SilverArmorMaterial.INSTANCE, Type.BOOTS,
            new Item.Settings());

}
