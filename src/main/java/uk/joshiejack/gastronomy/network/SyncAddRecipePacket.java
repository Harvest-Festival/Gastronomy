package uk.joshiejack.gastronomy.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.cooking.RecipeBook;
import uk.joshiejack.penguinlib.util.PenguinLoader;

@PenguinLoader.Packet(NetworkDirection.PLAY_TO_CLIENT)
public class SyncAddRecipePacket extends AbstractSyncRecipePacket {
    public SyncAddRecipePacket() {}
    public SyncAddRecipePacket(ResourceLocation recipeID, Appliance appliance) {
        super(recipeID, appliance);
    }

    @Override
    public void handle(PlayerEntity player) {
        RecipeBook.addLearntRecipe(appliance, recipeID);
    }
}
