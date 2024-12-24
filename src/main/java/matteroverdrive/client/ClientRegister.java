package matteroverdrive.client;

import matteroverdrive.References;
import matteroverdrive.client.ClientReferences.AtlasTextures;
import matteroverdrive.client.particle.replicator.ParticleReplicator;
import matteroverdrive.client.particle.shockwave.ParticleShockwave;
import matteroverdrive.client.particle.vent.ParticleVent;
import matteroverdrive.client.render.tile.*;
import matteroverdrive.client.screen.*;
import matteroverdrive.common.item.tools.ItemMatterContainer.ContainerType;
import matteroverdrive.common.item.tools.electric.ItemBattery.BatteryType;
import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import matteroverdrive.core.utils.UtilsNbt;
import matteroverdrive.core.utils.UtilsText;
import matteroverdrive.registry.ItemRegistry;
import matteroverdrive.registry.MenuRegistry;
import matteroverdrive.registry.ParticleRegistry;
import matteroverdrive.registry.TileRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.ModelEvent.RegisterAdditional;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.TextureAtlasStitchedEvent;
/*
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
*/
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.HashMap;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class ClientRegister {
	
	private static final String BLOCK_LOC = References.ID + ":block/";
	public static final ResourceLocation CHARGE = ResourceLocation.fromNamespaceAndPath(References.ID, "charge");

	/* MODELS */

	public static final ModelResourceLocation MODEL_CHARGER = ModelResourceLocation.standalone(ResourceLocation.parse(BLOCK_LOC + "charger_renderer"));

	/* TEXTURES */
	
	public static final ResourceLocation TEXTURE_WHITE = ResourceLocation.fromNamespaceAndPath("neoforge", "white");
	public static final HashMap<AtlasTextures, TextureAtlasSprite> CACHED_TEXTUREATLASSPRITES = new HashMap<>();

	public static void setup() {


	
		ItemProperties.register(ItemRegistry.ITEM_BATTERIES.get(BatteryType.REGULAR).get(), CHARGE,
				(stack, world, entity, call) -> {
					return stack.getCapability(ForgeCapabilities.ENERGY).map(m -> {
						double chargeRatio = m.getMaxEnergyStored() > 0
								? (double) m.getEnergyStored() / (double) m.getMaxEnergyStored()
								: 0.0;
						if (chargeRatio >= 0.8) {
							return 5;
						} else if (chargeRatio >= 0.6) {
							return 4;
						} else if (chargeRatio >= 0.4) {
							return 3;
						} else if (chargeRatio >= 0.2) {
							return 2;
						} else if (chargeRatio > 0) {
							return 1;
						}
						return 0;
					}).orElse(0);
				});
		ItemProperties.register(ItemRegistry.ITEM_BATTERIES.get(BatteryType.HIGHCAPACITY).get(), CHARGE,
				(stack, world, entity, call) -> {
					return stack.getCapability(ForgeCapabilities.ENERGY).map(m -> {
						double chargeRatio = m.getMaxEnergyStored() > 0
								? (double) m.getEnergyStored() / (double) m.getMaxEnergyStored()
								: 0.0;
						if (chargeRatio >= 0.8) {
							return 5;
						} else if (chargeRatio >= 0.6) {
							return 4;
						} else if (chargeRatio >= 0.4) {
							return 3;
						} else if (chargeRatio >= 0.2) {
							return 2;
						} else if (chargeRatio > 0) {
							return 1;
						}
						return 0;
					}).orElse(0);
				});
		ItemProperties.register(ItemRegistry.ITEM_MATTER_CONTAINERS.get(ContainerType.REGULAR).get(), CHARGE,
				(stack, world, entity, call) -> {
					return stack.getCapability(MatterOverdriveCapabilities.MATTER_STORAGE).map(m -> {
						double chargeRatio = m.getMaxMatterStored() > 0 ? m.getMatterStored() / m.getMaxMatterStored()
								: 0.0;
						if (chargeRatio >= 0.875) {
							return 8;
						} else if (chargeRatio >= 0.75) {
							return 7;
						} else if (chargeRatio >= 0.625) {
							return 6;
						} else if (chargeRatio >= 0.5) {
							return 5;
						} else if (chargeRatio > 0.375) {
							return 4;
						} else if (chargeRatio >= 0.25) {
							return 3;
						} else if (chargeRatio >= 0.125) {
							return 2;
						} else if (chargeRatio > 0) {
							return 1;
						}
						return 0;
					}).orElse(0);
				});
		ItemProperties.register(ItemRegistry.ITEM_TRANSPORTER_FLASHDRIVE.get(), CHARGE,
				(stack, world, entity, call) -> {
					if (stack.hasTag() && stack.getTag().contains(UtilsNbt.BLOCK_POS)) {
						return 1;
					}
					return 0;
				});
		ItemProperties.register(ItemRegistry.ITEM_NETWORK_FLASH_DRIVE.get(), CHARGE,
				(stack, world, entity, call) -> {
					if (stack.hasTag() && stack.getTag().contains(UtilsNbt.BLOCK_POS)) {
						return 1;
					}
					return 0;
				});
		ItemProperties.register(ItemRegistry.ITEM_MATTER_SCANNER.get(), CHARGE, (stack, world, entity, call) -> {
			if (stack.hasTag() && stack.getTag().getBoolean("on")) {
				return 1;
			}
			return 0;
		});

		ClientEventHandler.init();
		UtilsText.init();

	}

	@SubscribeEvent
    public static void registerMenus(RegisterMenuScreensEvent event) {
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

	@SubscribeEvent
	public static void registerEntities(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(TileRegistry.TILE_CHARGER.get(), RendererCharger::new);
		event.registerBlockEntityRenderer(TileRegistry.TILE_INSCRIBER.get(), RendererInscriber::new);
		event.registerBlockEntityRenderer(TileRegistry.TILE_PATTERN_MONITOR.get(), RendererPatternMonitor::new);
		event.registerBlockEntityRenderer(TileRegistry.TILE_MATTER_REPLICATOR.get(), RendererMatterReplicator::new);
		event.registerBlockEntityRenderer(TileRegistry.TILE_ANDROID_STATION.get(), RendererStationAndroid::new);
		event.registerBlockEntityRenderer(TileRegistry.TILE_MATTER_ANALYZER.get(), RendererMatterAnalyzer::new);
		event.registerBlockEntityRenderer(TileRegistry.TILE_HOLO_SIGN.get(), RendererHoloSign::new);
	}

	@SubscribeEvent
	public static void onModelEvent(RegisterAdditional event) {
		event.register(MODEL_CHARGER);
	}

	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ParticleRegistry.PARTICLE_REPLICATOR.get(), ParticleReplicator.Factory::new);
		event.registerSpriteSet(ParticleRegistry.PARTICLE_SHOCKWAVE.get(), ParticleShockwave.Factory::new);
		event.registerSpriteSet(ParticleRegistry.PARTICLE_VENT.get(), ParticleVent.Factory::new);
	}

	@SubscribeEvent
	public static void cacheCustomTextureAtlases(TextureAtlasStitchedEvent event) {
		if (event.getAtlas().location().equals(TextureAtlas.LOCATION_BLOCKS)) {
			for(AtlasTextures atlas : AtlasTextures.values()) {
				ClientRegister.CACHED_TEXTUREATLASSPRITES.put(atlas, event.getAtlas().getSprite(atlas.getTexture()));
			}
		}
	}

    public static TextureAtlasSprite getSprite(ResourceLocation sprite) {
        return CACHED_TEXTUREATLASSPRITES.getOrDefault(sprite, CACHED_TEXTUREATLASSPRITES.get(TEXTURE_WHITE));
    }
}
