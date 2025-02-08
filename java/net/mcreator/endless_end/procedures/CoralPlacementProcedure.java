package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class CoralPlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double type = 0;
		world.setBlock(BlockPos.containing(x, y, z),
				(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("minecraft:coral_blocks"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
						.defaultBlockState(),
				3);
		if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x, y + 1, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x, y + 1, z);
			if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x, y + 2, z))).getFluidState().isSource()) {
				world.setBlock(BlockPos.containing(x, y + 2, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
				CoralFanProcedure.execute(world, x, y + 2, z);
			}
		}
		if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x + 1, y, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x + 1, y, z);
		}
		if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x - 1, y, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x - 1, y, z);
		}
		if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x, y, z - 1), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x, y, z - 1);
		}
		if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x, y, z + 1), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x, y, z + 1);
		}
		if (Math.random() < 0.65 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getFluidState().isSource()) {
			CoralFanProcedure.execute(world, x, y, z);
			world.setBlock(BlockPos.containing(x, y - 1, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
		}
		if (Math.random() < 0.2 && (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x - 1, y + 1, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x - 1, y + 1, z);
		}
		if (Math.random() < 0.2 && (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x + 1, y + 1, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x + 1, y + 1, z);
		}
		if (Math.random() < 0.2 && (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x, y + 1, z + 1), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x, y + 1, z + 1);
		}
		if (Math.random() < 0.2 && (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getFluidState().isSource()) {
			world.setBlock(BlockPos.containing(x, y + 1, z - 1), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			CoralFanProcedure.execute(world, x, y + 1, z - 1);
		}
	}
}
