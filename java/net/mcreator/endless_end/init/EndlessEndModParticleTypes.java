
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, EndlessEndMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MOON_BLOB = REGISTRY.register("moon_blob", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MOON_SPLAT = REGISTRY.register("moon_splat", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CANTICLE_SPORE = REGISTRY.register("canticle_spore", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STAR_SPARKLE = REGISTRY.register("star_sparkle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STAR_SWIRL = REGISTRY.register("star_swirl", () -> new SimpleParticleType(false));
}
