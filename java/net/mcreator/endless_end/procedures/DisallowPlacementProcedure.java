package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;

public class DisallowPlacementProcedure {
	public static boolean execute(BlockState blockstate) {
		if (blockstate.is(BlockTags.create(ResourceLocation.parse("forge:lydian_placeable")))) {
			return true;
		}
		return false;
	}
}
