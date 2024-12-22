package matteroverdrive.common.event;

import java.util.ArrayList;
import java.util.List;

import matteroverdrive.References;
import matteroverdrive.common.event.handler.tick.ScheduledTaskHandler;
import matteroverdrive.common.event.handler.tick.TeleporterArrivalHandler;
import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import matteroverdrive.core.capability.types.entity_data.CapabilityEntityData;
import matteroverdrive.core.capability.types.overworld_data.CapabilityOverworldData;
import matteroverdrive.core.command.CommandGenerateMatterValues;
import matteroverdrive.core.command.CommandGenerateZeroValues;
import matteroverdrive.core.command.CommandManualMatterValue;
import matteroverdrive.core.event.RegisterMatterGeneratorsEvent;
import matteroverdrive.core.event.handler.server.AbstractServerTickHandler;
import matteroverdrive.core.matter.MatterRegister;
import matteroverdrive.core.matter.generator.DefaultMatterGenerators;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.AttachCapabilitiesEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.TickEvent.Phase;

@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD)
public class ServerEventHandler {

	private static final List<AbstractServerTickHandler> TICK_HANDLERS = new ArrayList<>();

	public static final ScheduledTaskHandler TASK_HANDLER = new ScheduledTaskHandler();
	public static final ServerEventPostManager EVENT_POST_MANAGER = new ServerEventPostManager();

	public static void init() {
		TICK_HANDLERS.add(new TeleporterArrivalHandler());
		TICK_HANDLERS.add(TASK_HANDLER);
	}

	@SubscribeEvent
	public static void reloadListeners(AddReloadListenerEvent event) {
		event.addListener(MatterRegister.INSTANCE);
	}

	@SubscribeEvent
	public static void serverStartedHandler(ServerStartedEvent event) {
		MatterRegister.INSTANCE.generateTagValues();
	}

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		CommandGenerateMatterValues.register(event.getDispatcher());
		CommandManualMatterValue.register(event.getDispatcher());
		CommandGenerateZeroValues.register(event.getDispatcher());
		EVENT_POST_MANAGER.postRegisterMatterGeneratorsEvent();
	}

	@SubscribeEvent
	public static void attachOverworldData(RegisterCapabilitiesEvent<Level> event) {
		Level world = event.getObject();
		if (!world.getCapability(MatterOverdriveCapabilities.OVERWORLD_DATA).isPresent()
				&& world.dimension().equals(Level.OVERWORLD)) {
			event.addCapability(new ResourceLocation(References.ID, "overworld_data"), new CapabilityOverworldData());
		}
	}

	@SubscribeEvent
	public static void attachEntityCaps(AttachCapabilitiesEvent<Entity> event) {
		if (!event.getObject().getCapability(MatterOverdriveCapabilities.ENTITY_DATA).isPresent()) {
			event.addCapability(new ResourceLocation(References.ID, "entity_data"), new CapabilityEntityData());
		}
	}

	@SubscribeEvent
	public static void handlerServerTickEvents(ServerTickEvent event) {

		MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
		Phase phase = event.phase;
		boolean enoughTime = event.haveTime();

		for (AbstractServerTickHandler handler : TICK_HANDLERS) {
			handler.handleTick(server, phase, enoughTime);
		}

	}
	
	@SubscribeEvent
	public static void registerDefaultMatterGenerators(RegisterMatterGeneratorsEvent event) {
		DefaultMatterGenerators.gatherGenerators(event);
	}
}
