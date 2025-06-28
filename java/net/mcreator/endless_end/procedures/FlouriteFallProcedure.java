package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FlouriteFallProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getDistance());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double distance) {
		execute(null, world, x, y, z, entity, distance);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double distance) {
		if (entity == null)
			return;
		double newstate = 0;
		if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:flourite_immune"))) && (world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getBlock() == EndlessEndModBlocks.FLOURITE.get()) {
			if (distance > 8) {
				world.setBlock(BlockPos.containing(x, y - 0.5, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", 1)), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:crystal.hit.hard")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:crystal.hit.hard")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (distance > 3) {
				newstate = Mth.nextInt(RandomSource.create(), 2, 5);
				while (newstate == ((world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip8
						? (world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getValue(_getip8)
						: -1)) {
					newstate = Mth.nextInt(RandomSource.create(), 2, 5);
				}
				world.setBlock(BlockPos.containing(x, y - 0.5, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 2, 5))), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:crystal.hit.medium")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:crystal.hit.medium")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				newstate = Mth.nextInt(RandomSource.create(), 5, 9);
				while (newstate == ((world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip16
						? (world.getBlockState(BlockPos.containing(x, y - 0.5, z))).getValue(_getip16)
						: -1)) {
					newstate = Mth.nextInt(RandomSource.create(), 5, 9);
				}
				world.setBlock(BlockPos.containing(x, y - 0.5, z), (new Object() {
					public BlockState with(BlockState _bs, String _property, int _newValue) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
						return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
					}
				}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", Mth.nextInt(RandomSource.create(), 5, 9))), 3);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:crystal.hit.light")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:crystal.hit.light")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y + 1), (z + 0.5), 5, 2, 2, 2, 0.1);
			}
		}
	}
}
