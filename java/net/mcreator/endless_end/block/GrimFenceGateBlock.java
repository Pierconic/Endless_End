
package net.mcreator.endless_end.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class GrimFenceGateBlock extends FenceGateBlock {
	public GrimFenceGateBlock() {
		super(WoodType.OAK,
				BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.COLOR_PURPLE)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.coral_block.break")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_sensor.step")),
								() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.coral_block.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_sensor.hit")),
								() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sculk_catalyst.fall"))))
						.strength(3f).requiresCorrectToolForDrops().dynamicShape().forceSolidOn());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}
}
