package matteroverdrive;

import java.util.Random;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import matteroverdrive.client.ClientRegister;
import matteroverdrive.client.screen.ScreenAndroidStation;
import matteroverdrive.client.screen.ScreenCharger;
import matteroverdrive.client.screen.ScreenChunkloader;
import matteroverdrive.client.screen.ScreenDiscManipulator;
import matteroverdrive.client.screen.ScreenHoloSign;
import matteroverdrive.client.screen.ScreenInscriber;
import matteroverdrive.client.screen.ScreenMatterAnalyzer;
import matteroverdrive.client.screen.ScreenMatterDecomposer;
import matteroverdrive.client.screen.ScreenMatterRecycler;
import matteroverdrive.client.screen.ScreenMatterReplicator;
import matteroverdrive.client.screen.ScreenMicrowave;
import matteroverdrive.client.screen.ScreenPatternMonitor;
import matteroverdrive.client.screen.ScreenPatternStorage;
import matteroverdrive.client.screen.ScreenSolarPanel;
import matteroverdrive.client.screen.ScreenSpacetimeAccelerator;
import matteroverdrive.client.screen.ScreenTransporter;
import matteroverdrive.client.screen.ScreenTritaniumCrate;
import matteroverdrive.common.event.ServerEventHandler;
import matteroverdrive.common.tags.OverdriveTags;
import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import matteroverdrive.core.matter.MatterRegister;
import matteroverdrive.registry.BlockRegistry;
import matteroverdrive.registry.ItemRegistry;
import matteroverdrive.registry.MenuRegistry;
import matteroverdrive.registry.ParticleRegistry;
import matteroverdrive.registry.TileRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;


@Mod(References.ID)
@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD)
public class MatterOverdrive {

	public MatterRegister register;

	public static final Logger LOGGER = LogUtils.getLogger();

	public static final Random RANDOM = new Random();

	public MatterOverdrive(IEventBus modEventBus, ModContainer modContainer) {
	/*	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		OverdriveBlockProperties.Defaults.init();
		SoundRegistry.SOUNDS.register(bus);
		OverdriveBlockStates.init();
		((IEventBus) BlockRegistry.BLOCKS).register(bus);
		((IEventBus) ItemRegistry.ITEMS).register(bus);
		((IEventBus) TileRegistry.TILES).register(bus);
		ConfiguredFeatureInit.CONFIGURED_FEATURES.register(bus);
		PlacedFeatureInit.PLACED_FEATURES.register(bus);
		
		FluidRegistry.FLUIDS.register(bus);
		EntityRegistry.ENTITIES.register(bus);
		ParticleRegistry.PARTICLES.register(bus);
		RecipeInit.RECIPE_TYPES.register(bus);
		RecipeInit.RECIPE_SERIALIZER.register(bus);
		NetworkHandler.init();
		ModLoadingContext.get().registerConfig(Type.COMMON, MatterOverdriveConfig.COMMON_CONFIG,
				"matteroverdrive/matteroverdrive.common.toml");
		ModLoadingContext.get().registerConfig(Type.CLIENT, MatterOverdriveConfig.CLIENT_CONFIG,
				"matteroverdrive/matteroverdrive.client.toml");
		MatterRegister.INSTANCE = new MatterRegister().subscribeAsSyncable(NetworkHandler.CHANNEL);
		*/
		NeoForge.EVENT_BUS.register(this);
		ItemRegistry.ITEMS.register(modEventBus);
		BlockRegistry.BLOCKS.register(modEventBus);
		TileRegistry.BLOCK_ENTITY_TYPES.register(modEventBus);
		ParticleRegistry.PARTICLES.register(modEventBus);
       // ModDataComponents.register(modEventBus);

	}
    @EventBusSubscriber(value= Dist.CLIENT, modid = References.ID, bus= EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents
    {
        @SubscribeEvent
        public static void menuScreens(RegisterMenuScreensEvent event)
        {
        	 event.register(MenuRegistry.MENU_TRITANIUM_CRATE.get(), ScreenTritaniumCrate::new);
        	 event.register(MenuRegistry.MENU_SOLAR_PANEL.get(), ScreenSolarPanel::new);
        	 event.register(MenuRegistry.MENU_MATTER_DECOMPOSER.get(), ScreenMatterDecomposer::new);
        	 event.register(MenuRegistry.MENU_MATTER_RECYCLER.get(), ScreenMatterRecycler::new);
        	 event.register(MenuRegistry.MENU_CHARGER.get(), ScreenCharger::new);
        	 event.register(MenuRegistry.MENU_MICROWAVE.get(), ScreenMicrowave::new);
        	 event.register(MenuRegistry.MENU_INSCRIBER.get(), ScreenInscriber::new);
        	 event.register(MenuRegistry.MENU_TRANSPORTER.get(), ScreenTransporter::new);
        	 event.register(MenuRegistry.MENU_SPACETIME_ACCELERATOR.get(), ScreenSpacetimeAccelerator::new);
        	 event.register(MenuRegistry.MENU_CHUNKLOADER.get(), ScreenChunkloader::new);
        	 event.register(MenuRegistry.MENU_PATTERN_STORAGE.get(), ScreenPatternStorage::new);
        	 event.register(MenuRegistry.MENU_MATTER_REPLICATOR.get(), ScreenMatterReplicator::new);
        	 event.register(MenuRegistry.MENU_PATTERN_MONITOR.get(), ScreenPatternMonitor::new);
        	 event.register(MenuRegistry.MENU_MATTER_ANALYZER.get(), ScreenMatterAnalyzer::new);
        	 event.register(MenuRegistry.MENU_ANDROID_STATION.get(), ScreenAndroidStation::new);
        	 event.register(MenuRegistry.MENU_DISC_MANIPULATOR.get(), ScreenDiscManipulator::new);
        	 event.register(MenuRegistry.MENU_HOLO_SIGN.get(), ScreenHoloSign::new);
        	 
        }
    }
	@SubscribeEvent
	public static void onCommonSetup(FMLCommonSetupEvent event) {
		ServerEventHandler.init();
		OverdriveTags.init();
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		MatterOverdriveCapabilities.register(event);
	}

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
	//	ClientRegister.init();
	}
}
