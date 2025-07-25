package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

import java.util.List;
import java.util.Comparator;

public class SculkAirBubbleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double radius, double radx, double rady, double radz) {
		double counter = 0;
		double x2 = 0;
		double yOff = 0;
		double z2 = 0;
		double localRad = 0;
		double counter2 = 0;
		while (counter <= 180) {
			localRad = radius * Math.cos(counter);
			yOff = rady * radius * Math.sin(counter);
			counter2 = 0;
			while (counter2 <= 360) {
				x2 = radx * localRad * Math.cos(counter2);
				z2 = radz * localRad * Math.sin(counter2);
				if (!(world.getBlockState(BlockPos.containing(x + x2 + 0.5, y + yOff + 0.5, z + z2 + 0.5))).is(BlockTags.create(ResourceLocation.parse("forge:bubble_immune")))) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff + 0.5, z + z2 + 0.5), Blocks.AIR.defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x + x2 + 0.5, (y + yOff + 0.5) - 1, z + z2 + 0.5))).getBlock() == EndlessEndModBlocks.SINGING_SAND.get() && Math.random() < 0.05) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff + 0.5, z + z2 + 0.5), EndlessEndModBlocks.SOUL_BULB.get().defaultBlockState(), 3);
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof ItemEntity) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
					}
				}
				counter2 = counter2 + 1;
			}
			counter = counter + 1;
		}
	}
}
