package uk.joshiejack.gastronomy.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.EnumProperty;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.gastronomy.Gastronomy;

import javax.annotation.Nonnull;
import java.util.Locale;


public class GastronomyBlocks {
    public static final EnumProperty<Section> SECTION = EnumProperty.create("section", Section.class);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gastronomy.MODID);
    public static final RegistryObject<Block> MATSUTAKE_MUSHROOM = BLOCKS.register("matsutake_mushroom", MatsutakeMushroomBlock::new);
    public static final RegistryObject<Block> BAMBOO_SHOOTS = BLOCKS.register("bamboo_shoots", () -> new BushBlock(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MINT = BLOCKS.register("mint", () -> new BushBlock(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> CHAMOMILE = BLOCKS.register("chamomile", () -> new BushBlock(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender", () -> new BushBlock(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> FRIDGE = BLOCKS.register("fridge", FridgeBlock::new);
    public static final RegistryObject<Block> COUNTER = BLOCKS.register("counter", CounterBlock::new);
    public static final RegistryObject<Block> ISLAND = BLOCKS.register("island", CounterBlock::new);
    public static final RegistryObject<Block> CUPBOARD = BLOCKS.register("cupboard", CupboardBlock::new);
    public static final RegistryObject<Block> SINK = BLOCKS.register("sink", SinkBlock::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register("oven", OvenBlock::new);
    public static final RegistryObject<Block> MIXER = BLOCKS.register("mixer", MixerBlock::new);
    public static final RegistryObject<Block> POT = BLOCKS.register("pot", PotBlock::new);
    public static final RegistryObject<Block> FRYING_PAN = BLOCKS.register("frying_pan", FryingPanBlock::new);

    public enum Section implements IStringSerializable {
        STRAIGHT, INNER, OUTER;

        @Nonnull
        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
