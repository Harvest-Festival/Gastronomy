package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.tileentity.TileEntityType;
import uk.joshiejack.penguinlib.tile.AbstractPenguinTileEntity;

public class SinkTileEntity extends AbstractPenguinTileEntity {
    public SinkTileEntity() {
        super(GastronomyTileEntities.SINK.get());
    }
//    private Direction facing = EnumFacing.NORTH;
//
//    @Override
//    protected FluidTank createTank() {
//        FluidTank tank = new FluidTank(FluidRegistry.WATER, Fluid.BUCKET_VOLUME, Fluid.BUCKET_VOLUME) {
//            @Nullable
//            @Override
//            public FluidStack drainInternal(int maxDrain, boolean doDrain) {
//                if (fluid == null || maxDrain <= 0) {
//                    return null;
//                }
//
//                int drained = maxDrain;
//                if (fluid.amount < drained) {
//                    drained = fluid.amount;
//                }
//
//                FluidStack stack = new FluidStack(fluid, drained);
//                if (doDrain) {
//                    onContentsChanged();
//                    if (tile != null) {
//                        FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(fluid, tile.getWorld(), tile.getPos(), this, drained));
//                    }
//                }
//                return stack;
//            }
//        };
//
//        tank.setTileEntity(this);
//        return tank;
//    }
//
//    @Override
//    public boolean onRightClicked(PlayerEntity player, Hand hand) {
//        FluidUtil.interactWithFluidHandler(player, hand, tank);
//        return true;
//    }
//
//    @Override
//    public void setFacing(Direction facing) {
//        this.facing = facing;
//        this.markDirty();
//        if (!world.isClientSide) {
//            PenguinNetwork.sendToNearby(this, new SetDirectionPacket(pos, facing));
//        }
//    }
//
//    @Nonnull
//    @Override
//    public Direction getFacing() {
//        return facing;
//    }
//
//    @Override
//    public void readFromNBT(CompoundNBT nbt) {
//        super.readFromNBT(nbt);
//        facing = EnumFacing.values()[nbt.getByte("Facing")];
//        if (facing == null || facing.getHorizontalIndex() < 0) facing = EnumFacing.NORTH;
//    }
//
//    @Nonnull
//    @Override
//    public CompoundNBT writeToNBT(CompoundNBT nbt) {
//        nbt.putByte("Facing", (byte) facing.ordinal());
//        return super.writeToNBT(nbt);
//    }
}
