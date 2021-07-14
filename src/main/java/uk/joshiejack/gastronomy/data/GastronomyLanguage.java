package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import uk.joshiejack.gastronomy.Gastronomy;

public class GastronomyLanguage extends LanguageProvider {
    public GastronomyLanguage(DataGenerator gen) {
        super(gen, Gastronomy.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.gastronomy.creativetab", "Gastronomy");
    }
}
