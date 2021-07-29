package uk.joshiejack.gastronomy.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.HorizontalBlock;
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
        handle.mirror = true;
        door = new ModelRenderer(32, 16, 0, 3);
        door.addBox(-5F, -7F, 0F, 10, 7, 1);
        door.mirror = true;
    }

    @Override
    protected void applyIngredientTransformations(@Nonnull MatrixStack mtx, @Nonnull OvenTileEntity tile, int i) {
        mtx.translate(0.5F, 0.5F, -0.3F);
        mtx.scale(0.3F, 0.3F, 0.3F);
        mtx.translate(tile.getRenderer().getOffsetX(i), (tile.getRenderer().getOffsetZ(i)), tile.getRenderer().getOffsetY(i));
        mtx.mulPose(Vector3f.ZP.rotationDegrees(tile.getRenderer().getRotation(i)));
    }

    @Override
    protected void applyResultTransformation(@Nonnull MatrixStack mtx, @Nonnull OvenTileEntity tile) {
        mtx.translate(0.5F, 0.5F, -0.3F);
        mtx.scale(0.6F, 0.6F, 0.6F);
        mtx.mulPose(Vector3f.ZP.rotationDegrees(-tile.getBlockState().getValue(HorizontalBlock.FACING).toYRot()));
    }

    @Override
    public void render(@Nonnull OvenTileEntity tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        super.render(tile, partialTicks, matrix, buffer, combinedLightIn, combinedOverlayIn);
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

        float f2 = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialTicks;
        f2 = 1.0F - f2;
        f2 = 1.0F - f2 * f2 * f2;
        door.xRot = (f2 * ((float) Math.PI / 2F));
        handle.xRot = door.xRot;
        IVertexBuilder builder = OVEN_DOOR.buffer(buffer, RenderType::entityCutout);
        door.render(matrix, builder, combinedLightIn, combinedOverlayIn);
        handle.render(matrix, builder, combinedLightIn, combinedOverlayIn);
        matrix.popPose();
    }
}
