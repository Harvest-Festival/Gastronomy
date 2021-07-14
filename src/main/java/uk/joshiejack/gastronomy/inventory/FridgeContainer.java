package uk.joshiejack.gastronomy.inventory;

//public class FridgeContainer extends PenguinContainerUnlimited {
//    private final FridgeTileEntity fridge;
//
//    public FridgeContainer(InventoryPlayer inventory, FridgeTileEntity fridge) {
//        super(fridge.getHandler().getSlots());
//        this.fridge = fridge;
//        fridge.getHandler().addPlayer();
//        int offsetY = 0;
//        for (int i = 0; i < 7; i++) {
//            if (i == 3) offsetY++;
//            for (int j = 0; j < 5; j++) {
//                addSlotToContainer(new FoodSlot(fridge.getHandler(), j + i * 5, 44 + j * 18, (i * 18) + 18 + (offsetY * 8)));
//            }
//        }
//
//        bindPlayerInventory(inventory, 82);
//    }
//
//    @Override
//    public void onContainerClosed(PlayerEntity playerIn) {
//        super.onContainerClosed(playerIn);
//        fridge.getHandler().removePlayer();
//    }
//
//    @Override
//    protected boolean hasUnlimitedInventory(Slot slot) {
//        return slot instanceof FoodSlot;
//    }
//
//}
