package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;

import java.util.ArrayList;

public class TeleporterPinkUnbindProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkX == x && entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkY == y
					&& entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkZ == z
					&& ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD
							&& entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkDimension == 0
							|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER
									&& entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkDimension == 1
							|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END
									&& entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES).EPPinkDimension == 2)) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.EPPinkX = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.EPPinkY = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entityiterator.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.EPPinkZ = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				if (entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EndlessEndModItems.WARP_CHIP_PINK.get())) : false) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Pink Enderporter has been unbound"), true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.off")),
									SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:transponder.transmission.off")), SoundSource.NEUTRAL,
									1, 1, false);
						}
					}
				}
			}
		}
	}
}
