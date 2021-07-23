package uk.joshiejack.gastronomy.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.function.Supplier;

public class CookingRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<CookingRecipe> {
    private final CookingRecipeSerializer.IFactory factory;
    private final IRecipeType<?> recipeType;

    public CookingRecipeSerializer(IRecipeType<?> recipeType, CookingRecipeSerializer.IFactory factory) {
        this.factory = factory;
        this.recipeType = recipeType;
    }

    @Nonnull
    @Override
    public CookingRecipe fromJson(@Nonnull ResourceLocation rl, @Nonnull JsonObject json) {
        if (!json.has("result"))
            throw new JsonSyntaxException("Missing result, expected to find a string or object");
        ItemStack result;
        if (json.get("result").isJsonObject())
            result = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
        else
            result = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(json, "result"))));
        JsonArray ingredients = JSONUtils.getAsJsonArray(json, "ingredients");
        NonNullList<CookingRecipe.RecipeIngredient<?>> ingredientList = NonNullList.create();
        ingredients.forEach(entry -> {
            JsonObject object = entry.getAsJsonObject();
            String type = object.has("type") ? JSONUtils.getAsString(object, "type") : "item";
            String tag = JSONUtils.getAsString(object, "tag");
            int amount = object.has("count") ? JSONUtils.getAsInt(object, "count") : 1;
            if (type.equals("fluid"))
                ingredientList.add(new CookingRecipe.FluidIngredient(new ResourceLocation(tag), amount));
            else if (type.equals("item"))
                ingredientList.add(new CookingRecipe.SolidIngredient(new ResourceLocation(tag), amount));
            else
                throw new JsonSyntaxException("Invalid type used for a recipe ingredient, expected fluid or item");
        });

        Item dish = json.has("dish") ? ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getAsString(json, "dish"))) : Items.AIR;
        EventPriority priority = json.has("priority") ? EventPriority.valueOf(JSONUtils.getAsString(json, "priority").toUpperCase(Locale.ROOT)) : EventPriority.NORMAL;
        return this.factory.create(() -> recipeType, this, rl, ingredientList, result, dish, priority);
    }

    @Override
    public CookingRecipe fromNetwork(@Nonnull ResourceLocation rl, @Nonnull PacketBuffer pb) {
        ItemStack itemstack = pb.readItem();
        NonNullList<CookingRecipe.RecipeIngredient<?>> ingredientList = NonNullList.create();
        int count = pb.readVarInt();
        for (int i = 0; i < count; i++) {
            boolean isItem = pb.readBoolean();
            ResourceLocation tag = pb.readResourceLocation();
            int amount = pb.readVarInt();
            if (isItem)
                ingredientList.add(new CookingRecipe.SolidIngredient(tag, amount));
            else
                ingredientList.add(new CookingRecipe.FluidIngredient(tag, amount));
        }

        Item dish = pb.readRegistryIdSafe(Item.class);
        EventPriority priority = EventPriority.values()[pb.readByte()];
        return factory.create(() -> recipeType, this, rl, ingredientList, itemstack, dish, priority);
    }

    @Override
    public void toNetwork(@Nonnull PacketBuffer pb, CookingRecipe recipe) {
        pb.writeItem(recipe.getResultItem());
        pb.writeVarInt(recipe.ingredients.size());
        recipe.ingredients.forEach(ingredient -> {
            pb.writeBoolean(ingredient instanceof CookingRecipe.SolidIngredient);
            pb.writeResourceLocation(ingredient.tag.getName());
            pb.writeVarInt(ingredient.amount);
        });

        pb.writeRegistryId(recipe.getDish());
    }

    interface IFactory {
        CookingRecipe create(Supplier<IRecipeType<?>> type, IRecipeSerializer<?> serializer, ResourceLocation rl, NonNullList<CookingRecipe.RecipeIngredient<?>> ingredients, ItemStack output, Item dish, EventPriority priority);
    }
}