package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CitadelPlacementProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!EndlessEndModVariables.MapVariables.get(world).citadel_placed && world instanceof ServerLevel _level1 && _level1.isLoaded(BlockPos.containing(-8, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 0, 0) - 8, -8))
				&& (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END) {
			EndlessEndModVariables.MapVariables.get(world).portal_height = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 0, 0) - 8;
			EndlessEndModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "end_well_inactive"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(-8, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 0, 0) - 8, -8),
							BlockPos.containing(-8, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 0, 0) - 8, -8), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "end_gazebo"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(98 - 5, 48 - 5, (-2) - 5), BlockPos.containing(98 - 5, 48 - 5, (-2) - 5),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
			EndlessEndModVariables.MapVariables.get(world).citadel_placed = true;
			EndlessEndModVariables.MapVariables.get(world).syncData(world);
			PillarPlacementProcedure.execute(world, (-42) - 8, (-1) - 8);
			MediumPillarPlacementProcedure.execute(world, (-34) - 7, (-25) - 7);
			SmolPillarPlacementProcedure.execute(world, (-13) - 5, (-40) - 5);
			PillarPlacementProcedure.execute(world, 12 - 8, (-40) - 8);
			MediumPillarPlacementProcedure.execute(world, 33 - 7, (-25) - 7);
			SmolPillarPlacementProcedure.execute(world, 42 - 5, 0 - 5);
			MediumPillarPlacementProcedure.execute(world, 33 - 7, 24 - 7);
			PillarPlacementProcedure.execute(world, 12 - 8, 39 - 8);
			MediumPillarPlacementProcedure.execute(world, (-13) - 7, 39 - 7);
			SmolPillarPlacementProcedure.execute(world, (-34) - 7, 24 - 7);
		}
	}
}
