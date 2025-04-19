package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;
import net.mcreator.endless_end.EndlessEndMod;

public class IndigestionDamageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		EndlessEndMod.queueServerWork(5, () -> {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("endless_end:flatuence")))),
					(float) (3 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.INDIGESTION) ? _livEnt.getEffect(EndlessEndModMobEffects.INDIGESTION).getAmplifier() : 0) * 5));
		});
	}
}
