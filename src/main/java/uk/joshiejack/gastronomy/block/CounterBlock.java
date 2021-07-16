package uk.joshiejack.gastronomy.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import uk.joshiejack.gastronomy.item.GastronomyTags;
import uk.joshiejack.gastronomy.tileentity.CounterTileEntity;

import javax.annotation.Nonnull;

public class CounterBlock extends AbstractSectionalBlock {
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
}