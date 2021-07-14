//package uk.joshiejack.gastronomy.cooking;
//
//import com.google.common.collect.Lists;
//import net.minecraft.init.Blocks;
//import net.minecraft.init.Items;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.crafting.FurnaceRecipes;
//import net.minecraft.item.crafting.IRecipe;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.registry.ForgeRegistries;
//import net.minecraftforge.registries.ForgeRegistry;
//import uk.joshiejack.gastronomy.item.GastronomyItems;
//import uk.joshiejack.penguinlib.data.database.Row;
//import uk.joshiejack.penguinlib.data.holder.Holder;
//import uk.joshiejack.penguinlib.events.DatabaseLoadedEvent;
//import uk.joshiejack.penguinlib.util.helpers.generic.StringHelper;
//import uk.joshiejack.penguinlib.util.helpers.minecraft.RecipeHelper;
//import uk.joshiejack.penguinlib.util.helpers.minecraft.StackHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static uk.joshiejack.gastronomy.Gastronomy.MODID;
//import static uk.joshiejack.gastronomy.block.BlockCookware.Cookware.*;
//import static uk.joshiejack.gastronomy.block.GastronomyBlocks.COOKWARE;
//import static uk.joshiejack.gastronomy.block.GastronomyBlocks.STORAGE;
//import static uk.joshiejack.gastronomy.item.GastronomyItems.UTENSIL;
//import static uk.joshiejack.gastronomy.item.KnifeItem.Utensil.KNIFE;
//
//
//@SuppressWarnings("unused")
//@Mod.EventBusSubscriber(modid = MODID)
//public class RecipeLoader {
//    @SubscribeEvent
//    public static void onDatabaseLoaded(DatabaseLoadedEvent.LoadComplete event) {
//        for (Row row: event.getData("dishes")) {
//            Recipe.DISHES.put(row.get("dish"), StackHelper.getStackFromString(row.get("item")));
//        }
//
//        for (Row row: event.getData("categories")) {
//            Category category = Category.getCategory(row.get("category"));
//            Ingredient ingredient = Ingredient.getIngredient(row.get("ingredient"));
//            Category.registerIngredient(category, ingredient);
//        }
//
//        for (Row row: event.getData("ingredients")) {
//            Ingredient ingredient = Ingredient.getIngredient(row.get("ingredient"));
//            String item = row.get("item");
//            Holder holder = Holder.getFromString(item);
//            if (!item.equals("fluid") && !holder.isEmpty()) {
//                ingredient.setAsIngredient(Holder.getFromString(item));
//            }
//        }
//
//        for (Appliance appliance: Appliance.values()) {
//             for (Row row: event.getData("recipes_" + appliance.getName())) {
//                boolean priority = row.get("item").toString().startsWith("!");
//                String item = row.get("item").toString().replace("!", "");
//                ItemStack result = StackHelper.getStackFromString(item);
//                ItemStack dish = Recipe.DISHES.getOrDefault(row.get("dish").toString(), ItemStack.EMPTY);
//                if (!result.isEmpty()) {
//                    String[] requiredString = StringHelper.getListFromDatabase(row.get("ingredients"));
//                    List<IngredientStack> required = Lists.newArrayList();
//                    convertStringArrayToIngredientStack(requiredString, required);
//                    if (hasItemsForAllIngredients(required)) {
//                        Recipe recipe = new Recipe(result, dish, required.toArray(new IngredientStack[required.size()]));
//                        if (priority) Recipe.PRIORITY_RECIPES.get(appliance).add(recipe);
//                        else Recipe.RECIPES.get(appliance).add(recipe); //Register the recipe item now that it has been created
//                        StackHelper.registerSynonym(item + "_recipe", GastronomyItems.RECIPE.getRecipeWithStack(recipe));
//                    }
//                }
//             }
//        }
//    }
//
//    private static boolean hasItemsForAllIngredients(List<IngredientStack> required) {
//        return required.stream().noneMatch((stack -> stack.getAsStacks().size() == 0));
//    }
//
//    private static void convertStringArrayToIngredientStack(String[] string, List<IngredientStack> list) {
//        for (String s: string) {
//            int amount = s.contains(" ") ? Integer.parseInt(s.split(" ")[1]) : 1;
//            String data = s.contains(" ") ? s.split(" ")[0] : s;
//            if (data.contains("category:")) {
//                list.add(new IngredientStack(Category.getCategory(data.replace("category:", "")), amount));
//            } else {
//                list.add(new IngredientStack(Ingredient.getIngredient(data), amount));
//            }
//        }
//    }
//
//    static ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
//    ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
//
//    private static final String[] removals = new String[] {
//            "beetroot_soup", "bread", "cake", "cookie", "mushroom_stew", "pumpkin_pie", "rabbit_stew_from_brown_mushroom", "rabbit_stew_from_red_mushroom"
//    };
//}
