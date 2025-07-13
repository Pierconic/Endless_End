package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;

public class MembranePushProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double repulsion = 0;
		double max = 0;
		repulsion = 1.65;
		if (entity.onGround()) {
			repulsion = 3;
		}
		if (entity instanceof ThrownTrident || entity instanceof SpectralArrow || entity instanceof Arrow) {
			repulsion = 1;
		}
		if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.DOWN && entity.getDeltaMovement().y() < 0) {
			if (entity.getDeltaMovement().y() < -0.6) {
				repulsion = 0.8;
			} else if (entity.getDeltaMovement().y() > -0.1) {
				repulsion = 6;
			}
			if (entity.getDeltaMovement().y() < -0.24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			for (int index0 = 0; index0 < 4; index0++) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0, (Math.abs(entity.getDeltaMovement().y()) * repulsion), 0);
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (Math.abs(entity.getDeltaMovement().y()) * repulsion), (entity.getDeltaMovement().z())));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.UP && entity.getDeltaMovement().y() > 0) {
			if (Math.abs(entity.getDeltaMovement().y()) > 0.5) {
				repulsion = 0.95;
			}
			if (Math.abs(entity.getDeltaMovement().y()) > 0.24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			for (int index1 = 0; index1 < 4; index1++) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0, (Math.abs(entity.getDeltaMovement().y()) * repulsion), 0);
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (Math.abs(entity.getDeltaMovement().y()) * (-1) * repulsion), (entity.getDeltaMovement().z())));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.SOUTH && entity.getDeltaMovement().z() > 0) {
			if (Math.abs(entity.getDeltaMovement().z()) > 3) {
				repulsion = 0.8;
			}
			if (Math.abs(entity.getDeltaMovement().z()) > 0.24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (entity.onGround()) {
				entity.setOnGround(false);
			}
			for (int index2 = 0; index2 < 4; index2++) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0, 0, (Math.abs(entity.getDeltaMovement().z()) * (-1) * repulsion));
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (Math.abs(entity.getDeltaMovement().z()) * (-1) * repulsion)));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.NORTH && entity.getDeltaMovement().z() < 0) {
			if (Math.abs(entity.getDeltaMovement().z()) > 3) {
				repulsion = 0.8;
			}
			if (Math.abs(entity.getDeltaMovement().z()) > 0.24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (entity.onGround()) {
				entity.setOnGround(false);
			}
			for (int index3 = 0; index3 < 4; index3++) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), 0, 0, (Math.abs(entity.getDeltaMovement().z()) * repulsion));
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (Math.abs(entity.getDeltaMovement().z()) * repulsion)));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.WEST && entity.getDeltaMovement().x() < 0) {
			if (Math.abs(entity.getDeltaMovement().x()) > 3) {
				repulsion = 0.8;
			}
			if (Math.abs(entity.getDeltaMovement().x()) > 0.24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (entity.onGround()) {
				entity.setOnGround(false);
			}
			for (int index4 = 0; index4 < 4; index4++) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), (Math.abs(entity.getDeltaMovement().x()) * repulsion), 0, 0);
			}
			entity.setDeltaMovement(new Vec3((Math.abs(entity.getDeltaMovement().x()) * repulsion), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
		} else if ((new Object() {
			public Direction getDirection(BlockState _bs) {
				Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (_prop instanceof DirectionProperty _dp)
					return _bs.getValue(_dp);
				_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
				return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
			}
		}.getDirection(blockstate)) == Direction.EAST && entity.getDeltaMovement().x() > 0) {
			if (Math.abs(entity.getDeltaMovement().x()) > 3) {
				repulsion = 0.8;
			}
			if (Math.abs(entity.getDeltaMovement().x()) > 0.24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:endorite.repel")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (entity.onGround()) {
				entity.setOnGround(false);
			}
			for (int index5 = 0; index5 < 4; index5++) {
				world.addParticle((SimpleParticleType) (EndlessEndModParticleTypes.ENDORITE_REPEL.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), (y + Mth.nextDouble(RandomSource.create(), 0, 1)),
						(z + Mth.nextDouble(RandomSource.create(), 0, 1)), (Math.abs(entity.getDeltaMovement().x()) * (-1) * repulsion), 0, 0);
			}
			entity.setDeltaMovement(new Vec3((Math.abs(entity.getDeltaMovement().x()) * (-1) * repulsion), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
		}
	}
}
