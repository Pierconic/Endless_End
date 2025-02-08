package net.mcreator.endless_end.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GenericExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String function_body = "";
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double size = 0;
		double destructiveness = 0;
		double grittiness = 0;
		double likelihood = 0;
		double scatter_chance = 0;
		function_body = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction");
		size = 5;
		destructiveness = 1;
		grittiness = 0;
		likelihood = 1;
		if (function_body.contains("$s[") && function_body.contains("]s$")) {
			size = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$s[") + "$s[".length(), (int) function_body.indexOf("]s$")));
		}
		if (function_body.contains("$sc[") && function_body.contains("]sc$")) {
			scatter_chance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$sc[") + "$sc[".length(), (int) function_body.indexOf("]sc$")));
		}
		if (function_body.contains("$d[") && function_body.contains("]d$")) {
			destructiveness = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$d[") + "$d[".length(), (int) function_body.indexOf("]d$")));
		}
		if (function_body.contains("$g[") && function_body.contains("]g$")) {
			grittiness = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$g[") + "$g[".length(), (int) function_body.indexOf("]g$")));
		}
		if (function_body.contains("$c[") && function_body.contains("]c$")) {
			size = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$c[") + "$c[".length(), (int) function_body.indexOf("]c$")));
		}
		if (Math.random() < likelihood) {
			sx = ((size + Math.round(0.1 * size)) - 1) * (-0.5);
			for (int index0 = 0; index0 < (int) (size + Math.floor(Math.round(0.1 * size) * 2)); index0++) {
				sy = ((size + Math.round(0.1 * size)) - 1) * (-0.5);
				for (int index1 = 0; index1 < (int) (size + Math.floor(Math.round(0.1 * size) * 2)); index1++) {
					sz = ((size + Math.round(0.1 * size)) - 1) * (-0.5);
					for (int index2 = 0; index2 < (int) (size + Math.floor(Math.round(0.1 * size) * 2)); index2++) {
						if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).canOcclude()
								&& (Math.abs(sx) <= destructiveness * 0.2 && Math.abs(sy) <= size * 0.2 && Math.abs(sz) <= size * 0.2 || Math.random() < (size - (Math.abs(sx) + Math.abs(sy) + Math.abs(sz)) * 0.33) / size)) {
							if (Math.random() < scatter_chance) {
								GenericScatterProcedure.execute(world, x + sx, y + sy, z + sz);
							} else {
								if (Math.random() < 0.2 && ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:pyramid_breakable")))
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:sand_replaceable"))))) {
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.SAND.defaultBlockState(), 3);
								} else if (Math.random() < 0.2 && ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:temple_breakable")))
										|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:gravel_replaceable"))))) {
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.GRAVEL.defaultBlockState(), 3);
								} else {
									world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
								}
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
