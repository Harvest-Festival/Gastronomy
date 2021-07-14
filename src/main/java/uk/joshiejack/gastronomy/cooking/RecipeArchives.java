//package uk.joshiejack.gastronomy.cooking;
//
//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;
//import com.google.common.collect.Sets;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.nbt.ListNBT;
//import net.minecraft.world.World;
//import net.minecraft.world.storage.WorldSavedData;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.gameevent.PlayerEvent;
//import uk.joshiejack.gastronomy.GastronomyConfig;
//import uk.joshiejack.gastronomy.network.SyncAddRecipePacket;
//import uk.joshiejack.gastronomy.network.SyncLearntRecipesPacket;
//import uk.joshiejack.penguinlib.data.holder.HolderMeta;
//import uk.joshiejack.penguinlib.network.PenguinNetwork;
//import uk.joshiejack.penguinlib.util.helpers.minecraft.NBTHelper;
//import uk.joshiejack.penguinlib.world.teams.PenguinTeams;
//
//import javax.annotation.Nonnull;
//import java.util.Collection;
//import java.util.Set;
//import java.util.UUID;
//
//import static uk.joshiejack.gastronomy.Gastronomy.MODID;
//
//@Mod.EventBusSubscriber(modid = MODID)
//public class RecipeArchives extends WorldSavedData {
//    private static final String DATA_NAME = "Gastronomy-Recipes";
//    private static RecipeArchives instance;
//
//    private final Multimap<UUID, HolderMeta> recipes = HashMultimap.create();
//
//    public RecipeArchives(String data) {
//        super(data);
//    }
//
//    public static RecipeArchives get(World world) {
//        instance = (RecipeArchives) world.getPerWorldStorage().getOrLoadData(RecipeArchives.class, DATA_NAME);
//        if (instance == null) {
//            instance = new RecipeArchives(DATA_NAME);
//            world.getPerWorldStorage().setData(DATA_NAME, instance);
//            instance.markDirty(); //Save the file
//        }
//
//        return instance;
//    }
//
//    public boolean learnRecipe(PlayerEntity player, ItemStack stack) {
//        HolderMeta meta = new HolderMeta(stack);
//        Collection<HolderMeta> collection = recipes.get(PenguinTeams.get(player.level).getTeamUUIDForPlayer(player));
//        if (!collection.contains(meta)) {
//            PenguinNetwork.sendToClient(new SyncAddRecipePacket(stack), player);
//            collection.add(meta);
//            markDirty();
//            return true;
//        } else return false;
//    }
//
//    @SuppressWarnings("ConstantConditions")
//    private Collection<HolderMeta> getCollection(PlayerEntity player) {
//        Collection<HolderMeta> collection = recipes.get(PenguinTeams.get(player.level).getTeamUUIDForPlayer(player));
//        if (!GastronomyConfig.findRecipes) {
//            collection.addAll(Recipe.RECIPE_BY_STACK.keySet());  //Add all the recipes
//            markDirty(); //Changed so mark dirty
//        } else if (GastronomyConfig.vanillaRecipes) {
//            Recipe.RECIPE_BY_STACK.keySet().stream()
//                    .filter((m) -> m.getStacks().get(0).getItem().getRegistryName().getNamespace().equals("minecraft"))
//                    .forEach(collection::add); //Add all the recipes
//            markDirty(); //Changed so mark dirty
//        }
//
//        return collection;
//    }
//
//    @SubscribeEvent
//    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
//        Collection<HolderMeta> collection = get(event.getPlayer().level).getCollection(event.getPlayer());
//        PenguinNetwork.sendToClient(new SyncLearntRecipesPacket(collection), event.getPlayer());
//    }
//
//    @Override
//    public void readFromNBT(@Nonnull CompoundNBT nbt) {
//        ListNBT list = nbt.getList("Teams", 10);
//        for (int i = 0; i < list.size(); i++) {
//            CompoundNBT tag = list.getCompound(i);
//            UUID uuid = UUID.fromString(tag.getString("UUID"));
//            Set<HolderMeta> set = Sets.newHashSet();
//            NBTHelper.readHolderCollection(tag.getList("Recipes", 10), set);
//            set.forEach((holder) -> recipes.get(uuid).add(holder));
//        }
//    }
//
//    @Nonnull
//    @Override
//    public CompoundNBT writeToNBT(@Nonnull CompoundNBT nbt) {
//        ListNBT list = new ListNBT();
//        for (UUID uuid: recipes.keySet()) {
//            CompoundNBT tag = new CompoundNBT();
//            tag.setString("UUID", uuid.toString());
//            tag.put("Recipes", NBTHelper.writeHolderCollection(recipes.get(uuid)));
//            list.add(tag);
//        }
//
//        nbt.put("Teams", list);
//        return nbt;
//    }
//}
