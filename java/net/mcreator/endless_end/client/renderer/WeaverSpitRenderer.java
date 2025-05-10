package net.mcreator.endless_end.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.endless_end.entity.WeaverSpitEntity;
import net.mcreator.endless_end.client.model.Modelweaver_spit;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class WeaverSpitRenderer extends EntityRenderer<WeaverSpitEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("endless_end:textures/entities/weaver_spit.png");
	private final Modelweaver_spit model;

	public WeaverSpitRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelweaver_spit(context.bakeLayer(Modelweaver_spit.LAYER_LOCATION));
	}

	@Override
	public void render(WeaverSpitEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(WeaverSpitEntity entity) {
		return texture;
	}
}
