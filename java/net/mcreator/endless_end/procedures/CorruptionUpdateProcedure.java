package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CorruptionUpdateProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:corrupt")))) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("deep_dark")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("deep_dark"))
					|| (entity.getBlockStateOn()).is(BlockTags.create(ResourceLocation.parse("forge:corruptable")))) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.Corruption = (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0) + 2;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity instanceof Player) {
				if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Corruption > (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION)
						? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration()
						: 0)) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MILK_BUCKET
							|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.MILK_BUCKET) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.CORRUPTION, (int) entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Corruption, 0, false, true));
					} else if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z)) && world instanceof Level _lvl16 && _lvl16.isDay() && !world.getLevelData().isRaining()
							&& (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD) {
						{
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.Corruption = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EndlessEndModMobEffects.CORRUPTION) ? _livEnt.getEffect(EndlessEndModMobEffects.CORRUPTION).getDuration() : 0;
							_vars.syncPlayerVariables(entity);
						}
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(EndlessEndModMobEffects.CORRUPTION, (int) entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).Corruption, 0, false, true));
					}
				}
			}
		}
	}
}
