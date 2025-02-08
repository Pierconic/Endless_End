package net.mcreator.endless_end.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VinePlacementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double chance = 0;
		double number = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		chance = 1;
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.NORTH) && Math.random() < chance && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z - 1)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ vine[south=true]");
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.SOUTH) && Math.random() < chance && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, (z + 1)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ vine[north=true]");
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.EAST) && Math.random() < chance && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x + 1), y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ vine[west=true]");
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), Direction.WEST) && Math.random() < chance && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((x - 1), y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ vine[east=true]");
		}
	}
}
