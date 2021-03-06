package uk.joshiejack.gastronomy.client;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;
import uk.joshiejack.gastronomy.client.renderer.*;
import uk.joshiejack.gastronomy.tileentity.GastronomyTileEntities;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Gastronomy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GastronomyClient {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ClientRegistry.bindTileEntityRenderer(GastronomyTileEntities.OVEN.get(), OvenTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(GastronomyTileEntities.POT.get(), PotTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(GastronomyTileEntities.FRYING_PAN.get(), FryingPanTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(GastronomyTileEntities.MIXER.get(), MixerTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(GastronomyTileEntities.COUNTER.get(), CounterTileEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (event.getMap().location().equals(AtlasTexture.LOCATION_BLOCKS)) {
            event.addSprite(OvenTileEntityRenderer.OVEN_DOOR.texture());
            event.addSprite(MixerTileEntityRenderer.MIXER_BLADE.texture());
        }
    }

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(() -> GastronomyBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(block -> block != GastronomyBlocks.MIXER.get())
                .forEach(block -> RenderTypeLookup.setRenderLayer(block, RenderType.cutout())));
        event.enqueueWork(() -> RenderTypeLookup.setRenderLayer(GastronomyBlocks.MIXER.get(), RenderType.translucent()));
    }
}
