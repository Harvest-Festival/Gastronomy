//package uk.joshiejack.gastronomy.client.gui.pages;
//
//import com.google.common.collect.Lists;
//import net.minecraft.client.gui.GuiButton;
//import net.minecraft.client.gui.GuiLabel;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.NonNullList;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fluids.FluidStack;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import net.minecraftforge.items.IItemHandlerModifiable;
//import uk.joshiejack.gastronomy.api.Appliance;
//import uk.joshiejack.gastronomy.client.gui.CyclingIngredient;
//import uk.joshiejack.gastronomy.client.gui.buttons.CookButton;
//import uk.joshiejack.gastronomy.client.gui.labels.CyclingStackLabel;
//import uk.joshiejack.gastronomy.client.gui.labels.InformationLabel;
//import uk.joshiejack.gastronomy.cooking.Cooker;
//import uk.joshiejack.gastronomy.cooking.IngredientStack;
//import uk.joshiejack.gastronomy.cooking.Recipe;
//import uk.joshiejack.penguinlib.util.helpers.minecraft.InventoryHelper;
//
//import java.util.List;
//
//@OnlyIn(Dist.CLIENT)
//public class PageRecipe extends AbstractPageCookbook {
//    private final List<CyclingIngredient> ingredients = Lists.newArrayList();
//    private final Recipe recipe;
//
//    PageRecipe(Appliance appliance, Recipe recipe) {
//        super(appliance);
//        this.recipe = recipe;
//        for (IngredientStack stack: recipe.getRequired()) {
//            ingredients.add(new CyclingIngredient(stack));
//        }
//    }
//
//    @Override
//    public void initGui(List<GuiButton> buttonList, List<GuiLabel> labelList) {
//        super.initGui(buttonList, labelList);
//        List<IItemHandlerModifiable> inventories = Cooker.getFoodStorageAndPlayer(gui.mc.player);
//        NonNullList<ItemStack> stacks = InventoryHelper.getAllStacks(inventories);
//        List<FluidStack> fluids = InventoryHelper.getAllFluids(inventories);
//        labelList.add(new InformationLabel(gui, recipe.getResult()));
//        int id = 0;
//        for (CyclingIngredient ingredient : ingredients) {
//            int amount = ingredient.getIngredient().getAmount();
//            for (int j = 0; j < amount; j++) {
//                labelList.add(new CyclingStackLabel(gui, j * amount, 45 + (id * 16), ingredient, stacks, fluids));
//                id++;
//            }
//        }
//
//        buttonList.add(new CookButton(appliance, recipe, gui, buttonList.size(), 195, 140));
//    }
//
//    public Recipe getRecipe() {
//        return recipe;
//    }
//
//    @Override
//    public boolean hasBackwardsButton() {
//        return true;
//    }
//
//    @Override
//    public void onBack() {
//        gui.setPage(PageApplianceList.RECIPE_LISTS.get(appliance));
//    }
//
//}
