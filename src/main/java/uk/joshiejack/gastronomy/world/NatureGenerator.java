package uk.joshiejack.gastronomy.world;

//public class NatureGenerator implements IWorldGenerator {
//    private static final List<WorldGenNature> GENERATORS = Lists.newArrayList(
//            new WorldGenNature(BlockNature.Nature.MINT, Biome.TempCategory.MEDIUM),
//            new WorldGenNature(BlockNature.Nature.CHAMOMILE, Biome.TempCategory.MEDIUM),
//            new WorldGenNature(BlockNature.Nature.LAVENDER, Biome.TempCategory.MEDIUM),
//            new WorldGenNature(BlockNature.Nature.MATSUTAKE, BiomeDictionary.Type.CONIFEROUS),
//            new WorldGenNature(BlockNature.Nature.BAMBOO, BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET));
//
//    @Nullable
//    private WorldGenNature getRandomValidGenerator(Biome biome) {
//        Collections.shuffle(GENERATORS);
//        for (WorldGenNature nature: GENERATORS) {
//            if (nature.isValidBiome(biome)) return nature;
//        }
//
//        return null;
//    }
//
//   @Override
//    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
//        BlockPos chunkPos = new BlockPos(chunkX, 0, chunkZ);
//        for (int l2 = 0; l2 < 2; ++l2) {
//            int i7 = random.nextInt(16) + 8;
//            int l10 = random.nextInt(16) + 8;
//            int j14 = world.getHeight(chunkPos.add(i7, 0, l10)).getY() + 32;
//
//            if (j14 > 0) {
//                int k17 = random.nextInt(j14);
//                BlockPos blockpos1 = chunkPos.add(i7, k17, l10);
//                WorldGenNature nature = getRandomValidGenerator(world.getBiome(blockpos1));
//                if (nature != null) {
//                    nature.generate(world, random, blockpos1);
//                }
//            }
//        }
//    }
//}
