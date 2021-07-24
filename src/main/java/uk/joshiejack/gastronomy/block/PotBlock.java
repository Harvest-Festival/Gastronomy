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
import net.minecraft.world.World;
import uk.joshiejack.gastronomy.tileentity.OvenTileEntity;
import uk.joshiejack.gastronomy.tileentity.PotTileEntity;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingHeatable;

import javax.annotation.Nonnull;

public class PotBlock extends AbstractCookwareBlock {
    private static final VoxelShape SHAPE = Block.box(3D, 0D, 3D, 13D, 6D, 13D);

    public PotBlock() {
        super(Properties.of(Material.METAL).strength(1F).sound(SoundType.METAL));
    }

    @Override
    @SuppressWarnings("deprecation")
    @Nonnull
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, @Nonnull ISelectionContext ctx) {
        return SHAPE;
    }

    @Deprecated
    @Override
    public void neighborChanged(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull Block neighbor, @Nonnull BlockPos neighborPos, boolean boo) {
        super.neighborChanged(state, world, pos, neighbor, neighborPos, boo);
        TileEntity below = world.getBlockEntity(pos.below());
        TileEntity thisTile = world.getBlockEntity(pos);
        if (thisTile instanceof PotTileEntity &&
                below instanceof OvenTileEntity)
            ((OvenTileEntity) below).heatable((TileCookingHeatable) thisTile);
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new PotTileEntity();
    }
}
