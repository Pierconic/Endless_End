
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.EndlessEndMod;

public class EndlessEndModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, EndlessEndMod.MODID);
	public static final DeferredHolder<Potion, Potion> CORRUPTION_EFFECT = REGISTRY.register("corruption_effect", () -> new Potion(new MobEffectInstance(EndlessEndModMobEffects.CORRUPTION, 3600, 0, false, true)));
}
