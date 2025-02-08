package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

import java.util.List;
import java.util.Comparator;

public class EndoriteMembraneCollisionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double distance = 0;
		distance = 0;
		if (!(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 14, 14, 14), e -> true).isEmpty())) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
		} else {
			if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.UP) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (Math.abs(entityiterator.getY() - (y + 0.5)) < distance || distance == 0) {
							if (entityiterator.getY() > y + 0.5 && !(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							} else {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							}
							distance = Math.abs(entityiterator.getY() - (y + 0.5));
						}
					}
				}
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.EAST) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (Math.abs(entityiterator.getX() - (x + 0.7)) < distance || distance == 0) {
							if (entityiterator.getX() > x + 0.7 && !(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							} else {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							}
							distance = Math.abs(entityiterator.getX() - (x + 0.7));
						}
					}
				}
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.WEST) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (Math.abs(entityiterator.getX() - (x + 0.7)) < distance || distance == 0) {
							if (entityiterator.getX() < x + 0.5 && !(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							} else {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							}
							distance = Math.abs(entityiterator.getX() - (x + 0.3));
						}
					}
				}
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.DOWN) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (Math.abs(entityiterator.getY() - (y + 0.5)) < distance || distance == 0) {
							if (entityiterator.getY() < y + 0.5 && !(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							} else {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							}
							distance = Math.abs(entityiterator.getY() - (y + 0.5));
						}
					}
				}
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.SOUTH) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (Math.abs(entityiterator.getZ() - (z + 0.7)) < distance || distance == 0) {
							if (entityiterator.getZ() > z + 0.5 && !(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							} else {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							}
							distance = Math.abs(entityiterator.getZ() - (z + 0.7));
						}
					}
				}
			} else if ((new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)) == Direction.NORTH) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(14 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (Math.abs(entityiterator.getZ() - (z + 0.3)) < distance || distance == 0) {
							if (entityiterator.getZ() < z + 0.5 && !(!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), 1, 1, 1), e -> true).isEmpty())) {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.power")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							} else {
								if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOLID_ENDORITE_MEMBRANE.get()) {
									{
										BlockPos _bp = BlockPos.containing(x, y, z);
										BlockState _bs = EndlessEndModBlocks.ENDORITE_MEMBRANE.get().defaultBlockState();
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
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:membrane.depower")), SoundSource.NEUTRAL, (float) 0.4, 1, false);
										}
									}
								}
							}
							distance = Math.abs(entityiterator.getZ() - (z + 0.3));
						}
					}
				}
			}
		}
	}
}
