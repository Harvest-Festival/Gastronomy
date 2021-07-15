package uk.joshiejack.gastronomy.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import uk.joshiejack.gastronomy.tileentity.FryingPanTileEntity;

import javax.annotation.Nonnull;

public class FryingPanBlock extends AbstractCookwareBlock {
    public FryingPanBlock() {
        super(Properties.of(Material.METAL).strength(1F).sound(SoundType.METAL));
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new FryingPanTileEntity();
    }
}
