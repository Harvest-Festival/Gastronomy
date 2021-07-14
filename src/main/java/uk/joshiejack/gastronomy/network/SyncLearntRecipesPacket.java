package uk.joshiejack.gastronomy.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.cooking.RecipeBook;
import uk.joshiejack.penguinlib.network.PenguinPacket;
import uk.joshiejack.penguinlib.util.PenguinLoader;

import java.util.ArrayList;
import java.util.Collection;

@PenguinLoader.Packet(NetworkDirection.PLAY_TO_CLIENT)
public class SyncLearntRecipesPacket extends PenguinPacket {
    private Appliance appliance;
    private Collection<ResourceLocation> learnt;

    public SyncLearntRecipesPacket() { }
    public SyncLearntRecipesPacket(Appliance appliance, Collection<ResourceLocation> learnt) {
        this.appliance = appliance;
        this.learnt = learnt;
    }

    @Override
    public void encode(PacketBuffer to) {
        to.writeByte(appliance.ordinal());
        to.writeShort(learnt.size());
        learnt.forEach(to::writeResourceLocation);
    }

    @Override
    public void decode(PacketBuffer from) {
        this.appliance = Appliance.values()[from.readByte()];
        int times = from.readShort();
        learnt = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            learnt.add(from.readResourceLocation());
        }
    }

    @Override
    public void handle(PlayerEntity player) {
        RecipeBook.setLearntRecipes(appliance, learnt);
    }
}
