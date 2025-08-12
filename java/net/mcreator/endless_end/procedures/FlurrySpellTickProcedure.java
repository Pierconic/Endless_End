package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class FlurrySpellTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState newBlock = Blocks.AIR.defaultBlockState();
		{
			int _value = (int) (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1
					? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1)
					: -1) + 1);
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip4 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4) : -1) > 8) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 18, 2, 2, 2, 0.1);
			FlurryRodBridgeProcedure.execute(world, x, y, z, Direction.NORTH, Mth.nextInt(RandomSource.create(), 1, 3));
			FlurryRodBridgeProcedure.execute(world, x, y, z, Direction.SOUTH, Mth.nextInt(RandomSource.create(), 1, 3));
			FlurryRodBridgeProcedure.execute(world, x, y, z, Direction.WEST, Mth.nextInt(RandomSource.create(), 1, 3));
			FlurryRodBridgeProcedure.execute(world, x, y, z, Direction.EAST, Mth.nextInt(RandomSource.create(), 1, 3));
			FlurryRodPillarProcedure.execute(world, x, y + 1, z, false, Mth.nextInt(RandomSource.create(), 1, 3));
			FlurryRodPillarInvertedProcedure.execute(world, x, y, z, Mth.nextInt(RandomSource.create(), 1, 3));
			world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.FLURRY_CRYSTALS.get().defaultBlockState(), 3);
		}
	}
}
