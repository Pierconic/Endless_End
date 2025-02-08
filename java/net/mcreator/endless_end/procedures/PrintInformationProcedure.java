package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class PrintInformationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String stored_function = "";
		stored_function = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "StoredFunction");
		if (stored_function.startsWith("/") && !(stored_function).equals("/summon rabbit")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.command").getString())), false);
		} else if (stored_function.startsWith("update")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.update").getString())), false);
		} else if (stored_function.startsWith("populate")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.populate").getString())), false);
		} else if (stored_function.startsWith("spread")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.spread").getString())), false);
		} else if (stored_function.startsWith("stair")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.stair").getString())), false);
		} else if (stored_function.startsWith("explode")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.explode").getString())), false);
		} else if (stored_function.startsWith("map")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.map").getString())), false);
		} else if (stored_function.startsWith("depopulate")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.depopulate").getString())), false);
		} else if (stored_function.startsWith("paint")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.paint").getString())), false);
		} else if (stored_function.startsWith("pillar")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.explanation.pillar").getString())), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("flavor.basics").getString())), false);
		}
	}
}
