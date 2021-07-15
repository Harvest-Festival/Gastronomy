package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import uk.joshiejack.gastronomy.Gastronomy;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static net.minecraftforge.common.Tags.Fluids.MILK;
import static net.minecraftforge.common.Tags.Items.CROPS_POTATO;
import static net.minecraftforge.common.Tags.Items.EGGS;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.*;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.CHOCOLATE;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.FLOUR;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.RICEBALL;
import static uk.joshiejack.gastronomy.data.builder.CookingRecipeBuilder.RecipeIngredientBuilder.fluid;
import static uk.joshiejack.gastronomy.data.builder.CookingRecipeBuilder.RecipeIngredientBuilder.item;
import static uk.joshiejack.gastronomy.data.builder.CookingRecipeBuilder.oven;
import static uk.joshiejack.gastronomy.item.GastronomyItems.*;
import static uk.joshiejack.penguinlib.util.PenguinTags.CROPS_APPLE;
import static uk.joshiejack.penguinlib.util.PenguinTags.CROPS_PUMPKIN;


public class GastronomyRecipes extends RecipeProvider {
    public GastronomyRecipes(DataGenerator generator) {
        super(generator);
    }

    private ResourceLocation rl (String name) {
        return new ResourceLocation(Gastronomy.MODID, name);
    }

    @Override
    protected void buildShapelessRecipes(@Nonnull Consumer<IFinishedRecipe> consumer) {
        oven(Items.COOKIE, 4, item(FLOUR), item(CHOCOLATE)).save(consumer, rl("cookie"));
        oven(Items.CAKE, 1, fluid(MILK, 1000), item(EGGS), item(SUGAR), item(FLOUR)).save(consumer, rl("cake"));
        oven(Items.BREAD, 1, item(FLOUR)).save(consumer, rl("bread"));
        oven(Items.BAKED_POTATO, 1, item(CROPS_POTATO)).save(consumer, rl("baked_potato"));
        oven(Items.COOKED_CHICKEN, 1, item(RAW_CHICKEN)).save(consumer, rl("cooked_chicken"));
        oven(Items.COOKED_BEEF, 1, item(RAW_BEEF)).save(consumer, rl("cooked_beef"));
        oven(Items.COOKED_PORKCHOP, 1, item(RAW_PORK)).save(consumer, rl("cooked_porkchop"));
        oven(Items.COOKED_MUTTON, 1, item(RAW_MUTTON)).save(consumer, rl("cooked_mutton"));
        oven(Items.COOKED_RABBIT, 1, item(RAW_RABBIT)).save(consumer, rl("cooked_rabbit"));
        oven(Items.COOKED_COD, 1, item(RAW_COD)).save(consumer, rl("cooked_cod"));
        oven(Items.COOKED_SALMON, 1, item(RAW_SALMON)).save(consumer, rl("cooked_salmon"));
        oven(Items.PUMPKIN_PIE, 1, item(CROPS_PUMPKIN), item(SUGAR), item(EGGS)).save(consumer, rl("pumpkin_pie"));
        oven(Items.POPPED_CHORUS_FRUIT, 1, item(CHORUS_FRUIT)).save(consumer, rl("popped_chorus_fruit"));
        oven(Items.DRIED_KELP, 1, item(KELP));
        oven(FRUIT_CAKE.get(), 1, item(EGGS), item(FLOUR), item(BUTTER), item(FRUIT_CAKE_FRUIT)).save(consumer, rl("fruit_cake"));
        oven(CHOCOLATE_CAKE.get(), 1, item(EGGS), item(FLOUR), item(BUTTER), item(CHOCOLATE)).save(consumer, rl("chocolate_cake"));
        oven(BUTTER_BISCUITS.get(), 1, item(EGGS), item(BUTTER), item(FLOUR));
        oven(DORIA.get(), 1, item(ONION), item(BUTTER), fluid(MILK), item(RICEBALL), item(FLOUR)).save(consumer, rl("doria"));
        oven(APPLE_PIE.get(), 1, item(CROPS_APPLE), item(EGGS), item(BUTTER), item(FLOUR)).save(consumer, rl("apple_pie"));
        oven(TOASTED_RICEBALLS.get(), 1, item(RICEBALL)).save(consumer, rl("toasted_riceballs"));
        oven(SWEET_POTATOES.get(), 1, item(SWEET_POTATO), item(BUTTER), item(EGGS)).save(consumer, rl("sweet_potatoes"));
        oven(TOAST.get(), 1, item(BREAD)).save(consumer, rl("toast"));
        oven(new ResourceLocation("horticulture", "baked_corn"), 1, item(CORN)).save(consumer, rl("baked_corn"));
        oven(new ResourceLocation("husbandry", "dinner_roll"), 1, item(EGGS), item(BUTTER), fluid(MILK)).save(consumer, rl("dinner_roll"));
    }

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
