
package net.mcreator.endless_end.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class AzureSepalSlabBlock extends SlabBlock {
	public AzureSepalSlabBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CHERRY_WOOD).strength(5f).dynamicShape());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
