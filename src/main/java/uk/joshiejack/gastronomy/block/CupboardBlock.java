package uk.joshiejack.gastronomy.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.gastronomy.tileentity.CupboardTileEntity;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

import javax.annotation.Nonnull;

public class CupboardBlock extends AbstractRotatableBlock {
    public CupboardBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(1.5F).sound(SoundType.WOOD));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(GastronomyBlocks.SECTION, GastronomyBlocks.Section.STRAIGHT));
        setHasInventory();
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new CupboardTileEntity();
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateContainer.Builder<Block, BlockState> stateContainerBuilder) {
        stateContainerBuilder.add(FACING, GastronomyBlocks.SECTION);
    }
}
