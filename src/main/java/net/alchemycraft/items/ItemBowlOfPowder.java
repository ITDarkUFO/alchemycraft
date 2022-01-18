package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ItemBowlOfPowder extends Item {
    public ItemBowlOfPowder(Settings settings) {
        super(settings.maxCount(16).recipeRemainder(Items.BOWL).group(ConfigItemsGroups.MISC));
    }
}