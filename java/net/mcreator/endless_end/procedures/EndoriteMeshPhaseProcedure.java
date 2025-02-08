package net.mcreator.endless_end.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.init.EndlessEndModBlocks;

public class EndoriteMeshPhaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockState _bs = EndlessEndModBlocks.PHASED_ENDORITE_MESH.get().defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Property<?> _propertyOld : _bso.getProperties()) {
				Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
				if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
					try {
						_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 15, 0.4, 0.4, 0.4, 0.4);
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("forge:zappable")))) {
			{
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0.5, y + 1.5, z + 0.5), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
