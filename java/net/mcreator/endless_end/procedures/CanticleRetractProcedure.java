package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class CanticleRetractProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randy = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.2, 0.2, 0.2, 0.1);
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep4
						? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getep4).toString()
						: "").equals("FLOOR")) {
			{
				BlockPos _bp = BlockPos.containing(x, y + 1, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep9
						? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getep9).toString()
						: "").equals("CEILING")) {
			{
				BlockPos _bp = BlockPos.containing(x, y - 1, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep14
						? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep14).toString()
						: "").equals("WALL")
				&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep16
						? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep16).toString()
						: "").equals("west")) {
			{
				BlockPos _bp = BlockPos.containing(x - 1, y, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep21
						? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep21).toString()
						: "").equals("WALL")
				&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep23
						? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep23).toString()
						: "").equals("east")) {
			{
				BlockPos _bp = BlockPos.containing(x + 1, y, z);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep28
						? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep28).toString()
						: "").equals("WALL")
				&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep30
						? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep30).toString()
						: "").equals("north")) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z - 1);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep35
						? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep35).toString()
						: "").equals("WALL")
				&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep37
						? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep37).toString()
						: "").equals("south")) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z + 1);
				BlockState _bs = Blocks.AIR.defaultBlockState();
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
		}
	}
}
