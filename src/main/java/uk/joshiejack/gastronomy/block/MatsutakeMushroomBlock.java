package uk.joshiejack.gastronomy.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;

public class MatsutakeMushroomBlock extends MushroomBlock {
    public MatsutakeMushroomBlock() {
        super(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).noCollission().randomTicks()
                .instabreak().sound(SoundType.GRASS).hasPostProcess((b,i,p)->true));
    }

    @Override
    public boolean canSurvive(@Nonnull BlockState state, IWorldReader world, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK))
            return true;
        else
            return blockstate.canSustainPlant(world, blockpos, net.minecraft.util.Direction.UP, this);
    }
}