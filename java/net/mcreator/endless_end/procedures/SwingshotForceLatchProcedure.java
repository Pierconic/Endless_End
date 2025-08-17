package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.entity.LoomerEntity;

public class SwingshotForceLatchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		double dx = 0;
		double distance = 0;
		double dy = 0;
		double dz = 0;
		boolean est = false;
		if (entity instanceof Player) {
			if (sourceentity instanceof LoomerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(LoomerEntity.DATA_latched, true);
			SwingsilkResetProcedure.execute(world, x, y, z, entity);
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkX = sourceentity.getX();
				_vars.syncPlayerVariables(entity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkY = sourceentity.getY();
				_vars.syncPlayerVariables(entity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkZ = sourceentity.getZ();
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
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkLinked = true;
				_vars.syncPlayerVariables(entity);
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.SwingsilkEntity = sourceentity.getStringUUID();
				_vars.syncPlayerVariables(entity);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.hit")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.hit")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.wolf_armor.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.wolf_armor.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), sourceentity), 7);
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
	}
}
