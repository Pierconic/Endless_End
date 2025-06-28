
package net.mcreator.endless_end.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.DoorBlock;

public class VioletDoorBlock extends DoorBlock {
	public VioletDoorBlock() {
		super(BlockSetType.OAK, BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CHERRY_WOOD).strength(5f).requiresCorrectToolForDrops().dynamicShape());
	}
}
