package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.SwingsilkBallEntity;

import java.util.List;
import java.util.Comparator;

public class SwingsilkResetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double dx = 0;
		double distance = 0;
		double dy = 0;
		double dz = 0;
		if ((world.getBlockState(
				BlockPos.containing(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ)))
				.getBlock() == EndlessEndModBlocks.SILK_SPOOL.get()) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY,
						entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.slimeNum = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkLinked = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkX = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkY = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkZ = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.fowards_polarity = false;
			_vars.syncPlayerVariables(entity);
		}
		{
			EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
			_vars.SwingsilkEntity = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof SwingsilkBallEntity) {
					if ((entityiterator instanceof SwingsilkBallEntity _datEntS ? _datEntS.getEntityData().get(SwingsilkBallEntity.DATA_BoundPlayer) : "").equals(entity.getStringUUID())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), new ItemStack(EndlessEndModItems.SWINGSILK.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.POOF, x, y, z, 12, 0.2, 0.2, 0.2, 0.1);
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		}
	}
}
