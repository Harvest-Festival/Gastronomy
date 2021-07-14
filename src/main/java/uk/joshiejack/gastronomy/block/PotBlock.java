package uk.joshiejack.gastronomy.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import uk.joshiejack.gastronomy.tileentity.PotTileEntity;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

import javax.annotation.Nonnull;

public class PotBlock extends AbstractRotatableBlock {
    public PotBlock() {
        super(Properties.of(Material.METAL).strength(1F).sound(SoundType.METAL));
        setHasInventory();
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new PotTileEntity();
    }
}
