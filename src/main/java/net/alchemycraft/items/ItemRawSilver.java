package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemRawSilver extends Item {
    public ItemRawSilver(Settings settings) {
        super(settings.group(ConfigItemsGroups.MISC));
    }
}