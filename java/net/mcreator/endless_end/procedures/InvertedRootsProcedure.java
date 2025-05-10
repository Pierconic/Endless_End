package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class InvertedRootsProcedure {
	public static void execute(LevelAccessor world, double x, double z, double radius, double radx, double radz) {
		BlockState cur_block = Blocks.AIR.defaultBlockState();
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double rad_temp = 0;
		double chance = 0;
		rad_temp = radius;
		cur_block = VoidGenBlockProcedure.execute(world, x + 0.5, z + 0.5);
		if (cur_block.getBlock() == Blocks.END_STONE || cur_block.getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get() || cur_block.getBlock() == EndlessEndModBlocks.GOLDEN_HUMUS.get()) {
			world.setBlock(BlockPos.containing(x + 0.5, VoidGenHeightProcedure.execute(world, x + 0.5, z + 0.5), z + 0.5), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
		}
		for (int index0 = 0; index0 < (int) radius; index0++) {
			counter = 0;
			chance = Math.max(0.05, 0.5 - rad_temp / radius);
			while (counter <= 360) {
				x2 = radx * rad_temp * Math.cos(counter);
				z2 = radz * rad_temp * Math.sin(counter);
				counter = counter + 2;
				cur_block = VoidGenBlockProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5);
				if ((cur_block.getBlock() == Blocks.END_STONE || cur_block.getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get() || cur_block.getBlock() == EndlessEndModBlocks.STRONG_STONE.get()
						|| cur_block.getBlock() == EndlessEndModBlocks.GOLDEN_HUMUS.get()) && Math.random() < chance) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, VoidGenHeightProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5), z + z2 + 0.5), EndlessEndModBlocks.ROOTED_ENDSTONE.get().defaultBlockState(), 3);
				}
			}
			rad_temp = rad_temp - 1;
		}
	}
}
