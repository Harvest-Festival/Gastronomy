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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.tileentity.MixerTileEntity;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
public class MixerTileEntityRenderer extends AbstractCookwareTileEntityRenderer<MixerTileEntity> {
    public static final RenderMaterial MIXER_BLADE = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, new ResourceLocation(Gastronomy.MODID, "block/kitchen/mixer_blade"));
    public ModelRenderer blade;

    public MixerTileEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
        blade = new ModelRenderer(16, 8, 0, 4);
        blade.addBox(-2.0F, -4.5F, -2.0F, 4.0F, 0.0F, 4.0F, 0.0F, false);
        blade.setPos(8F, 8F, 8F);
    }

    @Override
    public void render(@Nonnull MixerTileEntity tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        super.render(tile, partialTicks, matrix, buffer, combinedLightIn, combinedOverlayIn);
        float f1 = tile.prevBlade + (tile.blade - tile.prevBlade) * partialTicks;
        blade.yRot = tile.blade;
        blade.setPos(8F, 9F, 8F);
        IVertexBuilder builder = MIXER_BLADE.buffer(buffer, RenderType::entityCutout);
        blade.render(matrix, builder, combinedLightIn, combinedOverlayIn);
    }

    @Override
    protected void applyResultTransformation(@Nonnull MatrixStack mtx, @Nonnull MixerTileEntity tile) {
        mtx.translate(0.5F, 0.5F, -0.45F);
        mtx.scale(0.3F, 0.3F, 0.3F);
        mtx.mulPose(Vector3f.XP.rotationDegrees(-90F));
        mtx.mulPose(Vector3f.YP.rotationDegrees(180 + tile.getBlockState().getValue(HorizontalBlock.FACING).toYRot()));
    }

    @Override
    protected void applyIngredientTransformations(@Nonnull MatrixStack mtx, @Nonnull MixerTileEntity tile, int i) {
        mtx.translate(0.5F, 0.5F, -0.45F);
        mtx.scale(0.1F, 0.1F, 0.1F);
        mtx.mulPose(Vector3f.XP.rotationDegrees(-90F));
        mtx.mulPose(Vector3f.ZP.rotationDegrees(tile.getRenderer().getRotation(i)));
        mtx.mulPose(Vector3f.YP.rotationDegrees(-tile.getRenderer().getRotation(i)));
        mtx.translate(tile.getRenderer().getOffsetX(i) * 2.5F, tile.getRenderer().getOffsetZ(i) * 2.5F, tile.getRenderer().getOffsetY(i));
    }
}