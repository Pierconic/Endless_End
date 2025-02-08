package net.mcreator.endless_end.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class StairFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String function_body = "";
		Direction stair_direction = Direction.NORTH;
		boolean possible = false;
		boolean inverted = false;
		boolean required = false;
		BlockState main_block = Blocks.AIR.defaultBlockState();
		BlockState secondary_block = Blocks.AIR.defaultBlockState();
		BlockState tertiary_block = Blocks.AIR.defaultBlockState();
		BlockState secondary_flavor = Blocks.AIR.defaultBlockState();
		double offset = 0;
		double height = 0;
		double x_direction = 0;
		double z_direction = 0;
		double secondary_offset = 0;
		double maximum_distance = 0;
		function_body = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction");
		maximum_distance = 15;
		if (function_body.contains("$md[") && function_body.contains("]md$")) {
			maximum_distance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$md[") + "$md[".length(), (int) function_body.indexOf("]md$")));
		}
		if (function_body.contains("$m[") && function_body.contains("]m$")) {
			main_block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$m[") + "$m[".length(), (int) function_body.indexOf("]m$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$s[") && function_body.contains("]s$")) {
			secondary_block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$s[") + "$s[".length(), (int) function_body.indexOf("]s$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$sf[") && function_body.contains("]sf$")) {
			secondary_flavor = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$sf[") + "$sf[".length(), (int) function_body.indexOf("]sf$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$t[") && function_body.contains("]t$")) {
			tertiary_block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$t[") + "$t[".length(), (int) function_body.indexOf("]t$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		} else {
			tertiary_block = main_block;
		}
		if (function_body.contains("$inverted$")) {
			inverted = true;
		} else {
			inverted = false;
		}
		if (function_body.contains("$required$")) {
			required = true;
		} else {
			required = false;
		}
		possible = false;
		offset = 1;
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
			x_direction = 1;
			z_direction = 0;
			stair_direction = Direction.WEST;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST) {
			x_direction = -1;
			z_direction = 0;
			stair_direction = Direction.EAST;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH) {
			x_direction = 0;
			z_direction = -1;
			stair_direction = Direction.SOUTH;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH) {
			x_direction = 0;
			z_direction = 1;
			stair_direction = Direction.NORTH;
		}
		while (offset < maximum_distance && !possible) {
			if (world.getBlockState(BlockPos.containing(x + offset * x_direction, y - offset, z + offset * z_direction)).canOcclude()) {
				possible = true;
				height = offset + 2;
			} else {
				offset = offset + 1;
				if (offset == maximum_distance - 1 && required) {
					possible = true;
					height = offset + 2;
				}
			}
		}
		offset = 1;
		if (possible) {
			for (int index1 = 0; index1 < (int) height; index1++) {
				if ((world.getBlockState(BlockPos.containing(x + offset * x_direction, y - (offset - 1), z + offset * z_direction))).is(BlockTags.create(ResourceLocation.parse("forge:zappable")))) {
					if (Math.random() < 0.35) {
						world.setBlock(BlockPos.containing(x + offset * x_direction, y - (offset - 1), z + offset * z_direction), (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(secondary_flavor, stair_direction)), 3);
					} else {
						world.setBlock(BlockPos.containing(x + offset * x_direction, y - (offset - 1), z + offset * z_direction), (new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(secondary_block, stair_direction)), 3);
					}
					if (inverted) {
						if (Math.random() < 0.35) {
							world.setBlock(BlockPos.containing(x + offset * x_direction, y - (offset - 1), z + offset * z_direction), tertiary_block, 3);
						} else {
							world.setBlock(BlockPos.containing(x + offset * x_direction, y - (offset - 1), z + offset * z_direction), main_block, 3);
						}
					} else {
						secondary_offset = 1;
						for (int index2 = 0; index2 < (int) (height - offset); index2++) {
							if (Math.random() < 0.35) {
								world.setBlock(BlockPos.containing(x + offset * x_direction, y - ((offset + secondary_offset) - 1), z + offset * z_direction), tertiary_block, 3);
							} else {
								world.setBlock(BlockPos.containing(x + offset * x_direction, y - ((offset + secondary_offset) - 1), z + offset * z_direction), main_block, 3);
							}
							secondary_offset = secondary_offset + 1;
						}
					}
					offset = offset + 1;
				}
			}
		}
	}
}
