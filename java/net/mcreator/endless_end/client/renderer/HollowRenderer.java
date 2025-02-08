
package net.mcreator.endless_end.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.entity.model.HollowModel;
import net.mcreator.endless_end.entity.layer.HollowLayer;
import net.mcreator.endless_end.entity.HollowEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HollowRenderer extends GeoEntityRenderer<HollowEntity> {
	public HollowRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new HollowModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new HollowLayer(this));
	}

	@Override
	public RenderType getRenderType(HollowEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, HollowEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}

	@Override
	protected float getDeathMaxRotation(HollowEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
