package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class RemnantScatterProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double randy = 0;
		double xoff = 0;
		double yoff = 0;
		double zoff = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double sy2 = 0;
		sx = -7;
		for (int index0 = 0; index0 < 15; index0++) {
			sy = -7;
			for (int index1 = 0; index1 < 15; index1++) {
				sz = -7;
				for (int index2 = 0; index2 < 15; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == EndlessEndModBlocks.AMNESOCLAST.get()) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz + 1))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing(x + sx, y + sy, (z + sz) - 1))).getBlock() == Blocks.END_STONE
								|| (world.getBlockState(BlockPos.containing(x + sx, y + sy + 1, z + sz))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing(x + sx, (y + sy) - 1, z + sz))).getBlock() == Blocks.END_STONE
								|| (world.getBlockState(BlockPos.containing(x + sx + 1, y + sy, z + sz))).getBlock() == Blocks.END_STONE || (world.getBlockState(BlockPos.containing((x + sx) - 1, y + sy, z + sz))).getBlock() == Blocks.END_STONE) {
							world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.COBBLED_ENDSTONE.get().defaultBlockState(), 3);
						} else {
							if (Math.random() < 0.3) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), 3);
								{
									int _value = Mth.nextInt(RandomSource.create(), 0, 12);
									BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
										world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
								}
								if (Math.random() < 0.4 && !(world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:inverted_orchard"))
										|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:inverted_barrens"))
										|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:inverted_midlands")))) {
									if (world.isEmptyBlock(BlockPos.containing(x + sx, (y + sy) - 1, z + sz))) {
										sy2 = 1;
										for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 1, 6); index3++) {
											if (Math.random() < 0.5) {
												if (Math.random() < 0.02) {
													world.setBlock(BlockPos.containing(x + sx, (y + sy) - sy2, z + sz), EndlessEndModBlocks.DORMANT_ICONOCLAST.get().defaultBlockState(), 3);
												} else {
													world.setBlock(BlockPos.containing(x + sx, (y + sy) - sy2, z + sz), EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), 3);
													{
														int _value = Mth.nextInt(RandomSource.create(), 0, 13);
														BlockPos _pos = BlockPos.containing(x + sx, (y + sy) - sy2, z + sz);
														BlockState _bs = world.getBlockState(_pos);
														if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
															world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
													}
												}
											} else {
												world.setBlock(BlockPos.containing(x + sx, (y + sy) - sy2, z + sz), EndlessEndModBlocks.AMNESOCLAST.get().defaultBlockState(), 3);
											}
											sy2 = sy2 + 1;
										}
									} else if (world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz))) {
										sy2 = 1;
										for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 1, 6); index4++) {
											if (Math.random() < 0.5) {
												if (Math.random() < 0.02) {
													world.setBlock(BlockPos.containing(x + sx, y + sy + sy2, z + sz), EndlessEndModBlocks.DORMANT_ICONOCLAST.get().defaultBlockState(), 3);
												} else {
													world.setBlock(BlockPos.containing(x + sx, y + sy + sy2, z + sz), EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), 3);
													{
														int _value = Mth.nextInt(RandomSource.create(), 0, 13);
														BlockPos _pos = BlockPos.containing(x + sx, y + sy + sy2, z + sz);
														BlockState _bs = world.getBlockState(_pos);
														if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
															world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
													}
												}
											} else {
												world.setBlock(BlockPos.containing(x + sx, y + sy + sy2, z + sz), EndlessEndModBlocks.AMNESOCLAST.get().defaultBlockState(), 3);
											}
											sy2 = sy2 + 1;
										}
									}
								}
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		return true;
	}
}
