package uk.joshiejack.gastronomy.plugins.shopaholic;

//@PenguinLoader("recipe")
//public class RecipeListingHandler extends ListingHandler<Recipe> {
//    @Override
//    public String getType() {
//        return "recipe";
//    }
//
//    @Override
//    public String getDisplayName(Recipe recipe) {
//        return createIcon(recipe)[0].getDisplayName();
//    }
//
//    @Override
//    public ItemStack[] createIcon(Recipe recipe) {
//        return new ItemStack[] { GastronomyItems.RECIPE.getRecipeWithStack(recipe) };
//    }
//
//    @Override
//    public void purchase(PlayerEntity player, Recipe recipe) {
//        if (Cooker.learnRecipe(player, recipe.getResult())) {
//            player.level.playSound(player.posX, player.posY, player.posZ, GastronomySounds.RECIPE, SoundCategory.NEUTRAL, 0.8F, 1F, true);
//        }
//    }
//
//    @Override
//    public String getStringFromObject(Recipe recipe) {
//        return StackHelper.getStringFromStack(recipe.getResult());
//    }
//
//    @Override
//    public String getValidityError() {
//        return "Recipe does not exist";
//    }
//
//    @Override
//    public Recipe getObjectFromDatabase(Database database, String data) {
//        return Recipe.RECIPE_BY_STACK.get(new HolderMeta(StackHelper.getStackFromString(data)));
//    }
//
//    public boolean isValid(Recipe recipe) {
//        return recipe != null && !recipe.getResult().isEmpty();
//    }
//}
//
