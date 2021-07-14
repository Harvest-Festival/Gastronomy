package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import uk.joshiejack.gastronomy.cooking.Appliance;

public class TileCookingHeatable extends TileCookingFluids {
    private final SoundEvent sound;

    public TileCookingHeatable(Appliance appliance, SoundEvent sound, TileEntityType<?> type) {
        super(appliance, type);
        this.sound = sound;
    }

    //Called by the oven
    public void tick() {

    }

    /*
    @Override
    public void animate() {
        TileEntity tile = world.getTileEntity(pos.below());
        if (tile instanceof OvenTileEntity) {
            if (cookTimer == 1) {
                world.playSound(getPos().getX(), getPos().getY() + 0.5D, getPos().getZ(), sound, SoundCategory.BLOCKS, 2F, world.rand.nextFloat() * 0.1F + 0.9F, false);
            }

            Direction orientation = ((OvenTileEntity)tile).getFacing();
            if (orientation == EnumFacing.NORTH || orientation == EnumFacing.SOUTH) {
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.2D + (world.rand.nextInt(10) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.265D + (world.rand.nextInt(15) / 100D), 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.2D + (world.rand.nextInt(10) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.735D - (world.rand.nextInt(15) / 100D), 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.8D - (world.rand.nextInt(10) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.265D + (world.rand.nextInt(15) / 100D), 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.8D - (world.rand.nextInt(10) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.735D - (world.rand.nextInt(15) / 100D), 0, 0, 0);
            } else if (orientation == EnumFacing.WEST || orientation == EnumFacing.EAST) {
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.265D + (world.rand.nextInt(15) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.2D + (world.rand.nextInt(10) / 100D), 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.735D - (world.rand.nextInt(15) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.2D + (world.rand.nextInt(10) / 100D), 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.265D + (world.rand.nextInt(15) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.8D - (world.rand.nextInt(10) / 100D), 0, 0, 0);
                world.spawnParticle(EnumParticleTypes.FLAME, getPos().getX() + 0.735D - (world.rand.nextInt(15) / 100D), getPos().getY() - 0.115D, getPos().getZ() + 0.8D - (world.rand.nextInt(10) / 100D), 0, 0, 0);
            }

            world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getPos().getX() + 0.4D + (world.rand.nextInt(20) / 100D), getPos().getY() - 0.2D, getPos().getZ() + 0.4D + (world.rand.nextInt(20) / 100D), 0, 0, 0);
        }
    }

    @Override
    public PlaceIngredientResult hasPrereqs() {
        return isAbove(Appliance.OVEN) ? PlaceIngredientResult.SUCCESS : PlaceIngredientResult.MISSING_OVEN;
    } */
}
