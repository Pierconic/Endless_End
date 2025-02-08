
package net.mcreator.endless_end.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.endless_end.procedures.CorruptOverlayConditionProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class CorruptHeartsOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (CorruptOverlayConditionProcedure.execute(entity)) {
			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -20, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -28, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -36, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -44, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -52, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -60, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -68, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -76, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -84, h - 40, 0, 0, 11, 11, 11, 11);

			event.getGuiGraphics().blit(ResourceLocation.parse("endless_end:textures/screens/sculk_heart.png"), w / 2 + -92, h - 40, 0, 0, 11, 11, 11, 11);

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
