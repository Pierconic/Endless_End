package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.EndlessEndMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PortalPlacementProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END && EndlessEndModVariables.MapVariables.get(world).awaiting_portal
				&& world instanceof ServerLevel _level3 && _level3.isLoaded(BlockPos.containing(0, EndlessEndModVariables.MapVariables.get(world).portal_height, 0))
				&& !(!world.getEntitiesOfClass(EnderDragon.class, AABB.ofSize(new Vec3(0, 0, 0), 1000, 1000, 1000), e -> true).isEmpty())) {
			EndlessEndModVariables.MapVariables.get(world).awaiting_portal = false;
			EndlessEndModVariables.MapVariables.get(world).syncData(world);
			EndlessEndMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("endless_end", "end_well_active"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(-8, EndlessEndModVariables.MapVariables.get(world).portal_height, -8), BlockPos.containing(-8, EndlessEndModVariables.MapVariables.get(world).portal_height, -8),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(0, EndlessEndModVariables.MapVariables.get(world).portal_height + 15, 0)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
			});
		}
	}
}
