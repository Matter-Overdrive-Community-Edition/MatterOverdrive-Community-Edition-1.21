package matteroverdrive.registry;

import matteroverdrive.References;
import matteroverdrive.common.block.type.TypeMachine;
import matteroverdrive.common.inventory.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.MenuType.MenuSupplier;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuRegistry {

	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, References.ID);

	public static final DeferredHolder<MenuType<?>,MenuType<InventoryTritaniumCrate>> MENU_TRITANIUM_CRATE = register("tritanium_crate", InventoryTritaniumCrate::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryHoloSign>> MENU_HOLO_SIGN = register(TypeMachine.HOLO_SIGN.id(), InventoryHoloSign::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventorySolarPanel>> MENU_SOLAR_PANEL = register(TypeMachine.SOLAR_PANEL.id(), InventorySolarPanel::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryMatterDecomposer>> MENU_MATTER_DECOMPOSER = register(TypeMachine.MATTER_DECOMPOSER.id(), InventoryMatterDecomposer::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryMatterRecycler>> MENU_MATTER_RECYCLER = register(TypeMachine.MATTER_RECYCLER.id(), InventoryMatterRecycler::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryCharger>> MENU_CHARGER = register(TypeMachine.CHARGER.id(), InventoryCharger::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryMicrowave>> MENU_MICROWAVE = register(TypeMachine.MICROWAVE.id(), InventoryMicrowave::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryInscriber>> MENU_INSCRIBER = register(TypeMachine.INSCRIBER.id(), InventoryInscriber::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryTransporter>> MENU_TRANSPORTER = register(TypeMachine.TRANSPORTER.id(), InventoryTransporter::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventorySpacetimeAccelerator>> MENU_SPACETIME_ACCELERATOR = register(TypeMachine.SPACETIME_ACCELERATOR.id(), InventorySpacetimeAccelerator::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryChunkloader>> MENU_CHUNKLOADER = register(TypeMachine.CHUNKLOADER.id(), InventoryChunkloader::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryPatternStorage>> MENU_PATTERN_STORAGE = register(TypeMachine.PATTERN_STORAGE.id(), InventoryPatternStorage::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryMatterReplicator>> MENU_MATTER_REPLICATOR = register(TypeMachine.MATTER_REPLICATOR.id(), InventoryMatterReplicator::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryPatternMonitor>> MENU_PATTERN_MONITOR = register(TypeMachine.PATTERN_MONITOR.id(), InventoryPatternMonitor::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryMatterAnalyzer>> MENU_MATTER_ANALYZER = register(TypeMachine.MATTER_ANALYZER.id(), InventoryMatterAnalyzer::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryAndroidStation>> MENU_ANDROID_STATION = register(TypeMachine.ANDROID_STATION.id(), InventoryAndroidStation::new);
	public static final DeferredHolder<MenuType<?>,MenuType<InventoryDiscManipulator>> MENU_DISC_MANIPULATOR = register(TypeMachine.DISC_MANIPULATOR.id(), InventoryDiscManipulator::new);
	
	private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>,MenuType<T>> register(String id, MenuSupplier<T> supplier) {
		return MENU_TYPES.register(id, () -> new MenuType<>(supplier, FeatureFlags.DEFAULT_FLAGS));
	}
}
