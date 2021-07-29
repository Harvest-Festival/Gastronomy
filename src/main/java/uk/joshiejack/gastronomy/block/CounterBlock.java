package uk.joshiejack.gastronomy.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.gastronomy.item.GastronomyTags;
import uk.joshiejack.gastronomy.tileentity.CounterTileEntity;

import javax.annotation.Nonnull;

public class CounterBlock extends AbstractCookwareBlock {
    private static final VoxelShape NORTH = Block.box(0D, 0D, 1D, 16D, 16D, 16D);
    private static final VoxelShape SOUTH = Block.box(0D, 1D, 0D, 16D, 16D, 15D);
    private static final VoxelShape WEST = Block.box(1D, 1D, 0D, 16D, 16D, 16D);
    private static final VoxelShape EAST = Block.box(0D, 1D, 0D, 15D, 16D, 16D);

    public CounterBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(1.5F).sound(SoundType.WOOD));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(GastronomyBlocks.SECTION, GastronomyBlocks.Section.STRAIGHT));
    }

    @Override
    @SuppressWarnings("deprecation")
    @Nonnull
    public VoxelShape getShape(@Nonnull BlockState state, @Nonnull IBlockReader reader, @Nonnull BlockPos pos, @Nonnull ISelectionContext ctx) {
        switch (state.getValue(HorizontalBlock.FACING)) {
            case NORTH:
                return NORTH;
            case SOUTH:
                return SOUTH;
            case WEST:
                return WEST;
            case EAST:
                return EAST;
        }

        return super.getShape(state, reader, pos, ctx);
    }

    @Override
    public ActionResultType use(@Nonnull BlockState state, World world, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand hand, @Nonnull BlockRayTraceResult blockRayTraceResult) {
        ItemStack held = player.getItemInHand(hand);
        if (held.getItem().is(GastronomyTags.KNIVES)) {
            TileEntity tile = world.getBlockEntity(pos);
            if (!(tile instanceof CounterTileEntity))
                return ActionResultType.PASS;
            ((CounterTileEntity)tile).activate();
            held.hurtAndBreak(1, player, (s) -> s.broadcastBreakEvent(hand));
            return ActionResultType.SUCCESS;
        } else return super.use(state, world, pos, player, hand, blockRayTraceResult);
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new CounterTileEntity();
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateContainer.Builder<Block, BlockState> stateContainerBuilder) {
        stateContainerBuilder.add(FACING, GastronomyBlocks.SECTION);
    }
}