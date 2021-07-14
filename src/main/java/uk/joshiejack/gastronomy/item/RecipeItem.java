package uk.joshiejack.gastronomy.item;

import net.minecraft.item.Item;
import uk.joshiejack.gastronomy.Gastronomy;

public class RecipeItem extends Item {
    public RecipeItem() {
        super(new Item.Properties().stacksTo(1).tab(Gastronomy.TAB));
    }

//    @Nonnull
//    @Override
//    public String getItemStackDisplayName(@Nonnull ItemStack stack) {
//        ItemStack internal = new ItemStack(NBTHelper.getItemNBT(stack));
//        return internal.isEmpty() ? super.getItemStackDisplayName(stack) : I18n.translateToLocalFormatted(this.getUnlocalizedNameInefficiently(stack) + ".name", internal.getDisplayName());
//    }
//
//    @Nonnull
//    @Override
//    public ActionResult<ItemStack> use(World world, PlayerEntity player, @Nonnull Hand hand) {
//        ItemStack held = player.getItemInHand(hand);
//        ItemStack internal = new ItemStack(NBTHelper.getItemNBT(held));
//        if (!internal.isEmpty() && Cooker.learnRecipe(player, internal)) {
//            world.playSound(player.posX, player.posY, player.posZ, GastronomySounds.RECIPE, SoundCategory.NEUTRAL, 0.8F, 1F, true);
//            held.shrink(1);
//            return new ActionResult<>(ActionResult.SUCCESS, held);
//        }
//
//        return new ActionResult<>(ActionResult.PASS, player.getItemInHand(hand));
//    }
//
//    public ItemStack getRecipeWithStack(Recipe recipe) {
//        CompoundNBT tag = new CompoundNBT();
//        recipe.getResult().writeToNBT(tag);
//        ItemStack stack = new ItemStack(this);
//        stack.setTagCompound(tag);
//        return stack;
//    }
//
//    @Override
//    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
//        if (isInCreativeTab(tab)) {
//            Recipe.PRIORITY_RECIPES.values().forEach((recipe -> items.add(getRecipeWithStack(recipe))));
//            Recipe.RECIPES.values().forEach((recipe -> items.add(getRecipeWithStack(recipe))));
//        }
//    }
}
