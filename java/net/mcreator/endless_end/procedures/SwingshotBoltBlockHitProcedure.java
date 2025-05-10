package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModEntities;

public class SwingshotBoltBlockHitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dx = 0;
		double distance = 0;
		double dy = 0;
		double dz = 0;
		boolean est = false;
		SwingsilkResetProcedure.execute(world, x, y, z, entity);
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkLinked = true;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkX = x + 0.5;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkY = y + -0.2;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkZ = z + 0.5;
			_vars.syncPlayerVariables(entity);
		}
		dx = entity.getX() - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX;
		dy = entity.getY() - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY;
		dz = entity.getZ() - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ;
		distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2), 0.5);
		if (distance < 7) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkDistance = 7;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkDistance = distance;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = EndlessEndModEntities.SWINGSILK_BALL.get().spawn(_level,
					BlockPos.containing(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ),
					MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null,
						BlockPos.containing(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ),
						BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.hit")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ,
						BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.hit")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.hit")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.hit")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
	}
}
