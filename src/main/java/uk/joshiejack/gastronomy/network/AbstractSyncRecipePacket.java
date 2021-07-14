package uk.joshiejack.gastronomy.network;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.penguinlib.network.PenguinPacket;

public abstract class AbstractSyncRecipePacket extends PenguinPacket {
    protected ResourceLocation recipeID;
    protected Appliance appliance;

    public AbstractSyncRecipePacket() {}
    public AbstractSyncRecipePacket(ResourceLocation recipeID, Appliance appliance) {
        this.appliance = appliance;
        this.recipeID = recipeID;
    }

    @Override
    public void encode(PacketBuffer to) {
        to.writeResourceLocation(recipeID);
        to.writeByte(appliance.ordinal());
    }

    @Override
    public void decode(PacketBuffer from) {
        recipeID = from.readResourceLocation();
        appliance = Appliance.values()[from.readByte()];
    }
}
