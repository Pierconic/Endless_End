package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.AmalgamEntity;

public class FlurrySpellInitiateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double quantity) {
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double sy = 0;
		double y2 = 0;
		counter = quantity;
		if (!(world.getBlockFloorHeight(BlockPos.containing(x, y + 0, z)) > 0)) {
			world.setBlock(BlockPos.containing(x, y + 0, z), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
		}
		if (!(world.getBlockFloorHeight(BlockPos.containing(x + 1, y, z)) > 0)) {
			world.setBlock(BlockPos.containing(x + 1, y, z), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
		}
		if (!(world.getBlockFloorHeight(BlockPos.containing(x + -1, y, z)) > 0)) {
			world.setBlock(BlockPos.containing(x + -1, y, z), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
		}
		if (!(world.getBlockFloorHeight(BlockPos.containing(x, y, z + -1)) > 0)) {
			world.setBlock(BlockPos.containing(x, y, z + -1), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
		}
		if (!(world.getBlockFloorHeight(BlockPos.containing(x, y, z + 1)) > 0)) {
			world.setBlock(BlockPos.containing(x, y, z + 1), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
		}
		if (!(world.getBlockFloorHeight(BlockPos.containing(x, y + 1, z)) > 0)) {
			world.setBlock(BlockPos.containing(x, y + 0, z), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
		}
		for (int index0 = 0; index0 < (int) (quantity * 3); index0++) {
			if (counter > 0) {
				x2 = Mth.nextDouble(RandomSource.create(), -8, 8);
				y2 = Mth.nextDouble(RandomSource.create(), -8, 8);
				z2 = Mth.nextDouble(RandomSource.create(), -8, 8);
				if (!(world.getBlockFloorHeight(BlockPos.containing(x + x2, y + y2, z + z2)) > 0) && !(!world.getEntitiesOfClass(AmalgamEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty())) {
					world.setBlock(BlockPos.containing(x + x2, y + y2, z + z2), EndlessEndModBlocks.FLURRY_SPELL.get().defaultBlockState(), 3);
					counter = counter - 1;
				}
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:flurry_spell")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:flurry_spell")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
