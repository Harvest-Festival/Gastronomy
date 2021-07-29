package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import uk.joshiejack.gastronomy.client.renderer.CookerItemRender;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.crafting.CookingRecipe;
import uk.joshiejack.penguinlib.network.PenguinNetwork;
import uk.joshiejack.penguinlib.network.packet.SetInventorySlotPacket;
import uk.joshiejack.penguinlib.tile.inventory.AbstractInventoryTileEntity;
import uk.joshiejack.penguinlib.util.handlers.MultiFluidHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;

public abstract class CookerTileEntity extends AbstractInventoryTileEntity {
    public static final int RESULT_SLOT = 20;
    private static final int ALL_SLOTS = -777;
    private final Appliance appliance;
    protected boolean cooking;
    protected int cookTimer;
    protected LinkedList<Integer> last = new LinkedList<>();
    private final int timeRequired;
    private Optional<CookingRecipe> result = Optional.empty();
    private final MultiFluidHandler tanks = new MultiFluidHandler(4) {
        @Override
        public int fill(FluidStack resource, FluidAction action) {
            if (action == FluidAction.EXECUTE) {
                System.out.println("Filling with " + resource.getFluid().getFluid().getRegistryName());
                new Exception().printStackTrace();
            }
            for (FluidTank tank : tanks) {
                if (action == FluidAction.EXECUTE)
                    System.out.println(tank.getFluid().getFluid().getRegistryName());
                int fill = tank.fill(resource, action);
                if (fill > 0) {
                    return fill;
                }
            }

            if (action == FluidAction.EXECUTE)
            System.out.println("COULD NOT FILL ANY TANKS SO RETURNING 0");

            return 0;
        }
    };
    private final LazyOptional<IFluidHandler> holder = LazyOptional.of(() -> tanks);

    @OnlyIn(Dist.CLIENT)
    private CookerItemRender renderer;

    public CookerTileEntity(Appliance appliance, int timeRequired, TileEntityType<?> type) {
        super(type, 21);
        this.appliance = appliance;
        this.timeRequired = timeRequired;
    }

    @OnlyIn(Dist.CLIENT)
    public CookerItemRender getRenderer() {
        if (renderer == null)
            renderer = createRender();
        return renderer;
    }

    @OnlyIn(Dist.CLIENT)
    public abstract CookerItemRender createRender();

    @Nonnull
    public Item getDish() {
        if (result != null && result.isPresent()) {
            Item ret = result.get().getDish();
            result = Optional.empty();
            return ret;
        }

        return Items.AIR;
    }

    public boolean isCooking() {
        return cooking;
    }

    @Override
    public int getSlotLimit(int slot) {
        return slot == RESULT_SLOT ? getMaxStackSize() : 1;
    }

    @OnlyIn(Dist.CLIENT)
    private void reloadRenderers(int slot, ItemStack stack) {
        if (slot == ALL_SLOTS) {
            if (getRenderer().initSlot()) return;
            IntStream.range(0, last.size()).forEach(s -> getRenderer().initSlot(level, last.get(s)));
            IntStream.range(0, items.get(RESULT_SLOT).getCount()).forEach(s -> getRenderer().initSlot(level, s));
        } else if (slot == RESULT_SLOT)
            IntStream.range(0, stack.getCount()).forEach(s -> getRenderer().initSlot(level, s));
        else
            getRenderer().initSlot(level, slot);
    }

    @Override
    public void setItem(int slot, @Nonnull ItemStack stack) {
        if (!stack.isEmpty()) {
            if (slot < RESULT_SLOT)
                last.add(slot);
            if (level.isClientSide)
                reloadRenderers(slot, stack);

            if (slot != RESULT_SLOT) {
                cookTimer = 0; //Reset the timer
                cooking = true;
            }
        }

        super.setItem(slot, stack);
    }

    @Override
    public boolean canPlaceItem(int slot, @Nonnull ItemStack stack) {
        return slot < RESULT_SLOT && getItem(RESULT_SLOT).isEmpty() && (appliance.isIngredient(level, stack));
    }

    @Nonnull
    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (slot < RESULT_SLOT || items.get(RESULT_SLOT).isEmpty()) return ItemStack.EMPTY;
        return super.removeItem(slot, amount);
    }

    protected void setAndSync(int slot, ItemStack stack) {
        setItem(slot, stack);
        if (!level.isClientSide)
            PenguinNetwork.sendToNearby(new SetInventorySlotPacket(worldPosition, slot, stack), this);
    }

    public void activate() {
        //System.out.println(tanks.tanks[0].getFluid().getFluid().getRegistryName());
        //System.out.println(tanks.tanks[1].getFluid().getFluid().getRegistryName());

        if (cooking) {
            cookTimer++;
            onCooking();
            if (level.isClientSide)
                animate();
            else {
                if (last.size() == 0) {
                    cooking = false;
                    cookTimer = 0;
                    setChanged();
                } else if (cookTimer >= timeRequired) {
                    onCookingCompleted();
                }
            }
        }
    }

    protected void onCooking() {
    }

    protected void onCookingCompleted() {
        //We have finished so it's time to cook
        result = level.getRecipeManager().getAllRecipesFor(appliance.getRecipeType())
                .stream().sorted(Comparator.comparing(CookingRecipe::getPriority))
                .filter(r -> r.matches(this, level)).findFirst();
        result.ifPresent(recipe -> setAndSync(20, recipe.assemble(this)));
        if (!result.isPresent())
            setAndSync(RESULT_SLOT, appliance.getBurntItemStack());

        IntStream.range(0, 20)
                .filter(i -> !getItem(i).isEmpty())
                .forEach(i -> setAndSync(i, ItemStack.EMPTY));
        tanks.drain(Integer.MAX_VALUE, IFluidHandler.FluidAction.EXECUTE);
        cookTimer = 0;
        cooking = false;
        setChanged();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
    }

    protected abstract void animate();

    public Appliance getAppliance() {
        return appliance;
    }

    public boolean open() {
        return true;
    }

    public ItemStack getLast() {
        int NO_SLOT_FOUND = -999;
        int lastSlot = last.size() > 0 ? last.pollLast() : NO_SLOT_FOUND;
        if (lastSlot != NO_SLOT_FOUND) {
            ItemStack ret = items.get(lastSlot).copy();
            setAndSync(lastSlot, ItemStack.EMPTY);
            return ret;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        super.onDataPacket(net, packet);
        if (level.isClientSide)
            reloadRenderers(ALL_SLOTS, ItemStack.EMPTY);
    }

    @Nonnull
    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putBoolean("Cooking", cooking);
        nbt.putInt("CookTimer", cookTimer);
        nbt.putIntArray("Last", last.stream().mapToInt(i -> i).toArray());
        nbt.put("Tanks", tanks.serializeNBT());
        return super.save(nbt);
    }

    @Override
    public void load(@Nonnull BlockState state, CompoundNBT nbt) {
        cooking = nbt.getBoolean("Cooking");
        cookTimer = nbt.getInt("CookTimer");
        for (int l : nbt.getIntArray("Last"))
            last.add(l);
        tanks.deserializeNBT(nbt.getList("Tanks", 10));
        super.load(state, nbt);
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
            return holder.cast();
        return super.getCapability(capability, facing);
    }
}
