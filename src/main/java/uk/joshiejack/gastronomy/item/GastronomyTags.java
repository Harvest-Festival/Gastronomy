package uk.joshiejack.gastronomy.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.penguinlib.util.PenguinTags;

public class GastronomyTags {
    public static final ITag.INamedTag<Item> KNIVES = PenguinTags.forgeItemTag("tools/knives");
    public static final ITag.INamedTag<Block> FRIDGES = PenguinTags.forgeBlockTag("fridges");
    public static final ITag.INamedTag<Block> HEAT_SOURCE = BlockTags.createOptional(new ResourceLocation(Gastronomy.MODID, "heat_source"));
}
