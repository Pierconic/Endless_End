package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.entity.VioletPolypEntity;

import java.util.List;
import java.util.Comparator;

public class PolypTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sz = 0;
		double attempts = 0;
		boolean found = false;
		Entity near_entity = null;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity) && !(entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) && entityiterator instanceof LivingEntity _livEnt2
						&& _livEnt2.hasEffect(EndlessEndModMobEffects.ODOR)) {
					if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
		}
		if (!(!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) && world.getBlockState(BlockPos.containing(x, y - 0.1, z)).canOcclude()) {
			if (entity instanceof VioletPolypEntity) {
				((VioletPolypEntity) entity).setAnimation("grounded");
			}
		} else if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !(((VioletPolypEntity) entity).animationprocedure).equals("aggro")) {
			if (entity instanceof VioletPolypEntity) {
				((VioletPolypEntity) entity).setAnimation("aggro");
			}
		} else if (!(((VioletPolypEntity) entity).animationprocedure).equals("fly")) {
			if (entity instanceof VioletPolypEntity) {
				((VioletPolypEntity) entity).setAnimation("fly");
			}
		}
		if ((((VioletPolypEntity) entity).animationprocedure).equals("aggro")) {
			if (Math.random() < 0.4) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.STAR_SPARKLE.get()), x, y, z, Mth.nextInt(RandomSource.create(), 0, 1), 0.02, 0.02, 0.02, 0.01);
			}
		}
		if (!(!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null))) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty() && !(entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.LUCK))) {
				near_entity = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null);
				if (FlightHeightProcedure.execute(world, x, y, z) < 12 && (near_entity.isSprinting() || !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty() && near_entity.isShiftKeyDown()
						|| !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty() && !near_entity.isShiftKeyDown())) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, Mth.nextInt(RandomSource.create(), 70, 110), 1, false, false));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.STAR_SPARKLE.get()), x, y, z, 8, 0.05, 0.05, 0.05, 0.05);
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), (Mth.nextDouble(RandomSource.create(), 0.25, 0.4)),
							(entity.getDeltaMovement().z() + Mth.nextDouble(RandomSource.create(), -0.2, 0.2))));
				}
			} else {
				if (entity.getDeltaMovement().y() > 0) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 0.02), (entity.getDeltaMovement().z())));
				} else {
					if (VoidAccessProcedure.execute(world, x, z, y)) {
						entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.02), (entity.getDeltaMovement().z())));
					}
				}
			}
		}
	}
}
