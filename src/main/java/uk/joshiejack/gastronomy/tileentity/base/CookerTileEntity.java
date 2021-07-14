package uk.joshiejack.gastronomy.tileentity.base;

import net.minecraft.tileentity.TileEntityType;
import uk.joshiejack.gastronomy.cooking.Appliance;
import uk.joshiejack.penguinlib.tile.inventory.AbstractInventoryTileEntity;

public class CookerTileEntity extends AbstractInventoryTileEntity {
    private final Appliance appliance;
    private final int timeRequired;

    public CookerTileEntity(Appliance appliance, int timeRequired, TileEntityType<?> type) {
        super(type, 21);
        this.appliance = appliance;
        this.timeRequired = timeRequired;
    }
    /*public static final String IN_UTENSIL = "InUtensil";
    public static final int FINISH_SLOT = 20;
    protected static final int COOK_TIMER = 100;
    protected LinkedList<Integer> last = new LinkedList<>();
    private final SpecialRenderData render = createRenderData();
    public final Appliance appliance;
    protected final int timeRequired;
    private boolean cooking;
    protected int cookTimer;

    public enum PlaceIngredientResult {
        SUCCESS, FAILURE, MISSING_OVEN, MISSING_COUNTER
    }

    //Slot id 20 is for the result item
    public TileCooking(Appliance appliance) {
        this(appliance, COOK_TIMER);
    }

    public TileCooking(Appliance appliance, int timeRequired) {
        super(21);
        this.timeRequired = timeRequired;
        this.appliance = appliance;
    }

    public SpecialRenderData createRenderData() {
        return new SpecialRenderDataCooking();
    }

    public SpecialRenderData getRenderData() {
        return render;
    }

    public boolean isCooking() {
        return cooking;
    }

    public void setCooking(boolean cooking, int cookTimer) {
        this.cooking = cooking;
        this.cookTimer = cookTimer;
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        super.onDataPacket(net, packet);
        if (last.size() > 0) {
            render.doRenderUpdate(world, pos, last.peekLast());
        }
    }

    @Override
    public void handleUpdateTag(@Nonnull CompoundNBT tag) {
        super.handleUpdateTag(tag);
        if (last.size() > 0) {
            render.doRenderUpdate(world, pos, last.peekLast());
        }
    }

    @Override //Only allow one item in each slot
    public boolean isStackValidForInsertion(int slot, ItemStack stack) {
        return handler.getStackInSlot(FINISH_SLOT).isEmpty() && !Ingredient.registry.getValue(stack).isNone() && handler.getStackInSlot(slot).isEmpty();
    }

    @Override
    public boolean isSlotValidForExtraction(int slot, int amount) {
        return !handler.getStackInSlot(FINISH_SLOT).isEmpty();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean onRightClicked(PlayerEntity player, Hand hand) {
        //If we've got a finished item in the finish slot, then take it out
        ItemStack result = handler.getStackInSlot(FINISH_SLOT);
        ItemStack held = player.getItemInHand(hand);
        if (!result.isEmpty() && held.getItem() != GastronomyItems.UTENSIL) {
            Recipe recipe = Recipe.RECIPE_BY_STACK.get(new HolderMeta(result));
            if (GastronomyConfig.enableDishRequirement && recipe != null && !recipe.getDish().isEmpty()) {
                if (held.getItem() == recipe.getDish().getItem() && held.getItemDamage() == recipe.getDish().getItemDamage() && held.getCount() >= result.getCount()) {
                    held.shrink(result.getCount()); //Reduce the held item
                    return giveToPlayer(player, result, FINISH_SLOT);
                } else {
                    //TODO: Display error in chat that we don't have the right dish equipped
                    return false;
                }
            } else return giveToPlayer(player, result, FINISH_SLOT);
        } else {
            if (!held.isEmpty()) {
                if (cooking && held.getItem() == GastronomyItems.UTENSIL && appliance == Appliance.COUNTER) {
                    if (result.isEmpty()) {
                        updateTick(); //Call on both sides, to allow for particles if neccessary
                    }

                    return true;
                }

                if (handleFluids(player, hand, held)) {
                    cookTimer = 0;
                    cooking = true;
                    markDirty();
                    return true;
                }

                if (addIngredient(held)) return true;
            }

            //Since we haven't chopped, removed finished or inserted, attempt to remove the last stack
            int lastSlot = last.size() > 0 ? last.pollLast() : NO_SLOT_FOUND;
            if (lastSlot != NO_SLOT_FOUND) {
                ItemStack stack = handler.getStackInSlot(lastSlot);
                if (!stack.isEmpty()) {
                    Cooker.removeUtensilTag(stack);
                    return giveToPlayer(player, stack, lastSlot);
                }
            }
        }

        return false;
    }

    protected boolean handleFluids(PlayerEntity player, Hand hand, ItemStack held) {
        return false;
    }

    public boolean addIngredient(ItemStack stack) {
        if (hasPrereqs() != PlaceIngredientResult.SUCCESS) return false;
        Ingredient ingredient = Ingredient.registry.getValue(stack);
        if (!ingredient.isNone()) {
            int slot = handler.findEmptySlot(FINISH_SLOT);
            if (slot != NO_SLOT_FOUND) {
                if (!world.isClientSide) {
                    ItemStack copy = stack.copy();
                    copy.setCount(1);
                    if (!copy.hasTag()) {
                        copy.setTagCompound(new CompoundNBT());
                    }

                    copy.getTag().setBoolean(IN_UTENSIL, true);
                    handler.setStackInSlot(slot, copy);
                    stack.shrink(1);
                }

                last.add(slot);
                if (world.isClientSide) {
                    render.doRenderUpdate(world, pos, last.peekLast());
                }

                cookTimer = 0;
                cooking = true;
                markDirty();
                return true;
            }
        }

        return false;
    }

    protected boolean giveToPlayer(PlayerEntity player, ItemStack result, int slot) {
        if (!world.isClientSide) {
            MinecraftForge.EVENT_BUS.post(new ItemCookedEvent(player, result, appliance));
            ItemHandlerHelper.giveItemToPlayer(player, result);
            handler.setStackInSlot(slot, ItemStack.EMPTY);
        }

        return true;
    }

    @Override //Do cooking stuff
    public void updateTick() {
        if (cooking) {
            cookTimer++;
            if (world.isClientSide) {
                animate(); //Animate
            } else {
                if (last.size() == 0) {
                    cooking = false;
                    markDirty();
                } else if (cookTimer >= timeRequired) {
                    NonNullList<ItemStack> stacks = NonNullList.create();
                    for (int i = 0; i < FINISH_SLOT; i++) {
                        ItemStack stack = handler.getStackInSlot(i);
                        if (!stack.isEmpty()) stacks.add(stack);
                        handler.setStackInSlot(i, ItemStack.EMPTY);
                    }

                    handler.setStackInSlot(FINISH_SLOT, Cooker.cook(appliance, stacks, getFluids()));
                    cooking = false;
                    cookTimer = 0;
                    markDirty();
                    onFinished();
                }

                if (hasPrereqs() != PlaceIngredientResult.SUCCESS) {
                    cooking = false;
                    markDirty();
                }
            }
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (!world.isClientSide) {
            PenguinNetwork.sendToNearby(this, new SyncCookingPacket(pos, cooking, cookTimer));
        }
    }

    public void onFinished() {}

    public List<FluidStack> getFluids() {
        return Lists.newArrayList();
    }

    public PlaceIngredientResult hasPrereqs() {
        return PlaceIngredientResult.SUCCESS;
    }

    boolean isAbove(Appliance appliance) {
        TileEntity tile = world.getTileEntity(pos.below());
        return tile instanceof TileCooking && ((TileCooking)tile).appliance == appliance;
    }

    @OnlyIn(Dist.CLIENT)
    public void animate() {
        render.rotate(world); //Rotate stuff
    }

    @Override
    public void readFromNBT(CompoundNBT nbt) {
        super.readFromNBT(nbt);
        cooking = nbt.getBoolean("Cooking");
        cookTimer = nbt.getInteger("CookTimer");
        for (int l: nbt.getIntArray("Last")) {
            last.add(l);
        }
    }

    @Nonnull
    @Override
    public CompoundNBT writeToNBT(CompoundNBT nbt) {
        nbt.putBoolean("Cooking", cooking);
        nbt.putInt("CookTimer", cookTimer);
        nbt.putIntArray("Last", last.stream().mapToInt(i->i).toArray());
        return super.writeToNBT(nbt);
    }*/

}
