package net.alchemycraft.items;

import net.alchemycraft.config.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemMercuryCrystal extends Item {
    public ItemMercuryCrystal(Settings settings) {
        super(settings.group(ConfigItemsGroups.MISC));
    }
}

