package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.endless_end.EndlessEndMod;

import java.util.List;
import java.util.Comparator;

public class WitherRoseRegenerationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(Math.round(x), Math.round(y + 0.2), Math.round(z)))).getBlock() == Blocks.WITHER_ROSE) {
			world.destroyBlock(BlockPos.containing(Math.round(x), Math.round(y + 0.2), Math.round(z)), false);
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
			world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, x, y, z, 12, 0.2, 0.2, 0.2, 0.05);
			EndlessEndMod.queueServerWork(3, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither_skeleton.death")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither_skeleton.death")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			});
			EndlessEndMod.queueServerWork(5, () -> {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(x, y + 0.2, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 8, 0.2, 0.2, 0.2, 0.15);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("endless_end:null_ouroboros"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			});
		}
	}
}
