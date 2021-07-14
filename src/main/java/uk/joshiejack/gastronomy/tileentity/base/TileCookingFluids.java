package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.tileentity.TileEntityType;
import uk.joshiejack.gastronomy.cooking.Appliance;

public class TileCookingFluids extends CookerTileEntity /*implements ITankProvider */ {
    public TileCookingFluids(Appliance appliance, int timeRequired, TileEntityType<?> type) { super(appliance, timeRequired, type); }
    public TileCookingFluids(Appliance appliance, TileEntityType<?> type) {
        this(appliance, 100, type);
    }

    /*
    //Fluid storage
    private final QuadDirectionalTank tank = new QuadDirectionalTank();

    @Override
    public boolean handleFluids(@Nullable PlayerEntity player, Hand hand, ItemStack held) {
        return tryEmpty(player, held, hand, 0) || tryEmpty(player, held, hand, 1) || tryEmpty(player, held, hand, 2) || tryEmpty(player, held, hand, 3)
                || tryFill(player, held, hand, 0) || tryFill(player, held, hand, 1) || tryFill(player, held, hand, 2) || tryFill(player, held, hand, 3);
    }

    private boolean tryFill(@Nullable PlayerEntity player, ItemStack held, Hand hand, int slot) {
        FluidActionResult result = FluidUtil.tryFillContainer(held, tank.get(slot), 1000, player, true);
        if (result.success) {
            if (player != null) player.setHeldItem(hand, result.result);
            if (!world.isClientSide) {
                PenguinNetwork.sendToNearby(this, new SetTankSlotPacket(pos, slot, tank.getFluid(slot)));
            }

            return true;
        }

        return false;
    }

    private boolean tryEmpty(@Nullable PlayerEntity player, ItemStack held, Hand hand, int slot) {
        FluidActionResult result = FluidUtil.tryEmptyContainer(held, tank.get(slot), 1000, player, true);
        if (result.success) {
            if (player != null) player.setHeldItem(hand, result.result);
            if (!world.isClientSide) {
                PenguinNetwork.sendToNearby(this, new SetTankSlotPacket(pos, slot, tank.getFluid(slot)));
            }

            return true;
        }

        return false;
    }

    @Override
    public List<FluidStack> getFluids() {
        return tank.getFluids();
    }

    @Override
    public void setTank(int slot, FluidStack stack) {
        tank.set(slot, stack);
    }

    @Override
    public void onFinished() {
        for (int i = 0; i < 4; i++) {
            tank.set(i, null);
            PenguinNetwork.sendToNearby(this, new SetTankSlotPacket(pos, i, null));
        }
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable Direction facing) {
        return (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && tank.hasTank(facing)) || super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked, ConstantConditions")
    @Override
    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
            return (T) tank.getHandlerFromFacing(facing);
        else return super.getCapability(capability, facing);
    }

    @Override
    public void readFromNBT(CompoundNBT nbt) {
        super.readFromNBT(nbt);
        tank.deserializeNBT(nbt.getCompoundTag("Fluids"));
    }

    @Nonnull
    @Override
    public CompoundNBT writeToNBT(CompoundNBT nbt) {
        nbt.put("Fluids", tank.serializeNBT());
        return super.writeToNBT(nbt);
    }*/
}
