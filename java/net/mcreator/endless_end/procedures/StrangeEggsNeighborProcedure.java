package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class StrangeEggsNeighborProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof LiquidBlock || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() instanceof LiquidBlock
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() instanceof LiquidBlock || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() instanceof LiquidBlock
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() instanceof LiquidBlock) {
			StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
				world.destroyBlock(_pos, false);
			}
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep12 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep12).toString() : "")
				.equals("FLOOR") && !world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
			StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
				world.destroyBlock(_pos, false);
			}
		} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep16 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep16).toString() : "")
				.equals("CEILING") && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
			StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
				world.destroyBlock(_pos, false);
			}
		} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep20 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep20).toString() : "")
				.equals("WALL")) {
			if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep22 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep22).toString() : "")
					.equals("east") && !world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()) {
				StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
					world.destroyBlock(_pos, false);
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep26
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep26).toString()
					: "").equals("west") && !world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
				StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
					world.destroyBlock(_pos, false);
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep30
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep30).toString()
					: "").equals("north") && !world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude()) {
				StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
					world.destroyBlock(_pos, false);
				}
			} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep34
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getep34).toString()
					: "").equals("south") && !world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()) {
				StrangeEggsBreakProcedure.execute(world, x, y, z, blockstate);
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 0.5, z + 0.5), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}
}
