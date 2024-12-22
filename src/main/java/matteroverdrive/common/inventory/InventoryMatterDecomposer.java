package matteroverdrive.common.inventory;

import matteroverdrive.common.item.ItemUpgrade.UpgradeType;
import matteroverdrive.common.tile.TileMatterDecomposer;
import matteroverdrive.core.capability.types.item.CapabilityInventory;
import matteroverdrive.core.capability.types.item.PlayerSlotDataWrapper;
import matteroverdrive.core.inventory.GenericInventoryTile;
import matteroverdrive.core.inventory.slot.SlotEnergyCharging;
import matteroverdrive.core.inventory.slot.SlotGeneric;
import matteroverdrive.core.inventory.slot.SlotMatterCharging;
import matteroverdrive.core.inventory.slot.SlotRestricted;
import matteroverdrive.core.inventory.slot.SlotUpgrade;
import matteroverdrive.core.screen.component.ScreenComponentIcon.IconType;
import matteroverdrive.core.screen.component.ScreenComponentSlot.SlotType;
import matteroverdrive.registry.MenuRegistry;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;

public class InventoryMatterDecomposer extends GenericInventoryTile<TileMatterDecomposer> {

	public static final UpgradeType[] UPGRADES = new UpgradeType[] { UpgradeType.SPEED, UpgradeType.HYPER_SPEED,
			UpgradeType.POWER, UpgradeType.POWER_STORAGE, UpgradeType.MATTER_STORAGE, UpgradeType.FAIL_SAFE,
			UpgradeType.MUFFLER };

	public InventoryMatterDecomposer(int id, Inventory playerinv, CapabilityInventory invcap,
			ContainerData tilecoords) {
		super(MenuRegistry.MENU_MATTER_DECOMPOSER.get(), id, playerinv, invcap, tilecoords);
	}

	public InventoryMatterDecomposer(int id, Inventory playerinv) {
		this(id, playerinv, new CapabilityInventory(TileMatterDecomposer.SLOT_COUNT, true, true),
				new SimpleContainerData(3));
	}

	@Override
	public void addInvSlots(CapabilityInventory invcap, Inventory playerinv) {
		addSlot(new SlotGeneric(invcap, nextIndex(), 8, 48, new int[] { 0 }, SlotType.MAIN, IconType.NONE));
		addSlot(new SlotRestricted(invcap, nextIndex(), 67, 48, new int[] { 0 }, SlotType.BIG,
				IconType.MATTER_DUST_DARK));
		addSlot(new SlotEnergyCharging(invcap, nextIndex(), 8, 75, new int[] { 0 }));
		addSlot(new SlotMatterCharging(invcap, nextIndex(), 118, 48, new int[] { 0 }));
		addSlot(new SlotUpgrade(invcap, nextIndex(), 81, 55, new int[] { 2 }, UPGRADES));
		addSlot(new SlotUpgrade(invcap, nextIndex(), 105, 55, new int[] { 2 }, UPGRADES));
		addSlot(new SlotUpgrade(invcap, nextIndex(), 129, 55, new int[] { 2 }, UPGRADES));
		addSlot(new SlotUpgrade(invcap, nextIndex(), 153, 55, new int[] { 2 }, UPGRADES));

	}
	
	@Override
	public PlayerSlotDataWrapper getDataWrapper(Player player) {
		return defaultOverdriveScreen(new int[] { 0, 1, 2, 3 }, new int[] { 0 });
	}

}
