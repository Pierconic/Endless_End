package net.mcreator.endless_end.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PopulateFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean Persistent = false;
		String main_entity = "";
		String secondary_entity = "";
		String tertiary_entity = "";
		String function_body = "";
		String command_line = "";
		double main_chance = 0;
		double secondary_chance = 0;
		double tertiary_chance = 0;
		double repeats = 0;
		double offset = 0;
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
		tertiary_chance = 0;
		repeats = 1;
		offset = 0;
		if (function_body.contains("$m[") && function_body.contains("]m$")) {
			main_entity = function_body.substring((int) function_body.indexOf("$m[") + "$m[".length(), (int) function_body.indexOf("]m$"));
		}
		if (function_body.contains("$s[") && function_body.contains("]s$")) {
			secondary_entity = function_body.substring((int) function_body.indexOf("$s[") + "$s[".length(), (int) function_body.indexOf("]s$"));
		}
		if (function_body.contains("$t[") && function_body.contains("]t$")) {
			tertiary_entity = function_body.substring((int) function_body.indexOf("$t[") + "$t[".length(), (int) function_body.indexOf("]t$"));
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
		if (function_body.contains("$tc[") && function_body.contains("]tc$")) {
			tertiary_chance = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$tc[") + "$tc[".length(), (int) function_body.indexOf("]tc$")));
		}
		if (function_body.contains("$o[") && function_body.contains("]o$")) {
			offset = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$o[") + "$o[".length(), (int) function_body.indexOf("]o$")));
		}
		if (function_body.contains("$r[") && function_body.contains("]r$")) {
			repeats = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(function_body.substring((int) function_body.indexOf("$r[") + "$r[".length(), (int) function_body.indexOf("]r$")));
		}
		if (function_body.contains("$persistent$")) {
			Persistent = true;
		} else {
			Persistent = false;
		}
		for (int index0 = 0; index0 < (int) repeats; index0++) {
			if (Math.random() < tertiary_chance) {
				command_line = "summon [entity] ~0.5 ~0.5 ~0.5".replace("[entity]", tertiary_entity);
			} else if (Math.random() < secondary_chance) {
				command_line = "summon [entity] ~0.5 ~0.5 ~0.5".replace("[entity]", secondary_entity);
			} else if (Math.random() < main_chance) {
				command_line = "summon [entity] ~0.5 ~0.5 ~0.5".replace("[entity]", main_entity);
			}
			if (Persistent) {
				command_line = command_line + " " + "{PersistenceRequired:1b}";
			}
			if (offset > 0) {
				command_line = command_line.replace("0.5", new java.text.DecimalFormat("###.##").format(Mth.nextDouble(RandomSource.create(), offset * (-1), offset)));
			}
			if (command_line.contains("summon")) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							command_line);
			}
		}
	}
}
