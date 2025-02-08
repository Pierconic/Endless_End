package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class ProcessFlavorFunctionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String function_body = "";
		function_body = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction");
		if (function_body.startsWith("/")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						(function_body.replace("/", "")));
		} else if (function_body.startsWith("populate")) {
			PopulateFunctionProcedure.execute(world, x, y, z);
		} else if (function_body.startsWith("update")) {
			BasicUpdateTriggerProcedure.execute(world, x, y, z);
		} else if (function_body.startsWith("depopulate")) {
			DepopulateFunctionProcedure.execute(world, x, y, z);
		} else if (function_body.startsWith("explode")) {
			GenericExplosionProcedure.execute(world, x, y, z);
		} else if (function_body.startsWith("spread")) {
			SpreadFunctionProcedure.execute();
		} else if (function_body.startsWith("map")) {
			MapFunctionProcedure.execute();
		} else if (function_body.startsWith("paint")) {
			PaintFunctionProcedure.execute();
		} else if (function_body.startsWith("stair")) {
			StairFunctionProcedure.execute(world, x, y, z);
		} else if (function_body.startsWith("pillar")) {
			GenericPillarProcedure.execute(world, x, y, z);
		}
	}
}
