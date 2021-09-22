package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class AlchemySaltedCod extends Item {
    public AlchemySaltedCod(Settings settings) {
        super(settings.group(AlchemyItemsGroups.MISC)
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(8f).build()));
    }
}
