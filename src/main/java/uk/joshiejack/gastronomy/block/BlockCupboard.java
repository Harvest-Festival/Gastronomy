package uk.joshiejack.gastronomy.block;

/*public class BlockCupboard extends BlockMultiTileRotatable<BlockCupboard.Cupboard> {
    public BlockCupboard() {
        super(new ResourceLocation(Gastronomy.MODID, "cupboard"), Material.WOOD, Cupboard.class);
        setHardness(2.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(Gastronomy.TAB);
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, BlockState state, BlockPos pos, Direction face) {
        return ((CupboardTileEntity)Objects.requireNonNull(world.getTileEntity(pos))).getFacing() == face ? BlockFaceShape.CENTER : BlockFaceShape.SOLID;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean shouldSideBeRendered(BlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, Direction side) {
        return true; //TODO
    }

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(BlockState state, IBlockAccess world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof CupboardTileEntity) {
            switch (((CupboardTileEntity) tile).getFacing()) {
                case NORTH:
                    return new AxisAlignedBB(0D, 0D, 0.375D, 1D, 1D, 1D);
                case SOUTH:
                    return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 0.625D);
                case WEST:
                    return new AxisAlignedBB(0.375D, 0D, 0D, 1D, 1D, 1D);
                default:
                    return new AxisAlignedBB(0D, 0D, 0D, 0.625D, 1D, 1D);
            }
        } else return super.getBoundingBox(state, world, pos);
    }

    @Nonnull
    @Override
    public BlockState getActualState(@Nonnull BlockState state, IBlockAccess world, BlockPos pos) {
        BlockState ret = super.getActualState(state, world, pos);
        Direction northFacing = getFacing(NORTH, world, pos);
        Direction eastFacing = getFacing(EAST, world, pos);
        Direction southFacing = getFacing(SOUTH, world, pos);
        Direction westFacing = getFacing(WEST, world, pos);

        //Inner Corner
        if (northFacing == WEST && westFacing == NORTH)
            return state.withProperty(property, Cupboard.FULL_IC).withProperty(FACING, WEST);
        if (southFacing == WEST && westFacing == SOUTH)
            return state.withProperty(property, Cupboard.FULL_IC).withProperty(FACING, SOUTH);
        if (southFacing == EAST && eastFacing == SOUTH)
            return state.withProperty(property, Cupboard.FULL_IC).withProperty(FACING, EAST);
        if (northFacing == EAST && eastFacing == NORTH)
            return state.withProperty(property, Cupboard.FULL_IC).withProperty(FACING, NORTH);

        //Outer Corner
        if (northFacing == EAST && westFacing == SOUTH)
            return state.withProperty(property, Cupboard.FULL_OC).withProperty(FACING, EAST);
        if (southFacing == EAST && westFacing == NORTH)
            return state.withProperty(property, Cupboard.FULL_OC).withProperty(FACING, NORTH);
        if (southFacing == WEST && eastFacing == NORTH)
            return state.withProperty(property, Cupboard.FULL_OC).withProperty(FACING, WEST);
        if (northFacing == WEST && eastFacing == SOUTH)
            return state.withProperty(property, Cupboard.FULL_OC).withProperty(FACING, SOUTH);

        return ret;
    }

    private Direction getFacing(Direction facing, IBlockAccess world, BlockPos pos) {
        TileEntity tile = world.getTileEntity(pos.offset(facing));
        if (tile instanceof CupboardTileEntity) {
            return ((Rotatable) tile).getFacing();
        }

        return EnumFacing.DOWN;
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull BlockState state) {
        return new CupboardTileEntity();
    }

    public enum Cupboard implements IStringSerializable {
        FULL, FULL_IC, FULL_OC;

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ENGLISH);
        }
    }
}*/
