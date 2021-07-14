package uk.joshiejack.gastronomy.inventory;

//public class CupboardContainer extends PenguinContainerUnlimited {
//    private final CupboardTileEntity cupboard;
//
//    public CupboardContainer(InventoryPlayer inventory, CupboardTileEntity cupboard) {
//        super(cupboard.getHandler().getSlots());
//        this.cupboard = cupboard;
//        cupboard.getHandler().addPlayer();
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                addSlotToContainer(new FoodSlot(cupboard.getHandler(), j + i * 3, 62 + j * 18, (i * 18) + 18));
//            }
//        }
//
//        bindPlayerInventory(inventory, 2);
//    }
//
//    @Override
//    public void onContainerClosed(PlayerEntity playerIn) {
//        super.onContainerClosed(playerIn);
//        cupboard.getHandler().removePlayer();
//    }
//}
