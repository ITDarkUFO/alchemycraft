package net.alchemycraft.features;

import static net.alchemycraft.configs.Config.MOD_ID;

import net.alchemycraft.configs.ConfigBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FeatureSulfurOreGenerator {
        private static int vein_size = 5, veins_per_chunk = 18;

        private static ConfiguredFeature<?, ?> NETHER_SULFUR_ORE_CONFIGURATION = Feature.ORE
                        .configure(new OreFeatureConfig(
                                        OreConfiguredFeatures.NETHERRACK,
                                        ConfigBlocks.SULFUR_ORE.getDefaultState(),
                                        vein_size));

        public static PlacedFeature NETHER_SULFUR_ORE_PLACER = NETHER_SULFUR_ORE_CONFIGURATION.withPlacement(
                        CountPlacementModifier.of(veins_per_chunk), // number of veins per chunk
                        SquarePlacementModifier.of(), // spreading horizontally
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())); // height

        public static void init() {
                Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                                new Identifier(MOD_ID, "nether_sulfur_ore"),
                                NETHER_SULFUR_ORE_CONFIGURATION);
                Registry.register(BuiltinRegistries.PLACED_FEATURE,
                                new Identifier(MOD_ID, "nether_sulfur_ore"),
                                NETHER_SULFUR_ORE_PLACER);
                BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                GenerationStep.Feature.UNDERGROUND_ORES,
                                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                                                new Identifier(MOD_ID, "nether_sulfur_ore")));
        }
}
