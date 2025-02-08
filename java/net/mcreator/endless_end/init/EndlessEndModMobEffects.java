
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.potion.RadianceMobEffect;
import net.mcreator.endless_end.potion.CorruptionMobEffect;
import net.mcreator.endless_end.potion.AscensionMobEffect;
import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, EndlessEndMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ASCENSION = REGISTRY.register("ascension", () -> new AscensionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RADIANCE = REGISTRY.register("radiance", () -> new RadianceMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CORRUPTION = REGISTRY.register("corruption", () -> new CorruptionMobEffect());
}
