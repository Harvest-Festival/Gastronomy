package uk.joshiejack.gastronomy.cooking;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import uk.joshiejack.gastronomy.crafting.CookingRecipe;
import uk.joshiejack.gastronomy.crafting.GastronomyRegistries;
import uk.joshiejack.gastronomy.item.GastronomyItems;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public enum Appliance implements IStringSerializable {
    COUNTER(GastronomyItems.COUNTER, () -> GastronomyRegistries.COUNTER),
    FRYING_PAN(GastronomyItems.FRYING_PAN, () -> GastronomyRegistries.FRYING_PAN),
    MIXER(GastronomyItems.MIXER, () -> GastronomyRegistries.MIXER),
    OVEN(GastronomyItems.OVEN, () -> GastronomyRegistries.OVEN),
    POT(GastronomyItems.POT, () -> GastronomyRegistries.POT);

    private final Supplier<Item> item;
    private final Supplier<IRecipeType<?>> recipe;
    private final Cache<Item, Boolean> isIngredient = CacheBuilder.newBuilder().build();

    Appliance(Supplier<Item> item, Supplier<IRecipeType<?>> recipe) {
        this.item = item;
        this.recipe = recipe;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ENGLISH);
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    public <C extends IInventory, T extends IRecipe<C>> IRecipeType<T> getRecipeType() {
        return (IRecipeType<T>) recipe.get();
    }

    public ItemStack getItemStack() {
        return new ItemStack(item.get());
    }

    public boolean isIngredient(World level, ItemStack stack) {
        try {
            return isIngredient.get(stack.getItem(), () -> level.getServer().getRecipeManager().getAllRecipesFor(getRecipeType()).stream()
                    .anyMatch(r -> ((CookingRecipe) r).isIngredient(stack)));
        } catch (ExecutionException e) {
            return false;
        }
    }
}
