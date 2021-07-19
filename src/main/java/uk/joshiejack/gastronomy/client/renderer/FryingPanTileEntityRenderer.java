package uk.joshiejack.gastronomy.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.tileentity.FryingPanTileEntity;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class FryingPanTileEntityRenderer extends AbstractCookwareTileEntityRenderer<FryingPanTileEntity> {
    public FryingPanTileEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(@Nonnull FryingPanTileEntity tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        super.render(tile, partialTicks, matrix, buffer, combinedLightIn, combinedOverlayIn);
    }

    @Override
    protected void applyResultTransformation(@Nonnull MatrixStack mtx, @Nonnull FryingPanTileEntity tile) {
        mtx.translate(0.5F, 0.5F, -0.1F);
        mtx.scale(0.5F, 0.5F, 0.5F);
        mtx.mulPose(Vector3f.ZP.rotationDegrees(-tile.getBlockState().getValue(HorizontalBlock.FACING).toYRot()));
    }

    @Override
    protected void applyIngredientTransformations(@Nonnull MatrixStack mtx, @Nonnull FryingPanTileEntity tile, int i) {
        mtx.translate(0.5F, 0.5F, -0.1F);
        mtx.scale(0.25F, 0.25F, 0.25F);
        mtx.translate(tile.getRenderer().getOffsetX(i), tile.getRenderer().getOffsetZ(i), tile.getRenderer().getOffsetY(i));
        mtx.mulPose(Vector3f.ZP.rotationDegrees(tile.getRenderer().getRotation(i)));
    }
}
    /*

    @Override
    public void renderFluid(int i, ResourceLocation fluid) {
        renderFluidCube(fluid, 0.5F, 0.3F + (i * 0.001F), 0.5F, 0.725F);
    }
}
*/