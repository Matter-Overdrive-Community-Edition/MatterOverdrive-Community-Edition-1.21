package matteroverdrive.registry;

import com.google.common.base.Function;

import matteroverdrive.References;
import matteroverdrive.client.ClientReferences.Colors;
import matteroverdrive.common.item.BarrelUpgrade;
import matteroverdrive.common.item.BarrelUpgrade.UpgradeBarrel;
import matteroverdrive.common.item.ColorUpgrade;
import matteroverdrive.common.item.ColorUpgrade.UpgradeColor;
import matteroverdrive.common.item.ItemPatternDrive;
import matteroverdrive.common.item.ItemUpgrade;
import matteroverdrive.common.item.ItemUpgrade.UpgradeType;
import matteroverdrive.common.item.pill.ItemAndroidPill;
import matteroverdrive.common.item.pill.types.ItemAndroidBluePill;
import matteroverdrive.common.item.pill.types.ItemAndroidRedPill;
import matteroverdrive.common.item.pill.types.ItemAndroidYellowPill;
import matteroverdrive.common.item.tools.ItemMatterContainer;
import matteroverdrive.common.item.tools.ItemMatterContainer.ContainerType;
import matteroverdrive.common.item.tools.ItemNetworkFlashDrive;
import matteroverdrive.common.item.tools.ItemSecurityProtocol;
import matteroverdrive.common.item.tools.ItemTransporterFlashdrive;
import matteroverdrive.common.item.tools.electric.ItemBattery;
import matteroverdrive.common.item.tools.electric.ItemBattery.BatteryType;
import matteroverdrive.common.item.tools.electric.ItemCommunicator;
import matteroverdrive.common.item.tools.electric.ItemEnergyWeapon;
import matteroverdrive.common.item.tools.electric.ItemMatterScanner;
import matteroverdrive.common.item.type.TypeIsolinearCircuit;
import matteroverdrive.common.item.utils.OverdriveItem;
import matteroverdrive.common.tile.matter_network.matter_replicator.TileMatterReplicator;
import matteroverdrive.core.armor.MOArmorMaterial;
import matteroverdrive.core.registers.BulkRegister;
import matteroverdrive.core.registers.IBulkRegistryObject;
import matteroverdrive.core.tools.MOToolTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {

	 public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(References.ID);

//  Materials
	public static final DeferredItem<Item> ITEM_DILITHIUM_CRYSTAL = ITEMS.register("dilithium_crystal",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_TRITANIUM_INGOT = ITEMS.register("tritanium_ingot",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_TRITANIUM_NUGGET = ITEMS.register("tritanium_nugget",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_TRITANIUM_DUST = ITEMS.register("tritanium_dust",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_RAW_MATTER_DUST = ITEMS.register("raw_matter_dust",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_MATTER_DUST = ITEMS.register("matter_dust",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_MATTER_DUST_REFINED = ITEMS.register("matter_dust_refined",
            () -> new OverdriveItem(new Item.Properties(), false));
//  Food
    public static final DeferredItem<Item> ITEM_ANDROID_PILL_RED = ITEMS.register("android_pill_red",
            () -> new ItemAndroidRedPill(new Item.Properties().food(ItemAndroidPill.PILLS), Colors.PILL_RED, true));
    public static final DeferredItem<Item> ITEM_ANDROID_PILL_BLUE = ITEMS.register("android_pill_blue",
            () -> new ItemAndroidBluePill(new Item.Properties().food(ItemAndroidPill.PILLS), Colors.PILL_BLUE, true));
    public static final DeferredItem<Item> ITEM_ANDROID_PILL_YELLOW = ITEMS.register("android_pill_yellow",
            () -> new ItemAndroidYellowPill(new Item.Properties().food(ItemAndroidPill.PILLS), Colors.PILL_YELLOW, true));
    public static final DeferredItem<Item> ITEM_EARL_GRAY_TEA = ITEMS.register("earl_gray_tea",
            () -> new OverdriveItem(new Item.Properties().food(ItemAndroidPill.PILLS), false));
    public static final DeferredItem<Item> ITEM_ROMULAN_ALE = ITEMS.register("romulan_ale",
            () -> new OverdriveItem(new Item.Properties().food(ItemAndroidPill.PILLS), false));
    public static final DeferredItem<Item> ITEM_EMERGENCY_RATION = ITEMS.register("emergency_ration",
            () -> new OverdriveItem(new Item.Properties().food(ItemAndroidPill.PILLS), false));

    public static class Foods {
        public static final FoodProperties ITEM_EARL_GRAY_TEA = new FoodProperties.Builder()
                .nutrition(6).saturationModifier(0.8f).fast().alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f).build();
        public static final FoodProperties ITEM_ROMULAN_ALE = new FoodProperties.Builder()
                .nutrition(6).saturationModifier(0.6f).fast().alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f).build();
        public static final FoodProperties ITEM_EMERGENCY_RATION = new FoodProperties.Builder()
                .nutrition(6).saturationModifier(0.6f).fast().effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f).build();
    }

//  Storage
//	public static final BulkRegister<Item> ITEM_BATTERIES = bulkItem(
//		battery -> ITEMS.register(((BatteryType) battery).id(), () -> new ItemBattery((BatteryType) battery)),
//		BatteryType.values());
//	public static final BulkRegister<Item> ITEM_MATTER_CONTAINERS = bulkItem(
//		container -> ITEMS.register(container.id(), () -> new ItemMatterContainer((ContainerType) container)),
//		ContainerType.values());

//  Crafting
    public static final DeferredItem<Item> ITEM_ME_CONVERSION_MATRIX = ITEMS.register("me_conversion_matrix",
            () -> new OverdriveItem(new Item.Properties(), false));
    public static final DeferredItem<Item> ITEM_H_COMPENSATOR = ITEMS.register("h_compensator",
            () -> new OverdriveItem(new Item.Properties(), false));
    public static final DeferredItem<Item> ITEM_INTEGRATION_MATRIX = ITEMS.register("integration_matrix",
            () -> new OverdriveItem(new Item.Properties(), false));
    public static final DeferredItem<Item> ITEM_MACHINE_CASING = ITEMS.register("machine_casing",
            () -> new OverdriveItem(new Item.Properties(), false));
    
	//public static final BulkRegister<Item> ITEM_ISOLINEAR_CIRCUITS = bulkItem(
	//	circuit -> ITEMS.register(((TypeIsolinearCircuit) circuit).id(),
	//		() -> new Item(new Item.Properties().tab(References.MAIN))),
	//	TypeIsolinearCircuit.values());

//  Matter. <-- Is this fluid matter plasma?
    public static final DeferredItem<Item> ITEM_FORCEFIELD_EMITTER = ITEMS.register("forcefield_emitter",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_WEAPON_HANDLE = ITEMS.register("weapon_handle",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_WEAPON_RECEIVER = ITEMS.register("weapon_receiver",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> ITEM_PLASMA_CORE = ITEMS.register("plasma_core",
            () -> new OverdriveItem(new Item.Properties(), false));
//  Weapons
	public static final DeferredItem<Item> ITEM_PHASER = ITEMS.register("phaser",
            () -> new ItemEnergyWeapon(new Item.Properties().rarity(Rarity.UNCOMMON), true, 10000, true, true, 1000));
	public static final DeferredItem<Item> ITEM_PHASER_RIFLE = ITEMS.register("phaser_rifle",
            () -> new ItemEnergyWeapon(new Item.Properties().rarity(Rarity.UNCOMMON), true, 10000, true, true, 1000));
	public static final DeferredItem<Item> ITEM_PLASMA_SHOTGUN = ITEMS.register("plasma_shotgun",
            () -> new ItemEnergyWeapon(new Item.Properties().rarity(Rarity.UNCOMMON), true, 10000, true, true, 1000));
	public static final DeferredItem<Item> ITEM_ION_SNIPER = ITEMS.register("ion_sniper",
            () -> new ItemEnergyWeapon(new Item.Properties().rarity(Rarity.UNCOMMON), true, 10000, true, true, 1000));
	public static final DeferredItem<Item> ITEM_OMNI_TOOL = ITEMS.register("omni_tool",
            () -> new ItemEnergyWeapon(new Item.Properties().rarity(Rarity.UNCOMMON), true, 10000, true, true, 1000));

//  Weapon Modules
	// weapon_module_color <-- This needs reworked.
	// weapon_module_barrel <-- This needs reworked, too.
	// sniper_scope <-- Same here.
	// weapon_module_ricochet <-- Same here.
	// weapon_module_holo_sights <-- Same here.
	// holo_sights_base <-- Same here.

//  Buildings
	public static final DeferredItem<Item> SHIP_FACTORY = ITEMS.register("ship_factory",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> BUILDING_BASE = ITEMS.register("building_base",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> BUILDING_MATTER_EXTRACTOR = ITEMS.register("building_matter_extractor",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> BUILDING_RESIDENTIAL = ITEMS.register("building_residential",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> BUILDING_SHIP_HANGAR = ITEMS.register("building_ship_hangar",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> BUILDING_POWER_GENERATOR = ITEMS.register("building_power_generator",
            () -> new OverdriveItem(new Item.Properties(), false));

//  Ships
	public static final DeferredItem<Item> SCOUT_SHIP = ITEMS.register("scout_ship",
            () -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<Item> SHIP_COLONIZER = ITEMS.register("ship_colonizer",
            () -> new OverdriveItem(new Item.Properties(), false));

//  Tools
	public static final DeferredItem<OverdriveItem> ITEM_TRITANIUM_WRENCH = ITEMS.register("tritanium_wrench",
		() -> new OverdriveItem(new Item.Properties(), true));
	public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",
            () -> new SwordItem(MOToolTiers.TRITANIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(MOToolTiers.TRITANIUM, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            () -> new PickaxeItem(MOToolTiers.TRITANIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(MOToolTiers.TRITANIUM, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register("bismuth_shovel",
            () -> new ShovelItem(MOToolTiers.TRITANIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(MOToolTiers.TRITANIUM, 1.5F, -3))));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register("bismuth_axe",
            () -> new AxeItem(MOToolTiers.TRITANIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(MOToolTiers.TRITANIUM, 6, -3.1f))));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register("bismuth_hoe",
            () -> new HoeItem(MOToolTiers.TRITANIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(MOToolTiers.TRITANIUM, -2, -1))));

//  Armor - Missing Cool armor look...
    public static final DeferredItem<ArmorItem> BISMUTH_HELMET = ITEMS.register("bismuth_helmet",
            () -> new ArmorItem(MOArmorMaterial.TRITANIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> BISMUTH_CHESTPLATE = ITEMS.register("bismuth_chestplate",
            () -> new ArmorItem(MOArmorMaterial.TRITANIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> BISMUTH_LEGGINGS = ITEMS.register("bismuth_leggings",
            () -> new ArmorItem(MOArmorMaterial.TRITANIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> BISMUTH_BOOTS = ITEMS.register("bismuth_boots",
            () -> new ArmorItem(MOArmorMaterial.TRITANIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

//  Android
	public static final DeferredItem<Item> ITEM_ROGUE_ANDROID_ARMS = ITEMS.register("rogue_android_arms",
            () -> new OverdriveItem(new Item.Properties(), true));
	public static final DeferredItem<Item> ITEM_ROGUE_ANDROID_CHEST = ITEMS.register("rogue_android_chest",
            () -> new OverdriveItem(new Item.Properties(), true));
	public static final DeferredItem<Item> ITEM_ROGUE_ANDROID_HEAD = ITEMS.register("rogue_android_head",
            () -> new OverdriveItem(new Item.Properties(), true));
	public static final DeferredItem<Item> ITEM_ROGUE_ANDROID_LEGS = ITEMS.register("rogue_android_legs",
            () -> new OverdriveItem(new Item.Properties(), true));
	public static final DeferredItem<Item> ITEM_TRITANIUM_SPINE = ITEMS.register("tritanium_spine",
            () -> new OverdriveItem(new Item.Properties(), true));

//  Misc
	public static final DeferredItem<ItemMatterScanner> ITEM_MATTER_SCANNER = ITEMS.register("matter_scanner",
		ItemMatterScanner::new);
	public static final DeferredItem<ItemPatternDrive> ITEM_PATTERN_DRIVE = ITEMS.register("pattern_drive",
		ItemPatternDrive::new);
	public static final DeferredItem<ItemTransporterFlashdrive> ITEM_TRANSPORTER_FLASHDRIVE = ITEMS.register("transporter_flashdrive",
		ItemTransporterFlashdrive::new);
//  energy_pack
	public static final DeferredItem<OverdriveItem> ITEM_DATAPAD = ITEMS.register("data_pad",
		() -> new OverdriveItem(new Item.Properties().stacksTo(1), true));
	// contract
	// portable_decomposer
	// security_protocol
	// spacetime_equalizer
	// record_transformation
	// artifact
	public static final DeferredItem<OverdriveItem> ITEM_TRILITHIUM_CRYSTAL = ITEMS.register("trilithium_crystal",
			() -> new OverdriveItem(new Item.Properties().stacksTo(64), false));
	// Not sure where the following fit. They are new items compared to the 1.12.2 version.
	public static final DeferredItem<OverdriveItem> ITEM_SUPERCONDUCTOR_MAGNET = ITEMS.register("s_magnet",
			() -> new OverdriveItem(new Item.Properties().stacksTo(1), false));
	public static final DeferredItem<OverdriveItem> ITEM_UPGRADE_BASE = ITEMS.register("upgrade_base",
			() -> new OverdriveItem(new Item.Properties().stacksTo(16), false));
		
//	public static final BulkRegister<Item> ITEM_UPGRADES = bulkItem(
//			upgrade -> ITEMS.register(((UpgradeType) upgrade).id(), () -> new ItemUpgrade((UpgradeType) upgrade)),
//			UpgradeType.values());
//
//	public static final BulkRegister<Item> WEAPON_MODULE_COLOR = bulkItem(
//			upgrade -> ITEMS.register(((UpgradeColor) upgrade).id(), () -> new ColorUpgrade((UpgradeColor) upgrade)),
//			UpgradeColor.values());
//	public static final BulkRegister<Item> WEAPON_MODULE_BARREL = bulkItem(
//			upgrade -> ITEMS.register(((UpgradeBarrel) upgrade).id(), () -> new BarrelUpgrade((UpgradeBarrel) upgrade)),
//			UpgradeBarrel.values());
	
	public static final DeferredItem<OverdriveItem> ITEM_TRITANIUM_PLATE = ITEMS.register("tritanium_plate",
			() -> new OverdriveItem(new Item.Properties(), false));
	public static final DeferredItem<ItemCommunicator> ITEM_COMMUNICATOR = ITEMS.register("communicator",
			() -> new ItemCommunicator(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<ItemNetworkFlashDrive> ITEM_NETWORK_FLASH_DRIVE = ITEMS.register("network_flash_drive",
			ItemNetworkFlashDrive::new);
	public static final DeferredItem<OverdriveItem> ITEM_PORTABLE_DECOMPOSER = ITEMS.register("portable_decomposer",
		() -> new OverdriveItem(new Item.Properties().stacksTo(1), false));
	public static final DeferredItem<ItemSecurityProtocol> ITEM_SECURITY_PROTOCOL = ITEMS.register("security_protocol",
		() -> new ItemSecurityProtocol(new Item.Properties().stacksTo(1), false));
	public static final DeferredItem<OverdriveItem> ITEM_SNIPER_SCOPE = ITEMS.register("sniper_scope",
		() -> new OverdriveItem(new Item.Properties().stacksTo(1), false));
	public static final DeferredItem<OverdriveItem> ITEM_SPACETIME_EQUALIZER = ITEMS.register("spacetime_equalizer",
			() -> new OverdriveItem(new Item.Properties().stacksTo(1), false));

//	private static BulkRegister<Item> bulkItem(Function<IBulkRegistryObject, DeferredItem<Item>> factory,
//			IBulkRegistryObject[] bulkValues) {
//		return new BulkRegister<>(factory, bulkValues);
//	}

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
