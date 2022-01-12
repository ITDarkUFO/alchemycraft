package net.alchemycraft.config;

import net.alchemycraft.feature.FeatureMercuryOreGenerator;
import net.alchemycraft.feature.FeatureSaltOreGenerator;
import net.alchemycraft.feature.FeatureSilverOreGenerator;
import net.alchemycraft.feature.FeatureSulfurOreGenerator;

public class ConfigFeatures {
    public static void init() {
        FeatureSaltOreGenerator.init();
        FeatureMercuryOreGenerator.init();
        FeatureSulfurOreGenerator.init();
        FeatureSilverOreGenerator.init();
    }
}
