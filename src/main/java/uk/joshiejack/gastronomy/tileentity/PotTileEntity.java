package uk.joshiejack.gastronomy.tileentity;

import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingHeatable;

public class PotTileEntity extends TileCookingHeatable /*implements ITankProvider*/ {
    public PotTileEntity() {
        super(Appliance.POT, GastronomySounds.POT.get(), GastronomyTileEntities.POT.get());
    }
}