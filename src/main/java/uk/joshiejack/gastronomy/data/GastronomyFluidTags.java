package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.fluid.GastronomyFluids;
import uk.joshiejack.penguinlib.util.PenguinTags;

import javax.annotation.Nullable;

public class GastronomyFluidTags extends FluidTagsProvider {
    public static final ITag.INamedTag<Fluid> WINE = PenguinTags.forgeFluidTag("wine");
    public static final ITag.INamedTag<Fluid> COOKING_OIL = PenguinTags.forgeFluidTag("cooking_oil");

    public GastronomyFluidTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Gastronomy.MODID, existingFileHelper);

    }

    @Override
    public void addTags() {
        tag(WINE).add(GastronomyFluids.WINE.get());
        tag(COOKING_OIL).add(GastronomyFluids.COOKING_OIL.get());
    }
}
