package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class AscensionParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double radius = 0;
		double sx = 0;
		double sz = 0;
		double drag = 0;
		double theta = 0;
		double chance = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EndlessEndModMobEffects.ASCENSION)) {
			chance = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.ASCENSION) ? _livEnt.getEffect(EndlessEndModMobEffects.ASCENSION).getDuration() : 0;
			if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ascension_timer == 0) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.ascension_timer = 3599;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.ascension_timer = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ascension_timer - 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			theta = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ascension_timer * 0.1;
			radius = 3.5;
			sx = radius * Math.sin(theta);
			sz = radius * Math.cos(theta);
			if (Math.random() * 300 < chance) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.STAR_SPARKLE.get()), (x + sx), (y - 0.3), (z + sz), (entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
			}
			radius = 2.5;
			sx = radius * Math.sin(theta) * (-1);
			sz = radius * Math.cos(theta) * (-1);
			if (Math.random() * 300 < chance) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.STAR_SPARKLE.get()), (x + sx), (y - 0.3), (z + sz), (entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
			}
			if (chance % 8 == 0) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.STAR_SWIRL.get()), x, (y - 0.2), z, (entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
			}
		}
	}
}
