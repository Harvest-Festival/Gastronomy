//package uk.joshiejack.gastronomy.client.renderer.tile;
//
//import com.mojang.blaze3d.matrix.MatrixStack;
//import net.minecraft.client.renderer.IRenderTypeBuffer;
//import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
//import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import uk.joshiejack.gastronomy.client.model.ModelFridgeDoor;
//import uk.joshiejack.gastronomy.tileentity.FridgeTileEntity;
//
//import javax.annotation.Nonnull;
//
//import static uk.joshiejack.gastronomy.Gastronomy.MODID;
//
//@OnlyIn(Dist.CLIENT)
//public class SpecialRendererFridge extends TileEntityRenderer<FridgeTileEntity> {
//    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/blocks/kitchen/fridge_door.png");
//    private final ModelFridgeDoor ovenModel = new ModelFridgeDoor();
//
//    public SpecialRendererFridge(TileEntityRendererDispatcher dispatcher) {
//        super(dispatcher);
//    }
//
//    @Override
//    public void render(@Nonnull FridgeTileEntity tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
//        /*if (destroyStage >= 0) {
//            bindTexture(DESTROY_STAGES[destroyStage]);
//            GlStateManager.matrixMode(5890);
//            GlStateManager.pushMatrix();
//            GlStateManager.scale(4.0F, 4.0F, 1.0F);
//            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
//            GlStateManager.matrixMode(5888);
//        } else {
//            bindTexture(TEXTURE);
//        }
//
//        GlStateManager.pushMatrix();
//        GlStateManager.enableRescaleNormal();
//        if (destroyStage < 0) GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
//        GlStateManager.scale(1.0F, -1.0F, -1.0F);
//        Direction facing = fridge.getFacing();
//        int j = facing == NORTH ? 180 : facing == SOUTH ? 0 : facing == WEST ? 90 : -90;
//        if (facing == SOUTH) GlStateManager.translate(1F, 0F, 1F);
//        else if (facing == WEST) GlStateManager.translate(1F, 0F, 0F);
//        else if (facing == EAST) GlStateManager.translate(0F, 0F, 1F);
//
//        GlStateManager.rotate((float) j, 0.0F, 1.0F, 0.0F);
//        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
//        //Top Door
//        float f = fridge.prevLidAngleTop + (fridge.lidAngleTop - fridge.prevLidAngleTop) * partialTicks;
//        f = 1.0F - f;
//        f = 1.0F - f * f * f;
//        ovenModel.topDoor.rotateAngleY = -(f * ((float) Math.PI / 2F));
//
//        //Bottom Door
//        f = fridge.prevLidAngleBottom + (fridge.lidAngleBottom - fridge.prevLidAngleBottom) * partialTicks;
//        f = 1.0F - f;
//        f = 1.0F - f * f * f;
//        ovenModel.bottomDoor.rotateAngleY = -(f * ((float) Math.PI / 2F));
//
//        //Render
//        ovenModel.renderAll();
//        GlStateManager.disableRescaleNormal();
//        GlStateManager.popMatrix();
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//
//        if (destroyStage >= 0) {
//            GlStateManager.matrixMode(5890);
//            GlStateManager.popMatrix();
//            GlStateManager.matrixMode(5888);
//        } */
//    }
//}
