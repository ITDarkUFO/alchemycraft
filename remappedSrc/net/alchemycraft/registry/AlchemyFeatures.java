package net.alchemycraft.registry;

import net.alchemycraft.feature.AlchemyMercuryOreGenerator;
import net.alchemycraft.feature.AlchemySaltOreGenerator;
import net.alchemycraft.feature.AlchemySulfurOreGenerator;

public class AlchemyFeatures {
    public static void init() {
        AlchemySaltOreGenerator.init();
        AlchemyMercuryOreGenerator.init();
        AlchemySulfurOreGenerator.init();
    }
}
