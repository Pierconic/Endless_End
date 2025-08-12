package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class BreezeSpellInitiateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double radius) {
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double sy = 0;
		for (int index0 = 0; index0 < 24; index0++) {
			if (!(world.getBlockFloorHeight(BlockPos.containing(x, y - sy, z)) > 0)) {
				sy = sy + 1;
			}
		}
		BreezeSpellPlaceProcedure.execute(world, x, y - sy, z, true);
		counter = 0;
		while (counter <= 360) {
			x2 = 1 * radius * Math.cos(counter);
			z2 = 1 * radius * Math.sin(counter);
			sy = 0;
			for (int index2 = 0; index2 < 24; index2++) {
				if (!(world.getBlockFloorHeight(BlockPos.containing(x + x2 + 0.5, y - sy, z + z2 + 0.5)) > 0)) {
					sy = sy + 1;
				}
			}
			BreezeSpellPlaceProcedure.execute(world, x + x2 + 0.5, y - sy, z + z2 + 0.5, false);
			counter = counter + 1;
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:breeze_spell.charge")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:breeze_spell.charge")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
