package matteroverdrive.registry;

import matteroverdrive.common.tile.*;

import matteroverdrive.References;
import matteroverdrive.common.block.type.TypeMachine;
import matteroverdrive.common.tile.matter_network.TileDiscManipulator;
import matteroverdrive.common.tile.matter_network.TileMatterAnalyzer;
import matteroverdrive.common.tile.matter_network.TileMatterNetworkCable;
import matteroverdrive.common.tile.matter_network.TilePatternMonitor;
import matteroverdrive.common.tile.matter_network.TilePatternStorage;
import matteroverdrive.common.tile.matter_network.matter_replicator.TileMatterReplicator;
import matteroverdrive.common.tile.station.TileAndroidStation;
import matteroverdrive.common.tile.transporter.TileTransporter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TileRegistry {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, References.ID);
/*
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileTritaniumCrate>> TILE_TRITANIUM_CRATE = BLOCK_ENTITY_TYPES
    		.register("tritanium_crate", () -> BlockEntityType.Builder.of(TileTritaniumCrate::new, 
    				BlockRegistry.BLOCK_TRITANIUM_CRATES.getObjectsAsArray(new Block[0])).build(null));	
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileSolarPanel>> TILE_SOLAR_PANEL = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.SOLAR_PANEL.id(), () -> BlockEntityType.Builder.of(TileSolarPanel::new, 
    				BlockRegistry.BLOCK_SOLAR_PANEL.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMatterDecomposer>> TILE_MATTER_DECOMPOSER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.MATTER_DECOMPOSER.id(), () -> BlockEntityType.Builder.of(TileMatterDecomposer::new, 
    				BlockRegistry.BLOCK_MATTER_DECOMPOSER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMatterRecycler>> TILE_MATTER_RECYCLER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.MATTER_RECYCLER.id(), () -> BlockEntityType.Builder.of(TileMatterRecycler::new, 
    				BlockRegistry.BLOCK_MATTER_RECYCLER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileCharger>> TILE_CHARGER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.CHARGER.id(), () -> BlockEntityType.Builder.of(TileCharger::new, 
    				BlockRegistry.BLOCK_CHARGER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMicrowave>> TILE_MICROWAVE = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.MICROWAVE.id(), () -> BlockEntityType.Builder.of(TileMicrowave::new, 
    				BlockRegistry.BLOCK_MICROWAVE.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileInscriber>> TILE_INSCRIBER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.INSCRIBER.id(), () -> BlockEntityType.Builder.of(TileInscriber::new, 
    				BlockRegistry.BLOCK_INSCRIBER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMatterConduit>> TILE_MATTER_CONDUIT = BLOCK_ENTITY_TYPES
    		.register("matter_conduit", () -> BlockEntityType.Builder.of(TileMatterConduit::new, 
    				BlockRegistry.BLOCK_MATTER_CONDUITS.getObjectsAsArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileTransporter>> TILE_TRANSPORTER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.TRANSPORTER.id(), () -> BlockEntityType.Builder.of(TileTransporter::new, 
    				BlockRegistry.BLOCK_TRANSPORTER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileSpacetimeAccelerator>> TILE_SPACETIME_ACCELERATOR = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.SPACETIME_ACCELERATOR.id(), () -> BlockEntityType.Builder.of(TileSpacetimeAccelerator::new, 
    				BlockRegistry.BLOCK_SPACETIME_ACCELERATOR.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMatterNetworkCable>> TILE_MATTER_NETWORK_CABLE = BLOCK_ENTITY_TYPES
    		.register("network_cable", () -> BlockEntityType.Builder.of(TileMatterNetworkCable::new, 
    				BlockRegistry.BLOCK_MATTER_NETWORK_CABLES.getObjectsAsArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileChunkloader>> TILE_CHUNKLOADER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.CHUNKLOADER.id(), () -> BlockEntityType.Builder.of(TileChunkloader::new, 
    				BlockRegistry.BLOCK_CHUNKLOADER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMatterAnalyzer>> TILE_MATTER_ANALYZER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.MATTER_ANALYZER.id(), () -> BlockEntityType.Builder.of(TileMatterAnalyzer::new, 
    				BlockRegistry.BLOCK_MATTER_ANALYZER.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TilePatternStorage>> TILE_PATTERN_STORAGE = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.PATTERN_STORAGE.id(), () -> BlockEntityType.Builder.of(TilePatternStorage::new, 
    				BlockRegistry.BLOCK_PATTERN_STORAGE.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TilePatternMonitor>> TILE_PATTERN_MONITOR = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.PATTERN_MONITOR.id(), () -> BlockEntityType.Builder.of(TilePatternMonitor::new, 
    				BlockRegistry.BLOCK_PATTERN_MONITOR.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileHoloSign>> TILE_HOLO_SIGN = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.HOLO_SIGN.id(), () -> BlockEntityType.Builder.of(TileHoloSign::new, 
    				BlockRegistry.BLOCK_HOLO_SIGN.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMatterReplicator>> TILE_MATTER_REPLICATOR = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.MATTER_REPLICATOR.id(), () -> BlockEntityType.Builder.of(TileMatterReplicator::new, 
    				BlockRegistry.BLOCK_MATTER_REPLICATOR.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileAndroidStation>> TILE_ANDROID_STATION = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.ANDROID_STATION.id(), () -> BlockEntityType.Builder.of(TileAndroidStation::new, 
    				BlockRegistry.BLOCK_ANDROID_STATION.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileDiscManipulator>> TILE_DISC_MANIPULATOR = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.DISC_MANIPULATOR.id(), () -> BlockEntityType.Builder.of(TileDiscManipulator::new, 
    				BlockRegistry.BLOCK_DISC_MANIPULATOR.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileStarMap>> TILE_STAR_MAP = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.STAR_MAP.id(), () -> BlockEntityType.Builder.of(TileStarMap::new, 
    				BlockRegistry.BLOCK_STAR_MAP.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileWeaponStation>> TILE_WEAPON_STATION = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.WEAPON_STATION.id(), () -> BlockEntityType.Builder.of(TileWeaponStation::new, 
    				BlockRegistry.BLOCK_WEAPON_STATION.get()).build(null));
   
     Not Done.
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileSpacetimeEqualizer>> TILE_SPACETIME_EQUALIZER = BLOCK_ENTITY_TYPES
    		.register(TypeMachine.SPACETIME_EQUALIZER.id(), () -> BlockEntityType.Builder.of(TileSpacetimeEqualizer::new, 
    				ItemRegistry.ITEM_SPACETIME_EQUALIZER.get()).build(null));
*/
}
