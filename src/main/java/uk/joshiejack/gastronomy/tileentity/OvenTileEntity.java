package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;
import uk.joshiejack.gastronomy.GastronomySounds;
import uk.joshiejack.gastronomy.block.OvenBlock;
import uk.joshiejack.gastronomy.client.renderer.CookerItemRender;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.gastronomy.tileentity.base.CookerTileEntity;
import uk.joshiejack.gastronomy.tileentity.base.TileCookingHeatable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OvenTileEntity extends CookerTileEntity implements ITickableTileEntity {
    public float prevLidAngle;
    public float lidAngle;
    private boolean animating;
    private boolean opening = true;
    private TileCookingHeatable heatable;
    private boolean init;

    public OvenTileEntity() {
        super(Appliance.OVEN, 100, GastronomyTileEntities.OVEN.get());
    }

    @OnlyIn(Dist.CLIENT)
    public CookerItemRender createRender() {
        return new CookerItemRender() {
            @Override
            public void initSlot(World world, int slot) {
                rotation[slot] = world.random.nextFloat() * 360.0F;
                offsetX[slot] = (0.5F - world.random.nextFloat()) * 1.35F;
                offsetZ[slot] = (0.5F - world.random.nextFloat()) * 1.35F;
                offsetY[slot] = (world.random.nextFloat() * 0.05F);
            }
        };
    }

    @Override
    public void tick() {
        if (heatable != null) {
            heatable.activate();
            if (!level.isClientSide) {
                boolean lit = heatable.isCooking();
                boolean isLit = getBlockState().getValue(OvenBlock.LIT);
                if (lit != isLit) {
                    level.setBlock(worldPosition, getBlockState().setValue(OvenBlock.LIT, heatable.isCooking()), Constants.BlockFlags.BLOCK_UPDATE);
                    setChanged();
                }
            }
        } else if (!init || level.getDayTime() %100 == 0) {
            init = true;
            TileEntity tile = level.getBlockEntity(worldPosition.above());
            if (tile instanceof TileCookingHeatable)
                heatable((TileCookingHeatable) tile);
        }

        activate();

        //Animate the door up and down
        if (level.isClientSide) {
            prevLidAngle = lidAngle;
            float f1 = 0.05F;
            if (animating) {
                if (opening) {
                    lidAngle += f1;
                } else {
                    lidAngle -= f1;
                }

                if (lidAngle >= 1F) {
                    opening = false;
                }


                //We have closed again so let's clear this out
                if (lidAngle <= 0F) {
                    lidAngle = 0F;
                    opening = true;
                    animating = false;
                }
            }
        }
    }

    public void heatable(@Nullable TileCookingHeatable tile) {
        this.heatable = tile;
    }

    @Override
    protected void onCooking() {
        if (cookTimer % 100 == 0)
            level.playSound(null, worldPosition.getX(), worldPosition.getY() + 0.5D, worldPosition.getZ(), GastronomySounds.OVEN.get(),
                    SoundCategory.BLOCKS, 2F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void onCookingCompleted() {
        super.onCookingCompleted();
        level.playSound(null, worldPosition.getX(), worldPosition.getY() + 0.5D, worldPosition.getZ(), GastronomySounds.OVEN_DONE.get(),
                SoundCategory.BLOCKS, 2F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected void animate() {
    }

    @Override
    public void setItem(int slot, @Nonnull ItemStack stack) {
        if (slot != 20) {
            cooking = true;
        }

        super.setItem(slot, stack);
    }

    @Override
    public boolean open() {
        level.playSound(null, worldPosition.getX(), worldPosition.getY() + 0.5D, worldPosition.getZ(), GastronomySounds.OVEN_DOOR.get(), SoundCategory.BLOCKS, 2F, level.random.nextFloat() * 0.1F + 0.9F);
        if (level.isClientSide) {
            animating = true;
            opening = true;
        }

        return true;
    }


    /*
    @OnlyIn(Dist.CLIENT)
    @Override
    public void animate() {
        if (cookTimer == 1) {
            world.playSound(getPos().getX(), getPos().getY() + 0.5D, getPos().getZ(), GastronomySounds.OVEN, SoundCategory.BLOCKS, 2F, world.rand.nextFloat() * 0.1F + 0.9F, false);
        }
    }

    @Override
    public void onFinished() {
        super.onFinished();
        world.playSound(null, pos, GastronomySounds.OVEN_DONE, SoundCategory.BLOCKS, 2F, 1F);
    }

    private boolean openDoor() {
        world.playSound(getPos().getX(), getPos().getY() + 0.5D, getPos().getZ(), GastronomySounds.OVEN_DOOR, SoundCategory.BLOCKS, 2F, world.rand.nextFloat() * 0.1F + 0.9F, false);
        if (world.isClientSide) {
            animating = true;
        }

        return true;
    }

    @Override
    public boolean handleFluids(PlayerEntity player, Hand hand, ItemStack held) {
        return super.handleFluids(player, hand, held) && openDoor();
    }

    @Override
    public boolean addIngredient(ItemStack stack) {
        return super.addIngredient(stack) && openDoor();
    }

    @Override
    protected boolean giveToPlayer(PlayerEntity player, ItemStack result, int slot) {
        if (givePlayer == null) { //Play the sound if we can remove an ingredient
            world.playSound(getPos().getX(), getPos().getY() + 0.5D, getPos().getZ(), GastronomySounds.OVEN_DOOR, SoundCategory.BLOCKS, 2F, world.rand.nextFloat() * 0.1F + 0.9F, false);
            if (world.isClientSide) {
                animating = true;
            }

            givePlayer = player;
            giveTimer = GIVE_TIME;
            giveStack = result;
            giveSlot = slot;
        }

        return true;
    }

    @Override
    public void updateTick() {
        if (givePlayer != null && giveStack != null) {
            giveTimer--;

            if (giveTimer <= 0) {
                MinecraftForge.EVENT_BUS.post(new ItemCookedEvent(givePlayer, giveStack, appliance));
                ItemHandlerHelper.giveItemToPlayer(givePlayer, giveStack);
                handler.setStackInSlot(giveSlot, ItemStack.EMPTY);
                givePlayer = null; //Turn it back to null
            }
        }

        super.updateTick();
        //Only do render updates on the client
        if (world.isClientSide) {
            prevLidAngle = lidAngle;
            float f1 = 0.025F;
            if (animating) {
                if (up) {
                    lidAngle -= f1;
                } else {
                    lidAngle += f1;
                }

                if (lidAngle < -0.25F) {
                    lidAngle = -0.25F;
                    up = false; //Once we hit critical, go down instead
                }

                if (lidAngle > 0.0F) {
                    lidAngle = 0.0F;
                    animating = false;
                    up = true;
                }
            }
        }
    }*/
}
