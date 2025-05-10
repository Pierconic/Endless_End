package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModParticleTypes;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.TrawlerEntity;
import net.mcreator.endless_end.entity.GrazerEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GrazerInteractProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double egg_time = 0;
		if (entity instanceof GrazerEntity) {
			if (entity instanceof GrazerEntity _datEntL1 && _datEntL1.getEntityData().get(GrazerEntity.DATA_inverted)) {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS && (entity instanceof GrazerEntity _datEntI ? _datEntI.getEntityData().get(GrazerEntity.DATA_moss) : 0) == 1) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.PUFF_SPORE.get()), x, y, z, 20, 0.2, 0.2, 0.2, 0.2);
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell");
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.GOLDEN_SEPAL_LEAVES.get().defaultBlockState()));
					if (entity instanceof GrazerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GrazerEntity.DATA_moss, 0);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (world instanceof ServerLevel _level) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(2, _level, null, _stkprov -> {
							});
						}
					}
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.CHORUS_FRUIT) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.composter.fill")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.composter.fill")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.COMPOSTER, x, y, z, 10, 0.5, 0.5, 0.5, 0.2);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					}
					if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(EndlessEndModMobEffects.RADIANCE))) {
						egg_time = Mth.nextInt(RandomSource.create(), 600, 1800);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) egg_time, 1, false, true));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.RADIANCE, (int) egg_time, 0, false, false));
					}
				}
			} else {
				if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS && (entity instanceof GrazerEntity _datEntI ? _datEntI.getEntityData().get(GrazerEntity.DATA_moss) : 0) == 1) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EndlessEndModBlocks.CANTICLE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), x, y, z, 20, 0.2, 0.2, 0.2, 0.2);
					if (entity instanceof GrazerEntity animatable)
						animatable.setTexture("grazer_shell");
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
					if (entity instanceof GrazerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GrazerEntity.DATA_moss, 0);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (world instanceof ServerLevel _level) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(2, _level, null, _stkprov -> {
							});
						}
					}
				} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.CHORUS_FRUIT) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.composter.fill")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.composter.fill")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.brewing_stand.brew")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.COMPOSTER, x, y, z, 10, 0.5, 0.5, 0.5, 0.2);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					}
					if (!(entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(EndlessEndModMobEffects.RADIANCE))) {
						egg_time = Mth.nextInt(RandomSource.create(), 600, 1800);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) egg_time, 1, false, true));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.RADIANCE, (int) egg_time, 0, false, false));
					}
				}
			}
		} else if (entity instanceof TrawlerEntity) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS && (entity instanceof TrawlerEntity _datEntI ? _datEntI.getEntityData().get(TrawlerEntity.DATA_moss) : 0) > 0) {
				if ((entity instanceof TrawlerEntity _datEntI ? _datEntI.getEntityData().get(TrawlerEntity.DATA_moss) : 0) == 2) {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 3); index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EndlessEndModBlocks.LYDIAN_PETALS.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), x, y, z, 20, 0.2, 0.2, 0.2, 0.2);
					if (entity instanceof TrawlerEntity animatable)
						animatable.setTexture("trawler_shell_canticle");
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
					if (entity instanceof TrawlerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(TrawlerEntity.DATA_moss, 1);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (world instanceof ServerLevel _level) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(2, _level, null, _stkprov -> {
							});
						}
					}
				} else {
					if (sourceentity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 2, 3); index1++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EndlessEndModBlocks.CANTICLE.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.mooshroom.shear")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (EndlessEndModParticleTypes.CANTICLE_SPORE.get()), x, y, z, 30, 0.4, 0.4, 0.4, 0.2);
					if (entity instanceof TrawlerEntity animatable)
						animatable.setTexture("trawler_shell");
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
					world.levelEvent(2001, BlockPos.containing(x, y + 1, z), Block.getId(EndlessEndModBlocks.CANTICLE.get().defaultBlockState()));
					if (entity instanceof TrawlerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(TrawlerEntity.DATA_moss, 0);
					if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
						if (world instanceof ServerLevel _level) {
							(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(4, _level, null, _stkprov -> {
							});
						}
					}
				}
			}
		}
	}
}
