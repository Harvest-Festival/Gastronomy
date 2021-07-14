package uk.joshiejack.gastronomy.data;

import joptsimple.internal.Strings;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.item.GastronomyItems;

import java.util.Objects;

public class GastronomyItemModels extends ItemModelProvider {
    public GastronomyItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Gastronomy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        GastronomyItems.ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .forEach(item -> {
                    String path = Objects.requireNonNull(item.getRegistryName()).getPath();
                    if (item instanceof BlockItem)
                        getBuilder(path).parent(new ModelFile.UncheckedModelFile(modLoc("block/" + path)));
                    else {
                        String subdir =
                                item.getFoodProperties() != null && item.getFoodProperties().getNutrition() > 3 ? "meal/" :
                                        item.getFoodProperties() == null ? "loot/" :
                                                Strings.EMPTY;
                        singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + subdir));
                    }
                });
    }
}
