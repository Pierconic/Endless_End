package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ChorusStemCheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_orchard")) || Math.random() < 0.65) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_orchard"))) {
				GrowSmallVioletProcedure.execute(world, x, y, z, 2, 12, 2);
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_midlands")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_barrens"))) {
				GrowSmallVioletProcedure.execute(world, x, y, z, Mth.nextInt(RandomSource.create(), 0, 2), 9, 3);
			} else {
				VioletShootProcedure.execute(world, x, y, z);
			}
			AzureDownrootProcedure.execute(world, x, y - 1, z);
			SideWinderPlacementProcedure.execute(world, x + Mth.nextInt(RandomSource.create(), -2, 2), y - Mth.nextInt(RandomSource.create(), 4, 10), z + Mth.nextInt(RandomSource.create(), -2, 2));
			SideWinderPlacementProcedure.execute(world, x + Mth.nextInt(RandomSource.create(), -4, 4), y - Mth.nextInt(RandomSource.create(), 14, 32), z + Mth.nextInt(RandomSource.create(), -4, 4));
			return true;
		}
		return false;
	}
}
