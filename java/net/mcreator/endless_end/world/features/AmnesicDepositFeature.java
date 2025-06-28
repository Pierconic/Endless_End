
package net.mcreator.endless_end.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.ReplaceSphereConfiguration;
import net.minecraft.world.level.levelgen.feature.ReplaceBlobsFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.endless_end.procedures.RemnantScatterProcedure;

public class AmnesicDepositFeature extends ReplaceBlobsFeature {
	public AmnesicDepositFeature() {
		super(ReplaceSphereConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<ReplaceSphereConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!RemnantScatterProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
