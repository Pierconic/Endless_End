package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class StrangeEggsAgeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double chance = 0;
		boolean success = false;
		boolean hatch = false;
		success = false;
		hatch = false;
		chance = 0.3;
		if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep1 ? blockstate.getValue(_getep1).toString() : "").equals("FLOOR")
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get())) {
			if (Math.random() < chance || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
				success = true;
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep9 ? blockstate.getValue(_getep9).toString() : "").equals("CEILING")
				&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get())) {
			if (Math.random() < chance || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
				success = true;
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep17 ? blockstate.getValue(_getep17).toString() : "").equals("WALL")) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep19 ? blockstate.getValue(_getep19).toString() : "").equals("east")
					&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get())) {
				if (Math.random() < chance || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
					success = true;
				}
			} else if ((blockstate.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep27 ? blockstate.getValue(_getep27).toString() : "").equals("west")
					&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get())) {
				if (Math.random() < chance || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
					success = true;
				}
			} else if ((blockstate.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep35 ? blockstate.getValue(_getep35).toString() : "").equals("north")
					&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get())) {
				if (Math.random() < chance || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
					success = true;
				}
			} else if ((blockstate.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep43 ? blockstate.getValue(_getep43).toString() : "").equals("south")
					&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get())) {
				if (Math.random() < chance || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
					success = true;
				}
			}
		}
		if (success) {
			StrangeEggsAdvanceProcedure.execute(world, x, y, z, false);
		}
	}
}
