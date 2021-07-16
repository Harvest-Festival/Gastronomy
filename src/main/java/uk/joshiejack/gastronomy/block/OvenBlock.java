package uk.joshiejack.gastronomy.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import uk.joshiejack.gastronomy.tileentity.OvenTileEntity;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingHeatable;

import javax.annotation.Nonnull;

public class OvenBlock extends AbstractCookwareBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private static final VoxelShape NORTH = Block.box(0D, 0D, 1D, 16D, 16D, 16D);
    private static final VoxelShape SOUTH = Block.box(0D, 1D, 0D, 16D, 16D, 15D);
    private static final VoxelShape WEST = Block.box(1D, 1D, 0D, 16D, 16D, 16D);
    private static final VoxelShape EAST = Block.box(0D, 1D, 0D, 15D, 16D, 16D);

    public OvenBlock() {
        super(Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).strength(2F).sound(SoundType.METAL));
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }

    public static class Extractor {
        private final PlayerEntity playerEntity;
        private final IItemHandler handler;
        private int ticker;

        public Extractor(PlayerEntity player, IItemHandler itemHandler) {
            playerEntity = player;
            handler = itemHandler;
            ticker = 50;
        }

        @SubscribeEvent
        public void onWorldTick(TickEvent.WorldTickEvent event) {
            if (playerEntity == null || handler == null) MinecraftForge.EVENT_BUS.unregister(this);
            if (event.phase == TickEvent.Phase.END) {
                ticker--;
                if (ticker <= 0) {
                    ItemStack extracted = handler.extractItem(20, handler.getStackInSlot(20).getCount(), false);
                    if (!extracted.isEmpty() && event.side == LogicalSide.SERVER) {
                        ItemHandlerHelper.giveItemToPlayer(playerEntity, extracted);
                    }

                    MinecraftForge.EVENT_BUS.unregister(this);
                }
            }
        }
    }

    @Override
    public ActionResultType extract(PlayerEntity player, IItemHandler handler) {
        for(int i = 0; i < handler.getSlots(); ++i) {
            int extract = this.getExtractAmount(handler, i);
            if (extract > 0) {
                ItemStack extracted = handler.extractItem(i, extract, true);
                if (!extracted.isEmpty()) {
                    MinecraftForge.EVENT_BUS.register(new Extractor(player, handler));
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return ActionResultType.PASS;
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

    @Deprecated
    @Override
    public void neighborChanged(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull Block neighbor, @Nonnull BlockPos neighborPos, boolean boo) {
        super.neighborChanged(state, world, pos, neighbor, neighborPos, boo);
        TileEntity above = world.getBlockEntity(pos.above());
        TileEntity thisTile = world.getBlockEntity(pos);
        if (thisTile instanceof OvenTileEntity) {
            if (above instanceof TileCookingHeatable) {
                ((OvenTileEntity) thisTile).heatable((TileCookingHeatable) above);
            } else ((OvenTileEntity) thisTile).heatable(null);
        }
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new OvenTileEntity();
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateContainer.Builder<Block, BlockState> stateContainerBuilder) {
        stateContainerBuilder.add(FACING, LIT);
    }
}