package net.mcreator.endless_end.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class GenericPillarProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String function_body = "";
		BlockState pillar_type = Blocks.AIR.defaultBlockState();
		BlockState pillar_flavor = Blocks.AIR.defaultBlockState();
		BlockState pillar_break = Blocks.AIR.defaultBlockState();
		BlockState pillar_break_flavor = Blocks.AIR.defaultBlockState();
		boolean blocked = false;
		double Offset = 0;
		double secondary_chance = 0;
		double main_chance = 0;
		double required_distance = 0;
		double sx = 0;
		double sz = 0;
		double width = 0;
		double break_distance = 0;
		function_body = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction");
		main_chance = 1;
		secondary_chance = 0;
		Offset = 0;
		if (function_body.contains("$m[") && function_body.contains("]m$")) {
			pillar_type = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$m[") + "$m[".length(), (int) function_body.indexOf("]m$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$mf[") && function_body.contains("]mf$")) {
			pillar_flavor = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$m[") + "$m[".length(), (int) function_body.indexOf("]m$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$mf[") && function_body.contains("]mf$")) {
			pillar_flavor = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$mf[") + "$mf[".length(), (int) function_body.indexOf("]mf$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$s[") && function_body.contains("]s$")) {
			pillar_break = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$s[") + "$s[".length(), (int) function_body.indexOf("]s$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
		}
		if (function_body.contains("$sf[") && function_body.contains("]sf$")) {
			pillar_break_flavor = BuiltInRegistries.BLOCK.get(ResourceLocation.parse(((function_body.substring((int) function_body.indexOf("$sf[") + "$sf[".length(), (int) function_body.indexOf("]sf$")))).toLowerCase(java.util.Locale.ENGLISH)))
					.defaultBlockState();
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
		if (function_body.contains("$sc[") && function_body.contains("]sc$")) {
			secondary_chance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$sc[") + "$sc[".length(), (int) function_body.indexOf("]sc$")));
		}
		if (function_body.contains("$w[") && function_body.contains("]w$")) {
			width = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$w[") + "$w[".length(), (int) function_body.indexOf("]w$")));
		}
		if (function_body.contains("$b[") && function_body.contains("]b$")) {
			break_distance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$b[") + "$b[".length(), (int) function_body.indexOf("]b$")));
		}
		if (function_body.contains("$rd[") && function_body.contains("]rd$")) {
			required_distance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$rd[") + "$rd[".length(), (int) function_body.indexOf("]rd$")));
		} else {
			required_distance = 0;
		}
		blocked = false;
		Offset = y - 1;
		while (!blocked && Offset > -64) {
			if (world.getBlockState(BlockPos.containing(x + 1, Offset, z)).canOcclude() && world.getBlockState(BlockPos.containing(x - 1, Offset, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, Offset, z - 1)).canOcclude()
					&& world.getBlockState(BlockPos.containing(x, Offset, z + 1)).canOcclude() || required_distance == Offset) {
				blocked = true;
			}
			sx = (width - 1) * (-0.5);
			for (int index1 = 0; index1 < (int) width; index1++) {
				sz = (width - 1) * (-0.5);
				for (int index2 = 0; index2 < (int) width; index2++) {
					if (!(world.getBlockFloorHeight(BlockPos.containing(x + sx, Offset, z + sz)) > 0) && !(Math.abs(sx) + Math.abs(sz) + 1 == width)) {
						if (break_distance - 1 == Offset % break_distance) {
							if (Math.random() < secondary_chance) {
								world.setBlock(BlockPos.containing(x + sx, Offset, z + sz), pillar_break_flavor, 3);
							} else {
								world.setBlock(BlockPos.containing(x + sx, Offset, z + sz), pillar_break, 3);
							}
						} else {
							if (Math.random() < main_chance) {
								world.setBlock(BlockPos.containing(x + sx, Offset, z + sz), pillar_flavor, 3);
							} else {
								world.setBlock(BlockPos.containing(x + sx, Offset, z + sz), pillar_type, 3);
							}
						}
					}
					sz = sz + 1;
				}
				sx = sx + 1;
			}
			Offset = Offset - 1;
		}
	}
}
