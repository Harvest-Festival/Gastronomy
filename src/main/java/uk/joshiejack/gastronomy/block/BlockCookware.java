package uk.joshiejack.gastronomy.block;

//public class BlockCookware extends BlockMultiTileRotatable<BlockCookware.Cookware> {
//    private static final AxisAlignedBB FRYING_PAN_AABB = new AxisAlignedBB(0.2F, 0F, 0.2F, 0.8F, 0.15F, 0.8F);
//    private static final AxisAlignedBB MIXER_AABB = new AxisAlignedBB(0.275F, 0F, 0.275F, 0.725F, 0.725F, 0.725F);
//    private static final AxisAlignedBB POT_AABB = new AxisAlignedBB(0.2F, 0F, 0.2F, 0.8F, 0.375F, 0.8F);
//
//    public BlockCookware() {
//        super(new ResourceLocation(MODID, "cookware"), Material.PISTON, Cookware.class);
//        setHardness(2.5F);
//        setSoundType(SoundType.METAL);
//        setCreativeTab(Gastronomy.TAB);
//    }
//
//    @Override
//    public String getToolType(Cookware cookware) {
//        switch (cookware) {
//            case COUNTER:
//            case COUNTER_IC:
//            case COUNTER_OC:
//            case ISLAND:
//            case ISLAND_IC:
//            case ISLAND_OC:
//            case SINK:
//                return "axe";
//            default:
//                return "pickaxe";
//        }
//    }
//
//    @SuppressWarnings("deprecation")
//    @Nonnull
//    @Override
//    public Material getMaterial(@Nonnull BlockState state) {
//        switch (getEnumFromState(state)) {
//            case COUNTER:
//            case COUNTER_IC:
//            case COUNTER_OC:
//            case OVEN_OFF:
//            case OVEN_ON:
//            case ISLAND:
//            case ISLAND_IC:
//            case ISLAND_OC:
//            case SINK:
//                return Material.WOOD;
//            default:
//                return material;
//        }
//    }
//
//    @SuppressWarnings("deprecation")
//    @Nonnull
//    @Override
//    public SoundType getSoundType(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nullable Entity entity) {
//        switch (getEnumFromState(state)) {
//            case COUNTER:
//            case COUNTER_IC:
//            case COUNTER_OC:
//            case ISLAND:
//            case ISLAND_IC:
//            case ISLAND_OC:
//            case SINK:
//                return SoundType.WOOD;
//            default:
//                return getSoundType();
//        }
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public boolean canRenderInLayer(@Nonnull BlockState state, @Nonnull BlockRenderLayer layer) {
//        return (getEnumFromState(state) == MIXER ? layer == BlockRenderLayer.TRANSLUCENT : layer == BlockRenderLayer.CUTOUT_MIPPED);
//    }
//
//    @SuppressWarnings("deprecation")
//    @Override
//    @Nonnull
//    public AxisAlignedBB getBoundingBox(@Nonnull BlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
//        Cookware cookware = getEnumFromState(state);
//        switch (cookware) {
//            case FRYING_PAN:
//                return FRYING_PAN_AABB;
//            case POT:
//                return POT_AABB;
//            case MIXER:
//                return MIXER_AABB;
//            default:
//                return FULL_BLOCK_AABB;
//        }
//    }
//
//    @Nonnull
//    @Override
//    public BlockState getActualState(@Nonnull BlockState state, IBlockAccess world, BlockPos pos) {
//        BlockState ret = super.getActualState(state, world, pos);
//        Cookware cookware = getEnumFromState(ret);
//        if (cookware == OVEN_OFF || cookware == OVEN_ON) {
//            TileEntity tile = world instanceof ChunkCache ? ((ChunkCache)world).getTileEntity(pos.above(), Chunk.EnumCreateEntityType.CHECK) : world.getTileEntity(pos.above());
//            if (tile instanceof TileCookingHeatable) {
//                if (((TileCookingHeatable)tile).isCooking()) {
//                    return ret.withProperty(property, OVEN_ON);
//                }
//            }
//
//            return ret.withProperty(property, OVEN_OFF);
//        } else if (cookware.getName().contains("counter") || cookware.getName().contains("island")) {
//            Direction northFacing = getFacing(NORTH, world, pos);
//            Direction eastFacing = getFacing(EAST, world, pos);
//            Direction southFacing = getFacing(SOUTH, world, pos);
//            Direction westFacing = getFacing(WEST, world, pos);
//
//            //Inner Corner
//            Cookware inner = cookware.getName().contains("counter") ? COUNTER_IC: ISLAND_IC;
//            if (northFacing == WEST && westFacing == NORTH) return state.withProperty(property, inner).withProperty(FACING, WEST);
//            if (southFacing == WEST && westFacing == SOUTH) return state.withProperty(property, inner).withProperty(FACING, SOUTH);
//            if (southFacing == EAST && eastFacing == SOUTH) return state.withProperty(property, inner).withProperty(FACING, EAST);
//            if (northFacing == EAST && eastFacing == NORTH) return state.withProperty(property, inner).withProperty(FACING, NORTH);
//
//            //Outer Corner
//            Cookware outer = cookware.getName().contains("counter") ? COUNTER_OC: ISLAND_OC;
//            if (northFacing == EAST && westFacing == SOUTH) return state.withProperty(property, outer).withProperty(FACING, EAST);
//            if (southFacing == EAST && westFacing == NORTH) return state.withProperty(property, outer).withProperty(FACING, NORTH);
//            if (southFacing == WEST && eastFacing == NORTH) return state.withProperty(property, outer).withProperty(FACING, WEST);
//            if (northFacing == WEST && eastFacing == SOUTH) return state.withProperty(property, outer).withProperty(FACING, SOUTH);
//        }
//
//        return ret;
//    }
//
//    private Direction getFacing(Direction facing, IBlockAccess world, BlockPos pos) {
//        TileEntity tile = world.getTileEntity(pos.offset(facing));
//        if (tile instanceof CounterTileEntity || tile instanceof OvenTileEntity || tile instanceof FridgeTileEntity || tile instanceof SinkTileEntity) {
//            return ((Rotatable)tile).getFacing();
//        }
//
//        return EnumFacing.DOWN;
//    }
//
//    @Override
//    public void breakBlock(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull BlockState state) {
//        TileEntity tile = world.getTileEntity(pos);
//        if (tile instanceof AbstractInventoryTileEntity) {
//            dropInventory((AbstractInventoryTileEntity) tile, world, pos);
//            world.updateComparatorOutputLevel(pos, this);
//        }
//
//        super.breakBlock(world, pos, state);
//    }
//
//    private void dropInventory(AbstractInventoryTileEntity inventory, World world, BlockPos pos) {
//        for (int i = 0; i < inventory.getHandler().getSlots(); i++) {
//            ItemStack itemstack = inventory.getHandler().getStackInSlot(i);
//            if (!itemstack.isEmpty()) {
//                Cooker.removeUtensilTag(itemstack);
//                InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), itemstack);
//            }
//        }
//    }
//
//    @Nonnull
//    @Override
//    public TileEntity createTileEntity(@Nonnull World world, @Nonnull BlockState state) {
//        switch (getEnumFromState(state)) {
//            case FRYING_PAN:        return new FryingPanTileEntity();
//            case MIXER:             return new MixerTileEntity();
//            case OVEN_OFF:
//            case OVEN_ON:           return new OvenTileEntity();
//            case POT:               return new PotTileEntity();
//            case SINK:              return new SinkTileEntity();
//            default:                return new CounterTileEntity();
//        }
//    }
//
//    @Nonnull
//    protected ItemStack getCreativeStack(Cookware cookware) {
//        switch (cookware) {
//            case ISLAND_OC:
//            case ISLAND_IC:
//            case COUNTER_IC:
//            case COUNTER_OC:
//            case OVEN_ON:           return ItemStack.EMPTY;
//            default:                return super.getCreativeStack(cookware);
//        }
//    }
//
//    @Override
//    public BlockFaceShape getBlockFaceShape(IBlockAccess world, BlockState state, BlockPos pos, Direction face) {
//        TileEntity tile = world.getTileEntity(pos);
//        if (tile instanceof CounterTileEntity) {
//            return  ((CounterTileEntity)tile).getFacing() == face ? BlockFaceShape.CENTER : BlockFaceShape.SOLID;
//        } else return super.getBlockFaceShape(world, state, pos, face);
//    }
//
//    @SuppressWarnings("ConstantConditions")
//    @OnlyIn(Dist.CLIENT)
//    @Override
//    protected void registerModel(Item item, Cookware cookware) {
//        if (cookware == OVEN_OFF || cookware == OVEN_ON) {
//            ModelLoader.setCustomModelResourceLocation(item, cookware.ordinal(), new ModelResourceLocation(getRegistryName(), "inventory_oven"));
//        } else super.registerModel(item, cookware);
//    }
//
//    public enum Cookware implements IStringSerializable {
//        COUNTER, COUNTER_IC, COUNTER_OC, FRYING_PAN, MIXER, OVEN_OFF, OVEN_ON, POT,
//        ISLAND, ISLAND_IC, ISLAND_OC, SINK;
//
//        @Override
//        public @Nonnull String getName() {
//            return name().toLowerCase(Locale.ENGLISH);
//        }
//    }
//}
