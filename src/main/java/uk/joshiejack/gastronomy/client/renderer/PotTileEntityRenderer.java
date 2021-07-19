package uk.joshiejack.gastronomy.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.tileentity.PotTileEntity;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
public class PotTileEntityRenderer extends AbstractCookwareTileEntityRenderer<PotTileEntity> {
    public PotTileEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(@Nonnull PotTileEntity tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        super.render(tile, partialTicks, matrix, buffer, combinedLightIn, combinedOverlayIn);
    }

    @Override
    protected Consumer<MatrixStack> applyResultTransformation(@Nonnull PotTileEntity tile) {
        return (mtx) -> {
            mtx.translate(0.5F, 0.5F, -0.1F);
            mtx.scale(0.5F, 0.5F, 0.5F);
            mtx.mulPose(Vector3f.ZP.rotationDegrees(-tile.getBlockState().getValue(HorizontalBlock.FACING).toYRot()));
        };
    }

    @Override
    protected Consumer<MatrixStack> applyIngredientTransformations(@Nonnull PotTileEntity tile, int i) {
        return (mtx) -> {
            mtx.translate(0.5F, 0.5F, -0.1F);
            mtx.scale(0.25F, 0.25F, 0.25F);
            mtx.translate(tile.getRenderer().getOffsetX(i), tile.getRenderer().getOffsetZ(i), tile.getRenderer().getOffsetY(i));
            mtx.mulPose(Vector3f.ZP.rotationDegrees(tile.getRenderer().getRotation(i)));
        };
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
