package net.alchemycraft.items;

import net.alchemycraft.config.ConfigItemsGroups;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class ItemSaltedSalmon extends Item {
    public ItemSaltedSalmon(Settings settings) {
        super(settings.group(ConfigItemsGroups.FOOD)
                .food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()));
    }
}
