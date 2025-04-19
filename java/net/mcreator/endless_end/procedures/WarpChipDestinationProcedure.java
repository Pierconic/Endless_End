package net.mcreator.endless_end.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;

public class WarpChipDestinationProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double Warpcost = 0;
		double x_target = 0;
		double y_target = 0;
		double z_target = 0;
		double dimension = 0;
		String dimension_name = "";
		if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_WHITE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPWhiteZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_RED.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPRedZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_ORANGE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPOrangeZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_YELLOW.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPYellowZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_LIME.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLimeZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_GREEN.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGreenZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_LIGHT_BLUE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPLightBlueZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_CYAN.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPCyanZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_BLUE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlueZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_PURPLE.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPurpleZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_MAGENTA.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPMagentaZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_PINK.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_BROWN.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBrownZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_GRAY.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPGrayZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_DARK_GRAY.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPDarkGrayZ;
		} else if (itemstack.getItem() == EndlessEndModItems.WARP_CHIP_BLACK.get()) {
			dimension = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackDimension;
			x_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackX;
			y_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackY;
			z_target = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPBlackZ;
		}
		if (dimension == 2) {
			dimension_name = Component.translatable("warp.end").getString();
		} else if (dimension == 1) {
			dimension_name = Component.translatable("warp.nether").getString();
		} else {
			dimension_name = Component.translatable("warp.overworld").getString();
		}
		if (x_target == 0 && y_target == 0 && z_target == 0) {
			return Component.translatable("warp.missing").getString();
		}
		return ((((Component.translatable("warp.position").getString()).replace("dimension", dimension_name)).replace("%z", new java.text.DecimalFormat("#######").format(z_target))).replace("%y",
				new java.text.DecimalFormat("#######").format(y_target))).replace("%x", new java.text.DecimalFormat("#######").format(x_target));
	}
}
