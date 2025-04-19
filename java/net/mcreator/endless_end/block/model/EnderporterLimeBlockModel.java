package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterLimeTileEntity;

public class EnderporterLimeBlockModel extends GeoModel<EnderporterLimeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterLimeTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterLimeTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterLimeTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_lime.png");
	}
}
