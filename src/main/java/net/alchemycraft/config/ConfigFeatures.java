package net.alchemycraft.config;

import net.alchemycraft.feature.AlchemyMercuryOreGenerator;
import net.alchemycraft.feature.AlchemySaltOreGenerator;
import net.alchemycraft.feature.AlchemySulfurOreGenerator;

public class ConfigFeatures {
    public static void init() {
        AlchemySaltOreGenerator.init();
        AlchemyMercuryOreGenerator.init();
        AlchemySulfurOreGenerator.init();
    }
}
