package net.alchemycraft.items;

import net.alchemycraft.configs.ConfigItemsGroups;
import net.minecraft.item.Item;

public class ItemPestle extends Item {
    public ItemPestle(Settings settings) {
        super(settings.group(ConfigItemsGroups.TOOLS));
    }
}
