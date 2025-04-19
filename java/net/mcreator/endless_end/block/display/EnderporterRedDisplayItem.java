package net.mcreator.endless_end.block.display;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import net.mcreator.endless_end.block.renderer.EnderporterRedDisplayItemRenderer;

import java.util.function.Consumer;
import java.util.Properties;

public class EnderporterRedDisplayItem extends BlockItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public EnderporterRedDisplayItem(Block block, Properties settings) {
		super(block, settings);
	}

	private PlayState predicate(AnimationState event) {
		return PlayState.CONTINUE;
	}

	@Override
	public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
		consumer.accept(new GeoRenderProvider() {
			private EnderporterRedDisplayItemRenderer renderer;

			@Override
			public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
				if (this.renderer == null)
					this.renderer = new EnderporterRedDisplayItemRenderer();
				return this.renderer;
			}
		});
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
