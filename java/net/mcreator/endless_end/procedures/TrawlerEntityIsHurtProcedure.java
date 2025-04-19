package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Block;
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
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.TrawlerEntity;

public class TrawlerEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof TrawlerEntity _datEntI ? _datEntI.getEntityData().get(TrawlerEntity.DATA_moss) : 0) != 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), x, y, z, 35, 0.2, 0.2, 0.2, 0.2);
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
			world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
			if (entity instanceof TrawlerEntity animatable)
				animatable.setTexture("trawler_shell");
			if (entity instanceof TrawlerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TrawlerEntity.DATA_moss, 0);
		}
		if (sourceentity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(EndlessEndModMobEffects.FRAGRANCE)) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.removeEffect(EndlessEndModMobEffects.FRAGRANCE);
		} else {
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.ODOR, Mth.nextInt(RandomSource.create(), 1800, 3600), 0));
		}
		if (entity instanceof Mob _mob ? _mob.isAggressive() : false) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
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
		}
		if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && !(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MobEffects.MOVEMENT_SPEED))
				&& !(entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.LUCK))) {
			if (entity instanceof TrawlerEntity) {
				((TrawlerEntity) entity).setAnimation("warp");
			}
			if (!(entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MobEffects.UNLUCK))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 20, 1, false, false));
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 3, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 3, false, false));
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())));
		}
	}
}
