package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class BlueRoseConversionProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WITHER_ROSE && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SCULK) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			EndlessEndMod.queueServerWork(10, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(Blocks.SCULK.defaultBlockState()));
			});
			EndlessEndMod.queueServerWork(20, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(Blocks.SCULK.defaultBlockState()));
			});
			EndlessEndMod.queueServerWork(30, () -> {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WITHER_ROSE && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SCULK) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = EndlessEndModBlocks.BLUE_ROSE.get().defaultBlockState();
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
						BlockState _bs = EndlessEndModBlocks.SINGING_SAND.get().defaultBlockState();
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
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SCULK.defaultBlockState()));
					world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(Blocks.SCULK.defaultBlockState()));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5), (y + 0.5), (z + 0.5), 25, 0.2, 0.2, 0.2, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.prepare_summon")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.prepare_summon")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("endless_end:i_am_not_me"));
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
			});
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOUL_BULB.get()
				&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_SOIL || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_SAND)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			EndlessEndMod.queueServerWork(10, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
			});
			EndlessEndMod.queueServerWork(20, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
			});
			EndlessEndMod.queueServerWork(30, () -> {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == EndlessEndModBlocks.SOUL_BULB.get()
						&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_SOIL || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_SAND)) {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
					world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId(Blocks.SOUL_SAND.defaultBlockState()));
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = EndlessEndModBlocks.BLUE_ROSE.get().defaultBlockState();
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
						BlockState _bs = EndlessEndModBlocks.SINGING_SAND.get().defaultBlockState();
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
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, (x + 0.5), (y + 0.5), (z + 0.5), 25, 0.2, 0.2, 0.2, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.prepare_summon")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker.prepare_summon")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 16, 16, 16), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("endless_end:i_am_not_me"));
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
			});
		}
	}
}
