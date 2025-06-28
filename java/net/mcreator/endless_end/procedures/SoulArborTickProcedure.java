package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SoulArborTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:soul_arbor")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:soul_arbor_barrens"))
				|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:soul_arbor_midlands"))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 0, false, false));
		}
	}
}
