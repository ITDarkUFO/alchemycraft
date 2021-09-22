package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class AlchemySaltedSalmon extends Item {
    public AlchemySaltedSalmon(Settings settings) {
        super(settings.group(AlchemyItemsGroups.MISC)
                .food(new FoodComponent.Builder().hunger(6).saturationModifier(12f).build()));
    }
}
