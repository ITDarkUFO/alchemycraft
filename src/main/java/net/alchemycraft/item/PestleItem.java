package net.alchemycraft.item;

import net.alchemycraft.config.ItemGroupsConfig;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

public class PestleItem extends Item {
    public PestleItem(Settings settings) {
        super(settings);
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroupsConfig.TOOLS).register(entries -> {
            entries.add(this);
        });
    }
}
