package uk.joshiejack.gastronomy.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.penguinlib.block.base.AbstractDoubleBlock;

public class FridgeBlock extends AbstractDoubleBlock {
    public FridgeBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).strength(2.5F).sound(SoundType.METAL));
    }
/*
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, BlockState state, BlockPos pos, Direction face) {
        return Objects.requireNonNull(((FridgeTileEntity) (isTop(state) ? world.getTileEntity(pos.below()) : world.getTileEntity(pos))))
                .getFacing() == face ? BlockFaceShape.CENTER : BlockFaceShape.SOLID;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand, Direction side, float hitX, float hitY, float hitZ) {
        if (isTop(state)) {
            ((FridgeTileEntity) Objects.requireNonNull(world.getTileEntity(pos.below()))).animatingTop = true;
            return super.onBlockActivated(world, pos.below(), world.getBlockState(pos.below()), player, hand, side, hitX, hitY, hitZ);
        } else {
            ((FridgeTileEntity) Objects.requireNonNull(world.getTileEntity(pos))).animatingBottom = true;
            return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
        }
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull BlockState state) {
        return new FridgeTileEntity();
    }

    @SuppressWarnings("ConstantConditions")
    @OnlyIn(Dist.CLIENT)
    @Override
    protected void registerModel(Item item, Storage storage) {
        ModelLoader.setCustomModelResourceLocation(item, storage.ordinal(), new ModelResourceLocation(getRegistryName(), "inventory_fridge"));
    }

    public enum Storage implements IStringSerializable {
        FRIDGE;

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ENGLISH);
        }
    } */
}
