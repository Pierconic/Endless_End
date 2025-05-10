package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class OdorBoxCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.ODOR) ? _livEnt.getEffect(EndlessEndModMobEffects.ODOR).getDuration() : 0) % 40 == 0) {
			sx = -9;
			found = false;
			for (int index0 = 0; index0 < 19; index0++) {
				sy = -3;
				for (int index1 = 0; index1 < 19; index1++) {
					sz = -9;
					for (int index2 = 0; index2 < 19; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == EndlessEndModBlocks.WEAVER_NEST.get()) {
							if (Math.random() < 0.2) {
								WeaverEmergeNonRecProcedure.execute(world, x + sx, y + sy, z + sz, world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)));
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
