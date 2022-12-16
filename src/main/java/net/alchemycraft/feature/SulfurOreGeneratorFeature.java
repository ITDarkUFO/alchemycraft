package net.alchemycraft.feature;

import static net.alchemycraft.config.Config.MOD_ID;

import java.util.Arrays;

import net.alchemycraft.config.BlocksConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class SulfurOreGeneratorFeature {
	private static int vein_size = 5, veins_per_chunk = 20;

	private static FeatureConfig NETHER_SULFUR_ORE_FEATURE_CONFIG = new OreFeatureConfig(
			OreConfiguredFeatures.NETHERRACK,
			BlocksConfig.SULFUR_ORE.getDefaultState(),
			vein_size);

	@SuppressWarnings("all")
	private static ConfiguredFeature<?, ?> NETHER_SULFUR_ORE_CONFIGURED_FEATURE = new ConfiguredFeature(
			Feature.ORE,
			NETHER_SULFUR_ORE_FEATURE_CONFIG);

	public static PlacedFeature NETHER_SULFUR_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(NETHER_SULFUR_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(veins_per_chunk), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

	public static void init() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier(MOD_ID, "nether_sulfur_ore"),
				NETHER_SULFUR_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
				new Identifier(MOD_ID, "nether_sulfur_ore"),
				NETHER_SULFUR_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
				GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier(MOD_ID, "nether_sulfur_ore")));
	}
}
