package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class AmnesicSpreadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean success = false;
		if (Math.random() < 0.02) {
			sx = Mth.nextInt(RandomSource.create(), -1, 1);
			sy = Mth.nextInt(RandomSource.create(), -1, 1);
			sz = Mth.nextInt(RandomSource.create(), -1, 1);
			if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_stone")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 0)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_planks")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 1)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_bricks")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 2)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_cobble")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 3)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_fancy")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 4)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_organic")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 5)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_gourd")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 6)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_wood")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 7)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_polish")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 8)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_sediment")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 9)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_shelf")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 10)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_table")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 11)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_blocks")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 12)), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_breakable")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
				success = true;
			} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_ore")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.CONVERTED_AMNESOCLAST.get().defaultBlockState(), "blockstate", 13)), 3);
				success = true;
			} else if (!(world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_immune")))) {
				world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), EndlessEndModBlocks.AMNESOCLAST.get().defaultBlockState(), 3);
				success = true;
			}
			if (success) {
				world.levelEvent(2001, BlockPos.containing(x + sx, y + sy, z + sz), Block.getId(EndlessEndModBlocks.AMNESOCLAST.get().defaultBlockState()));
			}
		}
	}
}
