package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.GrazerEntity;

import java.util.List;
import java.util.Comparator;

public class GrazerTeleportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sz = 0;
		double attempts = 0;
		boolean found = false;
		found = false;
		if (Math.random() < 0.0008 && entity.getDeltaMovement().x() == 0 && entity.getDeltaMovement().z() == 0
				&& ((world.getBlockState(BlockPos.containing(x, y - 0.8, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y - 0.8, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()
						|| (world.getBlockState(BlockPos.containing(x, y - 0.8, z))).getBlock() == EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get())) {
			if (entity instanceof GrazerEntity) {
				((GrazerEntity) entity).setAnimation("graze");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, false, false));
			if ((entity instanceof GrazerEntity _datEntI ? _datEntI.getEntityData().get(GrazerEntity.DATA_moss) : 0) == 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 40, 1, false, false));
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.RADIANCE) ? _livEnt.getEffect(EndlessEndModMobEffects.RADIANCE).getDuration() : 0) == 1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sniffer_egg.plop")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sniffer_egg.plop")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EndlessEndModBlocks.STRANGE_EGGS.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getDuration() : 0) == 1) {
			if (entity instanceof GrazerEntity _datEntL16 && _datEntL16.getEntityData().get(GrazerEntity.DATA_inverted)) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
					if (entity instanceof GrazerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GrazerEntity.DATA_moss, 1);
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell_canticle_inv");
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState()));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.PUFF_SPORE.get()), x, y, z, 20, 0.2, 0.2, 0.2, 0.2);
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
					if (entity instanceof GrazerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GrazerEntity.DATA_moss, 1);
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell_canticle");
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), x, y, z, 20, 0.2, 0.2, 0.2, 0.2);
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.UNLUCK) ? _livEnt.getEffect(MobEffects.UNLUCK).getDuration() : 0) == 1
				&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity && !(entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(MobEffects.MOVEMENT_SPEED))) {
			while (attempts < 24 && !found) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 10, 0.2, 0.2, 0.2, 0.1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.shulker.teleport")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDirection()) == Direction.SOUTH) {
					sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -15, -8);
					sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -8, 8);
				} else if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDirection()) == Direction.EAST) {
					sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -15, -8);
					sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -8, 8);
				} else if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDirection()) == Direction.WEST) {
					sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), 8, 15);
					sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), -8, 8);
				} else {
					sz = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() + Mth.nextInt(RandomSource.create(), 8, 15);
					sx = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() + Mth.nextInt(RandomSource.create(), -8, 8);
				}
				if (world.getBlockState(BlockPos.containing(sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) - 1, sz)).canOcclude()
						&& !(world.getBlockState(BlockPos.containing(sx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) - 1, sz))).is(BlockTags.create(ResourceLocation.parse("forge:grazer_forbidden")))) {
					{
						Entity _ent = entity;
						_ent.teleportTo(sx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) + 1), sz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(sx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) sx, (int) sz) + 1), sz, _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 5, false, true));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 500, 1, false, true));
					found = true;
				}
				attempts = attempts + 1;
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity) && !(entityiterator instanceof LivingEntity _livEnt82 && _livEnt82.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) && entityiterator instanceof LivingEntity _livEnt83
						&& _livEnt83.hasEffect(EndlessEndModMobEffects.ODOR)) {
					if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
		}
		if (entity instanceof GrazerEntity _datEntL86 && _datEntL86.getEntityData().get(GrazerEntity.DATA_inverted)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.4
						&& !((entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_cracked_inv"))) {
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell_cracked_inv");
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.4
						&& !((entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_slightly_cracked_inv"))) {
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell_slightly_cracked_inv");
				}
			} else if (!((entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_inv")
					|| (entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_canticle_inv"))) {
				if (entity instanceof GrazerEntity animatable)
					animatable.setTexture("grazer_shell_inv");
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.4
						&& !((entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_cracked"))) {
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell_cracked");
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.4
						&& !((entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_slightly_cracked"))) {
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell_slightly_cracked");
				}
			} else if (!((entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell") || (entity instanceof GrazerEntity animatable ? animatable.getTexture() : "null").equals("grazer_shell_canticle"))) {
				if (entity instanceof GrazerEntity animatable)
					animatable.setTexture("grazer_shell");
			}
		}
	}
}
