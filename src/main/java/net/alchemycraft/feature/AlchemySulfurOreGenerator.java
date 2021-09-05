package net.alchemycraft.feature;

import net.alchemycraft.registry.AlchemyBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

@SuppressWarnings("deprecation")
public class AlchemySulfurOreGenerator {
    private static int vein_size = 7, veins_per_chunk = 25, lower_bound = 0, upper_bound = 127;

    private static ConfiguredFeature<?, ?> SULFUR_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER,
                    AlchemyBlocks.SULFUR_ORE.getDefaultState(), vein_size))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.fixed(lower_bound), YOffset.fixed(upper_bound))))
            .spreadHorizontally().repeat(veins_per_chunk);

    public static void init() {
        RegistryKey<ConfiguredFeature<?, ?>> SulfurOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("alchemycraft", "sulfur_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, SulfurOreOverworld.getValue(), SULFUR_ORE_OVERWORLD);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES, BiomeKeys.CRIMSON_FOREST, BiomeKeys.WARPED_FOREST),
                GenerationStep.Feature.UNDERGROUND_ORES, SulfurOreOverworld);
    }
}
