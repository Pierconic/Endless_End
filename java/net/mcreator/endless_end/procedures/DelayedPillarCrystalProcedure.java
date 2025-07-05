package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;
import net.mcreator.endless_end.EndlessEndMod;

import java.util.List;
import java.util.Comparator;

public class DelayedPillarCrystalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double delay) {
		if (entity == null)
			return;
		EndlessEndMod.queueServerWork((int) delay, () -> {
			if (world.isEmptyBlock(BlockPos.containing(x, y, z)) || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:amnesic_breakable")))) {
				{
					final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entity.getX()), (1.1 + entity.getY()), (entity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getX()), (1.1 + entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				world.setBlock(BlockPos.containing(x, y, z), EndlessEndModBlocks.FLURRY_CRYSTALS.get().defaultBlockState(), 3);
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(EndlessEndModBlocks.FLURRY_CRYSTALS.get().defaultBlockState()));
			}
		});
	}
}
