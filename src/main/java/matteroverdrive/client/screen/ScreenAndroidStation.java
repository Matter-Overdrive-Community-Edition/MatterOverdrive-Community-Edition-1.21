package matteroverdrive.client.screen;

import matteroverdrive.common.inventory.InventoryAndroidStation;
import matteroverdrive.core.screen.types.GenericMachineScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ScreenAndroidStation extends GenericMachineScreen<InventoryAndroidStation> {

	public ScreenAndroidStation(InventoryAndroidStation menu, Inventory playerinventory, Component title) {
		super(menu, playerinventory, title, 224, 176);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}

}
