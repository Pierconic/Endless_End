package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import java.util.List;
import java.util.Comparator;

public class TuneBlockPlayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean success = false;
		double level = 0;
		double sx = 0;
		double sz = 0;
		double sy = 0;
		double volume = 0;
		double status = 0;
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.DOWN) {
			sy = 1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.UP) {
			sy = -1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.EAST) {
			sx = -1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.WEST) {
			sx = 1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.NORTH) {
			sz = 1;
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH) {
			sz = -1;
		}
		volume = 1;
		if ((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		} else if ((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.AMETHYST_BLOCK) {
			volume = volume + 1.5;
		}
		if ((world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.AMETHYST_BLOCK) {
			volume = volume + 1.5;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z + 1))).getBlock() == Blocks.AMETHYST_BLOCK) {
			volume = volume + 1.5;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 0, z - 1))).getBlock() == Blocks.AMETHYST_BLOCK) {
			volume = volume + 1.5;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock() == Blocks.AMETHYST_BLOCK) {
			volume = volume + 1.5;
		}
		if ((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:dampens_vibrations")))) {
			volume = volume - 0.25;
		} else if ((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 0))).getBlock() == Blocks.AMETHYST_BLOCK) {
			volume = volume + 1.5;
		}
		if (volume >= 3) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(18 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("endless_end:public_nuisance"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				}
			}
		}
		status = ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip47 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip47) : -1) % 13;
		if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_gold")))) {
			TuneGoldProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_stone")))) {
			TuneStoneProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_stars")))) {
			TuneStarsProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_shiny")))) {
			TuneShinyProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_brass")))) {
			TuneBrassProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_growl")))) {
			TuneGrowlProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_cold")))) {
			TuneColdProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_flute")))) {
			TuneFluteProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_warble")))) {
			TuneWarbleProcedure.execute(world, x, y, z, status, volume);
		} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:tune_square")))) {
			TuneSquareProcedure.execute(world, x, y, z, status, volume);
		} else {
			TuneDefaultProcedure.execute(world, x, y, z, status, volume);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.NOTE, ((x + 0.5) - sx), ((y + 0.5) - sy), ((z + 0.5) - sz), (int) Math.ceil(volume), 0.1, 0.1, 0.1, 0.1);
	}
}
