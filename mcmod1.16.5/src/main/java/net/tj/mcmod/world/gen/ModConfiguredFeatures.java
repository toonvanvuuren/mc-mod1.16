package net.tj.mcmod.world.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.tj.mcmod.block.ModBlocks;

public class ModConfiguredFeatures {

     //public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCONUT =
            // register("coconut", Feature.TREE.withConfiguration((
                    // new BaseTreeFeatureConfig.Builder(
                     //        new SimpleBlockStateProvider(ModBlocks.COCONUT_LOG.get().getDefaultState()),
                     //        new SimpleBlockStateProvider(ModBlocks.COCONUT_LEAVES.get().getDefaultState()),
                    //         new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    //         new StraightTrunkPlacer(5, 3, 3),
                    //         new TwoLayerFeature(2, 0, 1))).setIgnoreVines().build()));

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> COCONUT =
            register("coconut", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.COCONUT_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.COCONUT_LEAVES.get().getDefaultState()),
                            new AcaciaFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0)),
                            new ForkyTrunkPlacer(5, 2, 2),
                            new TwoLayerFeature(2, 0, 3))).setIgnoreVines().build()));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }


}
