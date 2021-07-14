package uk.joshiejack.gastronomy.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;

@SuppressWarnings("ConstantConditions")
public class GastronomyTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Gastronomy.MODID);
    public static final RegistryObject<TileEntityType<CupboardTileEntity>> CUPBOARD = TILE_ENTITIES.register("cupboard", () -> TileEntityType.Builder.of(CupboardTileEntity::new, GastronomyBlocks.CUPBOARD.get()).build(null));
    public static final RegistryObject<TileEntityType<FridgeTileEntity>> FRIDGE = TILE_ENTITIES.register("fridge", () -> TileEntityType.Builder.of(FridgeTileEntity::new, GastronomyBlocks.FRIDGE.get()).build(null));
    public static final RegistryObject<TileEntityType<CounterTileEntity>> COUNTER = TILE_ENTITIES.register("counter", () -> TileEntityType.Builder.of(CounterTileEntity::new, GastronomyBlocks.COUNTER.get(), GastronomyBlocks.ISLAND.get()).build(null));
    public static final RegistryObject<TileEntityType<SinkTileEntity>> SINK = TILE_ENTITIES.register("sink", () -> TileEntityType.Builder.of(SinkTileEntity::new, GastronomyBlocks.SINK.get()).build(null));
    public static final RegistryObject<TileEntityType<FryingPanTileEntity>> FRYING_PAN = TILE_ENTITIES.register("frying_pan", () -> TileEntityType.Builder.of(FryingPanTileEntity::new, GastronomyBlocks.FRYING_PAN.get()).build(null));
    public static final RegistryObject<TileEntityType<MixerTileEntity>> MIXER = TILE_ENTITIES.register("mixer", () -> TileEntityType.Builder.of(MixerTileEntity::new, GastronomyBlocks.MIXER.get()).build(null));
    public static final RegistryObject<TileEntityType<PotTileEntity>> POT = TILE_ENTITIES.register("pot", () -> TileEntityType.Builder.of(PotTileEntity::new, GastronomyBlocks.POT.get()).build(null));
    public static final RegistryObject<TileEntityType<OvenTileEntity>> OVEN = TILE_ENTITIES.register("oven", () -> TileEntityType.Builder.of(OvenTileEntity::new, GastronomyBlocks.OVEN.get()).build(null));
}
