package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.item.GastronomyItems;

public class GastronomyLanguage extends LanguageProvider {
    public GastronomyLanguage(DataGenerator gen) {
        super(gen, Gastronomy.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.gastronomy", "Gastronomy");
        GastronomyItems.ITEMS.getEntries()
                .stream().map(RegistryObject::get)
                .forEach(item -> add(item, WordUtils.capitalizeFully(item.getRegistryName().getPath().replace("_", " "))));
        add("fluid.gastronomy.wine", "Wine");
        add("fluid.gastronomy.cooking_oil", "Cooking Oil");
    }
}
