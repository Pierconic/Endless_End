
package net.mcreator.endless_end.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class AzureSepalStairsBlock extends StairBlock {
	public AzureSepalStairsBlock() {
		super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.CHERRY_WOOD).strength(5f).requiresCorrectToolForDrops().dynamicShape());
	}

	@Override
	public float getExplosionResistance() {
		return 5f;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
