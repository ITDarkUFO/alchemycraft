package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerPlacedFeature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FeaturesConfig {
    public static final RegistryKey<PlacedFeature> SALT_ORE_UPPER = registerPlacedFeature("salt_ore_upper");
    public static final RegistryKey<PlacedFeature> SALT_ORE_BURIED = registerPlacedFeature("salt_ore_buried");
    public static final RegistryKey<PlacedFeature> SALT_ORE_SURFACE = registerPlacedFeature("salt_ore_surface");

    public static final RegistryKey<PlacedFeature> CINNABAR_ORE = registerPlacedFeature("cinnabar_ore");

    public static void init() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES, SALT_ORE_UPPER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES, SALT_ORE_BURIED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES, SALT_ORE_SURFACE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), Feature.UNDERGROUND_ORES, CINNABAR_ORE);
    }
}