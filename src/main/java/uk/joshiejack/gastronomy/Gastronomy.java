package uk.joshiejack.gastronomy;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;
import uk.joshiejack.gastronomy.crafting.GastronomyRegistries;
import uk.joshiejack.gastronomy.data.*;
import uk.joshiejack.gastronomy.fluid.GastronomyFluids;
import uk.joshiejack.gastronomy.inventory.CookbookContainer;
import uk.joshiejack.gastronomy.item.GastronomyItems;
import uk.joshiejack.gastronomy.tileentity.GastronomyTileEntities;
import uk.joshiejack.penguinlib.inventory.AbstractBookContainer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(Gastronomy.MODID)
public class Gastronomy {
    //public static final Set<Class<? extends TileEntity>> FOOD_STORAGE = Sets.newHashSet();
    public static final String MODID = "gastronomy";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup TAB = new ItemGroup(MODID) {
        @Nonnull
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(GastronomyItems.FRYING_PAN.get());
        }
    };
    
    public Gastronomy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        GastronomyBlocks.BLOCKS.register(eventBus);
        GastronomyContainers.CONTAINERS.register(eventBus);
        GastronomyItems.ITEMS.register(eventBus);
        GastronomyFluids.FLUIDS.register(eventBus);
        GastronomyRegistries.SERIALIZERS.register(eventBus);
        GastronomySounds.SOUNDS.register(eventBus);
        GastronomyTileEntities.TILE_ENTITIES.register(eventBus);
    }

    @SubscribeEvent
    public static void onDataGathering(final GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new GastronomyLootTables(generator));
            BlockTagsProvider blockTags = new GastronomyBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new GastronomyItemTags(generator, blockTags, event.getExistingFileHelper()));
            generator.addProvider(new GastronomyRecipes(generator));
            generator.addProvider(new GastronomyDatabase(generator));
        }

        if (event.includeClient()) {
            generator.addProvider(new GastronomyLanguage(generator));
            generator.addProvider(new GastronomyItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new GastronomyBlockStates(generator, event.getExistingFileHelper()));
        }
    }

    public static class GastronomyContainers {
        public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Gastronomy.MODID);
        public static final RegistryObject<ContainerType<AbstractBookContainer>> COOKBOOK = CONTAINERS.register("cookbook", () -> IForgeContainerType.create((id, inv, data) -> new CookbookContainer(id)));
    }
    /*
    

    @Mod.Instance(MODID)
    public static Gastronomy instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GastronomyAPI.instance = this;
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, instance);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GastronomyBlocks.init();
        GastronomyItems.init();
        if (GastronomyConfig.enableWorldGen) {
            GameRegistry.registerWorldGenerator(new NatureGenerator(), 0);
            FOOD_STORAGE.add(TileFridge.class);
            FOOD_STORAGE.add(TileCupboard.class);
        }
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        if (tile instanceof TileFridge) {
            return new FridgeContainer(player.inventory, (TileFridge) tile);
        } else if (tile instanceof TileCupboard) {
            return new CupboardContainer(player.inventory, (TileCupboard) tile);
        }

        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        if (tile instanceof TileFridge) {
            return new GuiFridge(new FridgeContainer(player.inventory, (TileFridge) tile));
        } else if (tile instanceof TileCupboard) {
            return new GuiCupboard(new CupboardContainer(player.inventory, (TileCupboard) tile));
        }

        return GuiCookbook.INSTANCE;
    }

    @Override
    public boolean hasRecipe(ItemStack stack) {
        for (HolderMeta holder: Recipe.RECIPE_BY_STACK.keySet()) {
            if (holder.matches(stack)) return true;
        }

        return false;
    } */
}
