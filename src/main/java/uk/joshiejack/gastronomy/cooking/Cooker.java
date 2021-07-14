package uk.joshiejack.gastronomy.cooking;

public class Cooker {
    /*
    public static ItemStack cook(Appliance appliance, NonNullList<ItemStack> stacks, List<FluidStack> fluids) {
        List<IngredientStack> ingredients = Lists.newArrayList();
        Object2IntMap<Ingredient> map = new Object2IntOpenHashMap<>();
        stacks.forEach(stack -> MapHelper.adjustOrPut(map, Ingredient.registry.getValue(stack), 1, 1));
        map.forEach((e, k) -> ingredients.add(new IngredientStack(e, k)));
        fluids.forEach((fluid) -> ingredients.add(new IngredientStack(fluid)));

        ItemStack ret = getResult(Recipe.PRIORITY_RECIPES.get(appliance), ingredients);
        if (ret.isEmpty()) ret = getResult(Recipe.RECIPES.get(appliance), ingredients);
        return ret.isEmpty() ? GastronomyItems.BURNT.getStackFromEnum(appliance) : ret;
    }

    private static ItemStack getResult(Collection<Recipe> recipes, List<IngredientStack> ingredients) {
        for (Recipe recipe: recipes) {
            ItemStack ret = recipe.cook(ingredients);
            if (!ret.isEmpty()) {
                return ret;
            }
        }

        return ItemStack.EMPTY;
    }

    @SuppressWarnings("ConstantConditions")
    public static void removeUtensilTag(ItemStack stack) {
        //Remove the in_utensil tag, and if no tags left, remove all tags entirely
        if (stack.hasTag()) stack.getTag().remove(IN_UTENSIL);
        if (stack.hasTag() && stack.getTag().isEmpty()) {
            stack.setTag(null);
        }
    }

    public static CookerTileEntity getNearbyAppliance(PlayerEntity player, Appliance appliance) {
        BlockPos pos = TerrainHelper.getFirstBlockWithinReach(player, (world, target) -> {
            TileEntity tile = world.getTileEntity(target);
            if (tile instanceof CookerTileEntity) {
                CookerTileEntity cooking = (CookerTileEntity) tile;
                IItemHandler handler = cooking.getHandler();
                for (int i = 0; i < handler.getSlots(); i++) {
                    ItemStack stack = handler.getStackInSlot(i);
                    if (!stack.isEmpty()) return false;
                }

                return cooking.appliance == appliance;
            }

            return false;
        });

        return pos != null ? ((CookerTileEntity)player.level.getBlockEntity(pos)) : null;
    }

    public static boolean learnRecipe(PlayerEntity player, ItemStack stack) {
        return player.level.isClientSide ? RecipeBook.learnRecipe(stack) : RecipeArchives.get(player.level).learnRecipe(player, stack);
    }

    public static List<IItemHandlerModifiable> getFoodStorageAndPlayer(PlayerEntity player) {
        List<IItemHandlerModifiable> inventories = Lists.newArrayList();
        inventories.add(new PlayerInvWrapper(player.inventory));
        inventories.addAll(TerrainHelper.getAllBlocksWithinReach(player, (pos, list) -> {
            TileEntity tile = player.level.getBlockEntity(pos);
            if (tile != null && tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP)) {
                for (Class<? extends TileEntity> c : Gastronomy.FOOD_STORAGE) {
                    if (c.isAssignableFrom(tile.getClass())) {
                        Object o = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
                        if (o instanceof IItemHandlerModifiable) {
                            list.add((IItemHandlerModifiable) o);
                        }
                    }
                }
            }

            return true;
        }));

        return inventories;
    }

    private static IngredientStack getIngredientStackFromItemStack(boolean fluids, ItemStack stack) {
        if (fluids) {
            Optional<FluidStack> fluid = FluidUtil.getFluidContained(stack);
            if (fluid.isPresent())
                return new IngredientStack(fluid.get());
        }

        Ingredient iIngredient = Ingredient.registry.getValue(stack);
        return new IngredientStack(iIngredient, stack.getCount());
    }

    //TODO: remove items from fridge and cupboard
    public static void takeFromFridgeOrPlayerInventory(CookerTileEntity cooking, List<IItemHandlerModifiable> inventories, List<IngredientStack> ingredients) {
        boolean fluids = cooking instanceof TileCookingFluids;
        for (IngredientStack ingredient: ingredients) {
            int count = ingredient.getAmount();
            handlers:
            for (IItemHandlerModifiable handler: inventories) {
                for (int i = 0; i < handler.getSlots(); i++) {
                    ItemStack stack = handler.getStackInSlot(i);
                    IngredientStack input = getIngredientStackFromItemStack(fluids, stack);
                    if (!input.isEmpty() && input.matches(ingredient)) {
                        if (fluids && input.isFluid()) {
                            PlayerEntity player = FakePlayerHelper.getFakePlayerWithPosition((ServerWorld) cooking.getWorld(), cooking.getPos());
                            ((TileCookingFluids)cooking).handleFluids(player, EnumHand.MAIN_HAND, stack);
                            handler.setStackInSlot(i, player.getItemInHand(EnumHand.MAIN_HAND));
                            break handlers; //Really doesn't matter for a fluid
                        } else {
                            ItemStack stackTaken = stack.copy();
                            int shrink = MathsHelper.constrainToRangeInt(count, 0, stack.getCount());
                            stack.shrink(shrink);
                            stackTaken.setCount(shrink);
                            while (!stackTaken.isEmpty()) {
                                cooking.addIngredient(stackTaken);
                            }

                            count -= shrink;
                            if (count <= 0) {
                                break handlers;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isInInventories(NonNullList<ItemStack> stacks, List<FluidStack> fluids, IngredientStack requiredStack) {
        List<IngredientStack> ingredients = Lists.newArrayList();
        Object2IntMap<Ingredient> map = new Object2IntOpenHashMap<>();
        stacks.forEach(stack -> MapHelper.adjustOrPut(map, Ingredient.registry.getValue(stack), stack.getCount(), stack.getCount()));
        map.forEach((e, k) -> ingredients.add(new IngredientStack(e, k)));
        fluids.forEach((fluid) -> ingredients.add(new IngredientStack(fluid)));
        int found = 0;
        for (IngredientStack ingredientStack: ingredients) {
            if (ingredientStack.matches(requiredStack)) {
                found += ingredientStack.getAmount();
            }

            if (found >= requiredStack.getAmount()) {
                return true;
            }
        }

        return false;
    }

    public static ItemStack getStackFromAppliance(Appliance appliance) {
        return appliance.getItemStack();
    } */
}
