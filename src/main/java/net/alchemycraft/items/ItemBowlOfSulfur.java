package net.alchemycraft.items;

import net.alchemycraft.config.ConfigItemsGroups;

public class ItemBowlOfSulfur extends ItemBowlOfPowder {
    public ItemBowlOfSulfur(Settings settings) {
        super(settings.group(ConfigItemsGroups.FOOD));
    }
}