package uk.joshiejack.gastronomy.plugins;

/*@Mod.EventBusSubscriber(modid = Gastronomy.MODID)
public class CookingScripting {
    @SubscribeEvent
    public static void onCollectScriptingFunctions(CollectScriptingFunctions event) {
        event.registerVar("cooking", CookingScripting.class);
    }

    @SubscribeEvent
    public static void onCollectScriptingMethods(CollectScriptingMethods event) {
        event.add("onItemCooked");
    }

    @SubscribeEvent
    public static void onCooked(ItemCookedEvent event) {
        if (event.getEntityPlayer().world.isClientSide) return;
            MinecraftForge.EVENT_BUS.post(new ScriptingTriggerFired("onItemCooked", event.getEntityPlayer(), event.getAppliance().getName(), event.getStack()));
    }

    public static boolean hasRecipe(ItemStackJS wrapper) {
        return GastronomyAPI.instance.hasRecipe(wrapper.penguinScriptingObject);
    }
} */
