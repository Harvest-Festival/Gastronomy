package uk.joshiejack.gastronomy.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.item.GastronomyItems;
import uk.joshiejack.penguinlib.util.PenguinTags;

import javax.annotation.Nullable;

public class GastronomyItemTags extends ItemTagsProvider {
    public GastronomyItemTags(DataGenerator generator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagProvider, Gastronomy.MODID, existingFileHelper);
    }

    @Override
    public void addTags() {
        tag(PenguinTags.forgeTag("flour")).add(GastronomyItems.FLOUR.get());
        tag(PenguinTags.forgeTag("curry_powder")).add(GastronomyItems.CURRY_POWDER.get());
    }
}
