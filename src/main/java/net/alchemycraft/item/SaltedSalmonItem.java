package net.alchemycraft.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class SaltedSalmonItem extends Item {
    public SaltedSalmonItem(Settings settings) {
        super(settings.food(new FoodComponent.Builder().hunger(6)
                .saturationModifier(12f).build()));
    }
}
