package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uk.joshiejack.gastronomy.client.renderer.CookerItemRender;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.item.GastronomyTags;

import javax.annotation.Nonnull;

@SuppressWarnings("ConstantConditions")
public abstract class TileCookingHeatable extends CookerTileEntity {
    private final SoundEvent sound;

    public TileCookingHeatable(Appliance appliance, SoundEvent sound, TileEntityType<?> type) {
        super(appliance, 80, type);
        this.sound = sound;
    }

    @OnlyIn(Dist.CLIENT)
    public CookerItemRender createRender() {
        return new CookerItemRender() {
            @Override
            public void initSlot(World world, int slot) {
                rotation[slot] = world.random.nextFloat() * 360.0F;
                offsetX[slot] = 0.5F - world.random.nextFloat();
                offsetZ[slot] = 0.5F - world.random.nextFloat();
                offsetY[slot] = (world.random.nextFloat() * 0.05F);
            }
        };
    }

    @Override
    public boolean canPlaceItem(int slot, @Nonnull ItemStack stack) {
        return level.getBlockState(worldPosition.below()).getBlock().is(GastronomyTags.HEAT_SOURCE) && super.canPlaceItem(slot, stack);
    }

    @Override
    protected void onCooking() {
        if (cookTimer == 1)
            level.playSound(null, worldPosition.getX(), worldPosition.getY() + 0.5D, worldPosition.getZ(), sound, SoundCategory.BLOCKS, 2F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void animate() {
        Direction orientation = getBlockState().getValue(HorizontalBlock.FACING);
        if (orientation == Direction.NORTH || orientation == Direction.SOUTH) {
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.2D + (level.random.nextInt(10) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.265D + (level.random.nextInt(15) / 100D), 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.2D + (level.random.nextInt(10) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.735D - (level.random.nextInt(15) / 100D), 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.8D - (level.random.nextInt(10) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.265D + (level.random.nextInt(15) / 100D), 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.8D - (level.random.nextInt(10) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.735D - (level.random.nextInt(15) / 100D), 0, 0, 0);
        } else if (orientation == Direction.WEST || orientation == Direction.EAST) {
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.265D + (level.random.nextInt(15) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.2D + (level.random.nextInt(10) / 100D), 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.735D - (level.random.nextInt(15) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.2D + (level.random.nextInt(10) / 100D), 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.265D + (level.random.nextInt(15) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.8D - (level.random.nextInt(10) / 100D), 0, 0, 0);
            level.addParticle(ParticleTypes.FLAME, worldPosition.getX() + 0.735D - (level.random.nextInt(15) / 100D), worldPosition.getY() - 0.115D, worldPosition.getZ() + 0.8D - (level.random.nextInt(10) / 100D), 0, 0, 0);
        }

        level.addParticle(ParticleTypes.SMOKE, worldPosition.getX() + 0.4D + (level.random.nextInt(20) / 100D), worldPosition.getY(), worldPosition.getZ() + 0.4D + (level.random.nextInt(20) / 100D), 0, 0, 0);
    } /*

    @Override
    public PlaceIngredientResult hasPrereqs() {
        return isAbove(Appliance.OVEN) ? PlaceIngredientResult.SUCCESS : PlaceIngredientResult.MISSING_OVEN;
    } */
}
