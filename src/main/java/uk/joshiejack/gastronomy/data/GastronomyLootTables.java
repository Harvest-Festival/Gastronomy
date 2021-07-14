package uk.joshiejack.gastronomy.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.gastronomy.Gastronomy;
import uk.joshiejack.gastronomy.block.GastronomyBlocks;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GastronomyLootTables extends LootTableProvider {
    public GastronomyLootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationTracker validationtracker) {
        map.forEach((name, table) -> LootTableManager.validate(validationtracker, name, table));
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(Pair.of(Blocks::new, LootParameterSets.BLOCK), Pair.of(Chests::new, LootParameterSets.FISHING));
    }

    public static class Blocks extends BlockLootTables {
        @Nonnull
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream()
                    .filter((block) -> Gastronomy.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
                    .collect(Collectors.toList());
        }

        @Override
        protected void addTables() {
            GastronomyBlocks.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .forEach(this::dropSelf);
        }
    }

    public static class Chests extends ChestLootTables {
        @Override
        public void accept(@Nonnull BiConsumer<ResourceLocation, LootTable.Builder> builder) {

        }
    }
}
