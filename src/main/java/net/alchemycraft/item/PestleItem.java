package net.alchemycraft.item;

import net.alchemycraft.config.ItemGroupsConfig;
import net.minecraft.item.Item;

public class PestleItem extends Item {
    public PestleItem(Settings settings) {
        super(settings.group(ItemGroupsConfig.TOOLS));
    }
}
