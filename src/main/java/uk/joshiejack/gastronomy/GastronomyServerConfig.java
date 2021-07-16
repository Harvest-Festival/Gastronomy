package uk.joshiejack.gastronomy;

import net.minecraftforge.common.ForgeConfigSpec;

public class GastronomyServerConfig {
    public static ForgeConfigSpec.BooleanValue requireDishesToRemoveMeals;

    GastronomyServerConfig(ForgeConfigSpec.Builder builder) {
        requireDishesToRemoveMeals = builder.define("Require dishes to remove meals", true);
    }

    public static ForgeConfigSpec create() {
        return new ForgeConfigSpec.Builder().configure(GastronomyServerConfig::new).getValue();
    }
}
