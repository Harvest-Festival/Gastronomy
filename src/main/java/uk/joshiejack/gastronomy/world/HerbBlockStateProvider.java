package uk.joshiejack.gastronomy.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraftforge.fml.RegistryObject;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;

import javax.annotation.Nonnull;
import java.util.Random;

public class HerbBlockStateProvider extends BlockStateProvider {
    public static final HerbBlockStateProvider INSTANCE = new HerbBlockStateProvider();
    public static final Codec<HerbBlockStateProvider> CODEC = Codec.unit(() -> INSTANCE);
    @SuppressWarnings("unchecked")
    private static final RegistryObject<Block>[] HERBS = (RegistryObject<Block>[]) new RegistryObject[]{ GastronomyBlocks.MINT, GastronomyBlocks.CHAMOMILE, GastronomyBlocks.LAVENDER };

    @Nonnull
    @Override
    protected BlockStateProviderType<?> type() {
        return GastronomyWorld.HERB_PROVIDER.get();
    }

    @Nonnull
    @Override
    public BlockState getState(@Nonnull Random random, @Nonnull BlockPos pos) {
        return Util.getRandom(HERBS, random).get().defaultBlockState();
    }
}