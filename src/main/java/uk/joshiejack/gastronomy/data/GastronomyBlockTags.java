package uk.joshiejack.gastronomy.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;
import uk.joshiejack.gastronomy.item.GastronomyTags;

import javax.annotation.Nullable;

public class GastronomyBlockTags extends BlockTagsProvider {
    public GastronomyBlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Gastronomy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(GastronomyTags.HEAT_SOURCE).add(GastronomyBlocks.OVEN.get());
        tag(GastronomyTags.FRIDGES).add(GastronomyBlocks.FRIDGE.get());
    }
}
