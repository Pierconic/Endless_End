
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.endless_end.client.particle.TrebleSeedParticle;
import net.mcreator.endless_end.client.particle.SwingSilkStringParticleTinyParticle;
import net.mcreator.endless_end.client.particle.SwingSilkStringParticleSmallParticle;
import net.mcreator.endless_end.client.particle.SwingSilkStringParticleParticle;
import net.mcreator.endless_end.client.particle.SwingSilkStringParticleGiantParticle;
import net.mcreator.endless_end.client.particle.SwingSilkStringParticleBigParticle;
import net.mcreator.endless_end.client.particle.StarSwirlParticle;
import net.mcreator.endless_end.client.particle.StarSparkleParticle;
import net.mcreator.endless_end.client.particle.PuffSporeParticle;
import net.mcreator.endless_end.client.particle.PuffDownfallParticle;
import net.mcreator.endless_end.client.particle.MoonSplatParticle;
import net.mcreator.endless_end.client.particle.MoonBlobParticle;
import net.mcreator.endless_end.client.particle.CanticleSporeParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EndlessEndModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(EndlessEndModParticleTypes.MOON_BLOB.get(), MoonBlobParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.MOON_SPLAT.get(), MoonSplatParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.CANTICLE_SPORE.get(), CanticleSporeParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.STAR_SPARKLE.get(), StarSparkleParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.STAR_SWIRL.get(), StarSwirlParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.TREBLE_SEED.get(), TrebleSeedParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.PUFF_SPORE.get(), PuffSporeParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.PUFF_DOWNFALL.get(), PuffDownfallParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE.get(), SwingSilkStringParticleParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_SMALL.get(), SwingSilkStringParticleSmallParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_BIG.get(), SwingSilkStringParticleBigParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_GIANT.get(), SwingSilkStringParticleGiantParticle::provider);
		event.registerSpriteSet(EndlessEndModParticleTypes.SWING_SILK_STRING_PARTICLE_TINY.get(), SwingSilkStringParticleTinyParticle::provider);
	}
}
