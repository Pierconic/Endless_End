package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;

public class FlurryChargeReverseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getStringUUID()).equals(entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Shooter) : "")) {
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Oomf, (int) ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) + 150));
		} else {
			if (entity instanceof FlurryChargeEntityEntity _datEntSetS)
				_datEntSetS.getEntityData().set(FlurryChargeEntityEntity.DATA_Target, (entity instanceof FlurryChargeEntityEntity _datEntS ? _datEntS.getEntityData().get(FlurryChargeEntityEntity.DATA_Shooter) : ""));
			if (entity instanceof FlurryChargeEntityEntity _datEntSetS)
				_datEntSetS.getEntityData().set(FlurryChargeEntityEntity.DATA_Shooter, (sourceentity.getStringUUID()));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_block.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Oomf, (int) ((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Oomf) : 0) + 150));
			if (entity instanceof FlurryChargeEntityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryChargeEntityEntity.DATA_Inaccuracy, (int) Math.max((entity instanceof FlurryChargeEntityEntity _datEntI ? _datEntI.getEntityData().get(FlurryChargeEntityEntity.DATA_Inaccuracy) : 0) - 5, 1));
		}
	}
}
