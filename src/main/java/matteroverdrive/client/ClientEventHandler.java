package matteroverdrive.client;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import matteroverdrive.References;
import matteroverdrive.client.keys.handlers.KeyHandlerMatterScanner;
import matteroverdrive.client.render.rlshandler.RLSHandlerMatterScanner;
import matteroverdrive.client.render.tile.RendererStationAndroid;
import matteroverdrive.client.render.tooltip.MatterValueTooltipHandler;
import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import matteroverdrive.core.config.MatterOverdriveConfig;
import matteroverdrive.core.event.handler.client.AbstractKeyPressHandler;
import matteroverdrive.core.event.handler.client.AbstractRenderLevelStageHandler;
import matteroverdrive.core.event.handler.client.AbstractTooltipHandler;
import matteroverdrive.registry.TileRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.InputEvent.Key;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class ClientEventHandler {

	private static final List<AbstractRenderLevelStageHandler> RLS_HANDLERS = new ArrayList<>();

	private static final List<AbstractKeyPressHandler> KEY_PRESS_HANDLERS = new ArrayList<>();
	private static final List<AbstractRenderLevelStageHandler> LEVEL_STAGE_RENDER_HANDLERS = new ArrayList<>();
	private static final List<AbstractTooltipHandler> TOOLTIP_HANDLERS = new ArrayList<>();

	protected static void init() {
		RLS_HANDLERS.add(new RLSHandlerMatterScanner());
		KEY_PRESS_HANDLERS.add(new KeyHandlerMatterScanner());
		TOOLTIP_HANDLERS.add(new MatterValueTooltipHandler());
	}

	@SubscribeEvent
	public static void handleTooltipEvents(ItemTooltipEvent event) {
		List<Component> tooltips = event.getToolTip();
		ItemStack item = event.getItemStack();
		// Note player can be null
		Player player = event.getEntity();

		for (AbstractTooltipHandler handler : TOOLTIP_HANDLERS) {
			handler.handleTooltips(tooltips, item, player);
		}
	}

	@SubscribeEvent
	public static void handleKeyPressEvents(Key event) {

		Minecraft minecraft = Minecraft.getInstance();
		int key = event.getKey();
		int scanCode = event.getScanCode();
		int action = event.getAction();

		for (AbstractKeyPressHandler handler : KEY_PRESS_HANDLERS) {
			handler.handleKeyPress(minecraft, scanCode, key, action);
		}

	}

	@SubscribeEvent
	public static void handleRenderEvents(RenderLevelStageEvent event) {
		LEVEL_STAGE_RENDER_HANDLERS.forEach(handler -> {
			if (handler.shouldRender(event.getStage())) {
				handler.render(event.getCamera(), event.getFrustum(), event.getLevelRenderer(), event.getPoseStack(), event.getProjectionMatrix(), Minecraft.getInstance(), event.getRenderTick(), event.getPartialTick());
			}
		});
	}
/*
	@SubscribeEvent
	public static void handlerTransporterArrival(MovementInputUpdateEvent event) {
		Entity entity = event.getEntity();
		if (MatterOverdriveConfig.ACCURATE_TRANSPORTER.get()) {
			entity.getCapability(MatterOverdriveCapabilities.ENTITY_DATA).ifPresent(h -> {
				if (h.getTransporterTimer() > 0) {
					Input input = event.getInput();
					input.down = false;
					input.forwardImpulse = 0.0F;
					input.jumping = false;
					input.left = false;
					input.leftImpulse = 0.0F;
					input.right = false;
					input.shiftKeyDown = false;
					input.up = false;
				}
			});
		}
	}
*/
	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(TileRegistry.TILE_ANDROID_STATION.get(), RendererStationAndroid::new);
	}

}
