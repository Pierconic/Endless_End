package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

public class DelayedBubbleCrystalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double delay) {
		EndlessEndMod.queueServerWork((int) delay, () -> {
			if (world.isEmptyBlock(BlockPos.containing(x, y, z)) || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_breakable")))) {
				world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.FLURRY_CRYSTALS.get().defaultBlockState(), 3);
			}
		});
	}
}
