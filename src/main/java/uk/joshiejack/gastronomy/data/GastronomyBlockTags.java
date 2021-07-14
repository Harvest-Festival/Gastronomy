package uk.joshiejack.gastronomy.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import uk.joshiejack.gastronomy.Gastronomy;

import javax.annotation.Nullable;

public class GastronomyBlockTags extends BlockTagsProvider {
    public GastronomyBlockTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Gastronomy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {}
}
