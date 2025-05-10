package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;

import java.util.List;
import java.util.Comparator;

public class GenericSwingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dx = 0;
		double distance = 0;
		double dy = 0;
		double dz = 0;
		Entity swing_entity = null;
		boolean found = false;
		if (!(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity).equals("")) {
			found = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getStringUUID()).equals(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity)) {
						swing_entity = entityiterator;
						found = true;
					}
				}
			}
			if (found) {
				if (swing_entity.getBbWidth() < 2) {
					swing_entity.setDeltaMovement(new Vec3((dx * 0.1), (dy * 0.1), (dz * 0.1)));
				}
			}
		}
		dx = x - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX;
		dy = y - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY;
		dz = z - entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ;
		distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2), 0.5);
		entity.setDeltaMovement(new Vec3((dx * (-0.1)), (dy * (-0.1)), (dz * (-0.1))));
		if (distance > 60) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.big.woosh")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.big.woosh")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else if (distance > 30) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.medium.woosh")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.medium.woosh")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.small.woosh")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:swingshot.small.woosh")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
