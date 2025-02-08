package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class CorruptionSpreadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double chance_modifier = 0;
		double time_modifier = 0;
		boolean found = false;
		boolean teeth = false;
		boolean ward_eyes = false;
		boolean evil_eyes = false;
		boolean spires = false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 38400) {
			chance_modifier = 3.5;
			time_modifier = 3;
			spires = true;
			evil_eyes = true;
			teeth = true;
			ward_eyes = true;
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 28800) {
			chance_modifier = 2.3;
			time_modifier = 3;
			evil_eyes = true;
			teeth = true;
			ward_eyes = true;
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 19200) {
			chance_modifier = 1.6;
			time_modifier = 2;
			teeth = true;
			ward_eyes = true;
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 8400) {
			chance_modifier = 1;
			time_modifier = 1;
			ward_eyes = true;
		}
		if (Math.random() < 0.05) {
			sx = -5;
			for (int index0 = 0; index0 < 11; index0++) {
				sy = -5;
				for (int index1 = 0; index1 < 11; index1++) {
					sz = -5;
					for (int index2 = 0; index2 < 11; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.SCULK) {
							if (Math.random() < 0.0012 * chance_modifier) {
								if (evil_eyes) {
									if (Math.random() < 0.2) {
										GenerateEvilEyesProcedure.execute(world, x + sx, y + sy, z + sz);
									} else if (Math.random() < 0.65) {
										GenerateBurrowingThornsProcedure.execute(world, x + sx, y + sy, z + sz);
									} else {
										GenerateWanderingEyesProcedure.execute(world, x + sx, y + sy, z + sz);
									}
								} else if (teeth) {
									if (Math.random() < 0.5) {
										GenerateBurrowingThornsProcedure.execute(world, x + sx, y + sy, z + sz);
									} else {
										GenerateWanderingEyesProcedure.execute(world, x + sx, y + sy, z + sz);
									}
								} else if (ward_eyes) {
									GenerateWanderingEyesProcedure.execute(world, x + sx, y + sy, z + sz);
								}
							}
						}
						if (evil_eyes && (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:sculk_replaceable"))) && Math.random() < 0.0012 * chance_modifier) {
							if (entity instanceof Player _player)
								_player.giveExperiencePoints(-(10));
							GenerateSculkProcedure.execute(world, x + sx, y + sy, z + sz);
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
