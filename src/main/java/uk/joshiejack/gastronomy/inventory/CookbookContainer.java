package uk.joshiejack.gastronomy.inventory;

import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.penguinlib.inventory.AbstractBookContainer;

public class CookbookContainer extends AbstractBookContainer {
    public CookbookContainer(int windowID) {
        super(Gastronomy.GastronomyContainers.COOKBOOK.get(), windowID);
    }
}
