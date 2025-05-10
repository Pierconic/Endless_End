package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.WeaverEntity;
import net.mcreator.endless_end.EndlessEndMod;

import java.util.List;
import java.util.Comparator;

public class WeaverTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		boolean entity_found = false;
		Entity swing_entity = null;
		BlockState nest = Blocks.AIR.defaultBlockState();
		double vx = 0;
		double vy = 0;
		double dx = 0;
		double distance = 0;
		double vz = 0;
		double dy = 0;
		double dz = 0;
		double dz1 = 0;
		double dx1 = 0;
		double dy1 = 0;
		double p_off = 0;
		double string = 0;
		double sx = 0;
		double sz = 0;
		double attempts = 0;
		double new_state = 0;
		string = (entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_string) : 0) * 0.05;
		nest = (world.getBlockState(BlockPos.containing(entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_X) : 0,
				entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Y) : 0, entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Z) : 0)));
		if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.LUCK) && string <= 1) {
			if ((nest.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6 ? nest.getValue(_getip6) : -1) > 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beehive.enter")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				new_state = (nest.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8 ? nest.getValue(_getip8) : -1) - 4;
				if (entity instanceof WeaverEntity _datEntL9 && _datEntL9.getEntityData().get(WeaverEntity.DATA_pollen)
						&& (nest.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip10 ? nest.getValue(_getip10) : -1) != 7) {
					new_state = new_state + 1;
				}
				{
					int _value = (int) new_state;
					BlockPos _pos = BlockPos.containing(entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_X) : 0,
							entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Y) : 0, entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Z) : 0);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if (string <= 0 || !(nest.getBlock() == EndlessEndModBlocks.WEAVER_NEST.get())) {
			if (entity instanceof WeaverEntity _datEntSetI)
				_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, 0);
		} else {
			dx = x - ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_X) : 0) + 0.5);
			dy = y - ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Y) : 0) + 0.5);
			dz = z - ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Z) : 0) + 0.5);
			distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2), 0.5);
			if (distance > 96) {
				if (entity instanceof WeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, 0);
			} else if (distance > string) {
				dx1 = (dx / distance) * string;
				dy1 = (dy / distance) * string;
				dz1 = (dz / distance) * string;
				vx = entity.getDeltaMovement().x() + (dx1 - dx) / distance;
				vy = entity.getDeltaMovement().y() + (dy1 - dy) / distance;
				vz = entity.getDeltaMovement().z() + (dz1 - dz) / distance;
			} else {
				vx = entity.getDeltaMovement().x();
				vy = entity.getDeltaMovement().y();
				vz = entity.getDeltaMovement().z();
			}
			entity.setDeltaMovement(new Vec3(vx, vy, vz));
			p_off = 0;
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).isEmpty()) {
				StringParticlesProcedure.execute(world, entity.getX(), entity.getY() + 0, entity.getZ(), distance, 0.7, (entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_X) : 0) + 0.5,
						(entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Y) : 0) + 0.5, (entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_Nest_Z) : 0) + 0.5);
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && string > 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.3) {
				if (entity instanceof WeaverEntity) {
					((WeaverEntity) entity).setAnimation("upper");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 0, false, false));
				if (entity instanceof WeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, (int) ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_string) : 0) - 1));
			} else if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - 1.2 > entity.getY() || !world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z))) && string > 1) {
				if (entity instanceof WeaverEntity) {
					((WeaverEntity) entity).setAnimation("upper");
				}
				if (entity instanceof WeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, (int) ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_string) : 0) - 1));
			} else if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.2 < entity.getY()) {
				if (entity instanceof WeaverEntity) {
					((WeaverEntity) entity).setAnimation("hang");
				}
				if (entity instanceof WeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, (int) ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_string) : 0) + 1));
			}
		} else {
			if (entity instanceof LivingEntity _livEnt59 && _livEnt59.hasEffect(MobEffects.UNLUCK) && string > 0) {
				if (entity instanceof WeaverEntity) {
					((WeaverEntity) entity).setAnimation("hang");
				}
				if (entity instanceof WeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, (int) ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_string) : 0) + 1));
			} else if (entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(MobEffects.LUCK) && string > 1) {
				if (entity instanceof WeaverEntity) {
					((WeaverEntity) entity).setAnimation("upper");
				}
				if (entity instanceof WeaverEntity _datEntSetI)
					_datEntSetI.getEntityData().set(WeaverEntity.DATA_string, (int) ((entity instanceof WeaverEntity _datEntI ? _datEntI.getEntityData().get(WeaverEntity.DATA_string) : 0) - 1));
			} else {
				if (!world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z)) || string <= 0) {
					if (entity instanceof WeaverEntity) {
						((WeaverEntity) entity).setAnimation("run");
					}
				} else {
					if (entity instanceof WeaverEntity) {
						((WeaverEntity) entity).setAnimation("hang");
					}
				}
				if (Math.random() < 0.003) {
					if (Math.random() < 0.5 || string > 11 || !world.isEmptyBlock(BlockPos.containing(x, y - 0.1, z)) || entity instanceof WeaverEntity _datEntL71 && _datEntL71.getEntityData().get(WeaverEntity.DATA_pollen)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, Mth.nextInt(RandomSource.create(), 100, 240), 0, false, false));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, Mth.nextInt(RandomSource.create(), 60, 160), 0, false, false));
					}
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 0.1, z))).getBlock() == EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get() && !(entity instanceof WeaverEntity _datEntL79 && _datEntL79.getEntityData().get(WeaverEntity.DATA_pollen))) {
			if (entity instanceof WeaverEntity _datEntSetL)
				_datEntSetL.getEntityData().set(WeaverEntity.DATA_pollen, true);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.PUFF_DOWNFALL.get()), x, y, z, 10, 0.2, 0.2, 0.2, 0);
			EndlessEndMod.queueServerWork(10, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.PUFF_DOWNFALL.get()), x, y, z, 10, 0.2, 0.2, 0.2, 0);
			});
			if (entity instanceof WeaverEntity animatable)
				animatable.setTexture("weaver_pollen");
		}
		if (entity instanceof LivingEntity _livEnt86 && _livEnt86.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) {
			if (entity instanceof Mob) {
				try {
					((Mob) entity).setTarget(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof LivingEntity _livEnt89 && _livEnt89.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) && entityiterator instanceof LivingEntity _livEnt90
							&& _livEnt90.hasEffect(EndlessEndModMobEffects.ODOR)) {
						if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		}
	}
}
