package net.alchemycraft.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class ItemSaltedSalmon extends Item {
    public ItemSaltedSalmon(Settings settings) {
        super(settings.food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()));
    }
}
