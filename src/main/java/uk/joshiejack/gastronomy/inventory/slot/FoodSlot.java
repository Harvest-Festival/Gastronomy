package uk.joshiejack.gastronomy.inventory.slot;

//public class FoodSlot extends UnlimitedSlot {
//    public FoodSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
//        super(itemHandler, index, xPosition, yPosition);
//    }
//
//    public static boolean isValid(ItemStack stack) {
//        FluidStack fluid = FluidUtil.getFluidContained(stack);
//        return fluid != null && Ingredient.ingredients.get(fluid.getFluid().getName()) != null ||
//                stack.getItem() instanceof ItemFood || stack.getItem() == Items.CAKE ||
//                !Ingredient.registry.getValue(stack).isNone() ||
//                Recipe.RECIPE_BY_STACK.values().stream().anyMatch((r) -> r.getResult().isItemEqual(stack));
//    }
//
//    @Override
//    public boolean isItemValid(@Nonnull ItemStack stack) {
//        return isValid(stack);
//    }
//}
