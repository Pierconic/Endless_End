package net.mcreator.endless_end.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.endless_end.world.inventory.FlavorInterfaceMenu;
import net.mcreator.endless_end.procedures.ReturnPersistenceProcedure;
import net.mcreator.endless_end.procedures.ReturnMechanicalProcedure;
import net.mcreator.endless_end.procedures.ReturnDisplayNameProcedure;
import net.mcreator.endless_end.procedures.ReturnCurrentReplacementProcedure;
import net.mcreator.endless_end.procedures.ReturnCurrentFunctionProcedure;
import net.mcreator.endless_end.network.FlavorInterfaceButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FlavorInterfaceScreen extends AbstractContainerScreen<FlavorInterfaceMenu> {
	private final static HashMap<String, Object> guistate = FlavorInterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox HackInput;
	EditBox ReplacementInput;
	EditBox DelayInput;
	EditBox NameInput;
	Checkbox PersistenceBox;
	Checkbox RedstoneBox;
	Button button_input_function;
	Button button_run_function;
	ImageButton imagebutton_flavor_buttons_cycle;
	ImageButton imagebutton_flavor_buttons_question;
	ImageButton imagebutton_flavor_buttons_quill;

	public FlavorInterfaceScreen(FlavorInterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 205;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("endless_end:textures/screens/flavor_interface.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		HackInput.render(guiGraphics, mouseX, mouseY, partialTicks);
		ReplacementInput.render(guiGraphics, mouseX, mouseY, partialTicks);
		DelayInput.render(guiGraphics, mouseX, mouseY, partialTicks);
		NameInput.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("endless_end:textures/screens/sigilindicator.png"), this.leftPos + 13, this.topPos + 167, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("endless_end:textures/screens/villager_cord_negative.png"), this.leftPos + 29, this.topPos + 125, 0, 0, 11, 11, 11, 11);

		guiGraphics.blit(ResourceLocation.parse("endless_end:textures/screens/villager_cord_negative.png"), this.leftPos + 29, this.topPos + 147, 0, 0, 11, 11, 11, 11);

		if (ReturnPersistenceProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("endless_end:textures/screens/villager_cord.png"), this.leftPos + 29, this.topPos + 124, 0, 0, 11, 11, 11, 11);
		}
		if (ReturnMechanicalProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("endless_end:textures/screens/villager_cord.png"), this.leftPos + 29, this.topPos + 147, 0, 0, 11, 11, 11, 11);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (HackInput.isFocused())
			return HackInput.keyPressed(key, b, c);
		if (ReplacementInput.isFocused())
			return ReplacementInput.keyPressed(key, b, c);
		if (DelayInput.isFocused())
			return DelayInput.keyPressed(key, b, c);
		if (NameInput.isFocused())
			return NameInput.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String HackInputValue = HackInput.getValue();
		String ReplacementInputValue = ReplacementInput.getValue();
		String DelayInputValue = DelayInput.getValue();
		String NameInputValue = NameInput.getValue();
		super.resize(minecraft, width, height);
		HackInput.setValue(HackInputValue);
		ReplacementInput.setValue(ReplacementInputValue);
		DelayInput.setValue(DelayInputValue);
		NameInput.setValue(NameInputValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnDisplayNameProcedure.execute(world, x, y, z), 44, 5, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentFunctionProcedure.execute(world, x, y, z), 8, 38, -1, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentReplacementProcedure.execute(world, x, y, z), 6, 187, -1, false);
	}

	@Override
	public void init() {
		super.init();
		HackInput = new EditBox(this.font, this.leftPos + 9, this.topPos + 50, 118, 18, Component.translatable("gui.endless_end.flavor_interface.HackInput")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.HackInput").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.HackInput").getString());
				else
					setSuggestion(null);
			}
		};
		HackInput.setMaxLength(32767);
		HackInput.setSuggestion(Component.translatable("gui.endless_end.flavor_interface.HackInput").getString());
		guistate.put("text:HackInput", HackInput);
		this.addWidget(this.HackInput);
		ReplacementInput = new EditBox(this.font, this.leftPos + 33, this.topPos + 166, 118, 18, Component.translatable("gui.endless_end.flavor_interface.ReplacementInput")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.ReplacementInput").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.ReplacementInput").getString());
				else
					setSuggestion(null);
			}
		};
		ReplacementInput.setMaxLength(32767);
		ReplacementInput.setSuggestion(Component.translatable("gui.endless_end.flavor_interface.ReplacementInput").getString());
		guistate.put("text:ReplacementInput", ReplacementInput);
		this.addWidget(this.ReplacementInput);
		DelayInput = new EditBox(this.font, this.leftPos + 136, this.topPos + 50, 25, 18, Component.translatable("gui.endless_end.flavor_interface.DelayInput")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.DelayInput").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.DelayInput").getString());
				else
					setSuggestion(null);
			}
		};
		DelayInput.setMaxLength(32767);
		DelayInput.setSuggestion(Component.translatable("gui.endless_end.flavor_interface.DelayInput").getString());
		guistate.put("text:DelayInput", DelayInput);
		this.addWidget(this.DelayInput);
		NameInput = new EditBox(this.font, this.leftPos + 30, this.topPos + 19, 118, 18, Component.translatable("gui.endless_end.flavor_interface.NameInput")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.NameInput").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.endless_end.flavor_interface.NameInput").getString());
				else
					setSuggestion(null);
			}
		};
		NameInput.setMaxLength(32767);
		NameInput.setSuggestion(Component.translatable("gui.endless_end.flavor_interface.NameInput").getString());
		guistate.put("text:NameInput", NameInput);
		this.addWidget(this.NameInput);
		button_input_function = Button.builder(Component.translatable("gui.endless_end.flavor_interface.button_input_function"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FlavorInterfaceButtonMessage(0, x, y, z));
				FlavorInterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 73, 98, 20).build();
		guistate.put("button:button_input_function", button_input_function);
		this.addRenderableWidget(button_input_function);
		button_run_function = Button.builder(Component.translatable("gui.endless_end.flavor_interface.button_run_function"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FlavorInterfaceButtonMessage(1, x, y, z));
				FlavorInterfaceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 44, this.topPos + 96, 87, 20).build();
		guistate.put("button:button_run_function", button_run_function);
		this.addRenderableWidget(button_run_function);
		imagebutton_flavor_buttons_cycle = new ImageButton(this.leftPos + 110, this.topPos + 75, 16, 16,
				new WidgetSprites(ResourceLocation.parse("endless_end:textures/screens/flavor_buttons_cycle.png"), ResourceLocation.parse("endless_end:textures/screens/flavor_buttons_cycle_pressed.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FlavorInterfaceButtonMessage(2, x, y, z));
						FlavorInterfaceButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_flavor_buttons_cycle", imagebutton_flavor_buttons_cycle);
		this.addRenderableWidget(imagebutton_flavor_buttons_cycle);
		imagebutton_flavor_buttons_question = new ImageButton(this.leftPos + 129, this.topPos + 75, 16, 16,
				new WidgetSprites(ResourceLocation.parse("endless_end:textures/screens/flavor_buttons_question.png"), ResourceLocation.parse("endless_end:textures/screens/flavor_buttons_question_pressed.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FlavorInterfaceButtonMessage(3, x, y, z));
						FlavorInterfaceButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_flavor_buttons_question", imagebutton_flavor_buttons_question);
		this.addRenderableWidget(imagebutton_flavor_buttons_question);
		imagebutton_flavor_buttons_quill = new ImageButton(this.leftPos + 149, this.topPos + 75, 16, 16,
				new WidgetSprites(ResourceLocation.parse("endless_end:textures/screens/flavor_buttons_quill.png"), ResourceLocation.parse("endless_end:textures/screens/flavor_buttons_quill_pressed.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FlavorInterfaceButtonMessage(4, x, y, z));
						FlavorInterfaceButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_flavor_buttons_quill", imagebutton_flavor_buttons_quill);
		this.addRenderableWidget(imagebutton_flavor_buttons_quill);
		PersistenceBox = Checkbox.builder(Component.translatable("gui.endless_end.flavor_interface.PersistenceBox"), this.font).pos(this.leftPos + 44, this.topPos + 120)

				.build();
		guistate.put("checkbox:PersistenceBox", PersistenceBox);
		this.addRenderableWidget(PersistenceBox);
		RedstoneBox = Checkbox.builder(Component.translatable("gui.endless_end.flavor_interface.RedstoneBox"), this.font).pos(this.leftPos + 44, this.topPos + 142)

				.build();
		guistate.put("checkbox:RedstoneBox", RedstoneBox);
		this.addRenderableWidget(RedstoneBox);
	}
}
