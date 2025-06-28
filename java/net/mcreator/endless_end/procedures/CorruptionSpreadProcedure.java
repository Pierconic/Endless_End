package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
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
		double eye_chance = 0;
		double teeth_chance = 0;
		double spike_chance = 0;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 12000) {
				chance_modifier = 3.5;
				time_modifier = 3;
				spike_chance = 0.5;
				eye_chance = 0.3;
				teeth_chance = 1;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 7200) {
				chance_modifier = 2.3;
				time_modifier = 3;
				spike_chance = 0.1;
				eye_chance = 0.3;
				teeth_chance = 0.5;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 4800) {
				chance_modifier = 1.6;
				time_modifier = 2;
				spike_chance = 0;
				eye_chance = 0.2;
				teeth_chance = 0.4;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) > 2400) {
				chance_modifier = 1;
				time_modifier = 1;
				spike_chance = 0;
				eye_chance = 0.1;
				teeth_chance = 0.2;
			}
			if (Math.random() < 0.05) {
				sx = -5;
				for (int index0 = 0; index0 < 11; index0++) {
					sy = -5;
					for (int index1 = 0; index1 < 11; index1++) {
						sz = -5;
						for (int index2 = 0; index2 < 11; index2++) {
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:sculk_replaceable"))) && Math.random() < 0.0012 * chance_modifier) {
								if (entity instanceof Player _player)
									_player.giveExperiencePoints(-(10));
								GenerateSculkProcedure.execute(world, x + sx, y + sy, z + sz);
							}
							if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.SCULK) {
								if (Math.random() < 0.0012 * chance_modifier) {
									if (Math.random() < spike_chance) {
										GenerateSpikeProcedure.execute(world, x + sx, y + sy, z + sz);
									} else if (Math.random() < eye_chance) {
										GenerateEvilEyesProcedure.execute(world, x + sx, y + sy, z + sz);
									} else if (Math.random() < teeth_chance) {
										GenerateBurrowingThornsProcedure.execute(world, x + sx, y + sy, z + sz);
									} else {
										GenerateWanderingEyesProcedure.execute(world, x + sx, y + sy, z + sz);
									}
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
		if (Math.random() < 0.1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SCULK_SOUL, x, y, z, 3, 0.1, 0.1, 0.1, 0.05);
		}
	}
}
