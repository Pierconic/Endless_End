package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

import java.util.List;
import java.util.Comparator;

public class SpitefulEyeUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean found = false;
		boolean triggered = false;
		found = false;
		triggered = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player && !(entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(EndlessEndModMobEffects.RADIANCE))) {
					found = true;
					if (entityiterator.level()
							.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(24)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entityiterator)).getBlockPos()
							.getX() == x
							&& entityiterator.level()
									.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(24)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entityiterator))
									.getBlockPos().getY() == y
							&& entityiterator.level()
									.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(24)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entityiterator))
									.getBlockPos().getZ() == z) {
						triggered = true;
						if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip6 ? blockstate.getValue(_getip6) : -1) == 4) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:eye_strike")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:eye_strike")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.RADIANCE, 60, 0, false, false));
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 4);
						}
					}
				}
			}
		}
		if (triggered) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip13 ? blockstate.getValue(_getip13) : -1) < 4) {
				{
					int _value = (int) ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip15 ? blockstate.getValue(_getip15) : -1) + 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip18 ? blockstate.getValue(_getip18) : -1) == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sculk.manifest")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:sculk.manifest")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		} else {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip21 ? blockstate.getValue(_getip21) : -1) > 0) {
				{
					int _value = (int) ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip23 ? blockstate.getValue(_getip23) : -1) - 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else {
				if (!found && new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "spawned")) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.SCULK.defaultBlockState(), 3);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_vein.place")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_vein.place")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
