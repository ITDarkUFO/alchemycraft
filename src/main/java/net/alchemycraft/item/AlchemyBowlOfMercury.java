package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;
import net.minecraft.item.ToolMaterial;

public class AlchemyBowlOfMercury extends AlchemyBowlOfPowder {
    public AlchemyBowlOfMercury(ToolMaterial material, Settings settings) {
        super(material, settings.group(AlchemyItemsGroups.MISC));
    }
}