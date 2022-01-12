package net.alchemycraft.items;

import net.alchemycraft.config.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemSilverIngot extends Item{
    public ItemSilverIngot(Settings settings) {
        super(settings.group(ConfigItemsGroups.MISC));
    }
}