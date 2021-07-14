package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.tileentity.TileEntityType;
import uk.joshiejack.gastronomy.cooking.Appliance;

public class TileCookingTicking extends TileCookingFluids implements ITickable {
    public TileCookingTicking(Appliance appliance, int timeRequired, TileEntityType<?> type) {
        super(appliance, timeRequired, type);
    }
    public TileCookingTicking(Appliance appliance, TileEntityType<?> type) {
        this(appliance, 100, type);
    }

    @Override
    public void tick() {
        //updateTick();
    }
}