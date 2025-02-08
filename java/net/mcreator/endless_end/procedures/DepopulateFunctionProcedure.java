package net.mcreator.endless_end.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class DepopulateFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double main_chance = 0;
		double scale = 0;
		String main_entity = "";
		String function_body = "";
		function_body = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction");
		main_chance = 1;
		scale = 24;
		if (function_body.contains("$m[") && function_body.contains("]m$")) {
			main_entity = function_body.substring((int) function_body.indexOf("$m[") + "$m[".length(), (int) function_body.indexOf("]m$"));
		}
		if (function_body.contains("$mc[") && function_body.contains("]mc$")) {
			main_chance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$mc[") + "$mc[".length(), (int) function_body.indexOf("]mc$")));
		}
		if (function_body.contains("$s[") && function_body.contains("]s$")) {
			scale = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$s[") + "$s[".length(), (int) function_body.indexOf("]s$")));
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(scale / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((BuiltInRegistries.ENTITY_TYPE.getKey(entityiterator.getType()).toString()).equals(main_entity) && Math.random() < main_chance) {
					if (!entityiterator.level().isClientSide())
						entityiterator.discard();
				}
			}
		}
	}
}
