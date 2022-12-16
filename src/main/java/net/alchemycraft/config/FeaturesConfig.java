package net.alchemycraft.config;

import net.alchemycraft.feature.DeepslateLeadOreGeneratorFeature;
import net.alchemycraft.feature.DeepslateMercuryOreGeneratorFeature;
import net.alchemycraft.feature.DeepslateSilverOreGeneratorFeature;
import net.alchemycraft.feature.LeadOreGeneratorFeature;
import net.alchemycraft.feature.MercuryOreGeneratorFeature;
import net.alchemycraft.feature.SaltOreGeneratorFeature;
import net.alchemycraft.feature.SilverOreGeneratorFeature;
import net.alchemycraft.feature.SulfurOreGeneratorFeature;

public class FeaturesConfig {
    public static void init() {
        SaltOreGeneratorFeature.init();
        MercuryOreGeneratorFeature.init();
        DeepslateMercuryOreGeneratorFeature.init();
        SulfurOreGeneratorFeature.init();
        SilverOreGeneratorFeature.init();
        DeepslateSilverOreGeneratorFeature.init();
        LeadOreGeneratorFeature.init();
        DeepslateLeadOreGeneratorFeature.init();
    }
}