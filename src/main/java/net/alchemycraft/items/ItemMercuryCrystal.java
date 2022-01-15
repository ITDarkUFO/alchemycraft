package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemMercuryCrystal extends Item {
    public ItemMercuryCrystal(Settings settings) {
        super(settings.group(ConfigItemsGroups.MISC));
    }
}

