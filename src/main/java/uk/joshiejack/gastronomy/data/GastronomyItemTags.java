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

import static net.minecraftforge.common.Tags.Items.CROPS_CARROT;
import static net.minecraftforge.common.Tags.Items.CROPS_POTATO;

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
    public static final ITag.INamedTag<Item> GREEN_PEPPER = PenguinTags.forgeItemTag("crops/green_pepper");
    public static final ITag.INamedTag<Item> SPINACH = PenguinTags.forgeItemTag("crops/spinach");
    public static final ITag.INamedTag<Item> SALT = PenguinTags.forgeItemTag("salt");
    public static final ITag.INamedTag<Item> CURRY_POWDER = PenguinTags.forgeItemTag("curry_powder");
    public static final ITag.INamedTag<Item> TOMATO = PenguinTags.forgeItemTag("crops/tomato");
    public static final ITag.INamedTag<Item> NOODLES = PenguinTags.forgeItemTag("noodles");
    public static final ITag.INamedTag<Item> TEMPURA = PenguinTags.forgeItemTag("tempura");
    public static final ITag.INamedTag<Item> BAKED_POTATO = PenguinTags.forgeItemTag("baked_potato");
    public static final ITag.INamedTag<Item> COOKED_RABBIT = PenguinTags.forgeItemTag("cooked_rabbit");
    public static final ITag.INamedTag<Item> BROWN_MUSHROOMS = PenguinTags.forgeItemTag("mushrooms/brown");
    public static final ITag.INamedTag<Item> RED_MUSHROOMS = PenguinTags.forgeItemTag("mushrooms/red");
    public static final ITag.INamedTag<Item> HERBS = PenguinTags.forgeItemTag("herbs");
    public static final ITag.INamedTag<Item> MINT = PenguinTags.forgeItemTag("herbs/mint");
    public static final ITag.INamedTag<Item> LAVENDER = PenguinTags.forgeItemTag("herbs/lavender");
    public static final ITag.INamedTag<Item> CHAMOMILE = PenguinTags.forgeItemTag("herbs/chamomile");
    public static final ITag.INamedTag<Item> STEW_VEGETABLE = ItemTags.createOptional(new ResourceLocation(Gastronomy.MODID, "stew_vegetable"));
    public static final ITag.INamedTag<Item> COCOA_BEANS = PenguinTags.forgeItemTag("crops/cocoa_beans");
    public static final ITag.INamedTag<Item> BAMBOO_SHOOTS = PenguinTags.forgeItemTag("bamboo_shoots");


    public GastronomyItemTags(DataGenerator generator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagProvider, Gastronomy.MODID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTags() {
        tag(FLOUR).add(GastronomyItems.FLOUR.get());
        tag(NOODLES).add(GastronomyItems.NOODLES.get());
        tag(TEMPURA).add(GastronomyItems.TEMPURA.get());
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
        tag(BAKED_POTATO).add(Items.BAKED_POTATO);
        tag(COOKED_RABBIT).add(Items.COOKED_RABBIT);
        tag(BROWN_MUSHROOMS).add(Items.BROWN_MUSHROOM).add(GastronomyItems.MATSUTAKE_MUSHROOM.get());
        tag(RED_MUSHROOMS).add(Items.RED_MUSHROOM);
        tag(HERBS).addTags(CHAMOMILE).addTags(LAVENDER).addTags(MINT);
        tag(CHAMOMILE).add(GastronomyItems.CHAMOMILE.get());
        tag(LAVENDER).add(GastronomyItems.LAVENDER.get());
        tag(MINT).add(GastronomyItems.MINT.get());
        tag(STEW_VEGETABLE).addTags(CROPS_POTATO, CROPS_CARROT).addOptionalTag(GREEN_PEPPER.getName()).addOptionalTag(ONION.getName()).addOptionalTag(EGGPLANT.getName());
        tag(COCOA_BEANS).add(Items.COCOA_BEANS);
        tag(BAMBOO_SHOOTS).add(GastronomyItems.BAMBOO_SHOOTS.get());
    }

    private static ResourceLocation optional(String name) {
        return new ResourceLocation("forge", name);
    }
}
