package uk.joshiejack.gastronomy.tileentity;

import uk.joshiejack.penguinlib.tile.inventory.AbstractInventoryTileEntity;

public class CupboardTileEntity extends AbstractInventoryTileEntity {
    public CupboardTileEntity() {
        super(GastronomyTileEntities.CUPBOARD.get(), 9);
    }

    /*

    @Override
    public boolean isStackValidForInsertion(int slot, ItemStack stack) {
        return hasInventory() && FoodSlot.isValid(stack);
    }

    @Override
    public boolean isSlotValidForExtraction(int slot, int amount) {
        return !handler.getStackInSlot(slot).isEmpty() && hasInventory();
    }

    @Override
    public boolean onRightClicked(PlayerEntity player, Hand hand) {
        if (hasInventory()) {
            player.openGui(Gastronomy.instance, 0, player.level, pos.getX(), pos.getY(), pos.getZ());
            return true;
        } else return false;
    }

    private boolean hasInventory() {
        BlockState actual = getState().getActualState(world, pos);
        return actual.getBlock() == blockType && GastronomyBlocks.CUPBOARD.getEnumFromState(actual) == BlockCupboard.Cupboard.FULL;
    }*/
}
