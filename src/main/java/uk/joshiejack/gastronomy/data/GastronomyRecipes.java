package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.util.ResourceLocation;
import uk.joshiejack.gastronomy.Gastronomy;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class GastronomyRecipes extends RecipeProvider {
    public GastronomyRecipes(DataGenerator generator) {
        super(generator);
    }

    private ResourceLocation rl (String name) {
        return new ResourceLocation(Gastronomy.MODID, name);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) { }

//    @SuppressWarnings("ConstantConditions")
//    @SubscribeEvent
//    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
//        if (GastronomyConfig.addKitchenRecipes) {
//            RecipeHelper helper = new RecipeHelper(event.getRegistry(), MODID);
//            helper.shapedRecipe("knife", UTENSIL.getStackFromEnum(KNIFE), " I", "S ", 'I', "ingotIron", 'S', "stickWood");
//            helper.shapedRecipe("pot", COOKWARE.getStackFromEnum(COUNTER), "S", "W", 'S', Blocks.STONE_SLAB, 'W', "plankWood");
//            helper.shapedRecipe("mixer", COOKWARE.getStackFromEnum(MIXER), "S", "G", "S", 'S', "slabWood", 'G', "blockGlass");
//            helper.shapedRecipe("pot", COOKWARE.getStackFromEnum(POT), "I I", "III", 'I', "ingotIron");
//            helper.shapedRecipe("oven", COOKWARE.getStackFromEnum(OVEN_OFF), "WFW", "WSW", "WWW", 'W', "plankWood", 'F', Items.FLINT_AND_STEEL, 'S', Blocks.FURNACE);
//            helper.shapedRecipe("frying_pan", COOKWARE.getStackFromEnum(FRYING_PAN), "  S", "II ", 'I', "ingotIron", 'S', "stickWood");
//            helper.shapedRecipe("fridge", STORAGE.getStackFromEnum(FridgeBlock.Storage.FRIDGE), "ID", 'I', "blockIron", 'D', Items.IRON_DOOR);
//        }
//
//        if (GastronomyConfig.disableVanillaFoodRecipes) {
//            for (String r: removals) {
//                ((ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", r));
//            }
//
//            List<Item> removals = Lists.newArrayList(Items.PORKCHOP, Items.BEEF, Items.CHICKEN, Items.RABBIT, Items.MUTTON, Items.POTATO, Items.CHORUS_FRUIT, Items.FISH);
//            FurnaceRecipes.instance().getSmeltingList().entrySet().removeIf(entry -> {
//                removals.contains(entry.getKey().getItem());
//                return true;
//            });
//        }
//    }
}
