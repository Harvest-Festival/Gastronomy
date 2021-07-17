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

public class GastronomyItemTags extends ItemTagsProvider {
    public static final ITag.INamedTag<Item> CHOCOLATE = PenguinTags.forgeItemTag("chocolate");
    public static final ITag.INamedTag<Item> FLOUR = PenguinTags.forgeItemTag("flour");
    public static final ITag.INamedTag<Item> SUGAR = PenguinTags.forgeItemTag("sugar");
    public static final ITag.INamedTag<Item> RAW_CHICKEN = PenguinTags.forgeItemTag("raw_chicken");
    public static final ITag.INamedTag<Item> RAW_BEEF = PenguinTags.forgeItemTag("raw_beef");
    public static final ITag.INamedTag<Item> RAW_PORK = PenguinTags.forgeItemTag("raw_pork");
    public static final ITag.INamedTag<Item> RAW_MUTTON = PenguinTags.forgeItemTag("raw_mutton");
    public static final ITag.INamedTag<Item> RAW_RABBIT = PenguinTags.forgeItemTag("raw_rabbit");
    public static final ITag.INamedTag<Item> RAW_COD = PenguinTags.forgeItemTag("raw_fishes/cod");
    public static final ITag.INamedTag<Item> RAW_SALMON = PenguinTags.forgeItemTag("raw_fishes/salmon");
    public static final ITag.INamedTag<Item> CHORUS_FRUIT = PenguinTags.forgeItemTag("chorus_fruit");
    public static final ITag.INamedTag<Item> BUTTER = PenguinTags.forgeItemTag("butter");
    public static final ITag.INamedTag<Item> FRUIT_CAKE_FRUIT = ItemTags.createOptional(new ResourceLocation(Gastronomy.MODID, "fruit_cake_fruit"));
    public static final ITag.INamedTag<Item> ONION = PenguinTags.forgeItemTag("crops/onion");
    public static final ITag.INamedTag<Item> RICEBALL = PenguinTags.forgeItemTag("riceball");
    public static final ITag.INamedTag<Item> SWEET_POTATO = PenguinTags.forgeItemTag("crops/sweet_potato");
    public static final ITag.INamedTag<Item> CORN = PenguinTags.forgeItemTag("crops/corn");
    public static final ITag.INamedTag<Item> KELP = PenguinTags.forgeItemTag("kelp");
    public static final ITag.INamedTag<Item> CABBAGE = PenguinTags.forgeItemTag("crops/cabbage");
    public static final ITag.INamedTag<Item> EGGPLANT = PenguinTags.forgeItemTag("crops/eggplant");
    public static final ITag.INamedTag<Item> SALT = PenguinTags.forgeItemTag("salt");
    public static final ITag.INamedTag<Item> CURRY_POWDER = PenguinTags.forgeItemTag("curry_powder");
    public static final ITag.INamedTag<Item> TOMATO = PenguinTags.forgeItemTag("crops/tomato");
    public static final ITag.INamedTag<Item> NOODLES = PenguinTags.forgeItemTag("noodles");

    public GastronomyItemTags(DataGenerator generator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagProvider, Gastronomy.MODID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags() {
        tag(FLOUR).add(GastronomyItems.FLOUR.get());
        tag(NOODLES).add(GastronomyItems.NOODLES.get());
        tag(CURRY_POWDER).add(GastronomyItems.CURRY_POWDER.get());
        tag(CHOCOLATE).add(GastronomyItems.CHOCOLATE.get());
        tag(SUGAR).add(Items.SUGAR);
        tag(SALT).add(GastronomyItems.SALT.get());
        tag(RAW_COD).add(Items.COD);
        tag(RAW_SALMON).add(Items.SALMON);
        tag(RAW_BEEF).add(Items.BEEF);
        tag(RAW_PORK).add(Items.PORKCHOP);
        tag(RAW_MUTTON).add(Items.MUTTON);
        tag(RAW_RABBIT).add(Items.RABBIT);
        tag(CHORUS_FRUIT).add(Items.CHORUS_FRUIT);
        tag(BUTTER).addOptional(new ResourceLocation("husbandry", "butter"));
        tag(FRUIT_CAKE_FRUIT).addOptionalTag(optional("crops/orange")).addOptionalTag(optional("crops/pineapple")).addOptionalTag(optional("crops/strawberry"))
                .addOptionalTag(optional("crops/peach")).addOptionalTag(optional("crops/grape"));
        tag(RICEBALL).add(GastronomyItems.RICEBALL.get());
        tag(KELP).add(Items.KELP);
        tag(GastronomyTags.KNIVES).add(GastronomyItems.KNIFE.get());
    }

    private static ResourceLocation optional(String name) {
        return new ResourceLocation("forge", name);
    }
}
