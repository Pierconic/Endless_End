
package net.mcreator.endless_end.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.DiskFeature;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.endless_end.procedures.CanticleEdgeProcedure;

public class CanticlePatchFeature extends DiskFeature {
	public CanticlePatchFeature() {
		super(DiskConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!CanticleEdgeProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
