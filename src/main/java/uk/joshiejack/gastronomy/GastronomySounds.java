package uk.joshiejack.gastronomy;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class GastronomySounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Gastronomy.MODID);
    public static final RegistryObject<SoundEvent> COUNTER = createSoundEvent("count");
    public static final RegistryObject<SoundEvent> FRIDGE = createSoundEvent("fridge");
    public static final RegistryObject<SoundEvent> FRYING_PAN = createSoundEvent("frying_pan");
    public static final RegistryObject<SoundEvent> MIXER = createSoundEvent("mixer");
    public static final RegistryObject<SoundEvent> OVEN = createSoundEvent("oven");
    public static final RegistryObject<SoundEvent> OVEN_DONE = createSoundEvent("oven_done");
    public static final RegistryObject<SoundEvent> OVEN_DOOR = createSoundEvent("oven_door");
    public static final RegistryObject<SoundEvent> POT = createSoundEvent("pot");
    public static final RegistryObject<SoundEvent> RECIPE = createSoundEvent("recipe");

    private static RegistryObject<SoundEvent> createSoundEvent(@Nonnull String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(Gastronomy.MODID, name)));
    }
}