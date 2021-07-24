package uk.joshiejack.gastronomy.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import uk.joshiejack.gastronomy.tileentity.MixerTileEntity;

import javax.annotation.Nonnull;

public class MixerBlock extends AbstractCookwareBlock {
    private static final VoxelShape SHAPE = Block.box(5D, 0D, 5D, 11D, 11D, 12D);

    public MixerBlock() {
        super(Properties.of(Material.METAL).strength(1F).sound(SoundType.METAL));
    }

    @Override
    @SuppressWarnings("deprecation")
    @Nonnull
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, @Nonnull ISelectionContext ctx) {
        return SHAPE;
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new MixerTileEntity();
    }
}
