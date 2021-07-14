package uk.joshiejack.gastronomy.data;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.FridgeBlock;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;
import uk.joshiejack.gastronomy.block.OvenBlock;
import uk.joshiejack.gastronomy.block.SectionalBlock;

public class GastronomyBlockStates extends BlockStateProvider {
    public GastronomyBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Gastronomy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        crossBlock(GastronomyBlocks.BAMBOO_SHOOTS);
        crossBlock(GastronomyBlocks.CHAMOMILE);
        crossBlock(GastronomyBlocks.LAVENDER);
        crossBlock(GastronomyBlocks.MINT);
        crossBlock(GastronomyBlocks.MATSUTAKE_MUSHROOM);
        rotationalBlock(GastronomyBlocks.FRYING_PAN);
        rotationalBlock(GastronomyBlocks.MIXER);
        rotationalBlock(GastronomyBlocks.POT);
        rotationalBlock(GastronomyBlocks.SINK);
        fridgeModel();
        ovenModel();
        sectionalModel(GastronomyBlocks.COUNTER);
        sectionalModel(GastronomyBlocks.ISLAND);
        sectionalModel(GastronomyBlocks.CUPBOARD);
    }

    private void sectionalModel(RegistryObject<Block> block) {
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());
        for (SectionalBlock.Section section: SectionalBlock.Section.values()) {
            ModelFile model = models().getExistingFile(new ResourceLocation(Gastronomy.MODID, block.get().getRegistryName().getPath() + "_" + section.getSerializedName()));
            builder.partialState().with(SectionalBlock.SECTION, section).with(SectionalBlock.FACING, Direction.WEST).modelForState().modelFile(model).rotationY(270).addModel();
            builder.partialState().with(SectionalBlock.SECTION, section).with(SectionalBlock.FACING, Direction.EAST).modelForState().modelFile(model).rotationY(90).addModel();
            builder.partialState().with(SectionalBlock.SECTION, section).with(SectionalBlock.FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(180).addModel();
            builder.partialState().with(SectionalBlock.SECTION, section).with(SectionalBlock.FACING, Direction.NORTH).modelForState().modelFile(model).rotationY(0).addModel();
        }
    }

    private void ovenModel() {
        ModelFile off = models().getExistingFile(new ResourceLocation(Gastronomy.MODID, "oven_off"));
        ModelFile on = models().getExistingFile(new ResourceLocation(Gastronomy.MODID, "oven_on"));

        VariantBlockStateBuilder builder = getVariantBuilder(GastronomyBlocks.OVEN.get());
        builder.partialState().with(OvenBlock.LIT, false).with(OvenBlock.FACING, Direction.WEST).modelForState().modelFile(off).rotationY(270).addModel();
        builder.partialState().with(OvenBlock.LIT, false).with(OvenBlock.FACING, Direction.EAST).modelForState().modelFile(off).rotationY(90).addModel();
        builder.partialState().with(OvenBlock.LIT, false).with(OvenBlock.FACING, Direction.SOUTH).modelForState().modelFile(off).rotationY(180).addModel();
        builder.partialState().with(OvenBlock.LIT, false).with(OvenBlock.FACING, Direction.NORTH).modelForState().modelFile(off).rotationY(0).addModel();
        builder.partialState().with(OvenBlock.LIT, true).with(OvenBlock.FACING, Direction.WEST).modelForState().modelFile(on).rotationY(270).addModel();
        builder.partialState().with(OvenBlock.LIT, true).with(OvenBlock.FACING, Direction.EAST).modelForState().modelFile(on).rotationY(90).addModel();
        builder.partialState().with(OvenBlock.LIT, true).with(OvenBlock.FACING, Direction.SOUTH).modelForState().modelFile(on).rotationY(180).addModel();
        builder.partialState().with(OvenBlock.LIT, true).with(OvenBlock.FACING, Direction.NORTH).modelForState().modelFile(on).rotationY(0).addModel();
    }

    private void fridgeModel() {
        ModelFile upper = models().getExistingFile(new ResourceLocation(Gastronomy.MODID, "fridge_upper"));
        ModelFile lower = models().getExistingFile(new ResourceLocation(Gastronomy.MODID, "fridge_lower"));
        VariantBlockStateBuilder builder = getVariantBuilder(GastronomyBlocks.FRIDGE.get());
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.UPPER).with(FridgeBlock.FACING, Direction.WEST).modelForState().modelFile(upper).rotationY(90).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.UPPER).with(FridgeBlock.FACING, Direction.EAST).modelForState().modelFile(upper).rotationY(270).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.UPPER).with(FridgeBlock.FACING, Direction.SOUTH).modelForState().modelFile(upper).rotationY(0).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.UPPER).with(FridgeBlock.FACING, Direction.NORTH).modelForState().modelFile(upper).rotationY(180).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.LOWER).with(FridgeBlock.FACING, Direction.WEST).modelForState().modelFile(lower).rotationY(90).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.LOWER).with(FridgeBlock.FACING, Direction.EAST).modelForState().modelFile(lower).rotationY(270).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.LOWER).with(FridgeBlock.FACING, Direction.SOUTH).modelForState().modelFile(lower).rotationY(0).addModel();
        builder.partialState().with(FridgeBlock.HALF, DoubleBlockHalf.LOWER).with(FridgeBlock.FACING, Direction.NORTH).modelForState().modelFile(lower).rotationY(180).addModel();
    }

    private void rotationalBlock(RegistryObject<Block> block) {
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());
        ModelFile model = models().getExistingFile(block.get().getRegistryName());
        builder.partialState().with(HorizontalBlock.FACING, Direction.WEST).modelForState().modelFile(model).rotationY(270).addModel();
        builder.partialState().with(HorizontalBlock.FACING, Direction.EAST).modelForState().modelFile(model).rotationY(90).addModel();
        builder.partialState().with(HorizontalBlock.FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(180).addModel();
        builder.partialState().with(HorizontalBlock.FACING, Direction.NORTH).modelForState().modelFile(model).rotationY(0).addModel();
    }

    private void crossBlock(RegistryObject<Block> block) {
        simpleBlock(block.get(), models().crop(block.get().getRegistryName().toString(), new ResourceLocation("gastronomy", "block/nature/" + block.get().getRegistryName().getPath())));
    }
}
