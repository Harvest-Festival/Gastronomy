package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.tileentity.ITickableTileEntity;
import uk.joshiejack.penguinlib.tile.inventory.AbstractInventoryTileEntity;

public class FridgeTileEntity extends AbstractInventoryTileEntity implements ITickableTileEntity {
    public FridgeTileEntity() {
        super(GastronomyTileEntities.FRIDGE.get(), 35);
    }
    /*
    private static final float f1 = 0.025F;
    public float prevLidAngleTop;
    public float lidAngleTop;
    public boolean animatingTop;
    public boolean openTop = true;
    public float prevLidAngleBottom;
    public float lidAngleBottom;
    public boolean animatingBottom;
    public boolean openBottom = true;

    public FridgeTileEntity() {
        super(35);
    }

    @Override
    public boolean isStackValidForInsertion(int slot, ItemStack stack) {
        return FoodSlot.isValid(stack);
    }

    @Override
    public boolean isSlotValidForExtraction(int slot, int amount) {
        return !handler.getStackInSlot(slot).isEmpty();
    }

    @Override
    public boolean onRightClicked(PlayerEntity player, Hand hand) {
        player.openGui(Gastronomy.instance, 0, player.level, pos.getX(), pos.getY(), pos.getZ());
        return true; //Open fridge gui
    } */

    @Override
    public void tick() {/*
        if (level.isClientSide) {
            if (lidAngleTop >= 0.1F && handler.getPlayersWatching() <= 0) {
                animatingTop = true;
                openTop = false;
            }

            if (lidAngleBottom >= 0.1F && handler.getPlayersWatching() <= 0) {
                animatingBottom = true;
                openBottom= false;
            }

            //Top Door
            prevLidAngleTop = lidAngleTop;
            if (animatingTop) {
                if (openTop) {
                    lidAngleTop += f1;
                } else {
                    lidAngleTop -= f1;
                }

                if (lidAngleTop > 0.5F) {
                    lidAngleTop = 0.5F;
                    animatingTop = false;
                    openTop = false; //Once we hit critical, go down instead
                }

                if (lidAngleTop < 0.0F) {
                    lidAngleTop = 0.0F;
                    animatingTop = false;
                    openTop = true;
                }
            }

            //Bottom Door
            prevLidAngleBottom = lidAngleBottom;
            if (animatingBottom) {
                if (openBottom) {
                    lidAngleBottom += f1;
                } else {
                    lidAngleBottom -= f1;
                }

                if (lidAngleBottom > 0.5F) {
                    lidAngleBottom = 0.5F;
                    openBottom = false; //Once we hit critical, go down instead
                    animatingBottom = false;
                }

                if (lidAngleBottom < 0.0F) {
                    lidAngleBottom = 0.0F;
                    animatingBottom = false;
                    openBottom = true;
                }
            }
        }*/
    }
/*
    @Override
    protected ValidatedStackHandler createHandler(int size) {
        return new FridgeInventory(this, size);
    }

    public static class FridgeInventory extends ValidatedStackHandler {
        public FridgeInventory(AbstractInventoryTileEntity tile, int size) {
            super(tile, size);
        }

        @Override
        protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
            return 512;
        }
    } */
}
