package net.mcreator.endless_end.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.endless_end.world.inventory.TransceiverInterfaceMenu;
import net.mcreator.endless_end.network.TransceiverInterfaceButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TransceiverInterfaceScreen extends AbstractContainerScreen<TransceiverInterfaceMenu> {
	private final static HashMap<String, Object> guistate = TransceiverInterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_toggle;

	public TransceiverInterfaceScreen(TransceiverInterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("endless_end:textures/screens/transceiver_interface.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("endless_end:textures/screens/sigilindicator.png"), this.leftPos + 25, this.topPos + 34, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.endless_end.transceiver_interface.label_send_and_recieve"), 6, 9, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_toggle = Button.builder(Component.translatable("gui.endless_end.transceiver_interface.button_toggle"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new TransceiverInterfaceButtonMessage(0, x, y, z));
				TransceiverInterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 56, 56, 20).build();
		guistate.put("button:button_toggle", button_toggle);
		this.addRenderableWidget(button_toggle);
	}
}
