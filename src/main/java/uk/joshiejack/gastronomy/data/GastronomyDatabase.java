package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.penguinlib.data.generators.AbstractDatabaseProvider;

public class GastronomyDatabase extends AbstractDatabaseProvider {
    public GastronomyDatabase(DataGenerator gen) {
        super(gen, Gastronomy.MODID);
    }

    @Override
    protected void addDatabaseEntries() {

    }
}
