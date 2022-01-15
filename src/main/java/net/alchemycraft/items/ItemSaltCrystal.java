package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemSaltCrystal extends Item {
    public ItemSaltCrystal(Settings settings) {
        super(settings.group(ConfigItemsGroups.MISC));
    }
}
