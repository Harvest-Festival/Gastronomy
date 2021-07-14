//package uk.joshiejack.gastronomy.client.gui.labels;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.text.TextFormatting;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fluids.FluidStack;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import uk.joshiejack.gastronomy.client.gui.CyclingIngredient;
//import uk.joshiejack.gastronomy.cooking.Cooker;
//import uk.joshiejack.penguinlib.client.GuiElements;
//import uk.joshiejack.penguinlib.client.gui.book.BookScreen;
//import uk.joshiejack.penguinlib.client.gui.book.label.BookLabel;
//
//import java.util.List;
//
//@OnlyIn(Dist.CLIENT)
//public class CyclingStackLabel extends BookLabel {
//    private final CyclingIngredient ingredient;
//    private final boolean isInInventory;
//    private final int offset;
//
//    public CyclingStackLabel(BookScreen gui, int offset, int y, CyclingIngredient ingredient, NonNullList<ItemStack> stacks, List<FluidStack> fluids) {
//        super(gui, 165, y);
//        this.offset = offset;
//        this.width = 64;
//        this.height = 64;
//        this.ingredient = ingredient;
//        this.isInInventory = Cooker.isInInventories(stacks, fluids, ingredient.getIngredient());
//    }
//
//    @Override
//    public void drawLabel(Minecraft mc, int mouseX, int mouseY) {
//        if (this.visible) {
//            ItemStack current = ingredient.getStack(offset);
//            drawStack(current, 0, 0, 1F);
//            GlStateManager.disableDepth();
//            TextFormatting formatting = isInInventory ? TextFormatting.DARK_GREEN : TextFormatting.RED;
//            mc.fontRenderer.drawString(formatting + current.getDisplayName(), x + 21, y + 7, 4210752);
//            gui.mc.getTextureManager().bindTexture(GuiElements.BOOK_LEFT);
//            if (isInInventory) {
//                drawTexturedModalRect(x + 8, y + 10, 31, 248, 10, 8);
//            } else drawTexturedModalRect(x + 8, y + 10, 41, 248, 7, 8);
//        }
//    }
//}
