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

import net.mcreator.iforgegorege.world.inventory.BeanselectMenu;
import net.mcreator.iforgegorege.network.BeanselectButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BeanselectScreen extends AbstractContainerScreen<BeanselectMenu> {
	private final static HashMap<String, Object> guistate = BeanselectMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_god_beans;
	Button button_void_igniter;

	public BeanselectScreen(BeanselectMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("i_forge_gorege:textures/screens/beanselect.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.i_forge_gorege.beanselect.label_select_your_beans"), 6, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_god_beans = Button.builder(Component.translatable("gui.i_forge_gorege.beanselect.button_god_beans"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new BeanselectButtonMessage(0, x, y, z));
				BeanselectButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 133, 72, 20).build();
		guistate.put("button:button_god_beans", button_god_beans);
		this.addRenderableWidget(button_god_beans);
		button_void_igniter = Button.builder(Component.translatable("gui.i_forge_gorege.beanselect.button_void_igniter"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new BeanselectButtonMessage(1, x, y, z));
				BeanselectButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 106, 87, 20).build();
		guistate.put("button:button_void_igniter", button_void_igniter);
		this.addRenderableWidget(button_void_igniter);
	}
}
