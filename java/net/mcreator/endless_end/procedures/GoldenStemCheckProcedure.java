package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GoldenStemCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_barrens")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_midlands"))) {
			if (Math.random() < 0.65) {
				GoldenShootProcedure.execute(world, x, y, z);
			} else {
				GrowLilGoldenStemProcedure.execute(world, x, y, z);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:inverted_barrens")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:inverted_midlands"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_orchard"))) {
			if (Math.random() < 0.5) {
				GoldenShootProcedure.execute(world, x, y, z);
			} else if (Math.random() < 0.5) {
				GrowGoldenStemProcedure.execute(world, x, y, z, 3);
			} else {
				GoldenShootProcedure.execute(world, x, y, z);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:inverted_orchard"))) {
			if (Math.random() < 0.5) {
				GoldenShootProcedure.execute(world, x, y, z);
			} else {
				GrowGoldenStemProcedure.execute(world, x, y, z, Mth.nextInt(RandomSource.create(), 1, 3));
			}
		}
	}
}
