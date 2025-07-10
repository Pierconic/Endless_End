package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class EssenceLeechProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double armor = 0;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:essence_immune"))) && entity instanceof LivingEntity) {
			if (entity.getTicksFrozen() < 1800) {
				entity.setTicksFrozen((int) (entity.getTicksFrozen() + 10));
			}
			if (Math.random() < 0.07) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.hurt")), SoundSource.NEUTRAL, (float) 0.5, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.vex.hurt")), SoundSource.NEUTRAL, (float) 0.5, (float) 0.8, false);
					}
				}
			}
			if (entity instanceof Player && (entity instanceof Player _plr ? _plr.experienceLevel : 0) > 0) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(-(3));
				if (Math.random() < 0.1) {
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 1);
				}
			} else {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 4);
			}
		}
	}
}
