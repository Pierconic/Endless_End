package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class VeinifyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && !(EndlessEndModBlocks.BURROWING_THORNS.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock())
				&& !(EndlessEndModBlocks.BURROWING_SPIKE.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) && !(EndlessEndModBlocks.SPITEFUL_EYE.get() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock())
				&& !(Blocks.SCULK == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock())) {
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z),
						(Blocks.SCULK_VEIN.getStateDefinition().getProperty("down") instanceof BooleanProperty _withbp10 ? Blocks.SCULK_VEIN.defaultBlockState().setValue(_withbp10, true) : Blocks.SCULK_VEIN.defaultBlockState()), 3);
			} else if (Blocks.SCULK_VEIN == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("down") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
				world.setBlock(BlockPos.containing(x, y - 1, z),
						(Blocks.SCULK_VEIN.getStateDefinition().getProperty("up") instanceof BooleanProperty _withbp16 ? Blocks.SCULK_VEIN.defaultBlockState().setValue(_withbp16, true) : Blocks.SCULK_VEIN.defaultBlockState()), 3);
			} else if (Blocks.SCULK_VEIN == (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("up") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1))) {
				world.setBlock(BlockPos.containing(x, y, z - 1),
						(Blocks.SCULK_VEIN.getStateDefinition().getProperty("south") instanceof BooleanProperty _withbp22 ? Blocks.SCULK_VEIN.defaultBlockState().setValue(_withbp22, true) : Blocks.SCULK_VEIN.defaultBlockState()), 3);
			} else if (Blocks.SCULK_VEIN == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("south") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1))) {
				world.setBlock(BlockPos.containing(x, y, z + 1),
						(Blocks.SCULK_VEIN.getStateDefinition().getProperty("north") instanceof BooleanProperty _withbp28 ? Blocks.SCULK_VEIN.defaultBlockState().setValue(_withbp28, true) : Blocks.SCULK_VEIN.defaultBlockState()), 3);
			} else if (Blocks.SCULK_VEIN == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("north") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z))) {
				world.setBlock(BlockPos.containing(x + 1, y, z),
						(Blocks.SCULK_VEIN.getStateDefinition().getProperty("west") instanceof BooleanProperty _withbp34 ? Blocks.SCULK_VEIN.defaultBlockState().setValue(_withbp34, true) : Blocks.SCULK_VEIN.defaultBlockState()), 3);
			} else if (Blocks.SCULK_VEIN == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("west") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
			if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z))) {
				world.setBlock(BlockPos.containing(x - 1, y, z),
						(Blocks.SCULK_VEIN.getStateDefinition().getProperty("east") instanceof BooleanProperty _withbp40 ? Blocks.SCULK_VEIN.defaultBlockState().setValue(_withbp40, true) : Blocks.SCULK_VEIN.defaultBlockState()), 3);
			} else if (Blocks.SCULK_VEIN == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("east") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			}
		}
	}
}
