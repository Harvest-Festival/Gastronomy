//package uk.joshiejack.gastronomy.client.gui.buttons;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import uk.joshiejack.gastronomy.api.Appliance;
//import uk.joshiejack.gastronomy.client.gui.GuiCookbook;
//import uk.joshiejack.gastronomy.client.gui.pages.PageApplianceList;
//import uk.joshiejack.gastronomy.cooking.Cooker;
//import uk.joshiejack.penguinlib.client.gui.book.BookScreen;
//import uk.joshiejack.penguinlib.client.gui.book.button.BookButton;
//
//import javax.annotation.Nonnull;
//
//@OnlyIn(Dist.CLIENT)
//public class TabButton extends BookButton {
//    private final Appliance appliance;
//    private final ItemStack stack;
//    private final boolean selected;
//
//    public TabButton(Appliance appliance, boolean selected, BookScreen gui, int buttonId, int x, int y) {
//        super(gui, buttonId, x, y, "");
//        this.appliance = appliance;
//        this.stack = Cooker.getStackFromAppliance(appliance);
//        this.selected = selected;
//        this.width = 26;
//        this.height = 32;
//    }
//
//    @Override
//    public void drawButton(@Nonnull Minecraft mc, int mouseX, int mouseY, float partialTicks) {
//        if (visible) {
//            hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
//            mc.getTextureManager().bindTexture(GuiCookbook.LEFT_GUI);
//            int theY = selected ? 64 :hovered ? 32: 0;
//            drawTexturedModalRect(x, y, 0, theY, 26, 32);
//            drawStack(stack, 0, 8, 1F);
//        }
//    }
//
//    @Override
//    public void mouseReleased(int mouseX, int mouseY) {
//        gui.setPage(PageApplianceList.RECIPE_LISTS.get(appliance));
//    }
//}
