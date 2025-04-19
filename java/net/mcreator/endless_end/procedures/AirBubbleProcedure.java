package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

import java.util.List;
import java.util.Comparator;

public class AirBubbleProcedure {
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
				if (!(world.getBlockState(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5))).is(BlockTags.create(ResourceLocation.parse("forge:bubble_immune")))) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), Blocks.AIR.defaultBlockState(), 3);
				}
				if ((world.getBlockState(BlockPos.containing(x + x2 + 0.5, (y + yOff) - 1, z + z2 + 0.5))).getBlock() == EndlessEndModBlocks.MOLDERING_PURPUR.get() && Math.random() < 0.3) {
					world.setBlock(BlockPos.containing(x + x2 + 0.5, y + yOff, z + z2 + 0.5), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with((new Object() {
						public BlockState with(BlockState _bs, String _property, String _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof EnumProperty _ep && _ep.getValue(_newValue).isPresent() ? _bs.setValue(_ep, (Enum) _ep.getValue(_newValue).get()) : _bs;
						}
					}.with(EndlessEndModBlocks.STRANGE_EGGS.get().defaultBlockState(), "face", "floor")), "blockstate", Mth.nextInt(RandomSource.create(), 1, 3))), 3);
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
