package uk.joshiejack.gastronomy.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.EventPriority;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.item.GastronomyItems;
import uk.joshiejack.penguinlib.item.PenguinItems;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

import static net.minecraftforge.common.Tags.Fluids.MILK;
import static net.minecraftforge.common.Tags.Items.*;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.BAMBOO_SHOOTS;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.CHAMOMILE;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.CHOCOLATE;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.CURRY_POWDER;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.FLOUR;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.LAVENDER;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.MATSUTAKE_MUSHROOM;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.MINT;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.NOODLES;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.RICEBALL;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.SALT;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.TEMPURA;
import static uk.joshiejack.gastronomy.data.GastronomyItemTags.*;
import static uk.joshiejack.gastronomy.data.builder.CookingRecipeBuilder.RecipeIngredientBuilder.fluid;
import static uk.joshiejack.gastronomy.data.builder.CookingRecipeBuilder.RecipeIngredientBuilder.item;
import static uk.joshiejack.gastronomy.data.builder.CookingRecipeBuilder.*;
import static uk.joshiejack.gastronomy.item.GastronomyItems.*;
import static uk.joshiejack.penguinlib.item.PenguinItems.GLASS;
import static uk.joshiejack.penguinlib.item.PenguinItems.*;
import static uk.joshiejack.penguinlib.util.PenguinTags.*;


public class GastronomyRecipes extends RecipeProvider {
    public GastronomyRecipes(DataGenerator generator) {
        super(generator);
    }

    private ResourceLocation rl(String name) {
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
        oven(FRUIT_CAKE.get(), 1, item(EGGS), item(FLOUR), item(BUTTER), item(FRUIT_CAKE_FRUIT)).dish(PLATE.get()).save(consumer, rl("fruit_cake"));
        oven(CHOCOLATE_CAKE.get(), 1, item(EGGS), item(FLOUR), item(BUTTER), item(CHOCOLATE)).dish(PLATE.get()).save(consumer, rl("chocolate_cake"));
        oven(BUTTER_BISCUITS.get(), 1, item(EGGS), item(BUTTER), item(FLOUR)).dish(PLATE.get()).save(consumer, rl("butter_biscuits"));
        oven(DORIA.get(), 1, item(ONION), item(BUTTER), fluid(MILK), item(RICEBALL), item(FLOUR)).dish(PenguinItems.DEEP_BOWL.get()).save(consumer, rl("doria"));
        oven(APPLE_PIE.get(), 1, item(CROPS_APPLE), item(EGGS), item(BUTTER), item(FLOUR)).dish(PLATE.get()).save(consumer, rl("apple_pie"));
        oven(TOASTED_RICEBALLS.get(), 1, item(RICEBALL)).dish(PLATE.get()).save(consumer, rl("toasted_riceballs"));
        oven(SWEET_POTATOES.get(), 1, item(SWEET_POTATO), item(BUTTER), item(EGGS)).dish(PLATE.get()).save(consumer, rl("sweet_potatoes"));
        oven(TOAST.get(), 1, item(BREAD)).dish(PLATE.get()).save(consumer, rl("toast"));
        oven(new ResourceLocation("horticulture", "baked_corn"), 1, item(CORN)).dish(PLATE.get()).save(consumer, rl("baked_corn"));
        oven(new ResourceLocation("husbandry", "dinner_roll"), 1, item(EGGS), item(BUTTER), fluid(MILK)).save(consumer, rl("dinner_roll"));
        fryingPan(SAVOURY_PANCAKE.get(), 1, item(FLOUR), item(CABBAGE), fluid(GastronomyFluidTags.COOKING_OIL), item(EGGS)).dish(PLATE.get()).save(consumer, rl("savoury_pancake"));
        fryingPan(FRENCH_FRIES.get(), 1, item(CROPS_POTATO), fluid(GastronomyFluidTags.COOKING_OIL)).dish(DEEP_BOWL.get()).save(consumer, rl("french_fries"));
        fryingPan(POPCORN.get(), 1, item(CORN)).dish(DEEP_BOWL.get()).save(consumer, rl("popcorn"));
        fryingPan(new ResourceLocation("horticulture", "cornflakes"), 1, item(CORN), fluid(MILK)).dish(DEEP_BOWL.get()).save(consumer, rl("cornflakes"));
        fryingPan(new ResourceLocation("horticulture", "happy_eggplant"), 1, item(EGGPLANT)).dish(PLATE.get()).save(consumer, rl("happy_eggplant"));
        fryingPan(new ResourceLocation("husbandry", "scrambled_egg"), 1, item(EGGS), fluid(GastronomyFluidTags.COOKING_OIL)).dish(DEEP_BOWL.get()).save(consumer, rl("scrambled_egg"));
        fryingPan(OMELETTE.get(), 1, item(EGGS), fluid(GastronomyFluidTags.COOKING_OIL), fluid(MILK)).dish(PLATE.get()).save(consumer, rl("omelette"));
        fryingPan(OMURICE.get(), 1, item(EGGS), fluid(GastronomyFluidTags.COOKING_OIL), fluid(MILK), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("omurice"));
        fryingPan(FRENCH_TOAST.get(), 1, item(EGGS), item(BREAD), fluid(GastronomyFluidTags.COOKING_OIL), item(SUGAR)).dish(PLATE.get()).save(consumer, rl("french_toast"));
        fryingPan(DOUGHNUT.get(), 1, item(EGGS), fluid(MILK), item(BUTTER), item(FLOUR), fluid(GastronomyFluidTags.COOKING_OIL)).dish(PLATE.get()).save(consumer, rl("doughnut"));
        fryingPan(GRILLED_FISH.get(), 1, item(RAW_FISHES), item(SALT)).dish(PLATE.get()).save(consumer, rl("grilled_fish"));
        fryingPan(PANCAKE.get(), 1, item(EGGS), fluid(MILK), item(FLOUR), fluid(GastronomyFluidTags.COOKING_OIL)).dish(PLATE.get()).save(consumer, rl("pancake"));
        fryingPan(POTSTICKER.get(), 1,  item(CABBAGE), item(ONION), item(FLOUR), fluid(GastronomyFluidTags.COOKING_OIL)).dish(PLATE.get()).save(consumer, rl("potsticker"));
        fryingPan(RISOTTO.get(), 1, item(TOMATO), item(ONION, 2), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("risotto"));
        fryingPan(new ResourceLocation("horticulture", "stir_fry"), 1, item(CABBAGE), fluid(GastronomyFluidTags.COOKING_OIL)).dish(PLATE.get()).save(consumer, rl("stir_fry"));
        fryingPan(FRIED_RICE.get(), 1, item(RICEBALL), fluid(GastronomyFluidTags.COOKING_OIL), item(EGGS)).dish(DEEP_BOWL.get()).save(consumer, rl("fried_rice"));
        fryingPan(CURRY_BREAD.get(), 1, item(BREAD), item(CURRY_POWDER), fluid(GastronomyFluidTags.COOKING_OIL)).save(consumer, rl("curry_bread"));
        fryingPan(THICK_FRIED_NOODLES.get(), 1, item(NOODLES), fluid(GastronomyFluidTags.COOKING_OIL)).dish(DEEP_BOWL.get()).save(consumer, rl("thick_fried_noodles"));
        fryingPan(GastronomyItems.TEMPURA.get(), 1, item(EGGS), item(FLOUR), fluid(GastronomyFluidTags.COOKING_OIL)).dish(DEEP_BOWL.get()).save(consumer, rl("tempura"));
        fryingPan(APPLE_SOUFFLE.get(), 1, item(CROPS_APPLE)).dish(MUG.get()).save(consumer, rl("apple_souffle"));
        pot(Items.RABBIT_STEW, 1, item(BAKED_POTATO), item(CROPS_CARROT), item(COOKED_RABBIT), item(MUSHROOMS)).dish(Items.BOWL).save(consumer, rl("rabbit_stew"));
        pot(Items.MUSHROOM_STEW, 1, item(BROWN_MUSHROOMS), item(RED_MUSHROOMS)).dish(Items.BOWL).save(consumer, rl("mushroom_stew"));
        pot(HOT_CHOCOLATE.get(), 1, fluid(MILK), item(CHOCOLATE)).dish(MUG.get()).save(consumer, rl("hot_chocolate"));
        pot(DUMPLINGS.get(), 1, item(CABBAGE), item(ONION), item(FLOUR), fluid(GastronomyFluidTags.COOKING_OIL)).dish(DEEP_BOWL.get()).save(consumer, rl("dumplings"));
        pot(EGG_OVER_RICE.get(), 1, item(EGGS), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("egg_over_rice"));
        pot(GastronomyItems.NOODLES.get(), 1, item(FLOUR)).dish(DEEP_BOWL.get()).save(consumer, rl("noodles"));
        pot(TEMPURA_NOODLES.get(), 1, item(TEMPURA), item(NOODLES)).dish(DEEP_BOWL.get()).save(consumer, rl("tempura_noodles"));
        pot(PORRIDGE.get(), 1, fluid(MILK), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("porridge"));
        pot(TEMPURA_RICE.get(), 1, item(TEMPURA), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("tempura_rice"));
        pot(HERB_SOUP.get(), 1, item(HERBS), item(ONION)).dish(DEEP_BOWL.get()).save(consumer, rl("herb_soup"));
        pot(RICE_SOUP.get(), 1, item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("rice_soup"));
        pot(VEGETABLE_STEW.get(), 1, fluid(MILK), item(FLOUR), item(STEW_VEGETABLE)).dish(DEEP_BOWL.get()).save(consumer, rl("vegetable_stew"));
        pot(new ResourceLocation("piscary", "fish_stew"), 1, item(RAW_FISHES)).dish(DEEP_BOWL.get()).save(consumer, rl("fish_stew"));
        pot(new ResourceLocation("horticulture", "boiled_spinach"), 1, item(SPINACH)).dish(DEEP_BOWL.get()).save(consumer, rl("boiled_spinach"));
        pot(new ResourceLocation("horticulture", "candied_potato"), 1, item(SWEET_POTATO)).dish(DEEP_BOWL.get()).save(consumer, rl("candied_potato"));
        pot(new ResourceLocation("horticulture", "pumpkin_stew"), 1, item(CROPS_PUMPKIN)).dish(DEEP_BOWL.get()).save(consumer, rl("pumpkin_stew"));
        pot(new ResourceLocation("husbandry", "hot_milk"), 1, fluid(MILK)).dish(MUG.get()).save(consumer, rl("hot_milk"));
        pot(new ResourceLocation("husbandry", "boiled_egg"), 1, item(EGGS)).save(consumer, rl("boiled_egg"));
        pot(CURRIED_RICE.get(), 1, item(RICEBALL), item(CURRY_POWDER)).dish(DEEP_BOWL.get()).save(consumer, rl("curried_rice"));
        pot(CURRY_NOODLES.get(), 1, item(NOODLES), item(CURRY_POWDER)).dish(DEEP_BOWL.get()).save(consumer, rl("curry_noodles"));
        pot(GastronomyItems.CHOCOLATE.get(), 1, fluid(MILK), item(COCOA_BEANS), item(SUGAR)).save(consumer, rl("chocolate"));
        pot(MOUNTAIN_STEW.get(), 1, item(BAMBOO_SHOOTS), item(CROPS_CARROT), item(BROWN_MUSHROOMS)).dish(DEEP_BOWL.get()).save(consumer, rl("mountain_stew"));
        mixer(Items.BEETROOT_SOUP, 1, item(CROPS_BEETROOT), item(TOMATO), item(ONION), fluid(GastronomyFluidTags.COOKING_OIL)).dish(Items.BOWL).priority(EventPriority.HIGH).save(consumer, rl("beetroot_soup"));
        mixer(new ResourceLocation("horticulture", "pineapple_juice"), 1, item(PINEAPPLE)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("pineapple_juice"));
        mixer(new ResourceLocation("horticulture", "tomato_juice"), 1, item(TOMATO)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("tomato_juice"));
        mixer(new ResourceLocation("horticulture", "peach_juice"), 1, item(PEACH)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("peach_juice"));
        mixer(new ResourceLocation("horticulture", "orange_juice"), 1, item(ORANGE)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("orange_juice"));
        mixer(new ResourceLocation("horticulture", "banana_juice"), 1, item(BANANA)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("banana_juice"));
        mixer(new ResourceLocation("horticulture", "apple_juice"), 1, item(CROPS_APPLE)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("apple_juice"));
        mixer(new ResourceLocation("horticulture", "strawberry_milk"), 1, item(STRAWBERRY), fluid(MILK)).dish(GLASS.get()).priority(EventPriority.HIGH).save(consumer, rl("strawberry_milk"));
        mixer(GastronomyItems.FLOUR.get(), 1, item(CROPS_WHEAT)).save(consumer, rl("flour"));
        mixer(VEGETABLE_JUICE.get(), 1, item(JUICE_VEGETABLE, 3)).dish(GLASS.get()).save(consumer, rl("vegetable_juice"));
        mixer(VEGETABLE_LATTE.get(), 1, item(JUICE_VEGETABLE, 2), fluid(MILK)).dish(GLASS.get()).save(consumer, rl("vegetable_latte"));
        mixer(KETCHUP.get(), 1, item(TOMATO), item(ONION), item(SALT), item(SUGAR)).dish(GLASS.get()).save(consumer, rl("ketchup"));
        mixer(new ResourceLocation("husbandry", "butter"), 1, fluid(MILK), item(SALT)).save(consumer, rl("butter"));
        mixer(new ResourceLocation("piscary", "fish_fingers"), 1, item(RAW_FISHES), item(BREAD), item(SALT)).dish(PLATE.get()).save(consumer, rl("fish_fingers"));
        mixer(FRUIT_JUICE.get(), 1, item(SANDWICH_FRUIT, 3)).dish(GLASS.get()).save(consumer, rl("fruit_juice"));
        mixer(FRUIT_LATTE.get(), 1, item(SANDWICH_FRUIT, 2), fluid(MILK)).dish(GLASS.get()).save(consumer, rl("fruit_latte"));
        mixer(MIXED_JUICE.get(), 1, item(SANDWICH_FRUIT), item(JUICE_VEGETABLE)).dish(GLASS.get()).save(consumer, rl("mixed_juice"));
        mixer(MIXED_LATTE.get(), 1, item(SANDWICH_FRUIT), item(JUICE_VEGETABLE), fluid(MILK)).dish(GLASS.get()).save(consumer, rl("mixed_latte"));
        counter(new ResourceLocation("horticulture", "pickled_turnip"), 1, item(TURNIP), item(SALT)).dish(PLATE.get()).save(consumer, rl("pickled_turnip"));
        counter(new ResourceLocation("horticulture", "pickled_cucumber"), 1, item(CUCUMBER), item(SALT)).dish(PICKLING_JAR.get()).save(consumer, rl("pickled_cucumber"));
        counter(new ResourceLocation("horticulture", "salad"), 1, item(SALAD_INGREDIENT, 3)).dish(DEEP_BOWL.get()).save(consumer, rl("salad"));
        counter(SANDWICH.get(), 1, item(BREAD), item(BUTTER), item(SANDWICH_INGREDIENT)).dish(PLATE.get()).save(consumer, rl("sandwich"));
        counter(new ResourceLocation("piscary", "sashimi"), 1, item(RAW_FISHES)).dish(PLATE.get()).save(consumer, rl("sashimi"));
        counter(SUSHI.get(), 1, item(SASHIMI), item(RICEBALL)).dish(PLATE.get()).save(consumer, rl("sushi"));
        counter(CHIRASHI_SUSHI.get(), 1, item(SASHIMI), item(GastronomyItemTags.SCRAMBLED_EGG), item(RICEBALL), item(CHIRASHI_SUSHI_INGREDIENT)).dish(DEEP_BOWL.get()).save(consumer, rl("chirashi_sushi"));
        counter(FRUIT_SANDWICH.get(), 1, item(BREAD), item(BUTTER), item(SANDWICH_FRUIT)).dish(PLATE.get()).save(consumer, rl("fruit_sandwich"));
        counter(BAMBOO_RICE.get(), 1, item(BAMBOO_SHOOTS), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("bamboo_rice"));
        counter(MATSUTAKE_RICE.get(), 1, item(MATSUTAKE_MUSHROOM), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("matsutake_rice"));
        counter(MUSHROOM_RICE.get(), 1, item(BROWN_MUSHROOM), item(RICEBALL)).dish(DEEP_BOWL.get()).save(consumer, rl("mushroom_rice"));
        counter(RAISIN_BREAD.get(), 1, item(BREAD), item(GRAPE)).save(consumer, rl("raisin_bread"));
        counter(new ResourceLocation("husbandry", "ice_cream"), 1, item(EGGS), fluid(MILK)).dish(DEEP_BOWL.get()).save(consumer, rl("ice_cream"));
        counter(HERB_SALAD.get(), 1, item(MINT), item(CHAMOMILE), item(LAVENDER)).dish(DEEP_BOWL.get()).save(consumer, rl("herb_salad"));
        counter(HERB_SANDWICH.get(), 1, item(BREAD), item(BUTTER), item(MINT), item(CHAMOMILE), item(LAVENDER)).dish(PLATE.get()).save(consumer, rl("herb_sandwich"));
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
