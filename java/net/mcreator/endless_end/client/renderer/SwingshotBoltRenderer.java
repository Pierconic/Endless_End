package net.mcreator.endless_end.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.entity.SwingshotBoltEntity;
import net.mcreator.endless_end.client.model.Modelswing_shot_bolt;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SwingshotBoltRenderer extends EntityRenderer<SwingshotBoltEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("endless_end:textures/entities/swing_shot_entity.png");
	private final Modelswing_shot_bolt model;

	public SwingshotBoltRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelswing_shot_bolt(context.bakeLayer(Modelswing_shot_bolt.LAYER_LOCATION));
	}

	@Override
	public void render(SwingshotBoltEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SwingshotBoltEntity entity) {
		return texture;
	}
}
