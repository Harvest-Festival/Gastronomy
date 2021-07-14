package uk.joshiejack.gastronomy.cooking;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IStringSerializable;
import uk.joshiejack.gastronomy.item.GastronomyItems;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.function.Supplier;

public enum Appliance implements IStringSerializable {
    COUNTER(GastronomyItems.COUNTER),
    FRYING_PAN(GastronomyItems.FRYING_PAN),
    MIXER(GastronomyItems.MIXER),
    OVEN(GastronomyItems.OVEN),
    POT(GastronomyItems.POT);

    //TODO: private final Supplier<IRecipeType<?>> recipeTypeSupplier;
    private final Supplier<Item> item;

    Appliance(Supplier<Item> item) {
        this.item = item;
    }

    @Nonnull
    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ENGLISH);
    }

    //TODO:
    public <C extends IInventory, T extends IRecipe<C>> IRecipeType<T> getRecipeType() {
        return null;
    }

    public ItemStack getItemStack() {
        return new ItemStack(item.get());
    }
}
