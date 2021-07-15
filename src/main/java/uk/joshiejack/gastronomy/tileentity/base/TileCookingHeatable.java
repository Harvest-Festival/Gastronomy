package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.OvenTileEntity;

public class TileCookingHeatable extends CookerTileEntity {
    private final SoundEvent sound;

    public TileCookingHeatable(Appliance appliance, SoundEvent sound, TileEntityType<?> type) {
        super(appliance, 80, type);
        this.sound = sound;
    }

    //Called by the oven
    public void tick() {

    }
    
    @Override
    public void animate() {
        TileEntity tile = level.getBlockEntity(worldPosition.below());
        if (tile instanceof OvenTileEntity) {
            if (cookTimer == 1) {
                level.playSound(null, worldPosition.getX(), worldPosition.getY() + 0.5D, worldPosition.getZ(), sound, SoundCategory.BLOCKS, 2F, level.random.nextFloat() * 0.1F + 0.9F);
            }

            Direction orientation = tile.getBlockState().getBedDirection(level, worldPosition.below());
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

            level.addParticle(ParticleTypes.SMOKE, worldPosition.getX() + 0.4D + (level.random.nextInt(20) / 100D), worldPosition.getY() - 0.2D, worldPosition.getZ() + 0.4D + (level.random.nextInt(20) / 100D), 0, 0, 0);
        }
    } /*

    @Override
    public PlaceIngredientResult hasPrereqs() {
        return isAbove(Appliance.OVEN) ? PlaceIngredientResult.SUCCESS : PlaceIngredientResult.MISSING_OVEN;
    } */
}
