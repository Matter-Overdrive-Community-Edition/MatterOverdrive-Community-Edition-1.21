package matteroverdrive.client.screen;

import com.mojang.blaze3d.platform.InputConstants;

import matteroverdrive.client.ClientReferences.Colors;
import matteroverdrive.common.inventory.InventoryTransporter;
import matteroverdrive.common.tile.transporter.TileTransporter;
import matteroverdrive.common.tile.transporter.utils.TransporterLocationWrapper;
import matteroverdrive.core.screen.component.ScreenComponentFillArea;
import matteroverdrive.core.screen.component.ScreenComponentHotbarBar;
import matteroverdrive.core.screen.component.ScreenComponentLabel;
import matteroverdrive.core.screen.component.ScreenComponentProgress;
import matteroverdrive.core.screen.component.ScreenComponentUpgradeInfo;
import matteroverdrive.core.screen.component.button.ButtonEditTransporterLocation;
import matteroverdrive.core.screen.component.button.ButtonGeneric;
import matteroverdrive.core.screen.component.button.ButtonIO;
import matteroverdrive.core.screen.component.button.ButtonIOConfig;
import matteroverdrive.core.screen.component.button.ButtonIOConfig.IOConfigButtonType;
import matteroverdrive.core.screen.component.button.ButtonMenuBar;
import matteroverdrive.core.screen.component.button.ButtonMenuOption;
import matteroverdrive.core.screen.component.button.ButtonMenuOption.MenuButtonType;
import matteroverdrive.core.screen.component.button.ButtonOverdrive;
import matteroverdrive.core.screen.component.button.ButtonTransporterLocation;
import matteroverdrive.core.screen.component.wrappers.WrapperIOConfig;
import matteroverdrive.core.screen.component.wrappers.WrapperTransporterLocationEditer;
import matteroverdrive.core.screen.types.GenericMachineScreen;
import matteroverdrive.core.utils.UtilsText;
import matteroverdrive.registry.SoundRegistry;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.KeyboardHandler;

public class ScreenTransporter extends GenericMachineScreen<InventoryTransporter> {

	private static boolean EXTENDED = false;

	private ButtonGeneric close;

	public ButtonMenuBar menu;

	private ButtonMenuOption home;
	private ButtonMenuOption settings;
	private ButtonMenuOption upgrades;
	private ButtonMenuOption ioconfig;

	private ButtonOverdrive redstone;
	private ButtonOverdrive reciever;

	private ButtonIOConfig items;
	private ButtonIOConfig energy;
	private ButtonIOConfig matter;

	private WrapperIOConfig itemWrapper;
	private WrapperIOConfig energyWrapper;
	private WrapperIOConfig matterWrapper;

	private ButtonTransporterLocation[] locationButtons = new ButtonTransporterLocation[5];
	private ButtonEditTransporterLocation[] editButtons = new ButtonEditTransporterLocation[5];

	private WrapperTransporterLocationEditer editor;

	private static final int BETWEEN_MENUS = 26;
	private static final int FIRST_HEIGHT = 40;

	public ScreenTransporter(InventoryTransporter menu, Inventory playerinventory, Component title) {
		super(menu, playerinventory, title, 224, 176);
	}

	@Override
	protected void init() {
	//	minecraft.keyboardHandler.setSendRepeatsToGui(true);
		super.init();
		close = getCloseButton(207, 6);
		menu = new ButtonMenuBar(this, 212, 33, 143, EXTENDED, button -> {
			toggleBarOpen();
			home.visible = !home.visible;
			settings.visible = !settings.visible;
			upgrades.visible = !upgrades.visible;
			ioconfig.visible = !ioconfig.visible;
		});
		home = new ButtonMenuOption(this, 217, FIRST_HEIGHT, button -> {
			updateScreen(0);
			settings.isActivated = false;
			upgrades.isActivated = false;
			ioconfig.isActivated = false;
			redstone.visible = false;
			reciever.visible = false;
			items.visible = false;
			energy.visible = false;
			matter.visible = false;
			items.isActivated = false;
			energy.isActivated = false;
			matter.isActivated = false;
			itemWrapper.hideButtons();
			energyWrapper.hideButtons();
			matterWrapper.hideButtons();
			editor.updateButtons(false);
			for (int i = 0; i < locationButtons.length; i++) {
				locationButtons[i].visible = true;
				editButtons[i].visible = true;
			}
		}, MenuButtonType.HOME, menu, true);
		settings = new ButtonMenuOption(this, 217, FIRST_HEIGHT + BETWEEN_MENUS, button -> {
			updateScreen(1);
			home.isActivated = false;
			upgrades.isActivated = false;
			ioconfig.isActivated = false;
			redstone.visible = true;
			reciever.visible = true;
			items.visible = false;
			energy.visible = false;
			matter.visible = false;
			items.isActivated = false;
			energy.isActivated = false;
			matter.isActivated = false;
			itemWrapper.hideButtons();
			energyWrapper.hideButtons();
			matterWrapper.hideButtons();
			editor.updateButtons(false);
			for (int i = 0; i < locationButtons.length; i++) {
				locationButtons[i].visible = false;
				editButtons[i].visible = false;
			}
		}, MenuButtonType.SETTINGS, menu, false);
		upgrades = new ButtonMenuOption(this, 217, FIRST_HEIGHT + BETWEEN_MENUS * 2, button -> {
			updateScreen(2);
			home.isActivated = false;
			settings.isActivated = false;
			ioconfig.isActivated = false;
			redstone.visible = false;
			reciever.visible = false;
			items.visible = false;
			energy.visible = false;
			matter.visible = false;
			items.isActivated = false;
			energy.isActivated = false;
			matter.isActivated = false;
			itemWrapper.hideButtons();
			energyWrapper.hideButtons();
			matterWrapper.hideButtons();
			editor.updateButtons(false);
			for (int i = 0; i < locationButtons.length; i++) {
				locationButtons[i].visible = false;
				editButtons[i].visible = false;
			}
		}, MenuButtonType.UPGRADES, menu, false);
		ioconfig = new ButtonMenuOption(this, 217, FIRST_HEIGHT + BETWEEN_MENUS * 3, button -> {
			updateScreen(3);
			home.isActivated = false;
			settings.isActivated = false;
			upgrades.isActivated = false;
			redstone.visible = false;
			reciever.visible = false;
			items.visible = true;
			energy.visible = true;
			matter.visible = true;
			items.isActivated = false;
			energy.isActivated = false;
			matter.isActivated = false;
			itemWrapper.hideButtons();
			energyWrapper.hideButtons();
			matterWrapper.hideButtons();
			editor.updateButtons(false);
			for (int i = 0; i < locationButtons.length; i++) {
				locationButtons[i].visible = false;
				editButtons[i].visible = false;
			}
		}, MenuButtonType.IO, menu, false);
		
		redstone = redstoneButton(48, 32);
		
		reciever = new ButtonOverdrive(this, 48, 60, 58, 20, () -> {
			TileTransporter transporter = getMenu().getTile();
			if (transporter != null) {
				if(transporter.recieverProp.get()) {
					return UtilsText.gui("isreciever");
				} else {
					return UtilsText.gui("notreciever");
				}
			}
			return Component.empty();
		}, button -> {
			TileTransporter transporter = getMenu().getTile();
			if (transporter != null) {
				transporter.getPropertyManager().updateServerBlockEntity(transporter.recieverProp, !transporter.recieverProp.get());
			}
		}).setSound(handler -> handler.play(SimpleSoundInstance.forUI(SoundRegistry.SOUND_BUTTON_LOUD3.get(), 1.0F)));
		
		items = new ButtonIOConfig(this, 48, 32, button -> {
			home.isActivated = false;
			settings.isActivated = false;
			upgrades.isActivated = false;
			redstone.visible = false;
			reciever.visible = false;
			energy.isActivated = false;
			matter.isActivated = false;
			itemWrapper.showButtons();
			energyWrapper.hideButtons();
			matterWrapper.hideButtons();
			editor.updateButtons(false);
		}, IOConfigButtonType.ITEM);
		energy = new ButtonIOConfig(this, 48, 72, button -> {
			home.isActivated = false;
			settings.isActivated = false;
			upgrades.isActivated = false;
			redstone.visible = false;
			reciever.visible = false;
			items.isActivated = false;
			matter.isActivated = false;
			itemWrapper.hideButtons();
			energyWrapper.showButtons();
			matterWrapper.hideButtons();
			editor.updateButtons(false);
		}, IOConfigButtonType.ENERGY);
		matter = new ButtonIOConfig(this, 48, 112, button -> {
			home.isActivated = false;
			settings.isActivated = false;
			upgrades.isActivated = false;
			redstone.visible = false;
			reciever.visible = false;
			items.isActivated = false;
			energy.isActivated = false;
			itemWrapper.hideButtons();
			energyWrapper.hideButtons();
			matterWrapper.showButtons();
			editor.updateButtons(false);
		}, IOConfigButtonType.MATTER);

		itemWrapper = getItemIOWrapper(137, 59);
		energyWrapper = getEnergyIOWrapper(137, 59);
		matterWrapper = getEnergyIOWrapper(137, 59);

		itemWrapper.initButtons();
		energyWrapper.initButtons();
		matterWrapper.initButtons();

		for (int i = 0; i < locationButtons.length; i++) {
			locationButtons[i] = (ButtonTransporterLocation) new ButtonTransporterLocation(this, 68, 32 + 22 * i, i,
					button -> {
						ButtonTransporterLocation locationButton = (ButtonTransporterLocation) button;
						TileTransporter transporter = getMenu().getTile();
						if (transporter != null) {
							if (locationButtons[locationButton.index].isActivated) {
								transporter.getPropertyManager().updateServerBlockEntity(transporter.destinationProp, -1);
							} else {
								transporter.getPropertyManager().updateServerBlockEntity(transporter.destinationProp, locationButton.index);
							}
							for (int j = 0; j < locationButtons.length; j++) {
								if (j != locationButton.index) {
									locationButtons[j].isActivated = false;
								}
							}
						}
					}, () -> getMenu().getTile()).setLeft();
		}

		for (int i = 0; i < editButtons.length; i++) {
			editButtons[i] = (ButtonEditTransporterLocation) new ButtonEditTransporterLocation(this, 180, 32 + 22 * i,
					button -> {
						ButtonEditTransporterLocation edit = (ButtonEditTransporterLocation) button;
						updateScreen(4);
						home.isActivated = false;
						settings.isActivated = false;
						upgrades.isActivated = false;
						redstone.visible = false;
						reciever.visible = false;
						energy.isActivated = false;
						matter.isActivated = false;
						itemWrapper.hideButtons();
						energyWrapper.hideButtons();
						matterWrapper.hideButtons();

						for (int j = 0; j < locationButtons.length; j++) {
							locationButtons[j].visible = false;
							editButtons[j].visible = false;
						}
						editButtons[edit.index].isPressed = false;

						editor.setCurrIndex(edit.index);
						editor.updateButtons(true);
					}, i).setRight();
		}

		editor = new WrapperTransporterLocationEditer(this, 0, 0, getMenu()::getTile);
		editor.initButtons();

		addButton(close);
		addButton(menu);
		addButton(home);
		addButton(settings);
		addButton(upgrades);
		addButton(redstone);
		addButton(reciever);
		addButton(ioconfig);
		addButton(items);
		addButton(energy);
		addButton(matter);
		for (ButtonIO button : itemWrapper.getButtons()) {
			addButton(button);
		}
		for (ButtonIO button : energyWrapper.getButtons()) {
			addButton(button);
		}
		for (ButtonIO button : matterWrapper.getButtons()) {
			addButton(button);
		}
		for (int i = 0; i < editButtons.length; i++) {
			addButton(editButtons[i]);
			addButton(locationButtons[i]);
		}

		editor.addRenderingData(this);

		redstone.visible = false;
		reciever.visible = false;
		items.visible = false;
		energy.visible = false;
		matter.visible = false;
		itemWrapper.hideButtons();
		energyWrapper.hideButtons();
		matterWrapper.hideButtons();
		editor.updateButtons(false);

		addScreenComponent(
				new ScreenComponentFillArea(this, 15, 77, 2, 26, new int[] { 1 }, Colors.GUI_STANDARD.getColor()));
		addScreenComponent(new ScreenComponentProgress(() -> 0, this, 8, 79, new int[] { 1 }).vertical());
		
		addScreenComponent(defaultEnergyBar(48, 35, new int[] { 0 }));
		addScreenComponent(defaultUsageMatterBar(48, 94, new int[] { 0 }));
		addScreenComponent(getRunningIndicator(6, 159, new int[] { 0, 1, 2, 3, 4 }));
		addScreenComponent(new ScreenComponentHotbarBar(this, 40, 143, 169, new int[] { 0, 1, 2, 3 }));
		addScreenComponent(new ScreenComponentLabel(this, 110, 37, new int[] { 1 }, UtilsText.gui("redstone"),
				Colors.HOLO.getColor()));
		addScreenComponent(new ScreenComponentLabel(this, 110, 65, new int[] { 1 }, UtilsText.gui("transportermode"),
				Colors.HOLO.getColor()));
		addScreenComponent(new ScreenComponentUpgradeInfo(this, 79, 76, new int[] { 2 }));
		addScreenComponent(new ScreenComponentLabel(this, 80, 42, new int[] { 3 }, UtilsText.gui("ioitems"),
				Colors.HOLO.getColor()));
		addScreenComponent(new ScreenComponentLabel(this, 80, 80, new int[] { 3 }, UtilsText.gui("ioenergy"),
				Colors.HOLO.getColor()));
		addScreenComponent(new ScreenComponentLabel(this, 80, 122, new int[] { 3 }, UtilsText.gui("iomatter"),
				Colors.HOLO.getColor()));
		addScreenComponent(
				new ScreenComponentLabel(this, 70, 54, new int[] { 4 }, UtilsText.gui("xlabel"), Colors.WHITE.getColor()));
		addScreenComponent(
				new ScreenComponentLabel(this, 70, 74, new int[] { 4 }, UtilsText.gui("ylabel"), Colors.WHITE.getColor()));
		addScreenComponent(
				new ScreenComponentLabel(this, 70, 94, new int[] { 4 }, UtilsText.gui("zlabel"), Colors.WHITE.getColor()));
		addScreenComponent(new ScreenComponentLabel(this, 70, 111, new int[] { 4 }, () -> {
			TileTransporter transporter = getMenu().getTile();
			Component extraComponent = Component.empty();
			if (transporter != null) {
				TransporterLocationWrapper wrapper = transporter.locationManager.getLocation(editor.getCurrIndex());
				String key = "";
				if (wrapper.getDimension() == null) {
					key = transporter.getLevel().dimension().location().getPath();
				} else {
					key = wrapper.getDimension().location().getPath();
				}
				if (UtilsText.dimensionExists(key)) {
					extraComponent = UtilsText.dimension(key);
				} else {
					extraComponent = Component.literal(key);
				}

			}
			return UtilsText.gui("dimensionname", extraComponent);
		}, Colors.WHITE.getColor()));

	}

	@Override
	protected void containerTick() {
		super.containerTick();
		editor.tickEditBoxes();
	}

	private void toggleBarOpen() {
		EXTENDED = !EXTENDED;
	}

	@Override
	public void removed() {
		super.removed();
	//	minecraft.keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
		InputConstants.Key mouseKey = InputConstants.getKey(pKeyCode, pScanCode);
		if (this.minecraft.options.keyInventory.isActiveAndMatches(mouseKey) && editor.areEditBoxesActive()) {
			return false;
		}
		return super.keyPressed(pKeyCode, pScanCode, pModifiers);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}

}
