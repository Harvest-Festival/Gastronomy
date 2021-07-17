package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.client.renderer.CookerItemRender;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingHeatable;

public class FryingPanTileEntity extends TileCookingHeatable {
    public FryingPanTileEntity() {
        super(Appliance.FRYING_PAN, GastronomySounds.FRYING_PAN.get(), GastronomyTileEntities.FRYING_PAN.get());
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