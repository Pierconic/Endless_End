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
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.endless_end.entity.GrazerEntity;

import java.util.List;
import java.util.Comparator;

public class GrazerEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Mob _mob ? _mob.isAggressive() : false) {
			if (Math.pow(x - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(), 2) + Math.pow(z - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ(), 2) > 16) {
				if (entity instanceof Mob) {
					try {
						((Mob) entity).setTarget(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && !(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.MOVEMENT_SPEED))
				&& !(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.LUCK))) {
			if (entity instanceof GrazerEntity) {
				((GrazerEntity) entity).setAnimation("warp");
			}
			if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.UNLUCK))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 20, 1, false, false));
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 3, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 3, false, false));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof GrazerEntity && !(entityiterator instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MobEffects.UNLUCK))) {
						if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		}
	}
}
