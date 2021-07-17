package uk.joshiejack.gastronomy.client.renderer;

import net.minecraft.world.World;

public abstract class CookerItemRender {
    protected final float[] rotation = new float[20];
    protected final float[] offsetX = new float[20];
    protected final float[] offsetZ = new float[20];
    protected final float[] offsetY = new float[20];

    public abstract void initSlot(World world, int slot);

    public float getRotation(int i) {
        return rotation[i];
    }

    public double getOffsetX(int i) {
        return offsetX[i];
    }

    public double getOffsetZ(int i) {
        return offsetZ[i];
    }

    public double getOffsetY(int i) {
        return offsetY[i];
    }

    public boolean initSlot() {
        return rotation[0] != 0F;
    }
}
