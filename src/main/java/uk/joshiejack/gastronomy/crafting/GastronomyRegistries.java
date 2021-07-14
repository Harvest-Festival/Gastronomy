package uk.joshiejack.gastronomy.crafting;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.gastronomy.Gastronomy;

public class GastronomyRegistries {
    public static final IRecipeType<CookingRecipe> OVEN = IRecipeType.register(Gastronomy.MODID + ":oven");
    public static final IRecipeType<CookingRecipe> COUNTER = IRecipeType.register(Gastronomy.MODID + ":counter");
    public static final IRecipeType<CookingRecipe> FRYING_PAN = IRecipeType.register(Gastronomy.MODID + ":frying_pan");
    public static final IRecipeType<CookingRecipe> POT = IRecipeType.register(Gastronomy.MODID + ":pot");
    public static final IRecipeType<CookingRecipe> MIXER = IRecipeType.register(Gastronomy.MODID + ":mixer");
    public static final DeferredRegister<IRecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Gastronomy.MODID);
    public static final RegistryObject<CookingRecipeSerializer> OVEN_SERIALIZER = SERIALIZERS.register("oven", () -> new CookingRecipeSerializer(OVEN, CookingRecipe::new));
    public static final RegistryObject<CookingRecipeSerializer> COUNTER_SERIALIZER = SERIALIZERS.register("counter", () -> new CookingRecipeSerializer(COUNTER, CookingRecipe::new));
    public static final RegistryObject<CookingRecipeSerializer> FRYING_PAN_SERIALIZER = SERIALIZERS.register("frying_pan", () -> new CookingRecipeSerializer(FRYING_PAN, CookingRecipe::new));
    public static final RegistryObject<CookingRecipeSerializer> POT_SERIALIZER = SERIALIZERS.register("pot", () -> new CookingRecipeSerializer(POT, CookingRecipe::new));
    public static final RegistryObject<CookingRecipeSerializer> MIXER_SERIALIZER = SERIALIZERS.register("mixer", () -> new CookingRecipeSerializer(MIXER, CookingRecipe::new));

}