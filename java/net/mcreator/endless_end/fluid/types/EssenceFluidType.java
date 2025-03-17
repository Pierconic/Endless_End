
package net.mcreator.endless_end.fluid.types;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.item.Rarity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.endless_end.init.EndlessEndModFluidTypes;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class EssenceFluidType extends FluidType {
	public EssenceFluidType() {
		super(FluidType.Properties.create().canSwim(false).canDrown(false).pathType(PathType.LAVA).adjacentPathType(null).motionScale(-0.0126D).rarity(Rarity.UNCOMMON).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:essence.empty"))).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("endless_end:block/essence_still");
			private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("endless_end:block/essence_flow");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}
		}, EndlessEndModFluidTypes.ESSENCE_TYPE.get());
	}
}
