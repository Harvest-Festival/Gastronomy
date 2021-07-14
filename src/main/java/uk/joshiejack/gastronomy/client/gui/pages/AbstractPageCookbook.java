//package uk.joshiejack.gastronomy.client.gui.pages;
//
//import net.minecraft.client.gui.GuiButton;
//import net.minecraft.client.gui.GuiLabel;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import uk.joshiejack.gastronomy.api.Appliance;
//import uk.joshiejack.gastronomy.client.gui.buttons.TabButton;
//import uk.joshiejack.penguinlib.client.gui.book.page.Page;
//
//import javax.annotation.Nullable;
//import java.util.List;
//
//@OnlyIn(Dist.CLIENT)
//public class AbstractPageCookbook extends Page {
//    @Nullable
//    final Appliance appliance;
//
//    AbstractPageCookbook(@Nullable Appliance appliance) {
//        this.appliance = appliance;
//    }
//
//    @Override
//    public void initGui(List<GuiButton> buttonList, List<GuiLabel> labelList) {
//        for (Appliance appliance: Appliance.values()) {
//            if (PageApplianceList.RECIPE_LISTS.get(appliance).hasRecipes()) {
//                buttonList.add(new TabButton(appliance, appliance == this.appliance, gui, buttonList.size(), 308, 16 + appliance.ordinal() * 36));
//            }
//        }
//    }
//}