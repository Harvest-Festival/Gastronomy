package uk.joshiejack.gastronomy.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static uk.joshiejack.gastronomy.Gastronomy.MODID;

@SuppressWarnings("unused")
public class GastronomyFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final RegistryObject<ForgeFlowingFluid> COOKING_OIL = FLUIDS.register("cooking_oil", () -> new ForgeFlowingFluid.Source(createCookingOilProperties()));
    public static final RegistryObject<ForgeFlowingFluid> WINE = FLUIDS.register("wine", () -> new ForgeFlowingFluid.Source(createWineProperties()));

    private static ForgeFlowingFluid.Properties createCookingOilProperties() {
        ResourceLocation texture = new ResourceLocation(MODID, "block/fluids/cooking_oil");
        return new ForgeFlowingFluid.Properties(COOKING_OIL, COOKING_OIL,
                FluidAttributes.builder(texture, texture)
                        .overlay(new ResourceLocation("block/water_overlay")).density(920).temperature(285));
    }

    private static ForgeFlowingFluid.Properties createWineProperties() {
        ResourceLocation texture = new ResourceLocation(MODID, "block/fluids/wine");
        return new ForgeFlowingFluid.Properties(WINE, WINE,
                FluidAttributes.builder(texture, texture)
                        .overlay(new ResourceLocation("block/water_overlay")).density(985).temperature(295));
    }
}
