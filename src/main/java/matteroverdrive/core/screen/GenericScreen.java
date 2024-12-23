package matteroverdrive.core.screen;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import matteroverdrive.References;
import matteroverdrive.core.inventory.GenericInventory;
import matteroverdrive.core.inventory.slot.IToggleableSlot;
import matteroverdrive.core.inventory.slot.SlotUpgrade;
import matteroverdrive.core.screen.component.ScreenComponentSlot;
import matteroverdrive.core.screen.component.ScreenComponentSlot.SlotType;
import matteroverdrive.core.screen.component.edit_box.EditBoxOverdrive;
import matteroverdrive.core.screen.component.edit_box.EditBoxOverdriveMultiline;
import matteroverdrive.core.screen.component.utils.AbstractOverdriveButton;
import matteroverdrive.core.screen.component.utils.ITexture;
import matteroverdrive.core.screen.component.utils.OverdriveScreenComponent;
import matteroverdrive.core.utils.UtilsRendering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public abstract class GenericScreen<T extends GenericInventory> extends AbstractContainerScreen<T> {

	private List<OverdriveScreenComponent> components = new ArrayList<>();
	protected ResourceLocation defaultResource = (ResourceLocation.fromNamespaceAndPath(References.ID, "textures/gui/base/base_overdrive_with_menu.png"));
	protected final GuiTextures background;

	public GenericScreen(T menu, Inventory playerinventory, Component title, GuiTextures background, int guiWidth, int guiHeight) {
		super(menu, playerinventory, title);
		this.background = background;
		imageWidth = guiWidth;
		imageHeight = guiHeight;
		setScreenParams();
	}

	@Override
	protected void init() {
		super.init();
		for (Slot slot : menu.slots) {
			addScreenComponent(createScreenSlot(slot));
		}
		updateComponentActivity(getScreenNumber());
	}

	protected ScreenComponentSlot createScreenSlot(Slot slot) {
		if (slot instanceof SlotUpgrade upgrade) {
			return new ScreenComponentSlot(upgrade.getSlotType(), upgrade.getIconType(), this, slot.x - 1, slot.y - 1,
					upgrade.getScreenNumbers()).setUpgrades(upgrade.getUpgrades());
		} else if (slot instanceof IToggleableSlot type) {
			return new ScreenComponentSlot(type.getSlotType(), type.getIconType(), this, slot.x - 1, slot.y - 1,
					type.getScreenNumbers());
		}
		return new ScreenComponentSlot(SlotType.SMALL, this, slot.x - 1, slot.y - 1, new int[] { 0 });
	}

	@Override
	public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack, mouseX, mouseY, partialTicks);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		renderTooltip(matrixStack, mouseX, mouseY);
	}
	
	/* TODO
	@Override
	protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
		// RenderingUtils.bindTexture(defaultResource);
		int guiWidth = (int) getGuiWidth();
		int guiHeight = (int) getGuiHeight();

		int y = guiHeight;

		graphics.blit(defaultResource, guiWidth, y, 0, 0, 176, 4, 176, 18);

		y += 4;

		int wholeHeight = (imageHeight - 8) / 10;
		int remainder = (imageHeight - 8) % 10;

		for(int i = 0; i < wholeHeight; i++){
			graphics.blit(defaultResource, guiWidth, y, 0, 4, 176, 10, 176, 18);
			y += 10;
		}

		graphics.blit(defaultResource, guiWidth, y, 0, 4, 176, remainder, 176, 18);
		y += remainder;

		graphics.blit(defaultResource, guiWidth, y, 0, 14, 176, 4, 176, 18);
	}
	*/
	@Override
	protected void renderBg(GuiGraphics graphics, float partialTick, int x, int y) {
		UtilsRendering.bindTexture(background.getTexture());
		graphics.blit(ResourceLocation.fromNamespaceAndPath(References.ID, "textures/gui/base/base_overdrive_with_menu.png"), getXPos(), getYPos(), 0, 0, imageWidth, imageHeight);
	}

	public int getXPos() {
		return (width - imageWidth) / 2;
	}

	public int getYPos() {
		return (height - imageHeight) / 2;
	}

	public Font getFontRenderer() {
		return Minecraft.getInstance().font;
	}

	public int[] getAxisAndGuiWidth(int mouseX, int mouseY) {
		int xPos = getXPos();
		int yPos = getYPos();
		return new int[] { xPos, yPos, mouseX - xPos, mouseY - yPos };
	}

	public void updateComponentActivity(int screenNum) {
		for (OverdriveScreenComponent component : components) {
			component.updateVisiblity(screenNum);
		}
		for (Slot slot : menu.slots) {
			if (slot instanceof IToggleableSlot toggle) {
				toggle.setActive(toggle.isScreenNumber(screenNum));
			}
		}
	}

	public void addScreenComponent(OverdriveScreenComponent component) {
		component.initScreenSize();
		components.add(component);
		addRenderableOnly(component);
	}

	public void addButton(AbstractOverdriveButton button) {
		button.initScreenSize();
		addRenderableWidget(button);
	}

	public void addEditBox(EditBoxOverdrive box) {
		addRenderableWidget(box);
	}

	public void addEditBox(EditBoxOverdriveMultiline box) {
		addRenderableWidget(box);
	}

	public int getGuiRight() {
		return getGuiLeft() + getXSize();
	}

	public int getGuiBottom() {
		return getGuiTop() + getYSize();
	}

	public abstract int getScreenNumber();

	public abstract void setScreenParams();
	
	public static enum GuiTextures implements ITexture {
		OVERDRIVE_MENU(ResourceLocation.fromNamespaceAndPath(References.ID, "textures/gui/base/base_overdrive_with_menu.png"), 120, 76),
		OVERDRIVE_NO_MENU(ResourceLocation.fromNamespaceAndPath(References.ID, "textures/gui/base/base_overdrive_wo_menu.png"), 120, 76),
		VANILLA(ResourceLocation.fromNamespaceAndPath(References.ID, "textures/gui/base/base_vanilla.png"), 256, 256);

		private final ResourceLocation texture;
		private final int imageWidth;
		private final int imageHeight;
		
		private GuiTextures(ResourceLocation texture, int imageWidth, int imageHeight) {
			this.texture = texture;
			this.imageWidth = imageWidth;
			this.imageHeight = imageHeight;
		}
		
		@Override
		public ResourceLocation getTexture() {
			return texture;
		}

		@Override
		public int getTextureWidth() {
			return imageWidth;
		}

		@Override
		public int getTextureHeight() {
			return imageHeight;
		}
		
	}

}
