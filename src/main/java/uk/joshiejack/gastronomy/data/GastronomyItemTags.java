package uk.joshiejack.gastronomy.data;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.item.GastronomyItems;
import uk.joshiejack.gastronomy.item.GastronomyTags;
import uk.joshiejack.penguinlib.util.PenguinTags;

import javax.annotation.Nullable;

import static uk.joshiejack.penguinlib.util.PenguinTags.RAW_FISHES;

public class GastronomyItemTags extends ItemTagsProvider {
    public static final ITag.INamedTag<Item> CHOCOLATE = PenguinTags.forgeTag("chocolate");
    public static final ITag.INamedTag<Item> FLOUR = PenguinTags.forgeTag("flour");
    public static final ITag.INamedTag<Item> SUGAR = PenguinTags.forgeTag("sugar");
    public static final ITag.INamedTag<Item> BREAD = PenguinTags.forgeTag("bread");
    public static final ITag.INamedTag<Item> RAW_CHICKEN = PenguinTags.forgeTag("raw_chicken");
    public static final ITag.INamedTag<Item> RAW_BEEF = PenguinTags.forgeTag("raw_beef");
    public static final ITag.INamedTag<Item> RAW_PORK = PenguinTags.forgeTag("raw_pork");
    public static final ITag.INamedTag<Item> RAW_MUTTON = PenguinTags.forgeTag("raw_mutton");
    public static final ITag.INamedTag<Item> RAW_RABBIT = PenguinTags.forgeTag("raw_rabbit");
    public static final ITag.INamedTag<Item> RAW_COD = PenguinTags.forgeTag("raw_fishes/cod");
    public static final ITag.INamedTag<Item> RAW_SALMON = PenguinTags.forgeTag("raw_fishes/salmon");
    public static final ITag.INamedTag<Item> CHORUS_FRUIT = PenguinTags.forgeTag("chorus_fruit");
    public static final ITag.INamedTag<Item> BUTTER = PenguinTags.forgeTag("butter");
    public static final ITag.INamedTag<Item> FRUIT_CAKE_FRUIT = ItemTags.createOptional(new ResourceLocation(Gastronomy.MODID, "fruit_cake_fruit"));
    public static final ITag.INamedTag<Item> ONION = PenguinTags.forgeTag("crops/onion");
    public static final ITag.INamedTag<Item> RICEBALL = PenguinTags.forgeTag("riceball");
    public static final ITag.INamedTag<Item> SWEET_POTATO = PenguinTags.forgeTag("crops/sweet_potato");
    public static final ITag.INamedTag<Item> CORN = PenguinTags.forgeTag("crops/corn");

    public GastronomyItemTags(DataGenerator generator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagProvider, Gastronomy.MODID, existingFileHelper);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags() {
        tag(FLOUR).add(GastronomyItems.FLOUR.get());
        tag(PenguinTags.forgeTag("curry_powder")).add(GastronomyItems.CURRY_POWDER.get());
        tag(CHOCOLATE).add(GastronomyItems.CHOCOLATE.get());
        tag(SUGAR).add(Items.SUGAR);
        //tag(BREAD).addTags(PenguinTags.BREADS);
        tag(RAW_COD).add(Items.COD);
        tag(RAW_SALMON).add(Items.SALMON);
        tag(RAW_BEEF).add(Items.BEEF);
        tag(RAW_PORK).add(Items.PORKCHOP);
        tag(RAW_MUTTON).add(Items.MUTTON);
        tag(RAW_RABBIT).add(Items.RABBIT);
        tag(RAW_FISHES).addTags(RAW_COD).addTags(RAW_SALMON);
        tag(CHORUS_FRUIT).add(Items.CHORUS_FRUIT);
        tag(BUTTER).addOptional(new ResourceLocation("husbandry", "butter"));
        tag(FRUIT_CAKE_FRUIT).addOptionalTag(optional("crops/orange")).addOptionalTag(optional("crops/pineapple")).addOptionalTag(optional("crops/strawberry"))
                .addOptionalTag(optional("crops/peach")).addOptionalTag(optional("crops/grape"));
        tag(RICEBALL).add(GastronomyItems.RICEBALL.get());
        tag(GastronomyTags.KNIFE).add(GastronomyItems.KNIFE.get());
    }

    private static ResourceLocation optional(String name) {
        return new ResourceLocation("forge", name);
    }
}
