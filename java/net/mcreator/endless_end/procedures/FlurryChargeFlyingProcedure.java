package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.FlurryEntity;
import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;

import java.util.List;
import java.util.Comparator;

public class FlurryChargeFlyingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		boolean found = false;
		boolean lost = false;
		boolean strike = false;
		double x_vec = 0;
		double y_vec = 0;
		double z_vec = 0;
		double magnitude = 0;
		double distance = 0;
		double baseMult = 0;
		double base_magnitude = 0;
		double inaccuracy = 0;
		if (y > 256 || (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_LifeTicks) : 0) > 1200) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 10, 0.2, 0.2, 0.2, 0.1);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
			_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_LifeTicks, (int) ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_LifeTicks) : 0) + 1));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 1, 0.2, 0.2, 0.2, 0.1);
		world.addParticle(ParticleTypes.FIREWORK, x, y, z, 0, 0, 0);
		entity.setNoGravity(true);
		inaccuracy = entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Inaccuracy) : 0;
		baseMult = 0.001;
		if ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) < 999) {
			if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Oomf, (int) ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) + 1));
		}
		if (!((entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Target) : "").equals("none"))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getStringUUID()).equals(entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Target) : "")) {
						target = entityiterator;
						found = true;
					}
				}
			}
			if (found) {
				magnitude = Math.sqrt(Math.pow(target.getX() - x, 2) + Math.pow((target.getY() + 0.7) - y, 2) + Math.pow(target.getZ() - z, 2));
				base_magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
				x_vec = (target.getX() - x) / magnitude;
				y_vec = ((target.getY() + 0.7) - y) / magnitude;
				z_vec = (target.getZ() - z) / magnitude;
				x_vec = (x_vec + (entity.getDeltaMovement().x() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
				y_vec = (y_vec + (entity.getDeltaMovement().y() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
				z_vec = (z_vec + (entity.getDeltaMovement().z() / base_magnitude) * inaccuracy) / (inaccuracy + 1);
				entity.setDeltaMovement(new Vec3((x_vec * (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) * baseMult),
						(y_vec * (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) * baseMult),
						(z_vec * (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) * baseMult)));
			} else {
				lost = true;
			}
		} else {
			lost = true;
		}
		if (lost) {
			distance = 99;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					magnitude = Math.sqrt(Math.pow(entityiterator.getX() - x, 2) + Math.pow(entityiterator.getY() - y, 2) + Math.pow(entityiterator.getZ() - z, 2));
					if (entityiterator instanceof LivingEntity && !(entityiterator instanceof FlurryChargeEntityEntity)
							&& !((entityiterator.getStringUUID()).equals(entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Shooter) : ""))
							&& !(entityiterator instanceof FlurryEntity && entity instanceof FlurryChargeEntityEntity _datEntL42 && _datEntL42.getEntityData().get(FlurryChargeEntityEntity.DATA_Natural))) {
						if (magnitude < distance) {
							if (entity instanceof FlurryChargeEntityEntity _datEntSetS)
								_datEntSetS.getEntityData().set(FlurryChargeEntityEntity.DATA_Target, (entityiterator.getStringUUID()));
							distance = magnitude;
						}
					}
				}
			}
			magnitude = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2) + Math.pow(entity.getDeltaMovement().y(), 2) + Math.pow(entity.getDeltaMovement().z(), 2));
			x_vec = entity.getDeltaMovement().x() / magnitude;
			y_vec = entity.getDeltaMovement().y() / magnitude;
			z_vec = entity.getDeltaMovement().z() / magnitude;
			entity.setDeltaMovement(new Vec3((x_vec * (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) * baseMult),
					(y_vec * (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) * baseMult),
					(z_vec * (entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) * baseMult)));
		}
		strike = false;
		if ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_LifeTicks) : 0) > 5) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator instanceof FlurryChargeEntityEntity)
							&& !((entityiterator.getStringUUID()).equals(entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Shooter) : ""))) {
						strike = true;
					}
				}
			}
		}
		if (strike || world.getBlockFloorHeight(BlockPos.containing(x, y, z)) > 0) {
			FlurryChargeStrikeProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Sparkle) : 0) <= 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:flurry_charge.loop")), SoundSource.NEUTRAL, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:flurry_charge.loop")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
				}
			}
			if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Sparkle, 15);
		} else {
			if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Sparkle, (int) ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Sparkle) : 0) - 1));
		}
	}
}
