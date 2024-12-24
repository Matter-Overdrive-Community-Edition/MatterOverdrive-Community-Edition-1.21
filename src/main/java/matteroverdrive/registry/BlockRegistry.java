package matteroverdrive.registry;

import java.util.function.Function;
import java.util.function.Supplier;

import matteroverdrive.References;
import matteroverdrive.common.block.*;
import matteroverdrive.common.block.cable.types.BlockMatterConduit;
import matteroverdrive.common.block.cable.types.BlockMatterNetworkCable;
import matteroverdrive.common.block.charger.BlockAndroidChargerChild;
import matteroverdrive.common.block.charger.BlockAndroidChargerParent;
import matteroverdrive.common.block.type.TypeMachine;
import matteroverdrive.common.block.type.TypeMatterConduit;
import matteroverdrive.common.block.type.TypeMatterNetworkCable;
import matteroverdrive.common.blockitem.BlockItemColored;
import matteroverdrive.common.blockitem.OverdriveBlockItem;
import matteroverdrive.common.tile.*;
import matteroverdrive.common.tile.TileTritaniumCrate.CrateColors;
import matteroverdrive.common.tile.matter_network.TileDiscManipulator;
import matteroverdrive.common.tile.matter_network.TileMatterAnalyzer;
import matteroverdrive.common.tile.matter_network.TilePatternMonitor;
import matteroverdrive.common.tile.matter_network.TilePatternStorage;
import matteroverdrive.common.tile.matter_network.matter_replicator.TileMatterReplicator;
import matteroverdrive.common.tile.station.TileAndroidStation;
import matteroverdrive.common.tile.transporter.TileTransporter;
import matteroverdrive.core.block.OverdriveBlockProperties;
import matteroverdrive.core.registers.BulkRegister;
import matteroverdrive.core.registers.IBulkRegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(References.ID);
	private static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK, References.ID);
	
	/**
	 * REGISTRY ORDER NOTES:
	 * 
	 * Register ore blocks, decoration blocks, then crates, then machines
	 */

	// Ore Blocks
	public static final DeferredBlock<Block> DILITHIUM_ORE = BLOCKS.register(
	        "dilithium_ore", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(2.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> TRITANIUM_ORE = BLOCKS.register(
	        "tritanium_ore", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(2.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> DEEPSLATE_DILITHIUM_ORE = BLOCKS.register(
	        "deepslate_dilithium_ore", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(2.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> DEEPSLATE_TRITANIUM_ORE = BLOCKS.register(
	        "deepslate_tritanium_ore", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(2.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	// Decoration Blocks
	public static final DeferredBlock<Block> BLOCK_REGULAR_TRITANIUM_PLATING = BLOCKS.register(
	        "tritanium_plating", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> BLOCK_STEELSCAFFOLDING = BLOCKS.register(
	        "steelscaffold", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(2.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.METAL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> BLOCK_MACHINE_HULL = BLOCKS.register(
	        "machine_hull", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> HOLO_MATRIX = BLOCKS.register(
	        "holo_matrix", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> EXHAUST_PLASMA = BLOCKS.register(
	        "engine_exhaust_plasma", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> YELLOW_STRIPES = BLOCKS.register(
	        "stripes", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> TRITANIUM_PLATE_STRIPE = BLOCKS.register(
	        "tritanium_plate_stripe", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> TRITANIUM_RAIL = BLOCKS.register(
	        "tritanium_rail", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> MATTER_TUBE = BLOCKS.register(
	        "matter_tube", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> SOFT_WALL_PLATES = BLOCKS.register(
	        "white_plate", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));

	public static final DeferredBlock<Block> BLOCK_DECORATIVE_BEAMS = BLOCKS.register(
	        "decorative.beams", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> BLOCK_DECORATIVE_CARBON_FIBER_PLATE = BLOCKS.register(
	        "decorative.carbon_fiber_plate", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> BLOCK_DECORATIVE_CLEAN = BLOCKS.register(
	        "decorative.clean", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> BLOCK_DECORATIVE_COILS = BLOCKS.register(
	        "decorative.coils", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> BLOCK_VENT_OPEN = BLOCKS.register(
	        "vent_open", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> BLOCK_VENT_CLOSED = BLOCKS.register(
	        "vent_closed", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> BLOCK_INDUSTRIAL_GLASS = BLOCKS.register(
	        "industrial_glass", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
	public static final DeferredBlock<Block> TRITANIUM_LAMP = BLOCKS.register(
	        "tritanium_lamp", 
	        () -> new Block(BlockBehaviour.Properties.of()
	                .destroyTime(1.0f)
	                .explosionResistance(10.0f)
	                .sound(SoundType.GRAVEL)
	                .lightLevel(state -> 7)
	        ));
/*
	public static final BulkRegister<Block> BLOCK_COLORED_TRITANIUM_PLATING = bulkBlock(
			color -> registerColoredBlock(color.id("tritanium_plating_"),
					() -> new BlockColored(
							Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1F, 100F),
							((OverdriveBlockColors) color).color),
					false, ((OverdriveBlockColors) color).color),
			OverdriveBlockColors.values());
	public static final BulkRegister<Block> BLOCK_FLOOR_TILE = bulkBlock(
			color -> registerColoredBlock(((OverdriveBlockColors) color).id("floor_tile_"),
					() -> new BlockColored(
							Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1F, 100F),
							((OverdriveBlockColors) color).color),
					false, ((OverdriveBlockColors) color).color),
			OverdriveBlockColors.values());
	public static final BulkRegister<Block> BLOCK_FLOOR_TILES = bulkBlock(
			color -> registerColoredBlock(((OverdriveBlockColors) color).id("floor_tiles_"),
					() -> new BlockColored(
							Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1F, 100F),
							((OverdriveBlockColors) color).color),
					false, ((OverdriveBlockColors) color).color),
			OverdriveBlockColors.values());

	// Crates

	public static final BulkRegister<Block> BLOCK_TRITANIUM_CRATES = bulkBlock(crate -> registerBlock(
			((CrateColors) crate).id(),
			() -> new BlockTritaniumCrate(OverdriveBlockProperties
					.from(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1F, 100F).noOcclusion())
					.setCanBeWaterlogged().setHasFacing(false)),
			true), TileTritaniumCrate.CrateColors.values());
/*
	// Machines
	public static final DeferredHolder<BlockMachine, BLOCK_SOLAR_PANEL> GRAVESTONE = BLOCK_REGISTER.register(TypeMachine.SOLAR_PANEL.id(), TileSolarPanel::new);
	public static final DeferredBlock<Block> BLOCK_SOLAR_PANEL = registerBlock(
			TypeMachine.SOLAR_PANEL.id(), () -> new BlockMachine<>(TileSolarPanel::new,
					TypeMachine.SOLAR_PANEL, TileRegistry.TILE_SOLAR_PANEL),
			true);

	public static final DeferredBlock<Block> BLOCK_MATTER_DECOMPOSER = registerBlock(
			TypeMachine.MATTER_DECOMPOSER.id(), () -> new BlockMachine<>(TileMatterDecomposer::new,
					TypeMachine.MATTER_DECOMPOSER, TileRegistry.TILE_MATTER_DECOMPOSER),
			true);

	public static final DeferredBlock<Block> BLOCK_DISC_MANIPULATOR = registerBlockNoItem(
			TypeMachine.DISC_MANIPULATOR.id(), () -> new BlockMachine<>(TileDiscManipulator::new,
					TypeMachine.DISC_MANIPULATOR, TileRegistry.TILE_DISC_MANIPULATOR),
			true);

	public static final DeferredBlock<Block> BLOCK_MATTER_RECYCLER = registerBlock(TypeMachine.MATTER_RECYCLER.id(),
			() -> new BlockMachine<>(TileMatterRecycler::new, TypeMachine.MATTER_RECYCLER,
					TileRegistry.TILE_MATTER_RECYCLER),
			true);

	public static final DeferredBlock<Block> BLOCK_CHARGER_CHILD = registerBlock("charger_child",
			() -> new BlockAndroidChargerChild(), true);

	public static final DeferredBlock<Block> BLOCK_CHARGER = registerBlock(TypeMachine.CHARGER.id(),
			() -> new BlockAndroidChargerParent<>(TileCharger::new, TypeMachine.CHARGER, TileRegistry.TILE_CHARGER),
			true);

	public static final DeferredBlock<Block> BLOCK_MICROWAVE = registerBlock(TypeMachine.MICROWAVE.id(),
			() -> new BlockMachine<>(TileMicrowave::new, TypeMachine.MICROWAVE, TileRegistry.TILE_MICROWAVE), true);

	public static final DeferredBlock<Block> BLOCK_INSCRIBER = registerBlock(TypeMachine.INSCRIBER.id(),
			() -> new BlockMachine<>(TileInscriber::new, TypeMachine.INSCRIBER, TileRegistry.TILE_INSCRIBER), true);

	public static final BulkRegister<Block> BLOCK_MATTER_CONDUITS = bulkBlock(
			conduit -> registerBlock(((TypeMatterConduit) conduit).id(),
					() -> new BlockMatterConduit((TypeMatterConduit) conduit), true),
			TypeMatterConduit.values());

	public static final DeferredBlock<Block> BLOCK_TRANSPORTER = registerBlock(TypeMachine.TRANSPORTER.id(),
			() -> new BlockMachine<>(TileTransporter::new, TypeMachine.TRANSPORTER, TileRegistry.TILE_TRANSPORTER),
			true);

	public static final DeferredBlock<Block> BLOCK_SPACETIME_ACCELERATOR = registerBlock(
			TypeMachine.SPACETIME_ACCELERATOR.id(), () -> new BlockMachine<>(TileSpacetimeAccelerator::new,
					TypeMachine.SPACETIME_ACCELERATOR, TileRegistry.TILE_SPACETIME_ACCELERATOR),
			true);

	public static final BulkRegister<Block> BLOCK_MATTER_NETWORK_CABLES = bulkBlock(
			cable -> registerBlock(cable.id(), () -> new BlockMatterNetworkCable((TypeMatterNetworkCable) cable), true),
			TypeMatterNetworkCable.values());

	public static final DeferredBlock<Block> BLOCK_CHUNKLOADER = registerBlock(TypeMachine.CHUNKLOADER.id(),
			() -> new BlockMachine<>(TileChunkloader::new, TypeMachine.CHUNKLOADER, 
					TileRegistry.TILE_CHUNKLOADER),
			true);

	public static final DeferredBlock<Block> BLOCK_MATTER_ANALYZER = registerBlock(TypeMachine.MATTER_ANALYZER.id(),
			() -> new BlockMachine<>(TileMatterAnalyzer::new, TypeMachine.MATTER_ANALYZER,
					TileRegistry.TILE_MATTER_ANALYZER),
			true);

	public static final DeferredBlock<Block> BLOCK_PATTERN_STORAGE = registerBlock(TypeMachine.PATTERN_STORAGE.id(),
			() -> new BlockMachine<>(TilePatternStorage::new, TypeMachine.PATTERN_STORAGE,
					TileRegistry.TILE_PATTERN_STORAGE),
			true);

	public static final DeferredBlock<Block> BLOCK_PATTERN_MONITOR = registerBlock(TypeMachine.PATTERN_MONITOR.id(),
			() -> new BlockMachine<>(TilePatternMonitor::new, TypeMachine.PATTERN_MONITOR,
					TileRegistry.TILE_PATTERN_MONITOR),
			true);

	public static final DeferredBlock<Block> BLOCK_MATTER_REPLICATOR = registerBlock(TypeMachine.MATTER_REPLICATOR.id(),
			() -> new BlockMachine<>(TileMatterReplicator::new,	TypeMachine.MATTER_REPLICATOR,
					TileRegistry.TILE_MATTER_REPLICATOR),
			true);

	public static final DeferredBlock<Block> BLOCK_ANDROID_STATION = registerBlock("coal_generator", Block::new);
	public static final DeferredBlock<Block> 1BLOCK_ANDROID_STATION = registerBlock(TypeMachine.ANDROID_STATION.id(),
			() -> new BlockMachine<>(TileAndroidStation::new, TypeMachine.ANDROID_STATION,
					TileRegistry.TILE_ANDROID_STATION),
			true);

	public static final DeferredBlock<Block> BLOCK_HOLO_SIGN = registerBlock(TypeMachine.HOLO_SIGN.id(),
			() -> new BlockMachine<>(TileHoloSign::new, TypeMachine.HOLO_SIGN,
					TileRegistry.TILE_HOLO_SIGN),
			true);
	//public static final DeferredBlock<Block> BLOCK_HOLO_SIGN1 = registerBlock(TypeMachine.HOLO_SIGN.id(), () -> new PortalGroupBlock(() -> portal_frame_tile));
	// For crafting only now.
	public static final DeferredBlock<Block> BLOCK_NETWORK_SWITCH = registerBlock("network_switch",
			() -> new BlockOverdrive(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1F, 100F)),
			false);

	
	public static final DeferredBlock<Block> BLOCK_STAR_MAP = registerBlock(TypeMachine.STAR_MAP.id(),
			() -> new BlockMachine<>(TileStarMap::new, TypeMachine.STAR_MAP, TileRegistry.TILE_STAR_MAP), true);

	public static final DeferredBlock<Block> BLOCK_WEAPON_STATION = registerBlock(TypeMachine.WEAPON_STATION.id(),
			() -> new BlockMachine(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1F, 100F)),
			false);

	// Functional Methods
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    
	private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier, boolean shiftTip) {
		return registerBlock(name, supplier, new Item.Properties(), shiftTip);
	}

	private static DeferredBlock<Block> registerBlockNoItem(String name, Supplier<Block> supplier, boolean shiftTip) {
		return registerBlock(name, supplier, new Item.Properties(), shiftTip);
	}

	private static DeferredBlock<Block> registerBlock(String name, Supplier<Block> supplier,
			Item.Properties properties, boolean shiftTip) {
		DeferredBlock<Block> block = BLOCKS.register(name, supplier);
		ItemRegistry.ITEMS.register(name, () -> new OverdriveBlockItem(block.get(), properties, shiftTip));
		return block;
	}

	private static DeferredBlock<Block> registerColoredBlock(String name, Supplier<Block> supplier, boolean shiftTip,
			int color) {
		return registerColoredBlock(name, supplier, new Item.Properties(), shiftTip, color);
	}

	private static DeferredBlock<Block> registerColoredBlock(String name, Supplier<Block> supplier,
			Item.Properties properties, boolean shiftTip, int color) {
		DeferredBlock<Block> block = BLOCKS.register(name, supplier);
		ItemRegistry.ITEMS.register(name, () -> new BlockItemColored(block.get(), properties, shiftTip, color));
		return block;
	}
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
    	ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }*/
}
