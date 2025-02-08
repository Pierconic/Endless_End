
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.endless_end.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.endless_end.network.GhostModeMessage;
import net.mcreator.endless_end.network.AscendUpwardsMessage;
import net.mcreator.endless_end.network.AscendRightMessage;
import net.mcreator.endless_end.network.AscendLeftMessage;
import net.mcreator.endless_end.network.AscendForwardsMessage;
import net.mcreator.endless_end.network.AscendDownwardsMessage;
import net.mcreator.endless_end.network.AscendBackwardsMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EndlessEndModKeyMappings {
	public static final KeyMapping GHOST_MODE = new KeyMapping("key.endless_end.ghost_mode", GLFW.GLFW_KEY_J, "key.categories.spectator") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new GhostModeMessage(0, 0));
				GhostModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				GHOST_MODE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - GHOST_MODE_LASTPRESS);
				PacketDistributor.sendToServer(new GhostModeMessage(1, dt));
				GhostModeMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ASCEND_UPWARDS = new KeyMapping("key.endless_end.ascend_upwards", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AscendUpwardsMessage(0, 0));
				AscendUpwardsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ASCEND_UPWARDS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ASCEND_UPWARDS_LASTPRESS);
				PacketDistributor.sendToServer(new AscendUpwardsMessage(1, dt));
				AscendUpwardsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ASCEND_DOWNWARDS = new KeyMapping("key.endless_end.ascend_downwards", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AscendDownwardsMessage(0, 0));
				AscendDownwardsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ASCEND_DOWNWARDS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ASCEND_DOWNWARDS_LASTPRESS);
				PacketDistributor.sendToServer(new AscendDownwardsMessage(1, dt));
				AscendDownwardsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ASCEND_FORWARDS = new KeyMapping("key.endless_end.ascend_forwards", GLFW.GLFW_KEY_W, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AscendForwardsMessage(0, 0));
				AscendForwardsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ASCEND_FORWARDS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ASCEND_FORWARDS_LASTPRESS);
				PacketDistributor.sendToServer(new AscendForwardsMessage(1, dt));
				AscendForwardsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ASCEND_BACKWARDS = new KeyMapping("key.endless_end.ascend_backwards", GLFW.GLFW_KEY_S, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AscendBackwardsMessage(0, 0));
				AscendBackwardsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ASCEND_BACKWARDS_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ASCEND_BACKWARDS_LASTPRESS);
				PacketDistributor.sendToServer(new AscendBackwardsMessage(1, dt));
				AscendBackwardsMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ASCEND_LEFT = new KeyMapping("key.endless_end.ascend_left", GLFW.GLFW_KEY_A, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AscendLeftMessage(0, 0));
				AscendLeftMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ASCEND_LEFT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ASCEND_LEFT_LASTPRESS);
				PacketDistributor.sendToServer(new AscendLeftMessage(1, dt));
				AscendLeftMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ASCEND_RIGHT = new KeyMapping("key.endless_end.ascend_right", GLFW.GLFW_KEY_D, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new AscendRightMessage(0, 0));
				AscendRightMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ASCEND_RIGHT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ASCEND_RIGHT_LASTPRESS);
				PacketDistributor.sendToServer(new AscendRightMessage(1, dt));
				AscendRightMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long GHOST_MODE_LASTPRESS = 0;
	private static long ASCEND_UPWARDS_LASTPRESS = 0;
	private static long ASCEND_DOWNWARDS_LASTPRESS = 0;
	private static long ASCEND_FORWARDS_LASTPRESS = 0;
	private static long ASCEND_BACKWARDS_LASTPRESS = 0;
	private static long ASCEND_LEFT_LASTPRESS = 0;
	private static long ASCEND_RIGHT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(GHOST_MODE);
		event.register(ASCEND_UPWARDS);
		event.register(ASCEND_DOWNWARDS);
		event.register(ASCEND_FORWARDS);
		event.register(ASCEND_BACKWARDS);
		event.register(ASCEND_LEFT);
		event.register(ASCEND_RIGHT);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				GHOST_MODE.consumeClick();
				ASCEND_UPWARDS.consumeClick();
				ASCEND_DOWNWARDS.consumeClick();
				ASCEND_FORWARDS.consumeClick();
				ASCEND_BACKWARDS.consumeClick();
				ASCEND_LEFT.consumeClick();
				ASCEND_RIGHT.consumeClick();
			}
		}
	}
}
