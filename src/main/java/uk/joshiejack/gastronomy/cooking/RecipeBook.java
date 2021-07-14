package uk.joshiejack.gastronomy.cooking;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collection;

@OnlyIn(Dist.CLIENT)
public class RecipeBook {
    private static final RecipeBook INSTANCE = new RecipeBook();
    private Multimap<Appliance, ResourceLocation> learnt = HashMultimap.create();

    public static boolean learnRecipe(Appliance appliance, ResourceLocation recipeID) {
        return !INSTANCE.learnt.get(appliance).contains(recipeID);
    }

    public static void addLearntRecipe(Appliance appliance, ResourceLocation recipeID) {
        INSTANCE.learnt.get(appliance).add(recipeID);
    }

    public static void setLearntRecipes(Appliance appliance, Collection<ResourceLocation> recipeIds) {
        INSTANCE.learnt.get(appliance).clear();
        INSTANCE.learnt.get(appliance).addAll(recipeIds);
    }

    public static boolean hasLearntRecipe(Appliance appliance, ResourceLocation recipeId) {
        return INSTANCE.learnt.get(appliance).contains(recipeId);
    }
}
