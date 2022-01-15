package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemSulfurCrystal extends Item {
    public ItemSulfurCrystal(Settings settings) {
        super(settings.group(ConfigItemsGroups.MISC));
    }
}

