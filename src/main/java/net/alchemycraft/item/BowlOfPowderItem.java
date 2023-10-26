package net.alchemycraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class BowlOfPowderItem extends Item {
    public BowlOfPowderItem(Settings settings) {
        super(settings.maxCount(16).recipeRemainder(Items.BOWL));
    }
}