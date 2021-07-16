package uk.joshiejack.gastronomy.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
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
        Minecraft mc = Minecraft.getInstance();
        matrix.pushPose();

        ItemStack result = tile.getItem(20);
        IntStream.range(0, 20).filter(i -> result.isEmpty() ? !tile.getItem(i).isEmpty() : i < result.getCount()).forEach(i -> {
            ItemStack stack = result.isEmpty() ? tile.getItem(i) : result.getCount() < i ? ItemStack.EMPTY : result;
            renderItem(mc, stack, matrix, buffer, combinedLightIn, combinedOverlayIn, (mtx) -> {
                mtx.scale(0.3F, 0.3F, 0.3F);
                mtx.translate(tile.getRenderer().offset1[i] - 0.05F, ((tile.getRenderer().heightOffset[i]) * 0.1F) - 2.475F, tile.getRenderer().offset2[i]);
                mtx.mulPose(Vector3f.XP.rotationDegrees(90F));
                mtx.mulPose(Vector3f.ZP.rotationDegrees(tile.getRenderer().rotations[i]));
            });
        });

        matrix.popPose();
    }

    /*
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

    public void translateResult(T cookware, boolean isBlock) {
        GlStateManager.translate(0.5F, 0.32F, 0.5F);
        GlStateManager.scale(0.4F, 0.4F, 0.4F);
        if (!isBlock) {
            GlStateManager.rotate(-90, 1F, 0F, 0F);
        } else {
            GlStateManager.rotate(90, 0F, 1F, 0F);
        }
    }

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
