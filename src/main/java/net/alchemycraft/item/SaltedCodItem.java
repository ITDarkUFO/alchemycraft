package net.alchemycraft.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class SaltedCodItem extends Item {
    public SaltedCodItem(Settings settings) {
        super(settings.food(new FoodComponent.Builder().hunger(5)
                .saturationModifier(8f).build()));
    }
}
