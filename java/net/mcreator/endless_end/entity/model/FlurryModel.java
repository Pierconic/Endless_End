package net.mcreator.endless_end.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.animation.AnimationState;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.endless_end.entity.FlurryEntity;

public class FlurryModel extends GeoModel<FlurryEntity> {
	@Override
	public ResourceLocation getAnimationResource(FlurryEntity entity) {
		return ResourceLocation.parse("endless_end:animations/flurry.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlurryEntity entity) {
		return ResourceLocation.parse("endless_end:geo/flurry.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlurryEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(FlurryEntity animatable, long instanceId, AnimationState animationState) {
		GeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
