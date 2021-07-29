package uk.joshiejack.gastronomy.item;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class FluidContainerItem extends Item {
    private final Supplier<ForgeFlowingFluid> fluid;

    public FluidContainerItem(Supplier<ForgeFlowingFluid> fluid, Properties properties) {
        super(properties);
        this.fluid = fluid;
    }

    @Nonnull
    @Override
    public UseAction getUseAnimation(@Nonnull ItemStack stack) {
        return stack.getItem().isEdible() ? UseAction.DRINK : UseAction.NONE;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, CompoundNBT nbt) {
        return new DefaultConsumable(stack, FluidAttributes.BUCKET_VOLUME, fluid.get());
    }

    public static class DefaultConsumable extends FluidHandlerItemStack.Consumable {
        public DefaultConsumable(ItemStack container, int capacity, Fluid fluid) {
            super(container, capacity);
            setFluid(new FluidStack(fluid, capacity));
        }
    }
}
