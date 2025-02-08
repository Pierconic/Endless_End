package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

public class GenerateWanderingEyesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sculk.manifest")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sculk.manifest")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		EndlessEndMod.queueServerWork(5, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.SCULK) {
				world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.WARDING_EYES.get().defaultBlockState(), 3);
			}
		});
	}
}
