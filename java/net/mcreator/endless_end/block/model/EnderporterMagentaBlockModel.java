package net.mcreator.endless_end.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.block.entity.EnderporterMagentaTileEntity;

public class EnderporterMagentaBlockModel extends GeoModel<EnderporterMagentaTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(EnderporterMagentaTileEntity animatable) {
		return ResourceLocation.parse("endless_end:animations/enderporter.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(EnderporterMagentaTileEntity animatable) {
		return ResourceLocation.parse("endless_end:geo/enderporter.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(EnderporterMagentaTileEntity animatable) {
		return ResourceLocation.parse("endless_end:textures/block/enderporter_magenta.png");
	}
}
