package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterBrownTileEntity;

public class EnderporterBrownBlockModel extends GeoModel<EnderporterBrownTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterBrownTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterBrownTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterBrownTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_brown.png");
	}
}
