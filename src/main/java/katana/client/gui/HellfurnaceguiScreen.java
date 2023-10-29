package katana.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import katana.world.inventory.HellfurnaceguiMenu;

import katana.network.HellfurnaceguiButtonMessage;

import katana.EnrichWithKatanaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HellfurnaceguiScreen extends AbstractContainerScreen<HellfurnaceguiMenu> {
	private final static HashMap<String, Object> guistate = HellfurnaceguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_recipe;

	public HellfurnaceguiScreen(HellfurnaceguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 190;
	}

	private static final ResourceLocation texture = new ResourceLocation("enrich_with_katana:textures/screens/hellfurnacegui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("enrich_with_katana:textures/screens/style.png"));
		this.blit(ms, this.leftPos + -4, this.topPos + 8, 0, 0, 176, 180, 176, 180);

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
		this.font.draw(poseStack, Component.translatable("gui.enrich_with_katana.hellfurnacegui.label_hell_furnace"), 55, 8, -12829636);
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
		button_recipe = new Button(this.leftPos + 123, this.topPos + 9, 34, 20, Component.translatable("gui.enrich_with_katana.hellfurnacegui.button_recipe"), e -> {
			if (true) {
				EnrichWithKatanaMod.PACKET_HANDLER.sendToServer(new HellfurnaceguiButtonMessage(0, x, y, z));
				HellfurnaceguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_recipe", button_recipe);
		this.addRenderableWidget(button_recipe);
	}
}
