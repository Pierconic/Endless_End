
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.endless_end.client.particle.MoonSplatParticle;
import net.mcreator.endless_end.client.particle.MoonBlobParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessEndModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(EndlessEndModParticleTypes.MOON_BLOB.get(), MoonBlobParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.MOON_SPLAT.get(), MoonSplatParticle::provider);
	}
}
