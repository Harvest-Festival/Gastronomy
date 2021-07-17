package uk.joshiejack.gastronomy.data.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import uk.joshiejack.gastronomy.crafting.CookingRecipe;
import uk.joshiejack.gastronomy.crafting.GastronomyRegistries;
import uk.joshiejack.penguinlib.data.generators.builders.SimplePenguinBuilder;

public class CookingRecipeBuilder extends SimplePenguinBuilder<CookingRecipe> {
    private int amount;
    private ResourceLocation output;
    private RecipeIngredientBuilder[] ingredients;
    private Item dish = Items.AIR;

    public CookingRecipeBuilder(IRecipeSerializer<CookingRecipe> serializer, ResourceLocation output, int amount, RecipeIngredientBuilder... ingredients) {
        super(serializer);
        this.amount = amount;
        this.output = output;
        this.ingredients = ingredients;
    }

    public CookingRecipeBuilder(IRecipeSerializer<CookingRecipe> serializer, Item output, int amount, RecipeIngredientBuilder... ingredients) {
        super(serializer);
        this.amount = amount;
        this.output = output.getRegistryName();
        this.ingredients = ingredients;
    }

    public CookingRecipeBuilder dish(Item item) {
        this.dish = item;
        return this;
    }

    public static CookingRecipeBuilder oven(ResourceLocation output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.OVEN_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder oven(Item output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.OVEN_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder counter(Item output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.COUNTER_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder pot(ResourceLocation output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.POT_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder pot(Item output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.POT_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder fryingPan(ResourceLocation output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.FRYING_PAN_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder fryingPan(Item output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.FRYING_PAN_SERIALIZER.get(), output, amount, ingredients);
    }

    public static CookingRecipeBuilder mixer(Item output, int amount, RecipeIngredientBuilder... ingredients) {
        return new CookingRecipeBuilder(GastronomyRegistries.MIXER_SERIALIZER.get(), output, amount, ingredients);
    }

    @Override
    public void serializeRecipeData(JsonObject json) {
        if (amount == 1)
            json.addProperty("result", output.toString());
        else {
            JsonObject obj = new JsonObject();
            obj.addProperty("item", output.toString());
            obj.addProperty("count", amount);
            json.add("result", obj);
        }


        if (dish != Items.AIR)
            json.addProperty("dish", dish.getRegistryName().toString());
        JsonArray array = new JsonArray();
        for (RecipeIngredientBuilder builder: ingredients) {
            JsonObject object = new JsonObject();
            builder.serialize(object);
            array.add(object);
        }

        json.add("ingredients", array);
    }

    public static class RecipeIngredientBuilder {
        private final String type;
        private final ResourceLocation tag;
        private final int amount;

        public RecipeIngredientBuilder(String type, ResourceLocation tag, int amount) {
            this.type = type;
            this.tag = tag;
            this.amount = amount;
        }

        public static RecipeIngredientBuilder fluid(ITag.INamedTag<Fluid> fluid) {
            return new RecipeIngredientBuilder("fluid", fluid.getName(), 1000);
        }

        public static RecipeIngredientBuilder fluid(ITag.INamedTag<Fluid> fluid, int amount) {
            return new RecipeIngredientBuilder("fluid", fluid.getName(), amount);
        }

        public static RecipeIngredientBuilder item(ITag.INamedTag<Item> item, int amount) {
            return new RecipeIngredientBuilder("item", item.getName(), amount);
        }

        public static RecipeIngredientBuilder item(ITag.INamedTag<Item> item) {
            return new RecipeIngredientBuilder("item", item.getName(), 1);
        }

        public void serialize(JsonObject object) {
            object.addProperty("type", type);
            object.addProperty("tag", tag.toString());
            object.addProperty("count", amount);
        }
    }
}
