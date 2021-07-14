package uk.joshiejack.gastronomy.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.function.Supplier;

public class SectionalBlock extends AbstractRotatableBlock {
    public static final EnumProperty<Section> SECTION = EnumProperty.create("section", Section.class);
    private final Supplier<TileEntity> tileEntitySupplier;

    public SectionalBlock(Supplier<TileEntity> tileEntitySupplier) {
        super(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(1.5F).sound(SoundType.WOOD));
        this.tileEntitySupplier = tileEntitySupplier;
        setHasInventory();
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SECTION, Section.STRAIGHT));
    }

    @Nonnull
    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return tileEntitySupplier.get();
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateContainer.Builder<Block, BlockState> stateContainerBuilder) {
        stateContainerBuilder.add(FACING, SECTION);
    }

    public enum Section implements IStringSerializable {
        STRAIGHT, INNER, OUTER;

        @Nonnull
        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
