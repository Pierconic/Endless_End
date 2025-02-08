
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.endless_end.entity.HollowEntity;
import net.mcreator.endless_end.entity.GrazerEntity;
import net.mcreator.endless_end.entity.FlavorNodeEntity;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, EndlessEndMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<GrazerEntity>> GRAZER = register("grazer",
			EntityType.Builder.<GrazerEntity>of(GrazerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlavorNodeEntity>> FLAVOR_NODE = register("flavor_node",
			EntityType.Builder.<FlavorNodeEntity>of(FlavorNodeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(1024).setUpdateInterval(3).fireImmune().sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<HollowEntity>> HOLLOW = register("hollow",
			EntityType.Builder.<HollowEntity>of(HollowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

					.sized(0.6f, 2.4f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		GrazerEntity.init(event);
		FlavorNodeEntity.init(event);
		HollowEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GRAZER.get(), GrazerEntity.createAttributes().build());
		event.put(FLAVOR_NODE.get(), FlavorNodeEntity.createAttributes().build());
		event.put(HOLLOW.get(), HollowEntity.createAttributes().build());
	}
}
