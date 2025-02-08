package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AscensionParticlesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double radius = 0;
		double sx = 0;
		double sz = 0;
		double drag = 0;
		double theta = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(EndlessEndModMobEffects.ASCENSION)) {
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
			world.addParticle(ParticleTypes.FIREWORK, (x + sx), (y - 0.3), (z + sz), (entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
			sx = radius * Math.sin(theta) * (-1);
			sz = radius * Math.cos(theta) * (-1);
			world.addParticle(ParticleTypes.FIREWORK, (x + sx), (y - 0.3), (z + sz), (entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
			radius = 1.4;
			sx = radius * Math.sin(theta);
			sz = radius * Math.cos(theta);
			world.addParticle(ParticleTypes.FIREWORK, (x + sx), (y - 1), (z + sz), (entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
		}
	}
}
