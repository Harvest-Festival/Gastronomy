package uk.joshiejack.gastronomy.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Gastronomy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GastronomyClient {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

    }

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> GastronomyBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .forEach(block -> RenderTypeLookup.setRenderLayer(block, RenderType.cutout())));
    }
}
