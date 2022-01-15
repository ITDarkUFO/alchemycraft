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

public class FeatureSaltOreGenerator {
        private static int vein_size = 15, veins_per_chunk = 20, lower_bound = 0;
        private static ConfiguredFeature<?, ?> OVERWORLD_SALT_ORE_CONFIGURATION = Feature.ORE
                        .configure(new OreFeatureConfig(
                                        OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                                        ConfigBlocks.SALT_ORE.getDefaultState(),
                                        vein_size));

        public static PlacedFeature OVERWORLD_SALT_ORE_PLACER = OVERWORLD_SALT_ORE_CONFIGURATION.withPlacement(
                        CountPlacementModifier.of(veins_per_chunk), // number of veins per chunk
                        SquarePlacementModifier.of(), // spreading horizontally
                        HeightRangePlacementModifier.uniform(YOffset.fixed(lower_bound), YOffset.getTop())); // height

        public static void init() {
                Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                                new Identifier(MOD_ID, "overworld_salt_ore"),
                                OVERWORLD_SALT_ORE_CONFIGURATION);
                Registry.register(BuiltinRegistries.PLACED_FEATURE,
                                new Identifier(MOD_ID, "overworld_salt_ore"),
                                OVERWORLD_SALT_ORE_PLACER);
                BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                GenerationStep.Feature.UNDERGROUND_ORES,
                                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                                                new Identifier(MOD_ID, "overworld_salt_ore")));
        }
}
