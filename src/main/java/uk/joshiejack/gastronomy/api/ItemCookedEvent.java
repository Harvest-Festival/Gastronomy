package uk.joshiejack.gastronomy.api;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import uk.joshiejack.gastronomy.cooking.Appliance;

public class ItemCookedEvent extends PlayerEvent {
    private final ItemStack result;
    private final Appliance appliance;

    public ItemCookedEvent(PlayerEntity player, ItemStack result, Appliance appliance) {
        super(player);
        this.result = result;
        this.appliance = appliance;
    }

    public ItemStack getStack() {
        return result;
    }

    public Appliance getAppliance() {
        return appliance;
    }
}
