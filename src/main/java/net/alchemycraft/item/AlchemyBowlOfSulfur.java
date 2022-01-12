package net.alchemycraft.item;

import net.alchemycraft.registry.AlchemyItemsGroups;

public class AlchemyBowlOfSulfur extends AlchemyBowlOfPowder {
    public AlchemyBowlOfSulfur(Settings settings) {
        super(settings.group(AlchemyItemsGroups.FOOD));
    }
}