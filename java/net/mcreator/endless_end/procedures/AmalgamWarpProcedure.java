package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.entity.AmalgamEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AmalgamWarpProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getOriginalDamage());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		if (entity instanceof AmalgamEntity && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			if ((entity instanceof AmalgamEntity _datEntS ? _datEntS.getEntityData().get(AmalgamEntity.DATA_spell) : "").equals("none")) {
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_spell_progress, 101);
				if (entity instanceof AmalgamEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AmalgamEntity.DATA_loop_progress, 75);
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.5 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > amount
					&& Math.random() < 0.3) {
				for (int index0 = 0; index0 < 32; index0++) {
					sx = Mth.nextInt(RandomSource.create(), -20, 20);
					sy = Mth.nextInt(RandomSource.create(), 0, 10);
					sz = Mth.nextInt(RandomSource.create(), -20, 20);
					if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + sx), (y + sy), (z + sz)), 8, 8, 8), e -> true).isEmpty()) && world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz))
							&& world.isEmptyBlock(BlockPos.containing(x + sx + 2, y + sy, z + sz)) && world.isEmptyBlock(BlockPos.containing((x + sx) - 2, y + sy, z + sz)) && world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, z + sz + 2))
							&& world.isEmptyBlock(BlockPos.containing(x + sx, y + sy, (z + sz) - 2)) && world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 2, z + sz)) && world.isEmptyBlock(BlockPos.containing(x + sx, (y + sy) - 2, z + sz))) {
						found = true;
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:randomteleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:randomteleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, 32, 1, 1, 1, 0.1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x + sx, y + sy, z + sz), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:randomteleport")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound((x + sx), (y + sy), (z + sz), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:randomteleport")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.REVERSE_PORTAL, (x + sx), (y + sy), (z + sz), 32, 1, 1, 1, 0.1);
						if (entity instanceof AmalgamEntity) {
							((AmalgamEntity) entity).setAnimation("spawn");
						}
						{
							Entity _ent = entity;
							_ent.teleportTo((x + sx), (y + sy), (z + sz));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((x + sx), (y + sy), (z + sz), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			}
		}
	}
}
