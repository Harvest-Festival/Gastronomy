//package uk.joshiejack.gastronomy.client.renderer.tile;
//
//import net.minecraft.client.renderer.GlStateManager;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.relauncher.SideOnly;
//import uk.joshiejack.gastronomy.item.GastronomyItems;
//import uk.joshiejack.gastronomy.item.KnifeItem;
//import uk.joshiejack.gastronomy.tileentity.MixerTileEntity;
//import uk.joshiejack.penguinlib.util.PenguinLoader;
//
//@SuppressWarnings("unused")
//@OnlyIn(Dist.CLIENT)
//@PenguinLoader(value = "mixer", side = Dist.CLIENT)
//public class SpecialRendererMixer extends SpecialRendererCookware<MixerTileEntity> {
//    private static ItemStack BLADE_STACK = ItemStack.EMPTY;
//
//    private ItemStack getBladeStack() {
//        if (BLADE_STACK.isEmpty()) {
//            BLADE_STACK = GastronomyItems.UTENSIL.getStackFromEnum(KnifeItem.Utensil.BLADE);
//        }
//
//        return BLADE_STACK;
//    }
//
//    @Override
//    protected void renderCookware(MixerTileEntity mixer) {
//        //Render the blade as an item
//        renderItem(getBladeStack(), ()-> translateItem(false, -0.38F, mixer.blade, 0F, 0F));
//        super.renderCookware(mixer);
//    }
//
//    @Override
//    public void renderFluid(int i, ResourceLocation fluid) {
//        renderFluidCube(fluid, 0.5F, 0.375F + (i * 0.001F), 0.5F, 0.3249F);
//    }
//
//    @Override
//    public void translateItem(boolean isBlock, float position, float rotation, float offset1, float offset2) {
//        if (!isBlock) {
//            if (offset2 != 0F) { //Rendering the blade
//                GlStateManager.enableLighting();
//                GlStateManager.translate(0.5F, 0.45F, 0.5F);
//                GlStateManager.scale(0.175F, 0.175F, 0.175F);
//                GlStateManager.rotate(rotation - 90F, 0F, 1F, 0F);
//            } else {
//                GlStateManager.translate(0.5F, 0.4F, 0.5F);
//                GlStateManager.scale(0.25F, 0.2F, 0.25F);
//                GlStateManager.rotate(-90, 1F, 0F, 0F);
//            }
//
//            GlStateManager.rotate(rotation, 0F, 0F, 1F);
//            GlStateManager.translate(offset1, offset2, position);
//        } else {
//            GlStateManager.rotate(90, 1F, 0F, 0F);
//            GlStateManager.translate(offset1 * 1.4F, 0.8F - offset2 * 2.5F, position - 1F);
//        }
//    }
//
//    @Override
//    public void translateResult(MixerTileEntity mixer, boolean isBlock) {
//        GlStateManager.scale(0.4F, 0.4F, 0.4F);
//        GlStateManager.translate(1.25F, 1.1F, 1.25F);
//        if (mixer.getFacing() == EnumFacing.EAST || mixer.getFacing() == EnumFacing.WEST) {
//            GlStateManager.rotate(-90, 0F, 1F, 0F);
//        }
//
//        if (isBlock) {
//            GlStateManager.rotate(90, 0F, 1F, 0F);
//        }
//    }
//}
