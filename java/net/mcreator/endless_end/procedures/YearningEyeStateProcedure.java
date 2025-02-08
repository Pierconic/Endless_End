package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;

public class YearningEyeStateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double hypotenuse = 0;
		double player_yaw = 0;
		double dx = 0;
		double dz = 0;
		double theta = 0;
		dx = 0.5;
		dz = 0.5;
		hypotenuse = Math.sqrt(Math.pow(entity.getX() - dx, 2) + Math.pow(entity.getZ() - dz, 2));
		theta = Math.asin((entity.getX() - dx) / hypotenuse) * 57.2957795;
		if (hypotenuse < 8) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.Eyeball_Agitation = 10;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation < 10 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.YEARNING_EYE.get()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.Eyeball_Agitation = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation + 1;
					_vars.syncPlayerVariables(entity);
				}
			} else if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation > 0 && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.YEARNING_EYE.get())) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.Eyeball_Agitation = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation - 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.YEARNING_EYE.get()) {
				{
					final String _tagName = "Pulse";
					final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pulse") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (hypotenuse < 128) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pulse") > 40) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + ((entity.getX() - dx) / hypotenuse) * (-15), y, z + ((entity.getZ() - dz) / hypotenuse) * (-15)),
										BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.near")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((x + ((entity.getX() - dx) / hypotenuse) * (-15)), y, (z + ((entity.getZ() - dz) / hypotenuse) * (-15)), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.near")),
										SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final String _tagName = "Pulse";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				} else if (hypotenuse < 1000) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pulse") > 80) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + ((entity.getX() - dx) / hypotenuse) * (-15), y, z + ((entity.getZ() - dz) / hypotenuse) * (-15)),
										BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.closer")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((x + ((entity.getX() - dx) / hypotenuse) * (-15)), y, (z + ((entity.getZ() - dz) / hypotenuse) * (-15)),
										BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.closer")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final String _tagName = "Pulse";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pulse") > 120) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + ((entity.getX() - dx) / hypotenuse) * (-15), y, z + ((entity.getZ() - dz) / hypotenuse) * (-15)),
										BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.far")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((x + ((entity.getX() - dx) / hypotenuse) * (-15)), y, (z + ((entity.getZ() - dz) / hypotenuse) * (-15)), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.far")),
										SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							final String _tagName = "Pulse";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.YEARNING_EYE.get()) {
			if (hypotenuse < 8 || 0 < (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Energy")) {
				if (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Energy")) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.charge")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.charge")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				{
					final String _tagName = "Energy";
					final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Energy") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Energy") >= 130) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(EndlessEndModItems.EMPTY_EYE.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_eye.death")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.ender_eye.death")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, x, (y + 1), z, 10, 0.2, 0.2, 0.2, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, (y + 1), z, 5, 0.2, 0.2, 0.2, 0.1);
			}
		}
	}
}
