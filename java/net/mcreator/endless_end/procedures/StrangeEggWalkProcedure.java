package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.EntityTypeTags;

import net.mcreator.endless_end.init.EndlessEndModMobEffects;

public class StrangeEggWalkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getType().is(EntityTypeTags.ARTHROPOD) && !(entity instanceof EnderMan) && !(entity instanceof Endermite) && entity instanceof LivingEntity) {
			if (Math.random() < 0.05) {
				StrangeEggsAdvanceProcedure.execute(world, x, y, z, true);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.ODOR, Mth.nextInt(RandomSource.create(), 60, 120), 0));
			}
		}
	}
}
