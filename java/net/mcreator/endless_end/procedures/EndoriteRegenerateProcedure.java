package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class EndoriteRegenerateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world instanceof Level _level0 && _level0.hasNeighborSignal(BlockPos.containing(x, y, z)))) {
			world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.ENDORITE_MESH.get().defaultBlockState(), 3);
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.ENDORITE_MESH.get().defaultBlockState()));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_eye.death")), SoundSource.NEUTRAL, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_eye.death")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
				}
			}
		}
	}
}
