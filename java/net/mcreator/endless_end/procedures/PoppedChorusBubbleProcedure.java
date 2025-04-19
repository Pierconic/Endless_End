package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class PoppedChorusBubbleProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double bubble_rad = 0;
		double core_rad = 0;
		double x_off = 0;
		double z_off = 0;
		double y_off = 0;
		if (world.getBlockState(BlockPos.containing(x, y - 2, z)).isFaceSturdy(world, BlockPos.containing(x, y - 2, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x + 3, y - 2, z)).isFaceSturdy(world, BlockPos.containing(x + 3, y - 2, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x - 3, y - 2, z)).isFaceSturdy(world, BlockPos.containing(x - 3, y - 2, z), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y - 2, z - 3)).isFaceSturdy(world, BlockPos.containing(x, y - 2, z - 3), Direction.UP)
				&& world.getBlockState(BlockPos.containing(x, y - 2, z + 3)).isFaceSturdy(world, BlockPos.containing(x, y - 2, z + 3), Direction.UP)
				&& world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:chorus_orchard"))) {
			bubble_rad = Mth.nextInt(RandomSource.create(), 4, 8);
			ChorusShellProcedure.execute(world, x, y, z, bubble_rad, 1, 1, 1);
			core_rad = bubble_rad - 1;
			for (int index0 = 0; index0 < (int) bubble_rad; index0++) {
				ChorusCoreProcedure.execute(world, x, y, z, core_rad, 1, 1, 1);
				core_rad = core_rad - 1;
			}
			core_rad = bubble_rad - 1;
			x_off = Mth.nextInt(RandomSource.create(), -2, 2);
			z_off = Mth.nextInt(RandomSource.create(), -2, 2);
			y_off = Mth.nextInt(RandomSource.create(), -1, 1);
			for (int index1 = 0; index1 < (int) bubble_rad; index1++) {
				AirBubbleProcedure.execute(world, x + x_off, y + bubble_rad + y_off, z + z_off, core_rad, 1, 1, 1);
				core_rad = core_rad - 1;
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(13 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ItemEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
			return true;
		}
		return false;
	}
}
