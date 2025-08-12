package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;
import net.mcreator.endless_end.init.EndlessEndModGameRules;
import net.mcreator.endless_end.EndlessEndMod;

public class WarpChipEnergizeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double Warpcost = 0;
		double dimension = 0;
		double x_target = 0;
		double y_target = 0;
		double z_target = 0;
		String color = "";
		if (entity instanceof LivingEntity _entity)
			_entity.swing(InteractionHand.MAIN_HAND, true);
		if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_WHITE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteZ;
			color = Component.translatable("warp.white").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_RED.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedZ;
			color = Component.translatable("warp.red").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_ORANGE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeZ;
			color = Component.translatable("warp.orange").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_YELLOW.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowZ;
			color = Component.translatable("warp.yellow").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_LIME.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeZ;
			color = Component.translatable("warp.lime").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_GREEN.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenZ;
			color = Component.translatable("warp.green").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_LIGHT_BLUE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueZ;
			color = Component.translatable("warp.light_blue").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_CYAN.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanZ;
			color = Component.translatable("warp.cyan").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_BLUE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueZ;
			color = Component.translatable("warp.blue").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_PURPLE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleZ;
			color = Component.translatable("warp.purple").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_MAGENTA.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaZ;
			color = Component.translatable("warp.magenta").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_PINK.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkZ;
			color = Component.translatable("warp.pink").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_BROWN.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownZ;
			color = Component.translatable("warp.brown").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_GRAY.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayZ;
			color = Component.translatable("warp.light_gray").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_DARK_GRAY.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayZ;
			color = Component.translatable("warp.gray").getString();
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_BLACK.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackZ;
			color = Component.translatable("warp.black").getString();
		}
		if (!(x_target == 0) || !(y_target == 0) || !(z_target == 0)) {
			Warpcost = Math.round(Math.sqrt(Math.pow(Math.abs(Math.abs(z) - Math.abs(z_target)), 2) + Math.pow(Math.abs(Math.abs(x) - Math.abs(x_target)), 2)) / (world.getLevelData().getGameRules().getInt(EndlessEndModGameRules.ENDERPORTER_COST)));
			if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD && dimension == 0
					|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER && dimension == 1
					|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END && dimension == 2) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= Warpcost || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
					if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Warpcooldown > 0) {
						{
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.Warpcooldown = 0;
							_vars.syncPlayerVariables(entity);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							Entity _ent = entity;
							_ent.teleportTo(x_target, y_target, z_target);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x_target, y_target, z_target, _ent.getYRot(), _ent.getXRot());
						}
						if (entity instanceof Player _player)
							_player.giveExperienceLevels(-((int) Warpcost));
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 1, 3), _level, null, _stkprov -> {
							});
						}
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
						EndlessEndMod.queueServerWork(3, () -> {
							SecondaryTeleportProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
						});
					} else {
						{
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.Warpcooldown = 100;
							_vars.syncPlayerVariables(entity);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((((Component.translatable("warp.confirm").getString()).replace("null", new java.text.DecimalFormat("##.##").format(Warpcost))).replace("color", color))), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:machinesenses")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:machinesenses")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(((Component.translatable("warp.insufficent_power").getString()).replace("null", new java.text.DecimalFormat("##.##").format(Warpcost)))), true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:machinesenses")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:machinesenses")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(((Component.translatable("warp.dimension_missing").getString()).replace("color", color))), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_off")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_off")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((Component.translatable("warp.unset").getString()).replace("color", color))), true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_off")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone_button.click_off")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
