package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class FlurryRodRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean success = false;
		double xAxis = 0;
		double yAxis = 0;
		double zAxis = 0;
		double Offset = 0;
		double localRad = 0;
		double initRad = 0;
		double counter2 = 0;
		double z2 = 0;
		double max_height = 0;
		double extraLocalRad = 0;
		double x2 = 0;
		double yOff = 0;
		double bubble_rad = 0;
		double core_rad = 0;
		double counter = 0;
		double repRad = 0;
		if (entity.isShiftKeyDown()) {
			bubble_rad = Mth.nextInt(RandomSource.create(), 8, 10);
			yOff = bubble_rad * (-0.5);
			for (int index0 = 0; index0 < (int) bubble_rad; index0++) {
				DelayedCrystalProcedure.execute(world, x + 1, y + yOff, z, 3);
				DelayedCrystalProcedure.execute(world, x - 1, y + yOff, z, 3);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z + 1, 3);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z - 1, 3);
				yOff = 1 + yOff;
			}
			bubble_rad = bubble_rad - 2;
			yOff = bubble_rad * (-0.5);
			for (int index1 = 0; index1 < (int) bubble_rad; index1++) {
				DelayedCrystalProcedure.execute(world, x + 1, y + yOff, z + 1, 6);
				DelayedCrystalProcedure.execute(world, x - 1, y + yOff, z - 1, 6);
				DelayedCrystalProcedure.execute(world, x + 1, y + yOff, z - 1, 6);
				DelayedCrystalProcedure.execute(world, x - 1, y + yOff, z + 1, 6);
				yOff = 1 + yOff;
			}
			bubble_rad = bubble_rad - 2;
			yOff = bubble_rad * (-0.5);
			for (int index2 = 0; index2 < (int) bubble_rad; index2++) {
				DelayedCrystalProcedure.execute(world, x + 2, y + yOff, z, 9);
				DelayedCrystalProcedure.execute(world, x - 2, y + yOff, z, 9);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z + 2, 9);
				DelayedCrystalProcedure.execute(world, x, y + yOff, z - 2, 9);
				yOff = 1 + yOff;
			}
		} else {
			if (entity.getLookAngle().y > 0.9) {
				success = FlurryRodPillarProcedure.execute(world, x, y, z, true, Mth.nextInt(RandomSource.create(), 9, 13));
			} else if (entity.getLookAngle().y < -0.9) {
				success = FlurryRodPlatformProcedure.execute(world, x, y, z, entity, Mth.nextInt(RandomSource.create(), 3, 5));
			} else {
				success = FlurryRodBridgeProcedure.execute(world, x, y - 1, z, entity.getDirection(), Mth.nextInt(RandomSource.create(), 9, 13));
			}
		}
		if (success) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				itemstack.shrink(1);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 18, 1, 1, 1, 0.1);
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:flurry.hurt")), SoundSource.NEUTRAL, (float) 0.2, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:flurry.hurt")), SoundSource.NEUTRAL, (float) 0.2, (float) 0.8, false);
				}
			}
		}
	}
}
