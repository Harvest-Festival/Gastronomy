package uk.joshiejack.gastronomy.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;
import uk.joshiejack.gastronomy.tileentity.base.CookerTileEntity;
import uk.joshiejack.penguinlib.client.renderer.tile.AbstractItemTileEntityRenderer;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;

public abstract class AbstractCookwareTileEntityRenderer<T extends CookerTileEntity> extends AbstractItemTileEntityRenderer<T> {
    public AbstractCookwareTileEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(@Nonnull T tile, float partialTicks, @Nonnull MatrixStack matrix, @Nonnull IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        //TODO: Render the fluids? in the oven
        matrix.pushPose();
        matrix.mulPose(Vector3f.XP.rotationDegrees(90F));
        ItemStack result = tile.getItem(20);
        if (!result.isEmpty())
            renderItem(result, matrix, buffer, combinedLightIn, (mtx) -> applyResultTransformation(mtx, tile));
        else IntStream.range(0, 20).filter(i ->!tile.getItem(i).isEmpty())
                .forEach(i -> renderItem(tile.getItem(i), matrix, buffer, combinedLightIn, (mtx) -> applyIngredientTransformations(mtx, tile, i)));
        matrix.popPose();
    }

    protected abstract void applyResultTransformation(@Nonnull MatrixStack mtx, @Nonnull T tile);
    protected abstract void applyIngredientTransformations(@Nonnull MatrixStack mtx, @Nonnull T tile, int slot);

    @Override
    public boolean shouldRenderOffScreen(@Nonnull T tile) {
        return IntStream.rangeClosed(0, 20).anyMatch(i -> !tile.getItem(i).isEmpty());
    }

    /*
    protected void renderFluid(int id, ResourceLocation fluid) {}

    @Override
    public void render(T cookware, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);

        renderCookware(cookware); //Additional rendering
        ItemStack result = cookware.getHandler().getStackInSlot(CookerTileEntity.FINISH_SLOT);
        if (!result.isEmpty()) {
            renderItem(result, () -> translateResult(cookware, result.getItem() instanceof ItemBlock));
        } else {
            for (int i = 0; i < CookerTileEntity.FINISH_SLOT; i++) {
                ItemStack stack = cookware.getHandler().getStackInSlot(i);
                if (!stack.isEmpty()) {
                    renderItem(stack, cookware.getRenderData(), i);
                }
            }
        }

        List<FluidStack> fluids = cookware.getFluids();
        for (int i = 0; i < fluids.size(); i++) {
            renderFluid(i * 10, fluids.get(i).getFluid().getStill());
        }

        GlStateManager.popMatrix();
    }

    protected void renderCookware(T cookware) { } */
}
