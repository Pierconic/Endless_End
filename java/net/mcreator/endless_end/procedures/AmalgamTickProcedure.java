package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.AmalgamEntity;

import java.util.List;
import java.util.Comparator;

public class AmalgamTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		boolean found = false;
		boolean lost = false;
		boolean strike = false;
		boolean deflection = false;
		double baseMult = 0;
		double distance = 0;
		double y_vec = 0;
		double inaccuracy = 0;
		double magnitude = 0;
		double x_vec = 0;
		double z_vec = 0;
		double base_magnitude = 0;
		double spell_chance = 0;
		double spell_strike = 0;
		entity.setNoGravity(true);
		inaccuracy = 15;
		baseMult = 0.2;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).isEmpty()) {
			target = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null);
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
				magnitude = Math.sqrt(Math.pow(x - target.getX(), 2) + Math.pow(y - (target.getY() - 1), 2) + Math.pow(z - target.getZ(), 2));
				base_magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
			} else {
				magnitude = Math.sqrt(Math.pow(target.getX() - x, 2) + Math.pow(target.getY() - y, 2) + Math.pow(target.getZ() - z, 2));
				base_magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
			}
			x_vec = (target.getX() - x) / magnitude;
			y_vec = (target.getY() - y) / magnitude;
			z_vec = (target.getZ() - z) / magnitude;
			if (entity.getDeltaMovement().x() != 0) {
				x_vec = (x_vec + (entity.getDeltaMovement().x() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
			}
			if (entity.getDeltaMovement().y() != 0) {
				y_vec = (y_vec + (entity.getDeltaMovement().y() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
			}
			if (entity.getDeltaMovement().z() != 0) {
				z_vec = (z_vec + (entity.getDeltaMovement().z() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
			}
			entity.setDeltaMovement(new Vec3((x_vec * baseMult), (y_vec * baseMult), (z_vec * baseMult)));
		} else {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		}
		if (entity instanceof AmalgamEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmalgamEntity.DATA_loop_progress, (int) ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_loop_progress) : 0) + 1));
		if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_loop_progress) : 0) > 74) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:amalgam.loop")), SoundSource.NEUTRAL, 1,
							(float) (0.9 + 0.3 * (1 - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1))));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:amalgam.loop")), SoundSource.NEUTRAL, 1,
							(float) (0.9 + 0.3 * (1 - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1))), false);
				}
			}
			if (entity instanceof AmalgamEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AmalgamEntity.DATA_loop_progress, 0);
		}
		if (entity instanceof AmalgamEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmalgamEntity.DATA_spell_progress, (int) ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) + 1));
		if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("none")) {
			if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) > 100) {
				spell_chance = Mth.nextInt(RandomSource.create(), 1, 11);
				if (spell_chance < 3) {
					if (entity instanceof AmalgamEntity _datEntSetS)
						_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "blaze");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof AmalgamEntity animatable)
						animatable.setTexture("amalgam_blaze_1");
				} else if (spell_chance < 6) {
					if (entity instanceof AmalgamEntity _datEntSetS)
						_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "breeze");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof AmalgamEntity animatable)
						animatable.setTexture("amalgam_breeze_1");
				} else if (spell_chance < 9) {
					if (entity instanceof AmalgamEntity _datEntSetS)
						_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "flurry");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof AmalgamEntity animatable)
						animatable.setTexture("amalgam_flurry_1");
				} else {
					if (entity instanceof AmalgamEntity _datEntSetS)
						_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "none");
					if (entity instanceof AmalgamEntity animatable)
						animatable.setTexture("amalgam");
				}
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_spell_progress, 0);
			}
		} else if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("breeze")) {
			deflection = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Arrow) {
						if ((entityiterator.getX() - x) * entityiterator.getDeltaMovement().x() < 0) {
							deflection = true;
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x() * (-1)), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
						}
						if ((entityiterator.getY() - y) * entityiterator.getDeltaMovement().y() < 0) {
							deflection = true;
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y() * (-1)), (entityiterator.getDeltaMovement().z())));
						}
						if ((entityiterator.getZ() - z) * entityiterator.getDeltaMovement().z() < 0) {
							deflection = true;
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z() * (-1))));
						}
					}
				}
			}
			if (Math.random() < 0.15) {
				world.addParticle(ParticleTypes.SMALL_GUST, (x + Mth.nextDouble(RandomSource.create(), -2, 2)), (y + Mth.nextDouble(RandomSource.create(), -2, 2)), (z + Mth.nextDouble(RandomSource.create(), -2, 2)), 0, (-0.1), 0);
			}
			for (int index0 = 0; index0 < (int) Math.round(0.0125 * (entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0)); index0++) {
				world.addParticle(ParticleTypes.POOF, (x + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + Mth.nextDouble(RandomSource.create(), -0.2, 0.4)), (z + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0, 0.1, 0);
			}
			if (deflection) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.breeze.deflect")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.breeze.deflect")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) == 80) {
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam_breeze_2");
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
							BreezeSpellTargetProcedure.execute(world, entityiterator, 1.5);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SMALL_GUST, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 24, 1, 1, 1, 0.1);
						}
					}
				}
			} else if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) == 160) {
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam_breeze_3");
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
							BreezeSpellTargetProcedure.execute(world, entityiterator, 1.5);
							BreezeSpellTargetProcedure.execute(world, entityiterator, 2);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SMALL_GUST, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 24, 1, 1, 1, 0.1);
						}
					}
				}
			} else if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) >= 240) {
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam");
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
							BreezeSpellTargetProcedure.execute(world, entityiterator, 1.5);
							BreezeSpellTargetProcedure.execute(world, entityiterator, 2);
							BreezeSpellTargetProcedure.execute(world, entityiterator, 3);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SMALL_GUST, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 24, 1, 1, 1, 0.1);
						}
					}
				}
				if (entity instanceof AmalgamEntity _datEntSetS)
					_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "none");
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_spell_progress, -100);
			}
		} else if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("blaze")) {
			if (Math.random() < 0.2) {
				world.addParticle(ParticleTypes.SMALL_FLAME, (x + Mth.nextDouble(RandomSource.create(), -2, 2)), (y + Mth.nextDouble(RandomSource.create(), -2, 2)), (z + Mth.nextDouble(RandomSource.create(), -2, 2)), 0, (-0.1), 0);
			}
			for (int index1 = 0; index1 < (int) Math.round(0.03 * (entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0)); index1++) {
				world.addParticle(ParticleTypes.SMOKE, (x + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + Mth.nextDouble(RandomSource.create(), -0.2, 0.4)), (z + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0, 0.1, 0);
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
						BlazeSpellTargetProcedure.execute(world, entityiterator);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMALL_FLAME, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 6, 0.3, 0.3, 0.3, 0.05);
					}
				}
			}
			if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) == 50) {
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam_blaze_2");
			} else if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) == 100) {
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam_blaze_3");
			} else if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) >= 150) {
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam");
				if (entity instanceof AmalgamEntity _datEntSetS)
					_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "none");
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_spell_progress, -100);
			}
		} else if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("flurry")) {
			entity.setTicksFrozen(0);
			if (Math.random() < 0.15) {
				world.addParticle(ParticleTypes.FIREWORK, (x + Mth.nextDouble(RandomSource.create(), -2, 2)), (y + Mth.nextDouble(RandomSource.create(), -2, 2)), (z + Mth.nextDouble(RandomSource.create(), -2, 2)), 0, (-0.1), 0);
			}
			for (int index2 = 0; index2 < (int) Math.round(0.016 * (entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0)); index2++) {
				world.addParticle(ParticleTypes.POOF, (x + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + Mth.nextDouble(RandomSource.create(), -0.2, 0.4)), (z + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0, 0.1, 0);
			}
			if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) == 120) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
							FlurrySpellTargetProcedure.execute(world, entityiterator, 10);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FIREWORK, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 24, 1, 1, 1, 0.1);
						}
					}
				}
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam_flurry_2");
			} else if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) == 240) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
							FlurrySpellTargetProcedure.execute(world, entityiterator, 15);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FIREWORK, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 24, 1, 1, 1, 0.1);
						}
					}
				}
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam_flurry_3");
			} else if ((entity instanceof AmalgamEntity _datEntI ? _datEntI.getEntityData().get(AmalgamEntity.DATA_spell_progress) : 0) >= 360) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(48 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
							FlurrySpellTargetProcedure.execute(world, entityiterator, 20);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FIREWORK, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 24, 1, 1, 1, 0.1);
						}
					}
				}
				if (entity instanceof AmalgamEntity animatable)
					animatable.setTexture("amalgam");
				if (entity instanceof AmalgamEntity _datEntSetS)
					_datEntSetS.getEntityData().set(AmalgamEntity.DATA_spell, "none");
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_spell_progress, 0);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false) && entityiterator instanceof Player) {
					magnitude = Math.sqrt(Math.pow(entityiterator.getX() - x, 2) + Math.pow(entityiterator.getY() - y, 2) + Math.pow(entityiterator.getZ() - z, 2));
					x_vec = (entityiterator.getX() - x) / magnitude;
					y_vec = ((entityiterator.getY() + 0.7) - y) / magnitude;
					z_vec = (entityiterator.getZ() - z) / magnitude;
					entityiterator.setDeltaMovement(new Vec3((x_vec * 0.2), (y_vec * 0.2), (z_vec * 0.2)));
					if (entityiterator instanceof LivingEntity _livEnt193 && _livEnt193.isBlocking()
							&& (entityiterator instanceof Player _plrCldRem195
									? _plrCldRem195.getCooldowns().getCooldownPercent((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 0f) * 100
									: 0) == 0) {
						entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), 1);
						if (world instanceof ServerLevel _level) {
							(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(2, _level, null, _stkprov -> {
							});
						}
						if (entityiterator instanceof Player _player)
							_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 60);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.shield.block")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else {
						if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("flurry")) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE)), 4);
						} else if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("blaze")) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.ON_FIRE)), 4);
							entityiterator.igniteForSeconds((int) (entity.getRemainingFireTicks() / 20 + 3));
						} else if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("breeze")) {
							entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 6), (entity.getDeltaMovement().y() * 6), (entity.getDeltaMovement().z() * 6)));
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), 4);
						} else {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), 4);
						}
					}
				}
			}
		}
	}
}
