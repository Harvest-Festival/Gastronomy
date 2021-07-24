package uk.joshiejack.gastronomy.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.UseAction;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;
import uk.joshiejack.gastronomy.fluid.GastronomyFluids;
import uk.joshiejack.gastronomy.inventory.CookbookContainer;
import uk.joshiejack.penguinlib.item.base.BookItem;
import uk.joshiejack.penguinlib.item.base.FluidContainerItem;
import uk.joshiejack.penguinlib.item.base.PenguinItem;


@SuppressWarnings("unused")
public class GastronomyItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Gastronomy.MODID);
    public static final RegistryObject<Item> CURRY_POWDER = ITEMS.register("curry_powder", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> DUMPLING_POWDER = ITEMS.register("dumpling_powder", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> COOKING_OIL = ITEMS.register("cooking_oil", () -> new FluidContainerItem(() -> GastronomyFluids.COOKING_OIL.get().getFluid(), FluidAttributes.BUCKET_VOLUME, new PenguinItem.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> RICEBALL = ITEMS.register("riceball", () -> new Item(new Item.Properties().food(GastronomyFoods.RICEBALL).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate", () -> new Item(new Item.Properties().food(GastronomyFoods.CHOCOLATE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CURRY_BREAD = ITEMS.register("curry_bread", () -> new Item(new Item.Properties().food(GastronomyFoods.CURRY_BREAD).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> RAISIN_BREAD = ITEMS.register("raisin_bread", () -> new Item(new Item.Properties().food(GastronomyFoods.RAISIN_BREAD).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRUIT_CAKE = ITEMS.register("fruit_cake", () -> new Item(new Item.Properties().food(GastronomyFoods.FRUIT_CAKE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake", () -> new Item(new Item.Properties().food(GastronomyFoods.CHOCOLATE_CAKE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BUTTER_BISCUITS = ITEMS.register("butter_biscuits", () -> new Item(new Item.Properties().food(GastronomyFoods.BUTTER_BISCUITS).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CHOCOLATE_COOKIES = ITEMS.register("chocolate_cookies", () -> new Item(new Item.Properties().food(GastronomyFoods.CHOCOLATE_COOKIES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CURRIED_RICE = ITEMS.register("curried_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.CURRIED_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> DORIA = ITEMS.register("doria", () -> new Item(new Item.Properties().food(GastronomyFoods.DORIA).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> DOUGHNUT = ITEMS.register("doughnut", () -> new Item(new Item.Properties().food(GastronomyFoods.DOUGHNUT).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> DUMPLINGS = ITEMS.register("dumplings", () -> new Item(new Item.Properties().food(GastronomyFoods.DUMPLINGS).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> EGG_OVER_RICE = ITEMS.register("egg_over_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.EGG_OVER_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SCRAMBLED_EGG = ITEMS.register("scrambled_egg", () -> new Item(new Item.Properties().food(GastronomyFoods.SCRAMBLED_EGG).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> GRILLED_FISH = ITEMS.register("grilled_fish", () -> new Item(new Item.Properties().food(GastronomyFoods.GRILLED_FISH).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRENCH_FRIES = ITEMS.register("french_fries", () -> new Item(new Item.Properties().food(GastronomyFoods.FRENCH_FRIES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> NOODLES = ITEMS.register("noodles", () -> new Item(new Item.Properties().food(GastronomyFoods.NOODLES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> TEMPURA = ITEMS.register("tempura", () -> new Item(new Item.Properties().food(GastronomyFoods.TEMPURA).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CURRY_NOODLES = ITEMS.register("curry_noodles", () -> new Item(new Item.Properties().food(GastronomyFoods.CURRY_NOODLES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> TEMPURA_NOODLES = ITEMS.register("tempura_noodles", () -> new Item(new Item.Properties().food(GastronomyFoods.TEMPURA_NOODLES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> THICK_FRIED_NOODLES = ITEMS.register("thick_fried_noodles", () -> new Item(new Item.Properties().food(GastronomyFoods.THICK_FRIED_NOODLES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> OMELETTE = ITEMS.register("omelette", () -> new Item(new Item.Properties().food(GastronomyFoods.OMELETTE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> OMURICE = ITEMS.register("omurice", () -> new Item(new Item.Properties().food(GastronomyFoods.OMURICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> PANCAKE = ITEMS.register("pancake", () -> new Item(new Item.Properties().food(GastronomyFoods.PANCAKE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SAVOURY_PANCAKE = ITEMS.register("savoury_pancake", () -> new Item(new Item.Properties().food(GastronomyFoods.SAVOURY_PANCAKE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new Item(new Item.Properties().food(GastronomyFoods.APPLE_PIE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> POPCORN = ITEMS.register("popcorn", () -> new Item(new Item.Properties().food(GastronomyFoods.POPCORN).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> PORRIDGE = ITEMS.register("porridge", () -> new Item(new Item.Properties().food(GastronomyFoods.PORRIDGE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> POTSTICKER = ITEMS.register("potsticker", () -> new Item(new Item.Properties().food(GastronomyFoods.POTSTICKER).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BAMBOO_RICE = ITEMS.register("bamboo_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.BAMBOO_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRIED_RICE = ITEMS.register("fried_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.FRIED_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MATSUTAKE_RICE = ITEMS.register("matsutake_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.MATSUTAKE_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MUSHROOM_RICE = ITEMS.register("mushroom_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.MUSHROOM_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> TEMPURA_RICE = ITEMS.register("tempura_rice", () -> new Item(new Item.Properties().food(GastronomyFoods.TEMPURA_RICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> TOASTED_RICEBALLS = ITEMS.register("toasted_riceballs", () -> new Item(new Item.Properties().food(GastronomyFoods.TOASTED_RICEBALLS).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> RISOTTO = ITEMS.register("risotto", () -> new Item(new Item.Properties().food(GastronomyFoods.RISOTTO).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> HERB_SALAD = ITEMS.register("herb_salad", () -> new Item(new Item.Properties().food(GastronomyFoods.HERB_SALAD).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SANDWICH = ITEMS.register("sandwich", () -> new Item(new Item.Properties().food(GastronomyFoods.SANDWICH).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRUIT_SANDWICH = ITEMS.register("fruit_sandwich", () -> new Item(new Item.Properties().food(GastronomyFoods.FRUIT_SANDWICH).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> HERB_SANDWICH = ITEMS.register("herb_sandwich", () -> new Item(new Item.Properties().food(GastronomyFoods.HERB_SANDWICH).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CHIRASHI_SUSHI = ITEMS.register("chirashi_sushi", () -> new Item(new Item.Properties().food(GastronomyFoods.CHIRASHI_SUSHI).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> APPLE_SOUFFLE = ITEMS.register("apple_souffle", () -> new Item(new Item.Properties().food(GastronomyFoods.APPLE_SOUFFLE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> HERB_SOUP = ITEMS.register("herb_soup", () -> new Item(new Item.Properties().food(GastronomyFoods.HERB_SOUP).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> RICE_SOUP = ITEMS.register("rice_soup", () -> new Item(new Item.Properties().food(GastronomyFoods.RICE_SOUP).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> VEGETABLE_STEW = ITEMS.register("vegetable_stew", () -> new Item(new Item.Properties().food(GastronomyFoods.VEGETABLE_STEW).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MOUNTAIN_STEW = ITEMS.register("mountain_stew", () -> new Item(new Item.Properties().food(GastronomyFoods.MOUNTAIN_STEW).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi", () -> new Item(new Item.Properties().food(GastronomyFoods.SUSHI).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SWEET_POTATOES = ITEMS.register("sweet_potatoes", () -> new Item(new Item.Properties().food(GastronomyFoods.SWEET_POTATOES).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> TOAST = ITEMS.register("toast", () -> new Item(new Item.Properties().food(GastronomyFoods.TOAST).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRENCH_TOAST = ITEMS.register("french_toast", () -> new Item(new Item.Properties().food(GastronomyFoods.FRENCH_TOAST).tab(Gastronomy.TAB)));
    //Drinks
    public static final RegistryObject<Item> WINE = ITEMS.register("wine", () -> new FluidContainerItem(() -> GastronomyFluids.WINE.get().getFluid(), FluidAttributes.BUCKET_VOLUME, new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.WINE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> HOT_CHOCOLATE = ITEMS.register("hot_chocolate", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.HOT_CHOCOLATE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> KETCHUP = ITEMS.register("ketchup", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.KETCHUP).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRUIT_JUICE = ITEMS.register("fruit_juice", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.FRUIT_JUICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MIXED_JUICE = ITEMS.register("mixed_juice", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.MIXED_JUICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> VEGETABLE_JUICE = ITEMS.register("vegetable_juice", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.VEGETABLE_JUICE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRUIT_LATTE = ITEMS.register("fruit_latte", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.FRUIT_LATTE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MIXED_LATTE = ITEMS.register("mixed_latte", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.MIXED_LATTE).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> VEGETABLE_LATTE = ITEMS.register("vegetable_latte", () -> new PenguinItem(new PenguinItem.Properties().useAction(UseAction.DRINK).food(GastronomyFoods.VEGETABLE_LATTE).tab(Gastronomy.TAB)));
    //Burnt Dishes
    public static final RegistryObject<Item> BURNT_COUNTER_DISH = ITEMS.register("burnt_counter_dish", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BURNT_FRYING_PAN_DISH = ITEMS.register("burnt_frying_pan_dish", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BURNT_MIXER_DISH = ITEMS.register("burnt_mixer_dish", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BURNT_OVEN_DISH = ITEMS.register("burnt_oven_dish", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BURNT_POT_DISH = ITEMS.register("burnt_pot_dish", () -> new Item(new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> COOKBOOK = ITEMS.register("cookbook", () -> new BookItem(new Item.Properties().stacksTo(1).tab(Gastronomy.TAB),  () -> (id, inv, p) ->  new CookbookContainer(id)));
    public static final RegistryObject<Item> KNIFE = ITEMS.register("knife", () -> new Item(new Item.Properties().durability(128).tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> RECIPE = ITEMS.register("recipe", RecipeItem::new);
    //Blocks
    public static final RegistryObject<Item> MATSUTAKE_MUSHROOM = ITEMS.register("matsutake_mushroom", () -> new BlockItem(GastronomyBlocks.MATSUTAKE_MUSHROOM.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> BAMBOO_SHOOTS = ITEMS.register("bamboo_shoots", () -> new BlockItem(GastronomyBlocks.BAMBOO_SHOOTS.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MINT = ITEMS.register("mint", () -> new BlockItem(GastronomyBlocks.MINT.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CHAMOMILE = ITEMS.register("chamomile", () -> new BlockItem(GastronomyBlocks.CHAMOMILE.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender", () -> new BlockItem(GastronomyBlocks.LAVENDER.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRIDGE = ITEMS.register("fridge", () -> new BlockItem(GastronomyBlocks.FRIDGE.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> COUNTER = ITEMS.register("counter", () -> new BlockItem(GastronomyBlocks.COUNTER.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> ISLAND = ITEMS.register("island", () -> new BlockItem(GastronomyBlocks.ISLAND.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> CUPBOARD = ITEMS.register("cupboard", () -> new BlockItem(GastronomyBlocks.CUPBOARD.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> SINK = ITEMS.register("sink", () -> new BlockItem(GastronomyBlocks.SINK.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> OVEN = ITEMS.register("oven", () -> new BlockItem(GastronomyBlocks.OVEN.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> MIXER = ITEMS.register("mixer", () -> new BlockItem(GastronomyBlocks.MIXER.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> POT = ITEMS.register("pot", () -> new BlockItem(GastronomyBlocks.POT.get(), new Item.Properties().tab(Gastronomy.TAB)));
    public static final RegistryObject<Item> FRYING_PAN = ITEMS.register("frying_pan", () -> new BlockItem(GastronomyBlocks.FRYING_PAN.get(), new Item.Properties().tab(Gastronomy.TAB)));
}
