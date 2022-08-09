package net.alchemycraft.configs;

import net.alchemycraft.features.FeatureLeadOreGenerator;
import net.alchemycraft.features.FeatureMercuryOreGenerator;
import net.alchemycraft.features.FeatureSaltOreGenerator;
import net.alchemycraft.features.FeatureSilverOreGenerator;
import net.alchemycraft.features.FeatureSulfurOreGenerator;

public class ConfigFeatures {
    public static void init() {
        FeatureSaltOreGenerator.init();
        FeatureMercuryOreGenerator.init();
        FeatureSulfurOreGenerator.init();
        FeatureSilverOreGenerator.init();
        FeatureLeadOreGenerator.init();
    }
}
