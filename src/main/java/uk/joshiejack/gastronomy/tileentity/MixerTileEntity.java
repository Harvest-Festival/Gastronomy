package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.client.renderer.CookerItemRender;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.CookerTileEntity;

public class MixerTileEntity extends CookerTileEntity implements ITickableTileEntity {
    private static final float MAX_OFFSET1 = 0.5F;
    private static final float MIN_OFFSET1 = -0.5F;
    private static final float MAX_OFFSET2 = 0F / 1.75F;
    private static final float MIN_OFFSET2 = 1F / 1.75F;

    public float blade = 0F;
    public float prevBlade = 0F;

    public MixerTileEntity() {
        super(Appliance.MIXER, 70, GastronomyTileEntities.MIXER.get());
    }

    @Override
    public void tick() {
        activate();
    }

    @OnlyIn(Dist.CLIENT)
    public CookerItemRender createRender() {
        return new CookerItemRender() {
            @Override
            public void initSlot(World world, int slot) {
                rotation[slot] = world.random.nextFloat() * 360.0F;
                offsetX[slot] = 0.5F - world.random.nextFloat();
                offsetZ[slot] = 0.5F - world.random.nextFloat();
                offsetY[slot] = (world.random.nextFloat() * 0.15F);
            }

            @Override
            public void animate() {
                for (int i = 0; i < rotation.length; i++) {
                    if (rotation[i] < 360F)
                        rotation[i] += (i % 2 == 1) ? -7.5F : 7.5F;
                    else
                        rotation[i] = 0F;
                    //offsetX[i] = offsetX[i] + 0.1F;
                    if (offsetX[i] > MAX_OFFSET1)
                        offsetX[i] = MIN_OFFSET1;
                   // offsetZ[i] = offsetZ[i] + 0.1F;
                    if (offsetZ[i] > MAX_OFFSET2)
                        offsetZ[i] = MIN_OFFSET2;
                }
            }
        };
    }

    @Override
    protected void onCooking() {
        //Play the sound effect
        if (cookTimer % 100 == 0)
            level.playSound(null, worldPosition.getX(), worldPosition.getY() + 0.5D, worldPosition.getZ(), GastronomySounds.MIXER.get(),
                    SoundCategory.BLOCKS, 2F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void animate() {
        prevBlade = blade;
        blade += 0.5F;
        getRenderer().animate();
    }
}
