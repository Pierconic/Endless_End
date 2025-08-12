package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class EndWellPropogateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sz = 0;
		double sx = 0;
		double startX = 0;
		double startZ = 0;
		double xWidth = 0;
		double zWidth = 0;
		boolean upper_corner_found = false;
		boolean upper_wall_found = false;
		boolean second_corner_found = false;
		boolean third_corner_found = false;
		boolean fourth_corner_found = false;
		boolean finished = false;
		boolean valid_ring = false;
		boolean portal_clear = false;
		sz = 0;
		sx = 0;
		upper_wall_found = false;
		upper_corner_found = false;
		second_corner_found = false;
		third_corner_found = false;
		fourth_corner_found = false;
		valid_ring = false;
		portal_clear = false;
		for (int index0 = 0; index0 < 25; index0++) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + sz))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
				upper_wall_found = true;
				startZ = z + sz;
			} else {
				sz = sz + 1;
			}
		}
		if (upper_wall_found) {
			for (int index1 = 0; index1 < 25; index1++) {
				if ((world.getBlockState(BlockPos.containing((x + sx) - 1, y, z + sz))).getBlock() == EndlessEndModBlocks.ADAMANT.get()
						&& (world.getBlockState(BlockPos.containing(x + sx, y, (z + sz) - 1))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
					startZ = z + sz;
					startX = x + sx;
					upper_corner_found = true;
				} else {
					sx = sx + 1;
				}
			}
			if (upper_corner_found) {
				finished = false;
				sz = 0;
				sx = 1;
				for (int index2 = 0; index2 < 25; index2++) {
					if (!finished) {
						if ((world.getBlockState(BlockPos.containing(startX - sx, y, startZ - 1))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
							if (sx < 4) {
								finished = true;
							} else {
								xWidth = sx;
								startX = startX - sx;
								finished = true;
								second_corner_found = true;
							}
						} else if ((world.getBlockState(BlockPos.containing(startX - sx, y, startZ))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
							sx = sx + 1;
						} else {
							finished = true;
						}
					}
				}
				if (second_corner_found) {
					finished = false;
					sx = 0;
					sz = 1;
					for (int index3 = 0; index3 < 25; index3++) {
						if (!finished) {
							if ((world.getBlockState(BlockPos.containing(startX + 1, y, startZ - sz))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
								if (sz < 4) {
									finished = true;
								} else {
									zWidth = sz;
									startZ = startZ - sz;
									third_corner_found = true;
									finished = true;
								}
							} else if ((world.getBlockState(BlockPos.containing(startX, y, startZ - sz))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
								sz = sz + 1;
							} else {
								finished = true;
							}
						}
					}
				}
				if (third_corner_found) {
					finished = false;
					sx = 1;
					sz = 0;
					for (int index4 = 0; index4 < 25; index4++) {
						if (!finished) {
							if ((world.getBlockState(BlockPos.containing(startX + sx, y, startZ + 1))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
								if (sx != xWidth) {
									finished = true;
								} else {
									startX = startX + sx;
									fourth_corner_found = true;
									finished = true;
								}
							} else if ((world.getBlockState(BlockPos.containing(startX + sx, y, startZ))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
								sx = sx + 1;
							} else {
								finished = true;
							}
						}
					}
				}
				if (fourth_corner_found) {
					finished = false;
					sx = 0;
					sz = 1;
					for (int index5 = 0; index5 < 25; index5++) {
						if (!finished) {
							if ((world.getBlockState(BlockPos.containing(startX - 1, y, startZ + sz))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
								if (sz != zWidth) {
									finished = true;
								} else {
									startZ = startZ + sz;
									valid_ring = true;
									finished = true;
								}
							} else if ((world.getBlockState(BlockPos.containing(startX, y, startZ + sz))).getBlock() == EndlessEndModBlocks.ADAMANT.get()) {
								sz = sz + 1;
							} else {
								finished = true;
							}
						}
					}
				}
			}
		}
		if (valid_ring) {
			portal_clear = true;
			sx = 1;
			sz = 1;
			for (int index6 = 0; index6 < (int) (xWidth - 1); index6++) {
				sz = 1;
				for (int index7 = 0; index7 < (int) (zWidth - 1); index7++) {
					if (!((world.getBlockState(BlockPos.containing(startX - sx, y, startZ - sz))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(startX - sx, y, startZ - sz))).getBlock() == Blocks.SOUL_FIRE
							|| (world.getBlockState(BlockPos.containing(startX - sx, y, startZ - sz))).getBlock() == Blocks.FIRE)) {
						portal_clear = false;
					}
					sz = sz + 1;
				}
				sx = sx + 1;
			}
			if (!portal_clear) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("end_well.obstructed").getString())), true);
			}
		}
		if (portal_clear) {
			if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END
					&& !world.getEntitiesOfClass(EnderDragon.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).isEmpty()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("end_well.inhibited").getString())), true);
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.end_portal.spawn")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				sx = 1;
				sz = 1;
				for (int index8 = 0; index8 < (int) (xWidth - 1); index8++) {
					sz = 1;
					for (int index9 = 0; index9 < (int) (zWidth - 1); index9++) {
						world.setBlock(BlockPos.containing(startX - sx, y, startZ - sz), Blocks.END_PORTAL.defaultBlockState(), 3);
						sz = sz + 1;
					}
					sx = sx + 1;
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (startX - (xWidth - 1) * 0.5 + 1), y, (startZ - (zWidth - 1) * 0.5 + 1), (int) (7 * xWidth * zWidth), (xWidth * 0.3), 1, (zWidth * 0.3), 0.1);
			}
		}
	}
}
