package net.mcreator.iforgegorege.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.iforgegorege.world.inventory.IphoneGUIMenu;
import net.mcreator.iforgegorege.network.IphoneGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class IphoneGUIScreen extends AbstractContainerScreen<IphoneGUIMenu> {
	private final static HashMap<String, Object> guistate = IphoneGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_iron_giver;
	Button button_diamond_giver;
	Button button_gold_giver;
	Button button_fly;

	public IphoneGUIScreen(IphoneGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("i_forge_gorege:textures/screens/iphone_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(RenderType::guiTextured, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.i_forge_gorege.iphone_gui.label_creative_menu"), 18, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_iron_giver = Button.builder(Component.translatable("gui.i_forge_gorege.iphone_gui.button_iron_giver"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new IphoneGUIButtonMessage(0, x, y, z));
				IphoneGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 70, 77, 20).build();
		guistate.put("button:button_iron_giver", button_iron_giver);
		this.addRenderableWidget(button_iron_giver);
		button_diamond_giver = Button.builder(Component.translatable("gui.i_forge_gorege.iphone_gui.button_diamond_giver"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new IphoneGUIButtonMessage(1, x, y, z));
				IphoneGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 102, this.topPos + 124, 93, 20).build();
		guistate.put("button:button_diamond_giver", button_diamond_giver);
		this.addRenderableWidget(button_diamond_giver);
		button_gold_giver = Button.builder(Component.translatable("gui.i_forge_gorege.iphone_gui.button_gold_giver"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new IphoneGUIButtonMessage(2, x, y, z));
				IphoneGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 97, 77, 20).build();
		guistate.put("button:button_gold_giver", button_gold_giver);
		this.addRenderableWidget(button_gold_giver);
		button_fly = Button.builder(Component.translatable("gui.i_forge_gorege.iphone_gui.button_fly"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new IphoneGUIButtonMessage(3, x, y, z));
				IphoneGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 124, 40, 20).build();
		guistate.put("button:button_fly", button_fly);
		this.addRenderableWidget(button_fly);
	}
}
