package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FlurryRodRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean success = false;
		double xAxis = 0;
		double yAxis = 0;
		double zAxis = 0;
		double Offset = 0;
		double localRad = 0;
		double initRad = 0;
		double counter2 = 0;
		double z2 = 0;
		double max_height = 0;
		double extraLocalRad = 0;
		double x2 = 0;
		double yOff = 0;
		double bubble_rad = 0;
		double core_rad = 0;
		double counter = 0;
		double repRad = 0;
		if (entity.isShiftKeyDown()) {
			bubble_rad = Mth.nextInt(RandomSource.create(), 8, 10);
			yOff = bubble_rad * (-0.5);
			for (int index0 = 0; index0 < (int) bubble_rad; index0++) {
				DelayedCrystalProcedure.execute(world, x + 1, y + yOff, z, 3);
				DelayedCrystalProcedure.execute(world, x - 1, y + yOff, z, 3);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z + 1, 3);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z - 1, 3);
				yOff = 1 + yOff;
			}
			bubble_rad = bubble_rad - 2;
			yOff = bubble_rad * (-0.5);
			for (int index1 = 0; index1 < (int) bubble_rad; index1++) {
				DelayedCrystalProcedure.execute(world, x + 1, y + yOff, z + 1, 6);
				DelayedCrystalProcedure.execute(world, x - 1, y + yOff, z - 1, 6);
				DelayedCrystalProcedure.execute(world, x + 1, y + yOff, z - 1, 6);
				DelayedCrystalProcedure.execute(world, x - 1, y + yOff, z + 1, 6);
				yOff = 1 + yOff;
			}
			bubble_rad = bubble_rad - 2;
			yOff = bubble_rad * (-0.5);
			for (int index2 = 0; index2 < (int) bubble_rad; index2++) {
				DelayedCrystalProcedure.execute(world, x + 2, y + yOff, z, 9);
				DelayedCrystalProcedure.execute(world, x - 2, y + yOff, z, 9);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z + 2, 9);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z - 2, 9);
				yOff = 1 + yOff;
			}
		} else {
			if (entity.getLookAngle().y > 0.9) {
				for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 9, 13); index3++) {
					DelayedPillarCrystalProcedure.execute(world, x + Offset * xAxis, (y + yOff) - 1, z + Offset * zAxis, entity, yOff * 2);
					yOff = yOff + 1;
				}
			} else if (entity.getLookAngle().y < -0.9) {
				localRad = Mth.nextInt(RandomSource.create(), 3, 5);
				extraLocalRad = localRad;
				for (int index4 = 0; index4 < (int) localRad; index4++) {
					counter2 = 0;
					while (counter2 <= 360) {
						x2 = 1 * extraLocalRad * Math.cos(counter2);
						z2 = 1 * extraLocalRad * Math.sin(counter2);
						DelayedCrystalProcedure.execute(world, x + x2 + 0.5, (y + entity.getDeltaMovement().y() * 2) - 1, z + z2 + 0.5, extraLocalRad * 2);
						success = true;
						counter2 = counter2 + 1;
					}
					extraLocalRad = extraLocalRad - 1;
				}
			} else {
				if ((entity.getDirection()) == Direction.NORTH) {
					zAxis = -1;
				} else if ((entity.getDirection()) == Direction.SOUTH) {
					zAxis = 1;
				} else if ((entity.getDirection()) == Direction.WEST) {
					xAxis = -1;
				} else {
					xAxis = 1;
				}
				Offset = 1;
				for (int index6 = 0; index6 < 13; index6++) {
					if (world.isEmptyBlock(BlockPos.containing(x + Offset * xAxis, y + Offset * yAxis, z + Offset * zAxis))
							|| (world.getBlockState(BlockPos.containing(x + Offset * xAxis, y + Offset * yAxis, z + Offset * zAxis))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_breakable")))) {
						DelayedCrystalProcedure.execute(world, x + Offset * xAxis, y - 1, z + Offset * zAxis, Offset * 2);
						success = true;
					}
					Offset = Offset + 1;
				}
			}
		}
		if (success && !(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			itemstack.shrink(1);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 18, 1, 1, 1, 0.1);
	}
}
