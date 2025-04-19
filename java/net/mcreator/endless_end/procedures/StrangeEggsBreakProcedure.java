package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.endless_end.init.EndlessEndModItems;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class StrangeEggsBreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 0
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) == 4
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1) == 8) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModBlocks.STRANGE_EGGS.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8 ? blockstate.getValue(_getip8) : -1) == 1
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip10 ? blockstate.getValue(_getip10) : -1) == 5
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip12 ? blockstate.getValue(_getip12) : -1) == 9) {
			for (int index0 = 0; index0 < 2; index0++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModBlocks.STRANGE_EGGS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15 ? blockstate.getValue(_getip15) : -1) == 2
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1) == 6
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? blockstate.getValue(_getip19) : -1) == 10) {
			for (int index1 = 0; index1 < 3; index1++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModBlocks.STRANGE_EGGS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip22 ? blockstate.getValue(_getip22) : -1) == 3
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip24 ? blockstate.getValue(_getip24) : -1) == 7
				|| (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip26 ? blockstate.getValue(_getip26) : -1) == 11) {
			for (int index2 = 0; index2 < 4; index2++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModBlocks.STRANGE_EGGS.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip29 ? blockstate.getValue(_getip29) : -1) == 12) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModItems.BRITTLE_CARAPACE.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip32 ? blockstate.getValue(_getip32) : -1) == 13) {
			for (int index3 = 0; index3 < 2; index3++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModItems.BRITTLE_CARAPACE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip35 ? blockstate.getValue(_getip35) : -1) == 14) {
			for (int index4 = 0; index4 < 3; index4++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModItems.BRITTLE_CARAPACE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip38 ? blockstate.getValue(_getip38) : -1) == 15) {
			for (int index5 = 0; index5 < 4; index5++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), new ItemStack(EndlessEndModItems.BRITTLE_CARAPACE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
