package uk.joshiejack.gastronomy.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.OvenBlock;
import uk.joshiejack.gastronomy.tileentity.OvenTileEntity;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
public class OvenTileEntityRenderer extends AbstractCookwareTileEntityRenderer<OvenTileEntity> {
    public static final RenderMaterial OVEN_DOOR = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, new ResourceLocation(Gastronomy.MODID, "block/kitchen/oven_door"));
    public ModelRenderer handle;
    public ModelRenderer door;

    public OvenTileEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
        handle = new ModelRenderer(32, 16, 0, 0);
        handle.addBox(-2.5F, -6F, -1F, 5, 1, 1);
        //handle.setPos(0F, 0F, 0F);
        handle.mirror = true;
        door = new ModelRenderer(32, 16, 0, 3);
        door.addBox(-5F, -7F, 0F, 10, 7, 1);
        //door.setPos(0F, 0F, 0F);
        door.mirror = true;
    }

    @Override
    public void render(@Nonnull OvenTileEntity tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        Direction dir = tile.getBlockState().getValue(OvenBlock.FACING);
        float f = 180F + dir.toYRot();
        matrix.pushPose();
        matrix.mulPose(Vector3f.ZP.rotationDegrees(180F));
        matrix.mulPose(Vector3f.YP.rotationDegrees(f));
        switch (dir) {
            case NORTH:
                matrix.translate(-0.5F, -0.1875F, 0.1F);
                break;
            case SOUTH:
                matrix.translate(0.5F, -0.1875F, -0.9F);
                break;
            case WEST:
                matrix.translate(0.5F, -0.1875F, 0.1F);
                break;
            case EAST:
                matrix.translate(-0.5F, -0.1875F, -0.9F);
                break;
        }

        door.xRot = tile.lidAngle;
        handle.xRot = door.xRot;
        IVertexBuilder builder = OVEN_DOOR.buffer(buffer, RenderType::entityCutout);
        door.render(matrix, builder, combinedLightIn, combinedOverlayIn);
        handle.render(matrix, builder, combinedLightIn, combinedOverlayIn);
        matrix.popPose();

        //TODO: Render the items in the oven
    }
    /*

    @Override
    public void renderFluid(int i, ResourceLocation fluid) {
        renderFluidCube(fluid, 0.5F, 0.3F + (i * 0.001F), 0.5F, 0.725F);
    }

    @Override
    public void translateItem(boolean isBlock, float position, float rotation, float offset1, float offset2) {
        GlStateManager.translate(0.5F, 0.11F, 0.5F);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        if (!isBlock) {
            GlStateManager.rotate(-90, 1F, 0F, 0F);
            GlStateManager.rotate(rotation, 0F, 0F, 1F);
            GlStateManager.translate(offset1, offset2, position);
        } else {
            GlStateManager.rotate(90, 1F, 0F, 0F);
            GlStateManager.translate(offset1 * 1.4F, 0.8F - offset2 * 2.5F, position - 1F);
        }
    }

    @Override
    public void translateResult(OvenTileEntity oven, boolean isBlock) {
        GlStateManager.translate(0.5F, 0.32F, 0.5F);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        if (!isBlock) {
            GlStateManager.rotate(-90, 1F, 0F, 0F);
        } else {
            GlStateManager.rotate(90, 0F, 1F, 0F);
        }
    }
*/
}
