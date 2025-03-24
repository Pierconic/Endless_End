package net.mcreator.endless_end.procedures;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class YearningEyeStateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double hypotenuse = 0;
		double player_yaw = 0;
		double dx = 0;
		double dz = 0;
		double theta = 0;
		String position = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.YEARNING_EYE.get()) {
			if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation == 0) {
				position = (new Object() {
					public String getResult(LevelAccessor world, Vec3 pos, String _command) {
						StringBuilder _result = new StringBuilder();
						if (world instanceof ServerLevel _level) {
							CommandSource _dataConsumer = new CommandSource() {
								@Override
								public void sendSystemMessage(Component message) {
									_result.append(message.getString());
								}

								@Override
								public boolean acceptsSuccess() {
									return true;
								}

								@Override
								public boolean acceptsFailure() {
									return true;
								}

								@Override
								public boolean shouldInformAdmins() {
									return false;
								}
							};
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
						}
						return _result.toString();
					}
				}.getResult(world, new Vec3(x, y, z), "locate structure ancient_city")).replace(" ~, ", "");
				if (position.contains("[") && position.contains("]")) {
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.Stronghold_X = new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(position.substring((int) position.indexOf("[") + "[".length(), (int) position.indexOf(",")));
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.Stronghold_Z = new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(position.substring((int) position.indexOf(",") + ",".length(), (int) position.indexOf("]")));
						_vars.syncPlayerVariables(entity);
					}
				}
			}
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.Eyeball_Agitation = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation + 1;
				_vars.syncPlayerVariables(entity);
			}
			dx = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Stronghold_X;
			dz = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Stronghold_Z;
			hypotenuse = Math.sqrt(Math.pow(entity.getX() - dx, 2) + Math.pow(entity.getZ() - dz, 2));
			theta = Math.asin((entity.getX() - dx) / hypotenuse) * 57.2957795;
			if (hypotenuse < 8 || 0 < entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ProximityPower) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.Eyeball_Agitation = 10;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.ProximityPower = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ProximityPower + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (1 == entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ProximityPower) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.charge")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:yearning_eye.charge")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).ProximityPower >= 130) {
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
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.ProximityPower = 0;
						_vars.syncPlayerVariables(entity);
					}
				}
			} else {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.PulseCooldown = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).PulseCooldown + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (hypotenuse < 128) {
					if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).PulseCooldown > 40) {
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
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.PulseCooldown = 0;
							_vars.syncPlayerVariables(entity);
						}
					}
				} else if (hypotenuse < 1000) {
					if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).PulseCooldown > 80) {
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
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.PulseCooldown = 0;
							_vars.syncPlayerVariables(entity);
						}
					}
				} else {
					if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).PulseCooldown > 120) {
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
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.PulseCooldown = 0;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
		} else if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation > 0) {
			{
				EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
				_vars.Eyeball_Agitation = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Eyeball_Agitation - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
