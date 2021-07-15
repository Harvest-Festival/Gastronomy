package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.util.SoundCategory;
import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.CookerTileEntity;

public class CounterTileEntity extends CookerTileEntity {
    private long lastHit;

    public CounterTileEntity() {
        super(Appliance.COUNTER, 30, GastronomyTileEntities.COUNTER.get());
    }

    @Override
    protected void animate() {
        long thisHit = System.currentTimeMillis();
        if (thisHit - lastHit >= 201 || cookTimer % 3 == 0) {
            level.playSound(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), GastronomySounds.COUNTER.get(), SoundCategory.BLOCKS, 1F, 1F);
        }

        lastHit = System.currentTimeMillis();
    }
}