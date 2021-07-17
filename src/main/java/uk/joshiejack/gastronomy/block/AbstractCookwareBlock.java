package uk.joshiejack.gastronomy.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;
import uk.joshiejack.gastronomy.GastronomyServerConfig;
import uk.joshiejack.gastronomy.tileentity.base.CookerTileEntity;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;
import uk.joshiejack.penguinlib.util.helpers.PlayerHelper;

import javax.annotation.Nonnull;

public abstract class AbstractCookwareBlock extends AbstractRotatableBlock {
    public AbstractCookwareBlock(Properties properties) {
        super(properties.noOcclusion());
        setHasInventory();
    }

    @Override
    protected int getInsertAmount(IItemHandler handler, ItemStack held) {
        return held.isEmpty() ? 0 : 1;
    }

    @Override
    protected int getExtractAmount(IItemHandler handler, int slot) {
        return handler.getStackInSlot(slot).getCount();
    }

    private static boolean stealFromCupboards(PlayerEntity player, Item item) {
        return false; //TODO
    }

    @Override
    public ActionResultType use(@Nonnull BlockState state, World world, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, @Nonnull Hand hand, @Nonnull BlockRayTraceResult blockRayTraceResult) {
        if (!this.hasInventory) {
            return super.use(state, world, pos, player, hand, blockRayTraceResult);
        } else {
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof CookerTileEntity) {
                CookerTileEntity cooker = ((CookerTileEntity) tileentity);
                LazyOptional<IItemHandler> optional = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                if (!optional.isPresent()) return ActionResultType.PASS;
                IItemHandlerModifiable handler = (IItemHandlerModifiable) optional.resolve().get();
                if (player.isShiftKeyDown()) {
                    ItemStack last = cooker.getLast();
                    if (!last.isEmpty()) {
                        if (!world.isClientSide)
                            ItemHandlerHelper.giveItemToPlayer(player, last);
                        cooker.open();
                        return ActionResultType.SUCCESS;
                    }

                    return ActionResultType.PASS;
                }

                ItemStack result = handler.getStackInSlot(CookerTileEntity.RESULT_SLOT);
                if (!result.isEmpty()) {
                    Item container = cooker.getAppliance().getDishForItem(world, result);
                    if (!GastronomyServerConfig.requireDishesToRemoveMeals.get() || container == Items.AIR || (PlayerHelper.hasInInventory(player, Ingredient.of(container), result.getCount())
                            && PlayerHelper.takeFromInventory(player, Ingredient.of(container), result.getCount())) || stealFromCupboards(player, container)) {
                        extract(player, handler);
                        cooker.open();
                        return ActionResultType.SUCCESS;
                    }

                    return ActionResultType.FAIL;
                } else
                    return !player.getItemInHand(hand).isEmpty() && insert(player, hand, handler) == ActionResultType.SUCCESS && cooker.open() ? ActionResultType.SUCCESS : ActionResultType.PASS;
            } else return ActionResultType.PASS;
        }
    }
}
