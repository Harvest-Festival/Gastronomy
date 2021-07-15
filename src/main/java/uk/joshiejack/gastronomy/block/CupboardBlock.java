package uk.joshiejack.gastronomy.block;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import uk.joshiejack.gastronomy.tileentity.CupboardTileEntity;

import javax.annotation.Nonnull;

public class CupboardBlock extends AbstractSectionalBlock {
    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new CupboardTileEntity();
    }
}
