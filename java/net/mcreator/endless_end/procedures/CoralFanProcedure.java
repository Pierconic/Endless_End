package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CoralFanProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getFluidState().isSource() && Math.random() < 0.7) {
			world.setBlock(BlockPos.containing(x, y + 1, z),
					(BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("minecraft:coral_plants"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
							.defaultBlockState(),
					3);
		}
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getFluidState().isSource() && Math.random() < 0.7) {
			world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
				public BlockState with(BlockState _bs, Direction newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
						return _bs.setValue(_dp, newValue);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
				}
			}.with((BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("minecraft:coral_fans"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
					.defaultBlockState(), Direction.EAST)), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getFluidState().isSource() && Math.random() < 0.7) {
			world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
				public BlockState with(BlockState _bs, Direction newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
						return _bs.setValue(_dp, newValue);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
				}
			}.with((BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("minecraft:coral_fans"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
					.defaultBlockState(), Direction.WEST)), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getFluidState().isSource() && Math.random() < 0.7) {
			world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
				public BlockState with(BlockState _bs, Direction newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
						return _bs.setValue(_dp, newValue);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
				}
			}.with((BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("minecraft:coral_fans"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
					.defaultBlockState(), Direction.NORTH)), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getFluidState().isSource() && Math.random() < 0.7) {
			world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
				public BlockState with(BlockState _bs, Direction newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
						return _bs.setValue(_dp, newValue);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
				}
			}.with((BuiltInRegistries.BLOCK.getOrCreateTag(BlockTags.create(ResourceLocation.parse("minecraft:coral_fans"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.BLOCK.wrapAsHolder(Blocks.AIR)).value())
					.defaultBlockState(), Direction.SOUTH)), 3);
		}
	}
}
