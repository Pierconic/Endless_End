package net.mcreator.endless_end.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.endless_end.network.EndlessEndModVariables;
import net.mcreator.endless_end.init.EndlessEndModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CloneWandClickProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EndlessEndModItems.CLONE_WAND.get()) {
			if (entity.isShiftKeyDown()) {
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.WandX = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.WandY = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.WandZ = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.CloneX = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.CloneY = 0;
					_vars.syncPlayerVariables(entity);
				}
				{
					EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
					_vars.CloneZ = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Reset anchors"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.hurt")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.hurt")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
			} else {
				if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandX == 0 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandY == 0 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandZ == 0
						&& entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneX == 0 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneY == 0 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneZ == 0) {
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.WandX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.WandY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.WandZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(((("Anchor 1 Set to [a] [b] [c]".replace("[c]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandZ))).replace("[b]",
								new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandY)))
								.replace("[a]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandX)))), false);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.hurt")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.hurt")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
				} else if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneX == 0 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneY == 0 && entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneZ == 0) {
					if (entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandX <= entity.level()
							.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							&& entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandY <= entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							&& entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandZ <= entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) {
						{
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.CloneX = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
									.getX();
							_vars.syncPlayerVariables(entity);
						}
						{
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.CloneY = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
									.getY();
							_vars.syncPlayerVariables(entity);
						}
						{
							EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
							_vars.CloneZ = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
									.getZ();
							_vars.syncPlayerVariables(entity);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(((("Anchor 2 Set to [a] [b] [c]".replace("[c]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneZ))).replace("[b]",
									new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneY)))
									.replace("[a]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneX)))), false);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.hurt")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.allay.hurt")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 10);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Invalid Anchor. Second anchor must have a greater position."), false);
					}
				} else if ((entity instanceof Player _plrCldRem29 ? _plrCldRem29.getCooldowns().getCooldownPercent((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 0f) * 100 : 0) == 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										((((((((("clone [a] [b] [c] [d] [e] [f] [g] [h] [i]".replace("[i]", new java.text.DecimalFormat("####").format(entity.level()
												.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
												.replace("[h]",
														new java.text.DecimalFormat("####").format(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY())))
												.replace("[g]",
														new java.text.DecimalFormat("####").format(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX())))
												.replace("[f]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneZ)))
												.replace("[e]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneY)))
												.replace("[d]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).CloneX)))
												.replace("[c]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandZ)))
												.replace("[b]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandY)))
												.replace("[a]", new java.text.DecimalFormat("####").format(entity.getData(EndlessEndModVariables.PLAYER_VARIABLES).WandX))));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.cast_spell")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Area Cloned"), false);
					if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.WandX = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.WandY = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.WandZ = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.CloneX = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.CloneY = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						EndlessEndModVariables.PlayerVariables _vars = entity.getData(EndlessEndModVariables.PLAYER_VARIABLES);
						_vars.CloneZ = 0;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
