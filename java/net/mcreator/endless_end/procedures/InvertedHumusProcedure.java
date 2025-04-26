package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class InvertedHumusProcedure {
	public static void execute(LevelAccessor world, double x, double z, double radius, double radx, double radz) {
		BlockState cur_block = Blocks.AIR.defaultBlockState();
		double z2 = 0;
		double x2 = 0;
		double counter = 0;
		double rad_temp = 0;
		double chance = 0;
		rad_temp = radius;
		cur_block = VoidGenBlockProcedure.execute(world, x + 0.5, z + 0.5);
		if (cur_block.getBlock() == Blocks.END_STONE || cur_block.getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get()) {
			world.setBlock(BlockPos.containing(x + 0.5, VoidGenHeightProcedure.execute(world, x + 0.5, z + 0.5), z + 0.5), EndlessEndModBlocks.GOLDEN_HUMUS.get().defaultBlockState(), 3);
		}
		for (int index0 = 0; index0 < (int) radius; index0++) {
			counter = 0;
			chance = Math.max(0.2, 1 - rad_temp / radius);
			while (counter <= 360) {
				x2 = radx * rad_temp * Math.cos(counter);
				z2 = radz * rad_temp * Math.sin(counter);
				counter = counter + 2;
				cur_block = VoidGenBlockProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5);
				if ((cur_block.getBlock() == Blocks.END_STONE || cur_block.getBlock() == EndlessEndModBlocks.COBBLED_ENDSTONE.get() || cur_block.getBlock() == EndlessEndModBlocks.STRONG_STONE.get()) && Math.random() < chance) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, VoidGenHeightProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5), z + z2 + 0.5), EndlessEndModBlocks.GOLDEN_HUMUS.get().defaultBlockState(), 3);
					if (world.isEmptyBlock(BlockPos.containing(x + x2 + 0.5, VoidGenHeightProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5) - 1, z + z2 + 0.5)) && Math.random() < 0.27) {
						if (Math.random() < 0.3) {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, VoidGenHeightProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5) - 1, z + z2 + 0.5), (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.GOLDEN_ROOTS.get().defaultBlockState(), Direction.DOWN)), 3);
						} else {
							world.setBlock(BlockPos.containing(x + x2 + 0.5, VoidGenHeightProcedure.execute(world, x + x2 + 0.5, z + z2 + 0.5) - 1, z + z2 + 0.5), (new Object() {
								public BlockState with(BlockState _bs, Direction newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
									if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
										return _bs.setValue(_dp, newValue);
									_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
									return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
								}
							}.with(EndlessEndModBlocks.GOLDEN_SPROUTS.get().defaultBlockState(), Direction.DOWN)), 3);
						}
					}
				}
			}
			rad_temp = rad_temp - 1;
		}
	}
}
