package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.client.renderer.CookerItemRender;
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

    @OnlyIn(Dist.CLIENT)
    public CookerItemRender createRender() {
        return new CookerItemRender() {
            @Override
            public void initSlot(World world, int slot) {
                rotation[slot] = world.random.nextFloat() * 360.0F;
                offsetX[slot] = 0.5F - world.random.nextFloat();
                offsetZ[slot] = 0.5F - world.random.nextFloat();
                offsetY[slot] = (world.random.nextFloat() * 0.05F);
            }
        };
    }
}