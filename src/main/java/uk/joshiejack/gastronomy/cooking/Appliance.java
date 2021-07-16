package uk.joshiejack.gastronomy.cooking;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import uk.joshiejack.gastronomy.crafting.CookingRecipe;
import uk.joshiejack.gastronomy.crafting.GastronomyRegistries;
import uk.joshiejack.gastronomy.item.GastronomyItems;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public enum Appliance implements IStringSerializable {
    COUNTER(GastronomyItems.COUNTER, GastronomyItems.BURNT_COUNTER_DISH, () -> GastronomyRegistries.COUNTER),
    FRYING_PAN(GastronomyItems.FRYING_PAN, GastronomyItems.BURNT_FRYING_PAN_DISH, () -> GastronomyRegistries.FRYING_PAN),
    MIXER(GastronomyItems.MIXER, GastronomyItems.BURNT_MIXER_DISH, () -> GastronomyRegistries.MIXER),
    OVEN(GastronomyItems.OVEN, GastronomyItems.BURNT_OVEN_DISH, () -> GastronomyRegistries.OVEN),
    POT(GastronomyItems.POT, GastronomyItems.BURNT_POT_DISH, () -> GastronomyRegistries.POT);

    private final Supplier<Item> item;
    private final Supplier<Item> burnt;
    private final Supplier<IRecipeType<CookingRecipe>> recipe;
    private final Cache<Item, Boolean> isIngredient = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();
    private final Cache<Item, Item> dishCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build();

    Appliance(Supplier<Item> item, Supplier<Item> burnt, Supplier<IRecipeType<CookingRecipe>> recipe) {
        this.item = item;
        this.burnt = burnt;
        this.recipe = recipe;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ENGLISH);
    }

    @Nonnull
    public IRecipeType<CookingRecipe> getRecipeType() {
        return recipe.get();
    }

    public ItemStack getItemStack() {
        return new ItemStack(item.get());
    }

    public ItemStack getBurntItemStack() {
        return new ItemStack(burnt.get());
    }

    public Item getDishForItem(World world, ItemStack stack) {
        try {
            return dishCache.get(stack.getItem(), () -> world.getRecipeManager().getAllRecipesFor(getRecipeType()).stream()
                    .filter(s -> s.getResultItem().getItem().equals(stack.getItem()))
                    .map(CookingRecipe::getDish).findFirst().orElse(Items.AIR));
        } catch (ExecutionException e) {
            return Items.AIR;
        }
    }

    public boolean isIngredient(World level, ItemStack stack) {
        try {
            return isIngredient.get(stack.getItem(), () -> level.getRecipeManager().getAllRecipesFor(getRecipeType()).stream()
                    .anyMatch(r -> r.isIngredient(stack)));
        } catch (ExecutionException e) {
            return false;
        }
    }
}
