
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

import net.mcreator.endless_end.entity.WeaverSpitEntity;
import net.mcreator.endless_end.entity.WeaverEntity;
import net.mcreator.endless_end.entity.TrawlerEntity;
import net.mcreator.endless_end.entity.SwingsilkBallEntity;
import net.mcreator.endless_end.entity.SwingshotBoltEntity;
import net.mcreator.endless_end.entity.SculkWormEntity;
import net.mcreator.endless_end.entity.SageEntity;
import net.mcreator.endless_end.entity.PolypEntity;
import net.mcreator.endless_end.entity.MoonJellyBallEntity;
import net.mcreator.endless_end.entity.MiniFlavorNodeEntity;
import net.mcreator.endless_end.entity.LoomerEntity;
import net.mcreator.endless_end.entity.LoomerBoltEntity;
import net.mcreator.endless_end.entity.HollowEntity;
import net.mcreator.endless_end.entity.GrazerEntity;
import net.mcreator.endless_end.entity.FlurryEntity;
import net.mcreator.endless_end.entity.FlurryChargeEntityEntity;
import net.mcreator.endless_end.entity.AmalgamEntity;
import net.mcreator.endless_end.EndlessEndMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EndlessEndModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, EndlessEndMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<GrazerEntity>> GRAZER = register("grazer",
			EntityType.Builder.<GrazerEntity>of(GrazerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.7f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HollowEntity>> HOLLOW = register("hollow",
			EntityType.Builder.<HollowEntity>of(HollowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3)

					.sized(0.6f, 2.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<MoonJellyBallEntity>> MOON_JELLY_BALL = register("moon_jelly_ball",
			EntityType.Builder.<MoonJellyBallEntity>of(MoonJellyBallEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<TrawlerEntity>> TRAWLER = register("trawler",
			EntityType.Builder.<TrawlerEntity>of(TrawlerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.5f, 1.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwingsilkBallEntity>> SWINGSILK_BALL = register("swingsilk_ball",
			EntityType.Builder.<SwingsilkBallEntity>of(SwingsilkBallEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.3f, 1.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwingshotBoltEntity>> SWINGSHOT_BOLT = register("swingshot_bolt",
			EntityType.Builder.<SwingshotBoltEntity>of(SwingshotBoltEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.25f, 0.25f));
	public static final DeferredHolder<EntityType<?>, EntityType<WeaverEntity>> WEAVER = register("weaver",
			EntityType.Builder.<WeaverEntity>of(WeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<WeaverSpitEntity>> WEAVER_SPIT = register("weaver_spit",
			EntityType.Builder.<WeaverSpitEntity>of(WeaverSpitEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.4f, 0.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<PolypEntity>> POLYP = register("polyp",
			EntityType.Builder.<PolypEntity>of(PolypEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.4f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlurryEntity>> FLURRY = register("flurry",
			EntityType.Builder.<FlurryEntity>of(FlurryEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlurryChargeEntityEntity>> FLURRY_CHARGE_ENTITY = register("flurry_charge_entity",
			EntityType.Builder.<FlurryChargeEntityEntity>of(FlurryChargeEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MiniFlavorNodeEntity>> MINI_FLAVOR_NODE = register("mini_flavor_node",
			EntityType.Builder.<MiniFlavorNodeEntity>of(MiniFlavorNodeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<AmalgamEntity>> AMALGAM = register("amalgam",
			EntityType.Builder.<AmalgamEntity>of(AmalgamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(3f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<SageEntity>> SAGE = register("sage",
			EntityType.Builder.<SageEntity>of(SageEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<LoomerBoltEntity>> LOOMER_BOLT = register("loomer_bolt",
			EntityType.Builder.<LoomerBoltEntity>of(LoomerBoltEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<LoomerEntity>> LOOMER = register("loomer",
			EntityType.Builder.<LoomerEntity>of(LoomerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(96).setUpdateInterval(3).fireImmune().sized(4f, 4f));
	public static final DeferredHolder<EntityType<?>, EntityType<SculkWormEntity>> SCULK_WORM = register("sculk_worm",
			EntityType.Builder.<SculkWormEntity>of(SculkWormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.3f, 0.4f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		GrazerEntity.init(event);
		HollowEntity.init(event);
		TrawlerEntity.init(event);
		SwingsilkBallEntity.init(event);
		WeaverEntity.init(event);
		PolypEntity.init(event);
		FlurryEntity.init(event);
		FlurryChargeEntityEntity.init(event);
		MiniFlavorNodeEntity.init(event);
		AmalgamEntity.init(event);
		SageEntity.init(event);
		LoomerEntity.init(event);
		SculkWormEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GRAZER.get(), GrazerEntity.createAttributes().build());
		event.put(HOLLOW.get(), HollowEntity.createAttributes().build());
		event.put(TRAWLER.get(), TrawlerEntity.createAttributes().build());
		event.put(SWINGSILK_BALL.get(), SwingsilkBallEntity.createAttributes().build());
		event.put(WEAVER.get(), WeaverEntity.createAttributes().build());
		event.put(POLYP.get(), PolypEntity.createAttributes().build());
		event.put(FLURRY.get(), FlurryEntity.createAttributes().build());
		event.put(FLURRY_CHARGE_ENTITY.get(), FlurryChargeEntityEntity.createAttributes().build());
		event.put(MINI_FLAVOR_NODE.get(), MiniFlavorNodeEntity.createAttributes().build());
		event.put(AMALGAM.get(), AmalgamEntity.createAttributes().build());
		event.put(SAGE.get(), SageEntity.createAttributes().build());
		event.put(LOOMER.get(), LoomerEntity.createAttributes().build());
		event.put(SCULK_WORM.get(), SculkWormEntity.createAttributes().build());
	}
}
