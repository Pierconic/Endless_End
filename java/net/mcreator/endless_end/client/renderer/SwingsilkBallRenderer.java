
package net.mcreator.endless_end.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.SwingsilkBallEntity;
import net.mcreator.endless_end.client.model.Modelswingsilk_ball;

public class SwingsilkBallRenderer extends MobRenderer<SwingsilkBallEntity, Modelswingsilk_ball<SwingsilkBallEntity>> {
	public SwingsilkBallRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelswingsilk_ball<SwingsilkBallEntity>(context.bakeLayer(Modelswingsilk_ball.LAYER_LOCATION)), 0f);
	}

    protected int getBlockLightLevel(SwingsilkBallEntity entity, BlockPos pos) {
        return 15;
    }
    
	@Override
	public ResourceLocation getTextureLocation(SwingsilkBallEntity entity) {
		return ResourceLocation.parse("endless_end:textures/entities/swingsilk_ball.png");
	}
}
