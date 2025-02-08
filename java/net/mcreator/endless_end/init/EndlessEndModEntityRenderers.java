
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.endless_end.client.renderer.HollowRenderer;
import net.mcreator.endless_end.client.renderer.GrazerRenderer;
import net.mcreator.endless_end.client.renderer.FlavorNodeRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessEndModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EndlessEndModEntities.GRAZER.get(), GrazerRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.FLAVOR_NODE.get(), FlavorNodeRenderer::new);
		event.registerEntityRenderer(EndlessEndModEntities.HOLLOW.get(), HollowRenderer::new);
	}
}
