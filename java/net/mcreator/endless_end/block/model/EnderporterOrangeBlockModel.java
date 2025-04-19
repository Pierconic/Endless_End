package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterOrangeTileEntity;

public class EnderporterOrangeBlockModel extends GeoModel<EnderporterOrangeTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterOrangeTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterOrangeTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterOrangeTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_orange.png");
	}
}
