package matteroverdrive;

import java.util.Random;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import matteroverdrive.client.ClientRegister;
import matteroverdrive.common.event.ServerEventHandler;
import matteroverdrive.common.tags.OverdriveTags;
import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import matteroverdrive.core.matter.MatterRegister;
import matteroverdrive.registry.BlockRegistry;
import matteroverdrive.registry.ItemRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
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
		MenuRegistry.MENUS.register(bus);
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

       // ModDataComponents.register(modEventBus);

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
		ClientRegister.init();
	}
}
