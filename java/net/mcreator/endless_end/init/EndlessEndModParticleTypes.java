
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
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TREBLE_SEED = REGISTRY.register("treble_seed", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PUFF_SPORE = REGISTRY.register("puff_spore", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PUFF_DOWNFALL = REGISTRY.register("puff_downfall", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWING_SILK_STRING_PARTICLE = REGISTRY.register("swing_silk_string_particle", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWING_SILK_STRING_PARTICLE_SMALL = REGISTRY.register("swing_silk_string_particle_small", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWING_SILK_STRING_PARTICLE_BIG = REGISTRY.register("swing_silk_string_particle_big", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWING_SILK_STRING_PARTICLE_GIANT = REGISTRY.register("swing_silk_string_particle_giant", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWING_SILK_STRING_PARTICLE_TINY = REGISTRY.register("swing_silk_string_particle_tiny", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ENDORITE_REPEL = REGISTRY.register("endorite_repel", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> VIOLET_PIP = REGISTRY.register("violet_pip", () -> new SimpleParticleType(false));
}
