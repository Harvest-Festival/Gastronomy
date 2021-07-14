package uk.joshiejack.gastronomy.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.penguinlib.network.PenguinPacket;
import uk.joshiejack.penguinlib.util.PenguinLoader;

@PenguinLoader.Packet(NetworkDirection.PLAY_TO_SERVER)
public class CookRecipePacket extends PenguinPacket {
    private ResourceLocation recipeID;
    private Appliance appliance;
    public CookRecipePacket() {}
    public CookRecipePacket(ResourceLocation recipeID, Appliance appliance) {
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

    @Override
    public void handle(PlayerEntity player) {
        /*
        player.level.getServer().getRecipeManager().getAllRecipesFor(appliance.getRecipeType());
        if (recipe != null) {
            CookerTileEntity cooking = Cooker.getNearbyAppliance(player, appliance);
            if (cooking != null) {
                List<IItemHandlerModifiable> inventories = Cooker.getFoodStorageAndPlayer(player);
                Cooker.takeFromFridgeOrPlayerInventory(cooking, inventories, recipe.getRequired());
                cooking.markDirty();
            }
        } */
    }
}
