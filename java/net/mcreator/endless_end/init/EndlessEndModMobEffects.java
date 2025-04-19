
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.procedures.ResetBlastingProcedure;
import net.mcreator.endless_end.procedures.ApplyBlastEffectProcedure;
import net.mcreator.endless_end.potion.RadianceMobEffect;
import net.mcreator.endless_end.potion.OdorMobEffect;
import net.mcreator.endless_end.potion.IndigestionMobEffect;
import net.mcreator.endless_end.potion.FragranceMobEffect;
import net.mcreator.endless_end.potion.DigestingMobEffect;
import net.mcreator.endless_end.potion.CorruptionMobEffect;
import net.mcreator.endless_end.potion.AscensionMobEffect;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber
public class EndlessEndModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, EndlessEndMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ASCENSION = REGISTRY.register("ascension", () -> new AscensionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RADIANCE = REGISTRY.register("radiance", () -> new RadianceMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CORRUPTION = REGISTRY.register("corruption", () -> new CorruptionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FRAGRANCE = REGISTRY.register("fragrance", () -> new FragranceMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ODOR = REGISTRY.register("odor", () -> new OdorMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INDIGESTION = REGISTRY.register("indigestion", () -> new IndigestionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DIGESTING = REGISTRY.register("digesting", () -> new DigestingMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(INDIGESTION)) {
			ResetBlastingProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(DIGESTING)) {
			ApplyBlastEffectProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, effectInstance.getAmplifier());
		}
	}
}
