
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.endless_end.client.renderer.WeaverSpitRenderer;
import net.mcreator.endless_end.client.renderer.WeaverRenderer;
import net.mcreator.endless_end.client.renderer.TrawlerRenderer;
import net.mcreator.endless_end.client.renderer.SwingsilkBallRenderer;
import net.mcreator.endless_end.client.renderer.SwingshotBoltRenderer;
import net.mcreator.endless_end.client.renderer.PolypRenderer;
import net.mcreator.endless_end.client.renderer.HollowRenderer;
import net.mcreator.endless_end.client.renderer.GrazerRenderer;
import net.mcreator.endless_end.client.renderer.FlurryRenderer;
import net.mcreator.endless_end.client.renderer.FlurryChargeEntityRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessEndModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EndlessEndModEntities.GRAZER.get(), GrazerRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.HOLLOW.get(), HollowRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.MOON_JELLY_BALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.TRAWLER.get(), TrawlerRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.SWINGSILK_BALL.get(), SwingsilkBallRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.SWINGSHOT_BOLT.get(), SwingshotBoltRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.WEAVER.get(), WeaverRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.WEAVER_SPIT.get(), WeaverSpitRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.POLYP.get(), PolypRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.FLURRY.get(), FlurryRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.FLURRY_CHARGE_ENTITY.get(), FlurryChargeEntityRenderer::new);
	}
}
