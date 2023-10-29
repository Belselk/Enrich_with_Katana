package katana.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import katana.world.inventory.FurnaceRecipeViewerMenu;

import katana.network.FurnaceRecipeViewerButtonMessage;

import katana.EnrichWithKatanaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FurnaceRecipeViewerScreen extends AbstractContainerScreen<FurnaceRecipeViewerMenu> {
	private final static HashMap<String, Object> guistate = FurnaceRecipeViewerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_x;
	Button button_set;

	public FurnaceRecipeViewerScreen(FurnaceRecipeViewerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = new ResourceLocation("enrich_with_katana:textures/screens/furnace_recipe_viewer.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_empty = new Button(this.leftPos + 150, this.topPos + 46, 18, 20, Component.translatable("gui.enrich_with_katana.furnace_recipe_viewer.button_empty"), e -> {
			if (true) {
				EnrichWithKatanaMod.PACKET_HANDLER.sendToServer(new FurnaceRecipeViewerButtonMessage(0, x, y, z));
				FurnaceRecipeViewerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 6, this.topPos + 46, 17, 20, Component.translatable("gui.enrich_with_katana.furnace_recipe_viewer.button_empty1"), e -> {
			if (true) {
				EnrichWithKatanaMod.PACKET_HANDLER.sendToServer(new FurnaceRecipeViewerButtonMessage(1, x, y, z));
				FurnaceRecipeViewerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_x = new Button(this.leftPos + 150, this.topPos + 4, 18, 20, Component.translatable("gui.enrich_with_katana.furnace_recipe_viewer.button_x"), e -> {
			if (true) {
				EnrichWithKatanaMod.PACKET_HANDLER.sendToServer(new FurnaceRecipeViewerButtonMessage(2, x, y, z));
				FurnaceRecipeViewerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_set = new Button(this.leftPos + 119, this.topPos + 72, 26, 20, Component.translatable("gui.enrich_with_katana.furnace_recipe_viewer.button_set"), e -> {
			if (true) {
				EnrichWithKatanaMod.PACKET_HANDLER.sendToServer(new FurnaceRecipeViewerButtonMessage(3, x, y, z));
				FurnaceRecipeViewerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_set", button_set);
		this.addRenderableWidget(button_set);
	}
}
