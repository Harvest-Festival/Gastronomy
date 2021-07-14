package uk.joshiejack.gastronomy.tileentity;

import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingFluids;

public class CounterTileEntity extends TileCookingFluids {
    private long lastHit;

    public CounterTileEntity() {
        super(Appliance.COUNTER, 30, GastronomyTileEntities.COUNTER.get());
    }

//    @Override
//    public void animate() {
//        long thisHit = System.currentTimeMillis();
//        if (thisHit - lastHit >= 201 || cookTimer % 3 == 0) {
//            world.playSound(getPos().getX(), getPos().getY(), getPos().getZ(), GastronomySounds.COUNTER, SoundCategory.BLOCKS, 1F, 1F, false);
//        }
//
//        lastHit = System.currentTimeMillis();
//    }
}
