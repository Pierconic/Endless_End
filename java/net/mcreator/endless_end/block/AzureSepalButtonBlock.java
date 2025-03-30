
package net.mcreator.endless_end.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class AzureSepalButtonBlock extends ButtonBlock {
	public AzureSepalButtonBlock() {
		super(BlockSetType.OAK, 30,
				BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CHERRY_WOOD).strength(0.8f, 1.2f).pushReaction(PushReaction.DESTROY).dynamicShape());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
