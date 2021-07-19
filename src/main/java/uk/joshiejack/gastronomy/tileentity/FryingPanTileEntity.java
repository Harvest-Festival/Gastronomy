package uk.joshiejack.gastronomy.tileentity;

import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingHeatable;

public class FryingPanTileEntity extends TileCookingHeatable {
    public FryingPanTileEntity() {
        super(Appliance.FRYING_PAN, GastronomySounds.FRYING_PAN.get(), GastronomyTileEntities.FRYING_PAN.get());
    }
}