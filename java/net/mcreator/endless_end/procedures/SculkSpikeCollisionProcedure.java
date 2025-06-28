package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class SculkSpikeCollisionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:corrupt")))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.CORRUPTION,
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) + 10), 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 160, 1, false, false));
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 5);
		}
	}
}
