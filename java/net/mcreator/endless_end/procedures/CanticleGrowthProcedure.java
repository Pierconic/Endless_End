package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class CanticleGrowthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double randy = 0;
		if (blockstate.getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
			if (Math.random() < 0.5
					&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get()
							|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.CANTICLE.get()
							|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get() || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get())) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lydian.tunnel")), SoundSource.NEUTRAL, (float) 0.6, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lydian.tunnel")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
					}
				}
				while ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.BLOOMING_CANTICLE.get()) {
					randy = Mth.nextInt(RandomSource.create(), 0, 5);
					if (randy == 0 && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
						{
							BlockPos _bp = BlockPos.containing(x, y + 1, z);
							BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
					} else if (randy == 1 && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
						{
							BlockPos _bp = BlockPos.containing(x, y - 1, z);
							BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
					} else if (randy == 2 && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
						{
							BlockPos _bp = BlockPos.containing(x - 1, y, z);
							BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
					} else if (randy == 3 && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.CANTICLE.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
						{
							BlockPos _bp = BlockPos.containing(x + 1, y, z);
							BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
					} else if (randy == 4 && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.CANTICLE.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
						{
							BlockPos _bp = BlockPos.containing(x, y, z + 1);
							BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
					} else if (randy == 5 && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.CANTICLE.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
						{
							BlockPos _bp = BlockPos.containing(x, y, z - 1);
							BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
			} else if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
					&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep45
							? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getep45).toString()
							: "").equals("CEILING")
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
							&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep49
									? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getep49).toString()
									: "").equals("FLOOR")
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
							&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep53
									? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep53).toString()
									: "").equals("WALL")
							&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep55
									? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep55).toString()
									: "").equals("west")
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
							&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep59
									? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep59).toString()
									: "").equals("WALL")
							&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep61
									? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep61).toString()
									: "").equals("east")
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
							&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep65
									? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep65).toString()
									: "").equals("WALL")
							&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep67
									? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep67).toString()
									: "").equals("north")
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
							&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep71
									? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep71).toString()
									: "").equals("WALL")
							&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep73
									? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep73).toString()
									: "").equals("south"))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lydian.emerge")), SoundSource.NEUTRAL, (float) 0.6, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lydian.emerge")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 0.5), (z + 0.5), 15, 0.3, 0.3, 0.3, 0.1);
				if (world.isEmptyBlock(BlockPos.containing(x + 0, y + 1, z + 0))) {
					{
						BlockPos _bp = BlockPos.containing(x + 0, y + 1, z + 0);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.LYDIAN_PETALS.get().defaultBlockState(), Direction.getRandom(RandomSource.create()))), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), "face", "floor"));
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
				if (world.isEmptyBlock(BlockPos.containing(x + 0, y - 1, z + 0))) {
					{
						BlockPos _bp = BlockPos.containing(x + 0, y - 1, z + 0);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.LYDIAN_PETALS.get().defaultBlockState(), Direction.getRandom(RandomSource.create()))), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), "face", "ceiling"));
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
				if (world.isEmptyBlock(BlockPos.containing(x + 1, y + 0, z + 0))) {
					{
						BlockPos _bp = BlockPos.containing(x + 1, y + 0, z + 0);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.LYDIAN_PETALS.get().defaultBlockState(), Direction.EAST)), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), "face", "wall"));
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
				if (world.isEmptyBlock(BlockPos.containing(x - 1, y + 0, z + 0))) {
					{
						BlockPos _bp = BlockPos.containing(x - 1, y + 0, z + 0);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.LYDIAN_PETALS.get().defaultBlockState(), Direction.WEST)), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), "face", "wall"));
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
				if (world.isEmptyBlock(BlockPos.containing(x + 0, y + 0, z - 1))) {
					{
						BlockPos _bp = BlockPos.containing(x + 0, y + 0, z - 1);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.LYDIAN_PETALS.get().defaultBlockState(), Direction.NORTH)), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), "face", "wall"));
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
				if (world.isEmptyBlock(BlockPos.containing(x + 0, y + 0, z + 1))) {
					{
						BlockPos _bp = BlockPos.containing(x + 0, y + 0, z + 1);
						BlockState _bs = (new Object() {
							public BlockState with(BlockState _bs, String _property, String _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, String _property, int _newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
								return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
							}
						}.with((new Object() {
							public BlockState with(BlockState _bs, Direction newValue) {
								Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
								if (_prop instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(newValue))
									return _bs.setValue(_dp, newValue);
								_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
								return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().contains(newValue.getAxis()) ? _bs.setValue(_ep, newValue.getAxis()) : _bs;
							}
						}.with(EndlessEndModBlocks.LYDIAN_PETALS.get().defaultBlockState(), Direction.SOUTH)), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), "face", "wall"));
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
						&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep117
								? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getep117).toString()
								: "").equals("CEILING")
						|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
								&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep121
										? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getep121).toString()
										: "").equals("FLOOR")
						|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
								&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep125
										? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep125).toString()
										: "").equals("WALL")
								&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep127
										? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep127).toString()
										: "").equals("west")
						|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
								&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep131
										? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep131).toString()
										: "").equals("WALL")
								&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep133
										? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep133).toString()
										: "").equals("east")
						|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
								&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep137
										? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep137).toString()
										: "").equals("WALL")
								&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep139
										? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep139).toString()
										: "").equals("north")
						|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
								&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep143
										? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep143).toString()
										: "").equals("WALL")
								&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep145
										? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep145).toString()
										: "").equals("south")) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = EndlessEndModBlocks.CANTICLE.get().defaultBlockState();
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
		} else if (blockstate.getBlock() == EndlessEndModBlocks.CANTICLE.get() && ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep152
						? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getep152).toString()
						: "").equals("CEILING")
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
						&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep156
								? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getep156).toString()
								: "").equals("FLOOR")
				|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
						&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep160
								? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep160).toString()
								: "").equals("WALL")
						&& ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep162
								? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getep162).toString()
								: "").equals("west")
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
						&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep166
								? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep166).toString()
								: "").equals("WALL")
						&& ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep168
								? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getep168).toString()
								: "").equals("east")
				|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
						&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep172
								? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep172).toString()
								: "").equals("WALL")
						&& ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep174
								? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getep174).toString()
								: "").equals("north")
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == EndlessEndModBlocks.LYDIAN_PETALS.get()
						&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep178
								? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep178).toString()
								: "").equals("WALL")
						&& ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _getep180
								? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getep180).toString()
								: "").equals("south"))) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = EndlessEndModBlocks.BLOOMING_CANTICLE.get().defaultBlockState();
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
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lydian.retract")), SoundSource.NEUTRAL, (float) 0.6, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:lydian.retract")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
				}
			}
			CanticleRetractProcedure.execute(world, x, y, z);
		}
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:canticle_corruptable")))) {
			{
				BlockPos _bp = BlockPos.containing(x, y + 1, z);
				BlockState _bs = EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState();
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
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:canticle_corruptable")))) {
			{
				BlockPos _bp = BlockPos.containing(x, y - 1, z);
				BlockState _bs = EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState();
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
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:canticle_corruptable")))) {
			{
				BlockPos _bp = BlockPos.containing(x - 1, y, z);
				BlockState _bs = EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState();
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
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:canticle_corruptable")))) {
			{
				BlockPos _bp = BlockPos.containing(x + 1, y, z);
				BlockState _bs = EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState();
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
		if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("forge:canticle_corruptable")))) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z + 1);
				BlockState _bs = EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState();
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
		if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("forge:canticle_corruptable")))) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z - 1);
				BlockState _bs = EndlessEndModBlocks.ROTTING_END_STONE.get().defaultBlockState();
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
