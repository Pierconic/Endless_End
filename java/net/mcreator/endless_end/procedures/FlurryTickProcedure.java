package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.endless_end.init.EndlessEndModEntities;
import net.mcreator.endless_end.entity.FlurryEntity;
import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;

import java.util.List;
import java.util.Comparator;

public class FlurryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		boolean found = false;
		boolean lost = false;
		boolean strike = false;
		double distance = 0;
		double y_vec = 0;
		double magnitude = 0;
		double x_vec = 0;
		double z_vec = 0;
		if (!(!(world.getNearestPlayer(entity, 96) == null))) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (Math.random() < 0.1) {
			world.addParticle(ParticleTypes.FIREWORK, (x + Mth.nextDouble(RandomSource.create(), -1, 1)), (y + Mth.nextDouble(RandomSource.create(), -1, 1)), (z + Mth.nextDouble(RandomSource.create(), -1, 1)), 0, (-0.1), 0);
		}
		for (int index0 = 0; index0 < (int) Math.round(0.025 * (entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_Charge) : 0)); index0++) {
			world.addParticle(ParticleTypes.POOF, (x + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), (y + Mth.nextDouble(RandomSource.create(), -0.2, 0.4)), (z + Mth.nextDouble(RandomSource.create(), -0.7, 0.7)), 0, 0.1, 0);
		}
		if ((!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty() || !world.getEntitiesOfClass(Blaze.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty())
				&& world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			found = false;
			distance = 99;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Blaze || entityiterator instanceof Player && !(entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (entity instanceof FlurryEntity _datEntSetI)
							_datEntSetI.getEntityData().set(FlurryEntity.DATA_Charge, (int) ((entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_Charge) : 0) + 1));
						magnitude = Math.sqrt(Math.pow(entityiterator.getX() - x, 2) + Math.pow(entityiterator.getY() - y, 2) + Math.pow(entityiterator.getZ() - z, 2));
						if (magnitude < distance) {
							target = entityiterator;
							distance = magnitude;
							found = true;
						}
					}
				}
			}
			if (found) {
				if ((entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_Charge) : 0) > 160) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((target.getX()), (target.getY() + 0.7), (target.getZ())));
					if (entity instanceof FlurryEntity _datEntSetI)
						_datEntSetI.getEntityData().set(FlurryEntity.DATA_Charge, 0);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EndlessEndModEntities.FLURRY_CHARGE_ENTITY.get().spawn(_level, BlockPos.containing(x, y + 1.2, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement((entity.getLookAngle().x * 2), (entity.getLookAngle().y * 2), (entity.getLookAngle().z * 2));
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.HOSTILE, 1, (float) 1.5);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.blaze.shoot")), SoundSource.HOSTILE, 1, (float) 1.5, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 16, 2, 2, 2, 0.1);
					if (!world.getEntitiesOfClass(FlurryChargeEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(FlurryChargeEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof FlurryChargeEntityEntity _datEntSetS)
							_datEntSetS.getEntityData().set(FlurryChargeEntityEntity.DATA_Shooter, (entity.getStringUUID()));
						if (((Entity) world.getEntitiesOfClass(FlurryChargeEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof FlurryChargeEntityEntity _datEntSetI)
							_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Oomf, 450);
						if (((Entity) world.getEntitiesOfClass(FlurryChargeEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof FlurryChargeEntityEntity _datEntSetL)
							_datEntSetL.getEntityData().set(FlurryChargeEntityEntity.DATA_Natural, true);
					}
				}
			}
		} else if ((entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_Charge) : 0) > 0) {
			if (entity instanceof FlurryEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryEntity.DATA_Charge, (int) ((entity instanceof FlurryEntity _datEntI ? _datEntI.getEntityData().get(FlurryEntity.DATA_Charge) : 0) - 1));
		}
	}
}
