package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WebPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double type = 0;
		world.setBlock(BlockPos.containing(x, y, z), Blocks.COBWEB.defaultBlockState(), 3);
		if (Math.random() < 0.65 && world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.65 && world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
			world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.65 && world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
			world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.65 && world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
			world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.65 && world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
			world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.65 && world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.COBWEB.defaultBlockState(), 3);
			if (Math.random() < 0.45 && world.isEmptyBlock(BlockPos.containing(x, y - 2, z))) {
				world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.COBWEB.defaultBlockState(), 3);
			}
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x - 1, y - 1, z))) {
			world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x + 1, y - 1, z))) {
			world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x, y - 1, z + 1))) {
			world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x, y - 1, z - 1))) {
			world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x - 1, y + 1, z))) {
			world.setBlock(BlockPos.containing(x - 1, y + 1, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x + 1, y + 1, z))) {
			world.setBlock(BlockPos.containing(x + 1, y + 1, z), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x, y + 1, z + 1))) {
			world.setBlock(BlockPos.containing(x, y + 1, z + 1), Blocks.COBWEB.defaultBlockState(), 3);
		}
		if (Math.random() < 0.2 && world.isEmptyBlock(BlockPos.containing(x, y + 1, z - 1))) {
			world.setBlock(BlockPos.containing(x, y + 1, z - 1), Blocks.COBWEB.defaultBlockState(), 3);
		}
	}
}
