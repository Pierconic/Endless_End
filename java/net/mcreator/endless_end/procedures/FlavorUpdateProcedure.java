package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.EndlessEndMod;

public class FlavorUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState saved_state = Blocks.AIR.defaultBlockState();
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DROPPER) {
			EndlessEndMod.queueServerWork(20, () -> {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = Blocks.OBSERVER.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
			});
		} else {
			saved_state = (world.getBlockState(BlockPos.containing(x, y, z)));
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), saved_state, 3);
			if (world instanceof Level _level)
				_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
		}
	}
}
