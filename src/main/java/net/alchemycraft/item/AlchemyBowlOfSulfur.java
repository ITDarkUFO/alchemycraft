package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;
import net.minecraft.item.ToolMaterial;

public class AlchemyBowlOfSulfur extends AlchemyBowlOfPowder {
    public AlchemyBowlOfSulfur(ToolMaterial material, Settings settings) {
        super(material, settings.group(AlchemyItemsGroups.MISC));
    }
}