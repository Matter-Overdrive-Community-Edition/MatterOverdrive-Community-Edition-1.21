package matteroverdrive.client.screen;

import matteroverdrive.client.ClientReferences.Colors;
import matteroverdrive.common.inventory.InventoryCharger;
import matteroverdrive.core.screen.component.ScreenComponentHotbarBar;
import matteroverdrive.core.screen.component.ScreenComponentLabel;
import matteroverdrive.core.screen.component.ScreenComponentUpgradeInfo;
import matteroverdrive.core.screen.component.button.ButtonGeneric;
import matteroverdrive.core.screen.component.button.ButtonMenuBar;
import matteroverdrive.core.screen.component.button.ButtonMenuOption;
import matteroverdrive.core.screen.component.button.ButtonMenuOption.MenuButtonType;
import matteroverdrive.core.screen.component.button.ButtonOverdrive;
import matteroverdrive.core.screen.types.GenericMachineScreen;
import matteroverdrive.core.utils.UtilsText;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ScreenCharger extends GenericMachineScreen<InventoryCharger> {

	private static boolean EXTENDED = false;

	private ButtonGeneric close;
	public ButtonMenuBar menu;
	private ButtonMenuOption home;
	private ButtonMenuOption settings;
	private ButtonMenuOption upgrades;
	private ButtonOverdrive redstone;

	private static final int BETWEEN_MENUS = 26;
	private static final int FIRST_HEIGHT = 40;

	public ScreenCharger(InventoryCharger menu, Inventory playerinventory, Component title) {
		super(menu, playerinventory, title, 224, 176);
	}

	@Override
	protected void init() {
		super.init();
		close = getCloseButton(207, 6);
		menu = new ButtonMenuBar(this, 212, 33, 143, EXTENDED, button -> {
			toggleBarOpen();
			home.visible = !home.visible;
			settings.visible = !settings.visible;
			upgrades.visible = !upgrades.visible;
		});
		home = new ButtonMenuOption(this, 217, FIRST_HEIGHT, button -> {
			updateScreen(0);
			settings.isActivated = false;
			upgrades.isActivated = false;
			redstone.visible = false;
		}, MenuButtonType.HOME, menu, true);
		settings = new ButtonMenuOption(this, 217, FIRST_HEIGHT + BETWEEN_MENUS, button -> {
			updateScreen(1);
			home.isActivated = false;
			upgrades.isActivated = false;
			redstone.visible = true;
		}, MenuButtonType.SETTINGS, menu, false);
		upgrades = new ButtonMenuOption(this, 217, FIRST_HEIGHT + BETWEEN_MENUS * 2, button -> {
			updateScreen(2);
			home.isActivated = false;
			settings.isActivated = false;
			redstone.visible = false;
		}, MenuButtonType.UPGRADES, menu, false);

		redstone = redstoneButton(48, 32);

		addButton(close);
		addButton(menu);
		addButton(home);
		addButton(settings);
		addButton(upgrades);
		addButton(redstone);

		addScreenComponent(defaultEnergyBar(118, 35, new int[] { 0 }));
		addScreenComponent(getRunningIndicator(6, 156, new int[] { 0, 1, 2 }));
		addScreenComponent(new ScreenComponentHotbarBar(this, 40, 143, 169, new int[] { 0, 1, 2 }));
		addScreenComponent(new ScreenComponentLabel(this, 110, 37, new int[] { 1 }, UtilsText.gui("redstone"),
				Colors.HOLO.getColor()));
		addScreenComponent(new ScreenComponentUpgradeInfo(this, 79, 76, new int[] { 2 }));

		redstone.visible = false;

	}

	private void toggleBarOpen() {
		EXTENDED = !EXTENDED;
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}

}
