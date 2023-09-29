package net.alchemycraft.feature;

import static net.alchemycraft.config.Config.MOD_ID;

import java.util.Arrays;

import net.alchemycraft.config.BlocksConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
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

public class DeepslateCinnabarOreGeneratorFeature {
	private static int vein_size = 4, veins_per_chunk = 15, lower_bound = -20;

	private static FeatureConfig OVERWORLD_DEEPSLATE_CINNABAR_ORE_FEATURE_CONFIG = new OreFeatureConfig(
			OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
			BlocksConfig.DEEPSLATE_CINNABAR_ORE.getDefaultState(),
			vein_size);

	@SuppressWarnings("all")
	private static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_CINNABAR_ORE_CONFIGURED_FEATURE = new ConfiguredFeature(
			Feature.ORE,
			OVERWORLD_DEEPSLATE_CINNABAR_ORE_FEATURE_CONFIG);

	public static PlacedFeature OVERWORLD_DEEPSLATE_CINNABAR_ORE_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(OVERWORLD_DEEPSLATE_CINNABAR_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(veins_per_chunk), // number of veins per chunk
					SquarePlacementModifier.of(), // spreading horizontally
					HeightRangePlacementModifier.uniform(YOffset.fixed(lower_bound), YOffset.fixed(0))));

	public static void init() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier(MOD_ID, "overworld_deepslate_cinnabar_ore"),
				OVERWORLD_DEEPSLATE_CINNABAR_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
				new Identifier(MOD_ID, "overworld_deepslate_cinnabar_ore"),
				OVERWORLD_DEEPSLATE_CINNABAR_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
				GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier(MOD_ID, "overworld_deepslate_cinnabar_ore")));
	}
}