package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.entity.LoomerEntity;

import java.util.List;
import java.util.Comparator;

public class LoomerFlightProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean success = false;
		boolean deflection = false;
		double height = 0;
		double baseMult = 0;
		double spell_chance = 0;
		double y_vec = 0;
		double inaccuracy = 0;
		double magnitude = 0;
		double x_vec = 0;
		double z_vec = 0;
		double base_magnitude = 0;
		Entity target = null;
		if (entity instanceof LoomerEntity _datEntL0 && _datEntL0.getEntityData().get(LoomerEntity.DATA_spiraling)) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
				target = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
				magnitude = Math.sqrt(Math.pow(x - target.getX(), 2) + Math.pow(y - (target.getY() - 1), 2) + Math.pow(z - target.getZ(), 2));
				base_magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
				x_vec = (target.getX() - x) / magnitude;
				y_vec = (target.getY() - y) / magnitude;
				z_vec = (target.getZ() - z) / magnitude;
				entity.setDeltaMovement(new Vec3((x_vec * 0.65), (y_vec * 0.65), (z_vec * 0.65)));
			} else {
				entity.setDeltaMovement(new Vec3(0, (-0.5), 0));
			}
			if (entity instanceof LoomerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(LoomerEntity.DATA_chase_ticks, (int) ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_chase_ticks) : 0) + 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.MOON_SPLAT.get()), x, y, z, 12, 0.3, 0.3, 0.3, 0.2);
			if (((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_chase_ticks) : 0) > 200 || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty())
					&& entity.isAlive()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loomer.rumble")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:loomer.rumble")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 99);
			}
		} else {
			if (LoomerFlightConditionProcedure.execute(world, x, y, z)) {
				height = FlightHeightProcedure.execute(world, x, y, z);
				if (height < 14 || VoidAccessProcedure.execute(world, x, z, y) && y < 72) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.05, (entity.getDeltaMovement().z())));
				} else if (height > 28) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.05), (entity.getDeltaMovement().z())));
				}
			} else {
				entity.setDeltaMovement(new Vec3(0, 0, 0));
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty() && 50 > (entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0)) {
			if (entity instanceof LoomerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(LoomerEntity.DATA_awareness, (int) ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) + 1));
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 0) {
			if (entity instanceof LoomerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(LoomerEntity.DATA_awareness, (int) ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) - 1));
		}
		if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 30) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_5");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 25) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_4");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 20) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_3");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 15) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_2");
		} else if ((entity instanceof LoomerEntity _datEntI ? _datEntI.getEntityData().get(LoomerEntity.DATA_awareness) : 0) > 10) {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell_1");
		} else {
			if (entity instanceof LoomerEntity animatable)
				animatable.setTexture("loomer_shell");
		}
		if (!(entity instanceof LoomerEntity _datEntL52 && _datEntL52.getEntityData().get(LoomerEntity.DATA_spiraling))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if ((entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity).equals(entity.getStringUUID()) && entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance > 3) {
							{
								EndlessEndModVariables.PlayerVariables _vars = entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES);
								_vars.SwingsilkDistance = entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance - 0.1;
								_vars.syncPlayerVariables(entityiterator);
							}
							if (entity instanceof LoomerEntity _datEntSetL)
								_datEntSetL.getEntityData().set(LoomerEntity.DATA_latched, true);
							if (entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance - 0.12 < Math.floor(entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance)) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.honey_block.step")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.honey_block.step")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						} else if ((entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity).equals(entity.getStringUUID()) && entityiterator.getY() > entity.getY()
								&& entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkDistance < 7) {
							SwingsilkResetProcedure.execute(world, x, y, z, entityiterator);
						}
					}
				}
			}
		}
		if (!(entity instanceof LoomerEntity _datEntL62 && _datEntL62.getEntityData().get(LoomerEntity.DATA_spiraling))) {
			{
				final Vec3 _center = new Vec3(x, (y - 2), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity), 4);
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, (y + 2), z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entityiterator.fallDistance = 0;
			}
		}
		if (entity instanceof LoomerEntity _datEntL71 && _datEntL71.getEntityData().get(LoomerEntity.DATA_spiraling)) {
			if (entity instanceof LoomerEntity) {
				((LoomerEntity) entity).setAnimation("spiral");
			}
		} else {
			if (entity.isAlive()) {
				if (entity instanceof LoomerEntity _datEntL74 && _datEntL74.getEntityData().get(LoomerEntity.DATA_latched)) {
					if (entity instanceof LoomerEntity) {
						((LoomerEntity) entity).setAnimation("reel");
					}
				} else {
					if (entity instanceof LoomerEntity) {
						((LoomerEntity) entity).setAnimation("drift");
					}
				}
			}
		}
	}
}
