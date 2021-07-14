package uk.joshiejack.gastronomy.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.gastronomy.tileentity.SinkTileEntity;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

import javax.annotation.Nonnull;

public class SinkBlock extends AbstractRotatableBlock {
    public SinkBlock() {
        super(Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(1.5F).sound(SoundType.WOOD));
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new SinkTileEntity();
    }
}
