package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class EssenceBubblesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) || world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) && (blockstate.getFluidState().isSource() && Math.random() < 0.00225 || Math.random() < 0.0015)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:essence.bubble")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:essence.bubble")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
		}
		if (Math.random() < 0.01 && world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) && blockstate.getFluidState().isSource()) {
			if (Math.random() < 0.05) {
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 18, 28); index0++) {
					if (Math.random() < 0.7) {
						world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), (y + Mth.nextDouble(RandomSource.create(), -0.5, 0.8)),
								(z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), 0, (Mth.nextDouble(RandomSource.create(), 0.1, 0.3)), 0);
					} else {
						world.addParticle(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), (y + Mth.nextDouble(RandomSource.create(), -0.5, 0.8)), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.3, 0.3)), 0,
								(Mth.nextDouble(RandomSource.create(), 0.1, 0.3)), 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:essence.plume")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:essence.plume")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				world.addParticle(ParticleTypes.SCULK_SOUL, (x + 0.5), (y + 0.3), (z + 0.5), 0, 0.1, 0);
			}
		}
	}
}
