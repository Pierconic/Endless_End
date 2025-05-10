package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.entity.SwingsilkBallEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class SwingsilkDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkLinked) {
			if ((entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkEntity).equals("spool")) {
				{
					int _value = 0;
					BlockPos _pos = BlockPos.containing(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkX, entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkY,
							entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).SwingsilkZ);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(96 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof SwingsilkBallEntity) {
							if ((entity.getStringUUID()).equals(entityiterator instanceof SwingsilkBallEntity _datEntS ? _datEntS.getEntityData().get(SwingsilkBallEntity.DATA_BoundPlayer) : "")) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
							}
						}
					}
				}
			}
		}
	}
}
