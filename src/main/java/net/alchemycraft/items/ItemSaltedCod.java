package net.alchemycraft.items;

import net.alchemycraft.config.ConfigItemsGroups;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class ItemSaltedCod extends Item {
    public ItemSaltedCod(Settings settings) {
        super(settings.group(ConfigItemsGroups.FOOD)
                .food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()));
    }
}
