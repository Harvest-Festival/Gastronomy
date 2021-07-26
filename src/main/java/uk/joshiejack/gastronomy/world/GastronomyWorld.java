package uk.joshiejack.gastronomy.world;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;

import java.util.Objects;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Gastronomy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GastronomyWorld {
    public static final DeferredRegister<BlockStateProviderType<?>> PROVIDERS = DeferredRegister.create(ForgeRegistries.BLOCK_STATE_PROVIDER_TYPES, Gastronomy.MODID);
    public static final RegistryObject<BlockStateProviderType<HerbBlockStateProvider>> HERB_PROVIDER = PROVIDERS.register("herbs", () -> new BlockStateProviderType<>(HerbBlockStateProvider.CODEC));
    public static ConfiguredFeature<BlockClusterFeatureConfig, ?> BAMBOO_SHOOTS = null;
    public static ConfiguredFeature<BlockClusterFeatureConfig, ?> MATSUTAKE_MUSHROOMS = null;
    public static ConfiguredFeature<BlockClusterFeatureConfig, ?> HERBS = null;

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> registerFeature(String key, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Gastronomy.MODID, key), feature);
    }

    @SubscribeEvent
    public static void onSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BAMBOO_SHOOTS = registerFeature("bamboo_shoots", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GastronomyBlocks.BAMBOO_SHOOTS.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(8).build()));
            MATSUTAKE_MUSHROOMS = registerFeature("matsutake_mushrooms", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GastronomyBlocks.MATSUTAKE_MUSHROOM.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).noProjection().build()));
            HERBS = registerFeature("herbs", Feature.FLOWER.configured((new BlockClusterFeatureConfig.Builder(HerbBlockStateProvider.INSTANCE, SimpleBlockPlacer.INSTANCE)).tries(64).build()));
        });
    }

    @Mod.EventBusSubscriber(modid = Gastronomy.MODID)
    public static class Loader {
        @SubscribeEvent
        public static void onBiomeLoad(BiomeLoadingEvent event) {
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(RegistryKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(event.getName())));
            if (types.contains(BiomeDictionary.Type.CONIFEROUS))
                event.getGeneration().addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MATSUTAKE_MUSHROOMS.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(3).chance(4));
            else if (types.contains(BiomeDictionary.Type.JUNGLE) && types.contains(BiomeDictionary.Type.HOT))
                event.getGeneration().addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BAMBOO_SHOOTS.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(5).chance(4));
            else if (!types.contains(BiomeDictionary.Type.WATER) && !types.contains(BiomeDictionary.Type.HOT) && !types.contains(BiomeDictionary.Type.COLD))
                event.getGeneration().addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HERBS.decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(5).chance(4));
        }
    }
}
