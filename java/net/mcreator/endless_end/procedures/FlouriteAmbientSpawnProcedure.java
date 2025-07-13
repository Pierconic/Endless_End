package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModEntities;
import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.entity.FlurryEntity;

import java.util.Comparator;

public class FlouriteAmbientSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (Math.random() < 0.008 && !(!world.getEntitiesOfClass(FlurryEntity.class, AABB.ofSize(new Vec3(x, y, z), 48, 48, 48), e -> true).isEmpty())
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty() && world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:whispering_delta"))
				&& 0 == (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip4 ? blockstate.getValue(_getip4) : -1)) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EndlessEndModEntities.FLURRY.get().spawn(_level, BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0.1, 0);
				}
			}
			if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (((Entity) world.getEntitiesOfClass(FlurryEntity.class, AABB.ofSize(new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z), 12, 12, 12), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z)).findFirst().orElse(null)) instanceof Mob _entity
						&& ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
			if (((Entity) world.getEntitiesOfClass(FlurryEntity.class, AABB.ofSize(new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z), 12, 12, 12), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z)).findFirst().orElse(null)) instanceof FlurryEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryEntity.DATA_homeX, (int) x);
			if (((Entity) world.getEntitiesOfClass(FlurryEntity.class, AABB.ofSize(new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z), 12, 12, 12), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z)).findFirst().orElse(null)) instanceof FlurryEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryEntity.DATA_homeY, (int) y);
			if (((Entity) world.getEntitiesOfClass(FlurryEntity.class, AABB.ofSize(new Vec3(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z), 12, 12, 12), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z)).findFirst().orElse(null)) instanceof FlurryEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FlurryEntity.DATA_homeZ, (int) z);
			world.setBlock(BlockPos.containing(x, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", 6)), 3);
		}
		if (0 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip25 ? blockstate.getValue(_getip25) : -1) && Math.random() < 0.02
				&& world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("endless_end:whispering_delta"))) {
			world.setBlock(BlockPos.containing(x, y, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(EndlessEndModBlocks.SPREADING_FLOURITE.get().defaultBlockState(), "blockstate", 0)), 3);
		}
	}
}
