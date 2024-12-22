package matteroverdrive.datagen.client;

import matteroverdrive.References;
import matteroverdrive.common.block.OverdriveBlockColors;
import matteroverdrive.common.block.type.TypeMachine;
import matteroverdrive.common.block.type.TypeMatterConduit;
import matteroverdrive.common.block.type.TypeMatterNetworkCable;
import matteroverdrive.common.item.ItemUpgrade.UpgradeType;
import matteroverdrive.common.item.tools.ItemMatterContainer.ContainerType;
import matteroverdrive.common.item.tools.electric.ItemBattery.BatteryType;
import matteroverdrive.common.item.tools.electric.ItemCommunicator;
import matteroverdrive.common.item.type.TypeIsolinearCircuit;
import matteroverdrive.common.recipe.item2item.specific_machines.InscriberRecipe;
import matteroverdrive.common.tile.TileTritaniumCrate;
import matteroverdrive.common.tile.TileTritaniumCrate.CrateColors;
import matteroverdrive.registry.BlockRegistry;
import matteroverdrive.registry.ItemRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class OverdriveLangKeyProvider extends LanguageProvider {

	public final Locale locale;
	public final String modID;

	public OverdriveLangKeyProvider(PackOutput output, Locale locale, String modID) {
		super(output, modID, locale.toString());
		this.locale = locale;
		this.modID = modID;
	}

	public OverdriveLangKeyProvider(PackOutput output, Locale local) {
		this(output, local, References.ID);
	}

	@Override
	protected void addTranslations() {

		switch (locale) {
		case "ru_ru":
			add("itemGroup.itemgroup" + References.ID + "main", "Ð­Ð½ÐµÑ€Ð³ÐµÑ‚Ð¸Ñ‡ÐµÑ�ÐºÐ°Ñ� Ñ�Ñ‡ÐµÐ¹ÐºÐ°");

			addItem(ItemRegistry.ITEM_MATTER_SCANNER, "Ð¡ÐºÐ°Ð½ÐµÑ€ Ð¼Ð°Ñ‚ÐµÑ€Ð¸Ð¸");
			addItem(ItemRegistry.ITEM_EMERGENCY_RATION, "Ð�Ð²Ð°Ñ€Ð¸Ð¹Ð½Ñ‹Ð¹ Ð¿Ð°Ñ‘Ðº");
			addItem(ItemRegistry.ITEM_PHASER, "Ð¤Ð°Ð·ÐµÑ€");
			addItem(ItemRegistry.ITEM_BATTERIES.get(BatteryType.REGULAR), "Ð‘Ð°Ñ‚Ð°Ñ€ÐµÐ¹ÐºÐ°");
			addItem(ItemRegistry.ITEM_BATTERIES.get(BatteryType.CREATIVE), "Ð¢Ð²Ð¾Ñ€Ñ‡ÐµÑ�ÐºÐ°Ñ� Ð±Ð°Ñ‚Ð°Ñ€ÐµÐ¹ÐºÐ°");
			addItem(ItemRegistry.ITEM_ME_CONVERSION_MATRIX, "ÐœÐ°Ñ‚ÐµÑ€Ð¸Ð°Ð»ÑŒÐ½Ð¾-Ñ�Ð½ÐµÑ€Ð³ÐµÑ‚Ð¸Ñ‡ÐµÑ�ÐºÐ°Ñ� ÐºÐ¾Ð½Ð²ÐµÑ€Ñ‚Ð¸Ñ€ÑƒÑŽÑ‰Ð°Ñ� Ð¼Ð°Ñ‚Ñ€Ð¸Ñ†Ð°");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER1), "Ð˜Ð·Ð¾Ð»Ð¸Ð½ÐµÐ¹Ð½Ð°Ñ� Ñ�Ñ…ÐµÐ¼Ð° MK1");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER2), "Ð˜Ð·Ð¾Ð»Ð¸Ð½ÐµÐ¹Ð½Ð°Ñ� Ñ�Ñ…ÐµÐ¼Ð° MK2");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER3), "Ð˜Ð·Ð¾Ð»Ð¸Ð½ÐµÐ¹Ð½Ð°Ñ� Ñ�Ñ…ÐµÐ¼Ð° MK3");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER4), "Ð˜Ð·Ð¾Ð»Ð¸Ð½ÐµÐ¹Ð½Ð°Ñ� Ñ�Ñ…ÐµÐ¼Ð° MK4");
			addItem(ItemRegistry.ITEM_UPGRADE_BASE, "ÐžÐ±Ð¾Ð»Ð¾Ñ‡ÐºÐ° ÑƒÐ»ÑƒÑ‡ÑˆÐµÐ½Ð¸Ð¹");
			addItem(ItemRegistry.ITEM_H_COMPENSATOR, "Ð“ÐµÐ¹Ð·ÐµÐ½Ð±ÐµÑ€Ð³Ð¾Ð²Ñ�ÐºÐ¸Ð¹ ÐºÐ¾Ð¼Ð¿ÐµÐ½Ñ�Ð°Ñ‚Ð¾Ñ€");
			addItem(ItemRegistry.ITEM_INTEGRATION_MATRIX, "ÐœÐ°Ñ‚Ñ€Ð¸Ñ†Ð° Ð¸Ð½Ñ‚ÐµÐ³Ñ€Ð°Ñ†Ð¸Ð¸");
			addItem(ItemRegistry.ITEM_SUPERCONDUCTOR_MAGNET, "Ð¡Ð²ÐµÑ€Ñ…Ð¿Ñ€Ð¾Ð²Ð¾Ð´Ñ�Ñ‰Ð¸Ð¹ Ð¼Ð°Ð³Ð½Ð¸Ñ‚");
//			item.matteroverdrive.matter_dust_refined.name=ÐžÑ‡Ð¸ÑˆÐµÐ½Ð½Ð°Ñ� Ð¼Ð°Ñ‚ÐµÑ€Ð¸Ð°Ð»ÑŒÐ½Ð°Ñ� Ð¿Ñ‹Ð»ÑŒ
			addItem(ItemRegistry.ITEM_MATTER_DUST, "ÐœÐ°Ñ‚ÐµÑ€Ð¸Ð°Ð»ÑŒÐ½Ð°Ñ� Ð¿Ñ‹Ð»ÑŒ");

			addItemDescTooltip(ItemRegistry.ITEM_MATTER_DUST, "ÐŸÐ¾Ð»Ð¾Ð¶Ð¸Ñ‚ÑŒ Ð² ÑƒÑ‚Ð¸Ð»Ð¸Ð·Ð°Ñ‚Ð¾Ñ€, Ñ‡Ñ‚Ð¾Ð±Ñ‹ Ð¾Ñ‡Ð¸Ñ�Ñ‚Ð¸Ñ‚ÑŒ");
			addItem(ItemRegistry.ITEM_MACHINE_CASING, "ÐœÐ°ÑˆÐ¸Ð½Ð½Ñ‹Ð¹ ÐºÐ¾Ñ€Ð¿ÑƒÑ�");
			addItem(ItemRegistry.ITEM_DILITHIUM_CRYSTAL, "Ð”Ð¸Ð»Ð¸Ñ‚Ð¸ÐµÐ²Ñ‹Ð¹ ÐºÑ€Ð¸Ñ�Ñ‚Ð°Ð»Ð»");
			addItem(ItemRegistry.ITEM_TRITANIUM_INGOT, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ Ñ�Ð»Ð¸Ñ‚Ð¾Ðº");
			addItem(ItemRegistry.ITEM_TRITANIUM_PLATE, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ð°Ñ� Ð¿Ð»Ð°Ñ�Ñ‚Ð¸Ð½Ð°");
			addItem(ItemRegistry.ITEM_TRITANIUM_DUST, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ð°Ñ� Ð¿Ñ‹Ð»ÑŒ");
			addItem(ItemRegistry.ITEM_PATTERN_DRIVE, "Ð¨Ð°Ð±Ð»Ð¾Ð½ Ð¿Ñ€Ð¸Ð²Ð¾Ð´Ð°");
			addItemDescTooltip(ItemRegistry.ITEM_PATTERN_DRIVE, "Ð¥Ñ€Ð°Ð½Ð¸Ñ‚ 2 ÑˆÐ°Ð±Ð»Ð¾Ð½Ð° Ð¿Ñ€ÐµÐ´Ð¼ÐµÑ‚Ð°");
			addItem(ItemRegistry.ITEM_EARL_GRAY_TEA, "Ð§Ð°Ð¹. Ð­Ñ€Ð» Ð“Ñ€ÐµÐ¹. Ð“Ð¾Ñ€Ñ�Ñ‡Ð¸Ð¹.");
			addItem(ItemRegistry.ITEM_ROMULAN_ALE, "Ð Ð¾Ð¼ÑƒÐ»Ð°Ð½Ñ�ÐºÐ¸Ð¹ Ñ�Ð»ÑŒ");
			addItemDescTooltip(ItemRegistry.ITEM_ROMULAN_ALE, "Ð’Ñ‹Ñ�Ð¾ÐºÐ¾ Ð¾Ð¿ÑŒÑ�Ð½Ñ�ÑŽÑ‰Ð¸Ð¹ Ð°Ð»ÐºÐ¾Ð³Ð¾Ð»ÑŒÐ½Ñ‹Ð¹ Ð½Ð°Ð¿Ð¸Ñ‚Ð¾Ðº Ñ€Ð¾Ð¼ÑƒÐ»Ð°Ð½Ñ�ÐºÐ¾Ð³Ð¾ Ð¿Ñ€Ð¾Ð¸Ñ�Ñ…Ð¾Ð¶Ð´ÐµÐ½Ð¸Ñ�");
			addItem(ItemRegistry.ITEM_SUPERCONDUCTOR_MAGNET, "Ð¡Ð²ÐµÑ€Ñ…Ð¿Ñ€Ð¾Ð²Ð¾Ð´Ñ�Ñ‰Ð¸Ð¹ Ð¼Ð°Ð³Ð½Ð¸Ñ‚");

			// Not implemented yet.

//			item.matteroverdrive.security_protocol.empty.name=ÐŸÑ€Ð¾Ñ‚Ð¾ÐºÐ¾Ð» Ð±ÐµÐ·Ð¾Ð¿Ð°Ñ�Ð½Ð¾Ñ�Ñ‚Ð¸
//			item.matteroverdrive.security_protocol.claim.name=ÐŸÑ€Ð¾Ñ‚Ð¾ÐºÐ¾Ð» Ð±ÐµÐ·Ð¾Ð¿Ð°Ñ�Ð½Ð¾Ñ�Ñ‚Ð¸ [Ð—Ð°Ð¿Ñ€Ð¾Ñ�]
//			item.matteroverdrive.security_protocol.claim.details=Ð—Ð°Ñ‰Ð¸Ñ‰Ð°ÐµÑ‚ Ð¼Ð°ÑˆÐ¸Ð½Ñ‹
//			item.matteroverdrive.security_protocol.access.name=ÐŸÑ€Ð¾Ñ‚Ð¾ÐºÐ¾Ð» Ð±ÐµÐ·Ð¾Ð¿Ð°Ñ�Ð½Ð¾Ñ�Ñ‚Ð¸ [Ð”Ð¾Ñ�Ñ‚ÑƒÐ¿]
//			item.matteroverdrive.security_protocol.access.details=ÐŸÐ¾Ð·Ð²Ð¾Ð»Ñ�ÐµÑ‚ Ð¿Ð¾Ð»ÑƒÑ‡Ð¸Ñ‚ÑŒ Ð´Ð¾Ñ�Ñ‚ÑƒÐ¿ Ðº Ð·Ð°Ñ‰Ð¸Ñ‰ÐµÐ½Ð½Ñ‹Ð¼ Ð¼Ð°ÑˆÐ¸Ð½Ð°Ð¼
//			item.matteroverdrive.security_protocol.remove.name=ÐŸÑ€Ð¾Ñ‚Ð¾ÐºÐ¾Ð» Ð±ÐµÐ·Ð¾Ð¿Ð°Ñ�Ð½Ð¾Ñ�Ñ‚Ð¸ [Ð£Ð´Ð°Ð»ÐµÐ½Ð¸Ðµ]
//			item.matteroverdrive.security_protocol.remove.details=Ð£Ð±Ð¸Ñ€Ð°ÐµÑ‚ Ð·Ð°Ñ‰Ð¸Ñ‚Ñƒ Ñƒ Ð¼Ð°ÑˆÐ¸Ð½
//			item.matteroverdrive.security_protocol.invalid=Ð�ÐµÐ²ÐµÑ€Ð½Ñ‹Ð¹ Ð¿Ñ€Ð¾Ñ‚Ð¾ÐºÐ¾Ð» Ð±ÐµÐ·Ð¾Ð¿Ð°Ñ�Ð½Ð¾Ñ�Ñ‚Ð¸

			addItem(ItemRegistry.ITEM_TRITANIUM_WRENCH, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ ÐºÐ»ÑŽÑ‡");
			addItemDescTooltip(ItemRegistry.ITEM_TRITANIUM_WRENCH, "Ð‘ÐµÐ·Ð¾Ð¿Ð°Ñ�Ð½Ð¾ Ð´ÐµÐ¼Ð¾Ð½Ñ‚Ð¸Ñ€ÑƒÐµÑ‚ Ð¸ Ð²Ñ€Ð°Ñ‰Ð°ÐµÑ‚ Ð¼Ð°ÑˆÐ¸Ð½Ñ‹");

			// Not implemented yet.
//			item.matteroverdrive.spacetime_equalizer.name=ÐŸÑ€Ð¾Ñ�Ñ‚Ñ€Ð°Ð½Ñ�Ñ‚Ð²ÐµÐ½Ð½Ð¾-Ð²Ñ€ÐµÐ¼ÐµÐ½Ð½Ð¾Ð¹ Ñ�ÐºÐ²Ð°Ð»Ð°Ð¹Ð·ÐµÑ€
//			item.matteroverdrive.spacetime_equalizer.details=ÐœÐ¾Ð¶ÐµÑ‚ Ð±Ñ‹Ñ‚ÑŒ Ð¾Ð´ÐµÑ‚ Ð² Ñ�Ð»Ð¾Ñ‚ Ð½Ð°Ð³Ñ€ÑƒÐ´Ð½Ð¸ÐºÐ°, Ñ‡Ñ‚Ð¾Ð±Ñ‹ Ð¿Ñ€ÐµÐ´Ð¾Ñ‚Ð²Ñ€Ð°Ñ‚Ð¸Ñ‚ÑŒ Ð²Ð»Ð¸Ñ�Ð½Ð¸Ðµ Ð³Ñ€Ð°Ð²Ð¸Ñ‚Ð°Ñ†Ð¸Ð¾Ð½Ð½Ñ‹Ñ… Ñ�Ð¸Ð»
//			item.matteroverdrive.rogue_android_part.melee=Ð ÑƒÐºÐ¾Ð¿Ð°ÑˆÐ½Ñ‹Ð¹ Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´
//			item.matteroverdrive.rogue_android_part.range=Ð”Ð°Ð»ÑŒÐ½Ð¾Ð±Ð¾Ð¹Ð½Ñ‹Ð¹ Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´

			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_HEAD, "Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´-Ð³Ð¾Ð»Ð¾Ð²Ð°");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_ARMS, "Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´-Ñ€ÑƒÐºÐ°");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_LEGS, "Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´-Ð½Ð¾Ð³Ð°");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_CHEST, "Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´-Ñ‚Ð¾Ñ€Ñ�");
//			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_MELEE, "Ð ÑƒÐºÐ¾Ð¿Ð°ÑˆÐ½Ñ‹Ð¹ Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´");
//			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_RANGE, "Ð”Ð°Ð»ÑŒÐ½Ð¾Ð±Ð¾Ð¹Ð½Ñ‹Ð¹ Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´")

			addItem(ItemRegistry.ITEM_FORCEFIELD_EMITTER, "Ð˜Ð·Ð»ÑƒÑ‡Ð°Ñ‚ÐµÐ»ÑŒ Ñ�Ð¸Ð»Ð¾Ð²Ð¾Ð³Ð¾ Ð¿Ð¾Ð»Ñ�");
			addItem(ItemRegistry.ITEM_BATTERIES.get(BatteryType.HIGHCAPACITY), "Ð’Ñ‹Ñ�Ð¾ÐºÐ¾Ñ‘Ð¼ÐºÐ¾Ñ�Ñ‚Ð½Ð°Ñ� Ð±Ð°Ñ‚Ð°Ñ€ÐµÐ¹ÐºÐ°");
			addItem(ItemRegistry.ITEM_ANDROID_PILL_RED, "ÐšÑ€Ð°Ñ�Ð½Ð°Ñ� Ð¿Ð¸Ð»ÑŽÐ»Ñ�");
			addItem(ItemRegistry.ITEM_ANDROID_PILL_BLUE, "Ð¡Ð¸Ð½Ñ�Ñ� Ð¿Ð¸Ð»ÑŽÐ»Ñ�");

			addItemDescTooltip(ItemRegistry.ITEM_ANDROID_PILL_RED, "ÐŸÑ€Ð¸Ð¼Ð¸Ñ‚Ðµ ÐºÑ€Ð°Ñ�Ð½ÑƒÑŽ Ð¿Ð¸Ð»ÑŽÐ»ÑŽ /n Ð¸ Ð·Ð°Ð±ÑƒÐ´ÑŒÑ‚Ðµ Ð¾ Ñ‚Ð¾Ð¼, Ñ‡Ñ‚Ð¾ Ð²Ð°Ñ� Ñ�Ð´ÐµÑ€Ð¶Ð¸Ð²Ð°ÐµÑ‚");
			addItemDescTooltip(ItemRegistry.ITEM_ANDROID_PILL_BLUE, "ÐŸÑ€Ð¸Ð¼Ð¸Ñ‚Ðµ Ñ�Ð¸Ð½ÑŽÑŽ Ð¿Ð¸Ð»ÑŽÐ»ÑŽ /n Ð¸ Ð²Ñ‹ Ð¿Ñ€Ð¾Ñ�Ð½ÐµÑ‚ÐµÑ�ÑŒ Ð² Ð¿Ð¾Ñ�Ñ‚ÐµÐ»Ð¸ Ð±Ð¾Ð»ÐµÐµ Ð¼ÑƒÐ´Ñ€Ñ‹Ð¼");

			// Not implemented yet.
//			addItem(ItemRegistry.ITEM_CREATIVE_PATTERN_DRIVE, "Ð¢Ð²Ð¾Ñ€Ñ‡ÐµÑ�ÐºÐ¸Ð¹ ÑˆÐ°Ð±Ð»Ð¾Ð½ Ð¿Ñ€Ð¸Ð²Ð¾Ð´Ð°");
//			addItem(ItemRegistry.ITEM_NETWORK_FLASH_DRIVE, "Ð¡ÐµÑ‚ÐµÐ²Ð¾Ð¹ Ñ„Ð»Ñ�Ñˆ-Ð½Ð°ÐºÐ¾Ð¿Ð¸Ñ‚ÐµÐ»ÑŒ");
//			item.matteroverdrive.creative_pattern_drive.name=Ð¢Ð²Ð¾Ñ€Ñ‡ÐµÑ�ÐºÐ¸Ð¹ ÑˆÐ°Ð±Ð»Ð¾Ð½ Ð¿Ñ€Ð¸Ð²Ð¾Ð´Ð°
//			item.matteroverdrive.creative_pattern_drive.details=Ð¡Ð¾Ð´ÐµÑ€Ð¶Ð¸Ñ‚ Ð½Ð°Ð¸Ð±Ð¾Ð»ÐµÐµ Ð²Ð¾Ñ�Ð¿Ñ€Ð¾Ð¸Ð·Ð²Ð¾Ð´Ð¸Ð¼Ñ‹Ðµ Ñ�Ð»ÐµÐ¼ÐµÐ½Ñ‚Ñ‹ /n ÐŸÐšÐœ Ð²Ð¾ Ð²Ñ€ÐµÐ¼Ñ� Ð¿Ñ€Ð¸Ñ�ÐµÐ´Ð°, Ñ‡Ñ‚Ð¾Ð±Ñ‹ Ð¿ÐµÑ€ÐµÐ·Ð°Ð³Ñ€ÑƒÐ·Ð¸Ñ‚ÑŒ
//			item.matteroverdrive.network_flash_drive.name=Ð¡ÐµÑ‚ÐµÐ²Ð¾Ð¹ Ñ„Ð»Ñ�Ñˆ-Ð½Ð°ÐºÐ¾Ð¿Ð¸Ñ‚ÐµÐ»ÑŒ
//			item.matteroverdrive.network_flash_drive.details=Ð˜Ñ�Ð¿Ð¾Ð»ÑŒÐ·ÑƒÐµÑ‚Ñ�Ñ� Ð² ÐºÐ°Ñ‡ÐµÑ�Ñ‚Ð²Ðµ Ñ„Ð¸Ð»ÑŒÑ‚Ñ€Ð° Ð² ÑƒÑ�Ñ‚Ñ€Ð¾Ð¹Ñ�Ñ‚Ð²Ð°Ñ… Ð¼Ð°Ñ‚ÐµÑ€Ð¸Ð°Ð»ÑŒÐ½Ð¾Ð¹ Ñ�ÐµÑ‚Ð¸

//			item.matteroverdrive.name=Ð­Ð½ÐµÑ€Ð³ÐµÑ‚Ð¸Ñ‡ÐµÑ�ÐºÐ°Ñ� Ñ�Ñ‡ÐµÐ¹ÐºÐ°

			// Not implemented.
//			item.matteroverdrive.energy_pack.details=Ð˜Ñ�Ð¿Ð¾Ð»ÑŒÐ·ÑƒÐµÑ‚Ñ�Ñ� Ð´Ð»Ñ� Ð±Ñ‹Ñ�Ñ‚Ñ€Ð¾Ð¹ Ð¿Ð¾Ð´Ð·Ð°Ñ€Ñ�Ð´ÐºÐ¸./nÐ”Ð»Ñ� "Ð¿Ð¾Ð´Ð·Ð°Ñ€Ñ�Ð´ÐºÐ¸" Ñ�Ð½ÐµÑ€Ð³ÐµÑ‚Ð¸Ñ‡ÐµÑ�ÐºÐ¸Ñ… Ð¾Ñ€ÑƒÐ¶Ð¸Ð¹

			addItem(ItemRegistry.ITEM_PHASER_RIFLE, "Ð¤Ð°Ð·ÐµÑ€Ð½Ð°Ñ� Ð²Ð¸Ð½Ñ‚Ð¾Ð²ÐºÐ°");
			addItem(ItemRegistry.ITEM_TRANSPORTER_FLASHDRIVE, "Ð¢Ñ€Ð°Ð½Ñ�Ð¿Ð¾Ñ€Ñ‚Ð½Ñ‹Ð¹ Ñ„Ð»Ñ�Ñˆ-Ð½Ð°ÐºÐ¾Ð¿Ð¸Ñ‚ÐµÐ»ÑŒ");
			addItemDescTooltip(ItemRegistry.ITEM_TRANSPORTER_FLASHDRIVE, "Ð˜Ñ�Ð¿Ð¾Ð»ÑŒÐ·ÑƒÐµÑ‚Ñ�Ñ� Ð´Ð»Ñ� Ð¾Ð±Ð¾Ð·Ð½Ð°Ñ‡ÐµÐ½Ð¸Ñ� Ð¼ÐµÑ�Ñ‚Ð° Ð´Ð»Ñ� Ð±Ñ‹Ñ�Ñ‚Ñ€Ð¾Ð³Ð¾ Ð¸Ñ�Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ð½Ð¸Ñ� Ð¢Ñ€Ð°Ð½Ñ�Ð¿Ð¾Ñ€Ñ‚ÐµÑ€Ð°");

			addItem(ItemRegistry.ITEM_MATTER_CONTAINERS.get(ContainerType.REGULAR), "ÐšÐ¾Ð½Ñ‚ÐµÐ¹Ð½ÐµÑ€ Ð¼Ð°Ñ‚ÐµÑ€Ð¸Ð¸ (ÐŸÑƒÑ�Ñ‚Ð¾Ð¹)");

			// Not implemented. I don't know why this is even a thing as a separate item.
//			item.matteroverdrive.matter_container_full.name=ÐšÐ¾Ð½Ñ‚ÐµÐ¹Ð½ÐµÑ€ Ð¼Ð°Ñ‚ÐµÑ€Ð¸Ð¸ (ÐŸÐ¾Ð»Ð½Ñ‹Ð¹)
			addItem(ItemRegistry.ITEM_MATTER_CONTAINERS.get(ContainerType.REGULAR), "ÐšÐ¾Ð½Ñ‚ÐµÐ¹Ð½ÐµÑ€ Ð¼Ð°Ñ‚ÐµÑ€Ð¸Ð¸");

			addItem(ItemRegistry.ITEM_TRITANIUM_NUGGET, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ Ñ�Ð°Ð¼Ð¾Ñ€Ð¾Ð´Ð¾Ðº");

			// Not implemented.
//			item.matteroverdrive.tritanium_spine.name=Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ Ð¿Ð¾Ð·Ð²Ð¾Ð½Ð¾Ñ‡Ð½Ð¸Ðº

			addItem(ItemRegistry.ITEM_DATAPAD, "Ð”Ð°Ñ‚Ð°Ð¿Ð°Ð´");
			addItemDescTooltip(ItemRegistry.ITEM_DATAPAD, "Ð¡Ð¾Ð´ÐµÑ€Ð¶Ð¸Ñ‚ Ð¸Ð½Ñ„Ð¾Ñ€Ð¼Ð°Ñ†Ð¸ÑŽ Ð¾ Ð²Ñ�Ñ‘Ð¼ Ð² Matter Overdrive");

			addItem(ItemRegistry.ITEM_OMNI_TOOL, "ÐžÐ¼Ð½Ð¸Ñ‚ÑƒÐ»");

			addItem(ItemRegistry.ITEM_ANDROID_PILL_YELLOW, "Ð–Ñ‘Ð»Ñ‚Ð°Ñ� Ð¿Ð¸Ð»ÑŽÐ»Ñ�");
			addItemDescTooltip(ItemRegistry.ITEM_ANDROID_PILL_YELLOW, "Ð˜Ñ�Ð¿Ð¾Ð»ÑŒÐ·ÑƒÐµÑ‚Ñ�Ñ� Ð´Ð»Ñ� Ñ�Ð±Ñ€Ð¾Ñ�Ð° Ð²Ñ�ÐµÑ… Ñ€Ð°Ð·Ð±Ð»Ð¾ÐºÐ¸Ñ€Ð¾Ð²Ð°Ð½Ð½Ñ‹Ñ… Ñ�Ð¿Ð¾Ñ�Ð¾Ð±Ð½Ð¾Ñ�Ñ‚ÐµÐ¹ Ð�Ð½Ð´Ñ€Ð¾Ð¸Ð´Ð°");

			addItem(ItemRegistry.ITEM_TRITANIUM_HELMET, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ ÑˆÐ»ÐµÐ¼");
			addItem(ItemRegistry.ITEM_TRITANIUM_CHESTPLATE, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ Ð½Ð°Ð³Ñ€ÑƒÐ´Ð½Ð¸Ðº");
			addItem(ItemRegistry.ITEM_TRITANIUM_LEGGINGS, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ðµ Ð¿Ð¾Ð½Ð¾Ð¶Ð¸");
			addItem(ItemRegistry.ITEM_TRITANIUM_BOOTS, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ðµ Ð±Ð¾Ñ‚Ð¸Ð½ÐºÐ¸");
			addItem(ItemRegistry.ITEM_TRITANIUM_HOE, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ð°Ñ� Ð¼Ð¾Ñ‚Ñ‹Ð³Ð°");
			addItem(ItemRegistry.ITEM_TRITANIUM_SWORD, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ Ð¼ÐµÑ‡");
			addItem(ItemRegistry.ITEM_TRITANIUM_PICKAXE, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ð°Ñ� ÐºÐ¸Ñ€ÐºÐ°");
			addItem(ItemRegistry.ITEM_TRITANIUM_AXE, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ñ‹Ð¹ Ñ‚Ð¾Ð¿Ð¾Ñ€");
			addItem(ItemRegistry.ITEM_TRITANIUM_SHOVEL, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¾Ð²Ð°Ñ� Ð»Ð¾Ð¿Ð°Ñ‚Ð°");

			addItem(ItemRegistry.ITEM_WEAPON_HANDLE, "Ð ÑƒÐºÐ¾Ñ�Ñ‚ÐºÐ° Ð¾Ñ€ÑƒÐ¶Ð¸Ñ�");
			addItem(ItemRegistry.ITEM_WEAPON_RECEIVER, "ÐŸÑ€Ð¸Ñ‘Ð¼Ð½Ð¸Ðº Ð¾Ñ€ÑƒÐ¶Ð¸Ñ�");
			addItem(ItemRegistry.ITEM_PLASMA_CORE, "ÐŸÐ»Ð°Ð·Ð¼ÐµÐ½Ð½Ð¾Ðµ Ñ�Ð´Ñ€Ð¾");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_ARMS, "Ð ÑƒÐºÐ¸ Ð±ÑƒÐ½Ñ‚Ð°Ñ€Ñ�ÐºÐ¾Ð³Ð¾ Ð°Ð½Ð´Ñ€Ð¾Ð¸Ð´Ð°");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_CHEST, "Ð“Ñ€ÑƒÐ´ÑŒ Ð±ÑƒÐ½Ñ‚Ð°Ñ€Ñ�ÐºÐ¾Ð³Ð¾ Ð°Ð½Ð´Ñ€Ð¾Ð¸Ð´Ð°");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_HEAD, "Ð“Ð¾Ð»Ð¾Ð²Ð° Ð±ÑƒÐ½Ñ‚Ð°Ñ€Ñ�ÐºÐ¾Ð³Ð¾ Ð°Ð½Ð´Ñ€Ð¾Ð¸Ð´Ð°");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_LEGS, "Ð�Ð¾Ð³Ð¸ Ð±ÑƒÐ½Ñ‚Ð°Ñ€Ñ�ÐºÐ¾Ð³Ð¾ Ð°Ð½Ð´Ñ€Ð¾Ð¸Ð´Ð°");
			addItem(ItemRegistry.ITEM_TRITANIUM_SPINE, "Ð¢Ñ€Ð¸Ñ‚Ð°Ð½Ð¸ÐµÐ²Ð°Ñ� Ð¿Ð¾Ð·Ð²Ð¾Ð½Ð¾Ñ‡Ð½Ð¸Ðº");

			addItem(ItemRegistry.ITEM_TRILITHIUM_CRYSTAL, "Ð¢Ñ€Ð¸Ð»Ð¸Ñ‚Ð¸ÐµÐ²Ñ‹Ð¹ ÐºÑ€Ð¸Ñ�Ñ‚Ð°Ð»Ð»");

			// Not implemented.
//			item.matteroverdrive.contract.name=ÐšÐ¾Ð½Ñ‚Ñ€Ð°ÐºÑ‚

			addItem(ItemRegistry.ITEM_ION_SNIPER, "Ð˜Ð¾Ð½Ð½Ð°Ñ� Ð²Ð¸Ð½Ñ‚Ð¾Ð²ÐºÐ°");
			addItem(ItemRegistry.ITEM_PLASMA_SHOTGUN, "ÐŸÐ»Ð°Ð·Ð¼ÐµÐ½Ð½Ñ‹Ð¹ Ð´Ñ€Ð¾Ð±Ð¾Ð²Ð¸Ðº");

			// Not implemented.
//			item.matteroverdrive.plasma_shotgun.name=ÐŸÐ»Ð°Ð·Ð¼ÐµÐ½Ð½Ñ‹Ð¹ Ð´Ñ€Ð¾Ð±Ð¾Ð²Ð¸Ðº
//			item.matteroverdrive.weapon_receiver.name=ÐžÑ€ÑƒÐ¶ÐµÐ¹Ð½Ñ‹Ð¹ Ð¿Ñ€Ð¸Ñ‘Ð¼Ð½Ð¸Ðº
//			item.matteroverdrive.weapon_handle.name=ÐžÑ€ÑƒÐ¶ÐµÐ¹Ð½Ð°Ñ� Ñ€ÑƒÐºÐ¾Ñ�Ñ‚ÑŒ

			// Not implemented.
//			item.matteroverdrive.plasma_core.name=ÐŸÐ»Ð°Ð·Ð¼ÐµÐ½Ð½Ð¾Ðµ Ñ�Ð´Ñ€Ð¾
//			item.matteroverdrive.portable_decomposer.name=ÐŸÐ¾Ñ€Ñ‚Ð°Ñ‚Ð¸Ð²Ð½Ñ‹Ð¹ Ñ€Ð°Ð·Ð»Ð°Ð³Ð°Ñ‚ÐµÐ»ÑŒ
//			item.matteroverdrive.portable_decomposer.details=Ð Ð°Ð·Ð»Ð°Ð³Ð°ÐµÑ‚ Ð¿Ð¾Ð´Ð¾Ð±Ñ€Ð°Ð½Ð½Ñ‹Ðµ Ð¿Ñ€ÐµÐ´Ð¼ÐµÑ‚Ñ‹ Ð² Ð¿Ð»Ð°Ð·Ð¼ÐµÐ½Ð½ÑƒÑŽ Ð¼Ð°Ñ‚ÐµÑ€Ð¸ÑŽ
//			item.record.matteroverdrive.transformation.desc=BoxCat Games - Trace Route

			// Not implemented.
//			item.matteroverdrive.trilithium_crystal.name=Ð§Ð¸Ñ�Ñ‚Ñ‹Ð¹ Ð¢Ñ€Ð¸Ð»Ð¸Ñ‚Ð¸ÐµÐ²Ñ‹Ð¹ ÐºÑ€Ð¸Ñ�Ñ‚Ð°Ð»Ð»
//			item.matteroverdrive.artifact.name=Ð�ÐµÐ¸Ð·Ð²ÐµÑ�Ñ‚Ð½Ñ‹Ð¹ Ð°Ñ€Ñ‚ÐµÑ„Ð°ÐºÑ‚
//			item.matteroverdrive.quantum_fold_manipulator.name=ÐšÐ²Ð°Ð½Ñ‚Ð¾Ð²Ñ‹Ð¹ Ñ�ÐºÐ»Ð°Ð´Ð½Ð¾Ð¹ Ð¼Ð°Ð½Ð¸Ð¿ÑƒÐ»Ñ�Ñ‚Ð¾Ñ€

//			item.matteroverdrive.matter.name=ÐœÐ°Ñ‚ÐµÑ€Ð¸Ñ�

			addBlock(BlockRegistry.BLOCK_MACHINE_HULL, "ÐšÐ¾Ñ€Ð¿ÑƒÑ� Ð¼Ð°ÑˆÐ¸Ð½Ñ‹");

			case "en_us":
			default:

			add("itemGroup.itemgroup" + References.ID + "main", "Matter Overdrive");
			add("itemGroup.itemgroup" + References.ID + "modules", "Matter Overdrive: Modules");
			add("itemGroup.itemgroup" + References.ID + "upgrades", "Matter Overdrive: Upgrades");
			add("itemGroup.itemgroup" + References.ID + "food", "Matter Overdrive: Food");
			add("itemGroup.itemgroup" + References.ID + "ships", "Matter Overdrive: Ships");
			add("itemGroup.itemgroup" + References.ID + "buildings", "Matter Overdrive: Buildings");
			add("itemGroup.itemgroup" + References.ID + "decorative", "Matter Overdrive: Decorative");

			addItem(ItemRegistry.ITEM_RAW_MATTER_DUST, "Raw Matter Dust");
			addItem(ItemRegistry.ITEM_MATTER_DUST, "Matter Dust");
			addItem(ItemRegistry.ITEM_UPGRADE_BASE, "Upgrade Shell");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.SPEED), "Speed Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.MATTER_STORAGE), "Matter Storage Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.POWER), "Power Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.POWER_STORAGE), "Power Storage Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.FAIL_SAFE), "Fail-Safe Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.HYPER_SPEED), "Hyper Speed Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.RANGE), "Range Upgrade");
			addItem(ItemRegistry.ITEM_UPGRADES.get(UpgradeType.MUFFLER), "Muffler Upgrade");
			addItem(ItemRegistry.ITEM_ION_SNIPER, "Ion Sniper");
			addItem(ItemRegistry.ITEM_PHASER_RIFLE, "Phaser Rifle");
			addItem(ItemRegistry.ITEM_PHASER, "Phaser");
			addItem(ItemRegistry.ITEM_PLASMA_SHOTGUN, "Plasma Shotgun");
			addItem(ItemRegistry.ITEM_OMNI_TOOL, "Omni Tool");
			addItem(ItemRegistry.SHIP_FACTORY, "Ship Factory");
			addItem(ItemRegistry.BUILDING_BASE, "Base");
			addItem(ItemRegistry.BUILDING_MATTER_EXTRACTOR, "Matter Extractor");
			addItem(ItemRegistry.BUILDING_RESIDENTIAL, "Residential Buildings");
			addItem(ItemRegistry.BUILDING_SHIP_HANGAR, "Ship Hangar");
			addItem(ItemRegistry.BUILDING_POWER_GENERATOR, "Power Generator");
			addItem(ItemRegistry.SCOUT_SHIP, "Scout Ship");
			addItem(ItemRegistry.SHIP_COLONIZER, "Colonizer Ship");
			addItem(ItemRegistry.ITEM_BATTERIES.get(BatteryType.REGULAR), "Battery");
			addItem(ItemRegistry.ITEM_BATTERIES.get(BatteryType.HIGHCAPACITY), "High-Capacity Battery");
			addItem(ItemRegistry.ITEM_BATTERIES.get(BatteryType.CREATIVE), "Creative Battery");
			addItem(ItemRegistry.ITEM_MATTER_CONTAINERS.get(ContainerType.REGULAR), "Matter Container");
			addItem(ItemRegistry.ITEM_MATTER_CONTAINERS.get(ContainerType.CREATIVE), "Creative Matter Container");
			addItem(ItemRegistry.ITEM_MACHINE_CASING, "Machine Casing");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER1), "Isolinear Circuit Mk1");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER2), "Isolinear Circuit Mk2");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER3), "Isolinear Circuit Mk3");
			addItem(ItemRegistry.ITEM_ISOLINEAR_CIRCUITS.get(TypeIsolinearCircuit.TIER4), "Isolinear Circuit Mk4");
			addItem(ItemRegistry.ITEM_TRANSPORTER_FLASHDRIVE, "Location Flashdrive");
			addItem(ItemRegistry.ITEM_PATTERN_DRIVE, "Pattern Drive");
			addItem(ItemRegistry.ITEM_MATTER_SCANNER, "Matter Scanner");
			addItem(ItemRegistry.ITEM_TRITANIUM_PLATE, "Tritanium Plate");
			addItem(ItemRegistry.ITEM_TRITANIUM_INGOT, "Tritanium Ingot");
			addItem(ItemRegistry.ITEM_TRITANIUM_NUGGET, "Tritanium Nugget");
			addItem(ItemRegistry.ITEM_TRITANIUM_DUST, "Tritanium Dust");
			addItem(ItemRegistry.ITEM_ANDROID_PILL_BLUE, "Blue Pill");
			addItem(ItemRegistry.ITEM_ANDROID_PILL_RED, "Red Pill");
			addItem(ItemRegistry.ITEM_ANDROID_PILL_YELLOW, "Yellow Pill");
			addItem(ItemRegistry.ITEM_COMMUNICATOR, "Communicator");
			addItem(ItemRegistry.ITEM_EARL_GRAY_TEA, "Tea. Earl Grey. Hot.");
			addItem(ItemRegistry.ITEM_ROMULAN_ALE, "Romulan Ale");
			addItem(ItemRegistry.ITEM_EMERGENCY_RATION, "Emergency Ration");
			addItem(ItemRegistry.ITEM_ME_CONVERSION_MATRIX, "ME Conversion Matrix");
			addItem(ItemRegistry.ITEM_H_COMPENSATOR, "Heisenberg Compensator");
			addItem(ItemRegistry.ITEM_INTEGRATION_MATRIX, "Integration Matrix");
			addItem(ItemRegistry.ITEM_SUPERCONDUCTOR_MAGNET, "Superconductor Magnet");
			addItem(ItemRegistry.ITEM_TRITANIUM_WRENCH, "Tritanium Wrench");
			addItem(ItemRegistry.ITEM_DATAPAD, "Datapad");
			addItem(ItemRegistry.ITEM_DILITHIUM_CRYSTAL, "Dilithium Crystal");
			addItem(ItemRegistry.ITEM_FORCEFIELD_EMITTER, "Force Field Emitter");
			addItem(ItemRegistry.ITEM_WEAPON_HANDLE, "Weapon Handle");
			addItem(ItemRegistry.ITEM_WEAPON_RECEIVER, "Weapon Reciver");
			addItem(ItemRegistry.ITEM_PLASMA_CORE, "Plasma Core");
			addItem(ItemRegistry.ITEM_TRITANIUM_AXE, "Tritanium Axe");
			addItem(ItemRegistry.ITEM_TRITANIUM_PICKAXE, "Tritanium Pickaxe");
			addItem(ItemRegistry.ITEM_TRITANIUM_SWORD, "Tritanium Sword");
			addItem(ItemRegistry.ITEM_TRITANIUM_HOE, "Tritanium Hoe");
			addItem(ItemRegistry.ITEM_TRITANIUM_SHOVEL, "Tritanium Shovel");
			addItem(ItemRegistry.ITEM_TRITANIUM_HELMET, "Tritanium Helmet");
			addItem(ItemRegistry.ITEM_TRITANIUM_CHESTPLATE, "Tritanium Chestplate");
			addItem(ItemRegistry.ITEM_TRITANIUM_LEGGINGS, "Tritanium Leggings");
			addItem(ItemRegistry.ITEM_TRITANIUM_BOOTS, "Tritanium Boots");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_ARMS, "Rogue Android Arms");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_CHEST, "Rogue Android Chest");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_HEAD, "Rogue Android Head");
			addItem(ItemRegistry.ITEM_ROGUE_ANDROID_LEGS, "Rogue Android Legs");
			addItem(ItemRegistry.ITEM_TRITANIUM_SPINE, "Tritanium Spine");
			addItem(ItemRegistry.ITEM_TRILITHIUM_CRYSTAL, "Trilithium Crystal");
			addItem(ItemRegistry.ITEM_SNIPER_SCOPE, "Snipe Scope");
			addItem(ItemRegistry.ITEM_SECURITY_PROTOCOL, "Security Protocol");
			addItem(ItemRegistry.ITEM_PORTABLE_DECOMPOSER, "Portable Decomposer");
			addItem(ItemRegistry.ITEM_NETWORK_FLASH_DRIVE, "Network Flash Drive");
//			addItem(ItemRegistry.ITEM_SPACETIME_EQUALIZER, "Spacetime Equalizer.");

			for (OverdriveBlockColors color : OverdriveBlockColors.values()) {
				String name = getNameFromEnum(color.toString());
				addBlock(BlockRegistry.BLOCK_COLORED_TRITANIUM_PLATING.get(color), name + " Tritanium Plating");
				addBlock(BlockRegistry.BLOCK_FLOOR_TILE.get(color), name + " Floor Tile");
				addBlock(BlockRegistry.BLOCK_FLOOR_TILES.get(color), name + " Floor Tiles");
			}
			addBlock(BlockRegistry.BLOCK_REGULAR_TRITANIUM_PLATING, "Tritanium Plating");
			for (CrateColors color : TileTritaniumCrate.CrateColors.values()) {
				String name = getNameFromEnum(color.toString());
				if (name.equals("Reg")) {
					addBlock(BlockRegistry.BLOCK_TRITANIUM_CRATES.get(color), "Tritanium Crate");
				} else {
					addBlock(BlockRegistry.BLOCK_TRITANIUM_CRATES.get(color), name + " Tritanium Crate");
				}

			}
			addBlock(BlockRegistry.DEEPSLATE_TRITANIUM_ORE, "Deepslate Tritanium Ore");
			addBlock(BlockRegistry.DEEPSLATE_DILITHIUM_ORE, "Deepslate Dilithium Ore");
			addBlock(BlockRegistry.TRITANIUM_ORE, "Tritanium Ore");
			addBlock(BlockRegistry.DILITHIUM_ORE, "Dilithium Ore");
			addBlock(BlockRegistry.BLOCK_INDUSTRIAL_GLASS, "Industrial Glass");
			addBlock(BlockRegistry.BLOCK_SOLAR_PANEL, "Solar Panel");
			addBlock(BlockRegistry.BLOCK_MATTER_DECOMPOSER, "Matter Decomposer");
			addBlock(BlockRegistry.BLOCK_MATTER_RECYCLER, "Matter Recycler");
			addBlock(BlockRegistry.BLOCK_CHARGER_CHILD, "Charger Child");
			addBlock(BlockRegistry.BLOCK_CHARGER, "Android Charger");
			addBlock(BlockRegistry.BLOCK_MICROWAVE, "Microwave");
			addBlock(BlockRegistry.BLOCK_INSCRIBER, "Inscriber");
			addBlock(BlockRegistry.BLOCK_TRANSPORTER, "Transporter");
			addBlock(BlockRegistry.BLOCK_SPACETIME_ACCELERATOR, "Spacetime Accelerator");
			addBlock(BlockRegistry.BLOCK_CHUNKLOADER, "Chunkloader");
			addBlock(BlockRegistry.BLOCK_MATTER_ANALYZER, "Matter Analyzer");
			addBlock(BlockRegistry.BLOCK_PATTERN_STORAGE, "Pattern Storage");
			addBlock(BlockRegistry.BLOCK_PATTERN_MONITOR, "Pattern Monitor");
			addBlock(BlockRegistry.BLOCK_MATTER_REPLICATOR, "Matter Replicator");
			addBlock(BlockRegistry.BLOCK_MACHINE_HULL, "Machine Hull");
			addBlock(BlockRegistry.BLOCK_MATTER_CONDUITS.get(TypeMatterConduit.REGULAR), "Matter Conduit");
			addBlock(BlockRegistry.BLOCK_MATTER_CONDUITS.get(TypeMatterConduit.HEAVY), "Heavy Matter Conduit");
			addBlock(BlockRegistry.BLOCK_MATTER_NETWORK_CABLES.get(TypeMatterNetworkCable.REGULAR), "Network Cable");
			addBlock(BlockRegistry.BLOCK_TRITANIUM, "Tritanium Block");
			addBlock(BlockRegistry.BLOCK_ANDROID_STATION, "Android Station");
//			addBlock(BlockRegistry.BLOCK_DISC_MANIPULATOR, "Disc Manipulator");
			addBlock(BlockRegistry.BLOCK_DECORATIVE_BEAMS, "Decorative Beams");
			addBlock(BlockRegistry.BLOCK_DECORATIVE_CARBON_FIBER_PLATE, "Carbon Fiber Plate");
			addBlock(BlockRegistry.BLOCK_DECORATIVE_CLEAN, "Tritanium Smooth Plate");
			addBlock(BlockRegistry.BLOCK_DECORATIVE_COILS, "Decorative Coils");
			addBlock(BlockRegistry.HOLO_MATRIX, "Holographic Matrix");
			addBlock(BlockRegistry.YELLOW_STRIPES, "Yellow Stripes");
			addBlock(BlockRegistry.EXHAUST_PLASMA, "Engine Exhaust Plasma");
			addBlock(BlockRegistry.SOFT_WALL_PLATES, "Soft Wall Plates");
			addBlock(BlockRegistry.TRITANIUM_RAIL, "Tritanium Rail");
			addBlock(BlockRegistry.TRITANIUM_PLATE_STRIPE, "Tritanium Plate Guided");
			addBlock(BlockRegistry.MATTER_TUBE, "Matter Tube");
			addBlock(BlockRegistry.TRITANIUM_LAMP, "Tritanium Lamp");
			addBlock(BlockRegistry.BLOCK_STAR_MAP, "Star Map");
			addBlock(BlockRegistry.BLOCK_WEAPON_STATION, "Weapon Station");
			addBlock(BlockRegistry.BLOCK_NETWORK_SWITCH, "Network Switch");
			addBlock(BlockRegistry.BLOCK_VENT_CLOSED, "Closed Vents");
			addBlock(BlockRegistry.BLOCK_VENT_OPEN, "Open Vents");
			addBlock(BlockRegistry.BLOCK_HOLO_SIGN, "Holo Sign");

			addTooltip("energystored", "%1$s / %2$s %3$sFE");
			addTooltip("creativeenergystored", "INFINITE");
			addTooltip("matterval", "Matter: %s");
			addTooltip("potmatterval", "Potential Matter: %s");
			addTooltip("nomatter", "NONE");
			addTooltip("openmenu", "Open Menu");
			addTooltip("closemenu", "Close Menu");
			addTooltip("menuhome", "Home");
			addTooltip("menusettings", "Settings");
			addTooltip("menuupgrades", "Upgrades");
			addTooltip("matterstored", "%1$s / %2$s %3$skM");
			addTooltip("usage", "%s");
			addTooltip("usagetick", "%s/t");
			addTooltip("menuio", "I/O");
			addTooltip("ioinput", "Input");
			addTooltip("iooutput", "Output");
			addTooltip("ionone", "None");
			addTooltip("iotop", "Top");
			addTooltip("iobottom", "Bottom");
			addTooltip("ioleft", "Left");
			addTooltip("ioright", "Right");
			addTooltip("iofront", "Front");
			addTooltip("ioback", "Back");
			addTooltip("io", "%1$s (%2$s)");
			addTooltip("upgradeinfo", "Hold %s for Details");
			addTooltip("controlkey", "Ctrl");
			addTooltip("speedbonus", "Speed: %s");
			addTooltip("mattstorebonus", "Matter Storage: %s");
			addTooltip("mattusebonus", "Matter Usage: %s");
			addTooltip("failurebonus", "Failure: %s");
			addTooltip("powstorebonus", "Power Storage: %s");
			addTooltip("powusebonus", "Power Usage: %s");
			addTooltip("rangebonus", "Range: %s");
			addTooltip("mufflerupgrade", "Mutes machine sound");
			addTooltip("invaliddest", "Invalid Destination");
			addTooltip("empty", "Empty");
			addTooltip("storedpattern", "%1$s [%2$s]");
			addTooltip("has_storage_loc", "Bound: %s");
			addTooltip("no_storage_loc", "Unbound");
			addTooltip("menutasks", "Tasks");
			addTooltip("order", "Order");
			addTooltip("orderabv", "O");
			addTooltip("remainabv", "R");
			addTooltip("reporder", "%1$s: %2$s, %3$s: %4$s");
			addTooltip("noorder", "No Orders Queued");
			addTooltip("fused", "Fused");
			addTooltip("effectiveuses", "Uses: %s");
			addTooltip("hasshifttip", "Hold %s for info...");
			addTooltip("shiftkey", "Shift");
			addTooltip("fusedrive", "Fuse Drive");
			addTooltip("erasepattern", "Erase");
			addTooltip("erasedrive", "Erase Drive");
			addTooltip("fusedpattern", "Fused");
			addTooltip("fusepattern", "Fuse");
			
			addItemDescTooltip(ItemRegistry.ITEM_RAW_MATTER_DUST, "A failure, but recyclable");
			addItemDescTooltip(ItemRegistry.ITEM_MATTER_DUST, "Ready to decompose");
			addItemDescTooltip(ItemRegistry.ITEM_ION_SNIPER, "The zombie is WAY over there");
			addItemDescTooltip(ItemRegistry.ITEM_PHASER_RIFLE, "There are many zombies");
			addItemDescTooltip(ItemRegistry.ITEM_PLASMA_SHOTGUN, "There is a big zombie next to me");
			addItemDescTooltip(ItemRegistry.ITEM_PHASER, "There is one zombie plus B E A M");
			addItemDescTooltip(ItemRegistry.ITEM_OMNI_TOOL, "Like a pocket multi-tool but better");
			addItemDescTooltip(ItemRegistry.ITEM_TRANSPORTER_FLASHDRIVE, "Right-click to store a location");
			addItemDescTooltip(ItemRegistry.ITEM_PATTERN_DRIVE, "Stores up to 3 unique patterns");
			addItemDescTooltip(ItemRegistry.ITEM_MATTER_SCANNER, "A portable Matter Analyzer with perks");
			addItemDescTooltip(ItemRegistry.ITEM_ANDROID_PILL_RED, "Makes you an android");
			addItemDescTooltip(ItemRegistry.ITEM_ANDROID_PILL_BLUE, "Makes you an human for a price");
			addItemDescTooltip(ItemRegistry.ITEM_ANDROID_PILL_YELLOW, "Resets all android abilities");
			addItemDescTooltip(ItemRegistry.ITEM_COMMUNICATOR, "Link to a Transporter for on the go");
			addItemDescTooltip(ItemRegistry.ITEM_TRITANIUM_WRENCH, "Safely disassembles and rotates machines.");
			addItemDescTooltip(ItemRegistry.ITEM_ROMULAN_ALE, "Highly intoxicating alcoholic beverage of Romulan origin.");
			addItemDescTooltip(ItemRegistry.ITEM_EMERGENCY_RATION, "Emergency Rations.");
			addItemDescTooltip(ItemRegistry.SHIP_FACTORY, "Allows the building of ships");
			addItemDescTooltip(ItemRegistry.BUILDING_BASE, "Main building, needed for everything");
			addItemDescTooltip(ItemRegistry.SCOUT_SHIP, "A fast ship, used for scouting");
			addItemDescTooltip(ItemRegistry.SHIP_COLONIZER, "Used to claim planets by building a Base building on arrival");

			for (CrateColors color : TileTritaniumCrate.CrateColors.values()) {
				addBlockItemDescTooltip(BlockRegistry.BLOCK_TRITANIUM_CRATES.get(color), "Retains items when broken");
			}
			addBlockItemDescTooltip(BlockRegistry.BLOCK_SOLAR_PANEL, "E=MC^2 if you think about it");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_MATTER_DECOMPOSER, "Converts items to matter");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_MATTER_RECYCLER, "Makes raw matter dust usable again");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_CHARGER, "Wireless charging for androids");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_MICROWAVE, "A 24th century smoker");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_INSCRIBER, "Makes ciruits n' stuff");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_STAR_MAP, "A Galactic delight");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_ANDROID_STATION, "Android Development Kit");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_WEAPON_STATION, "Weapon Accessory Emporium");
			
			for(TypeMatterConduit conduit : TypeMatterConduit.values()) {
				addBlockItemDescTooltip(BlockRegistry.BLOCK_MATTER_CONDUITS.get(conduit), "XFER Limit: " + conduit.capacity + "kM");
			}
			addBlockItemDescTooltip(BlockRegistry.BLOCK_TRANSPORTER, "Say the line Kirk");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_SPACETIME_ACCELERATOR, "Speeds up machines around it");
			for(TypeMatterNetworkCable cable : TypeMatterNetworkCable.values()) {
				addBlockItemDescTooltip(BlockRegistry.BLOCK_MATTER_NETWORK_CABLES.get(cable), "It's not an AE cable you guys");
			}
			addBlockItemDescTooltip(BlockRegistry.BLOCK_CHUNKLOADER, "The bane of servers");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_MATTER_ANALYZER, "Scans a block's matter content");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_PATTERN_STORAGE, "Holds 6 Pattern Drives");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_PATTERN_MONITOR, "Queues Replication tasks");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_MATTER_REPLICATOR, "Makes ordered items from matter");
			addBlockItemDescTooltip(BlockRegistry.BLOCK_DISC_MANIPULATOR, "Wipe patterns and more");

			addGuiLabel("redstonelow", "Low");
			addGuiLabel("redstonehigh", "High");
			addGuiLabel("redstonenone", "None");
			addGuiLabel("redstone", "Redstone");
			addGuiLabel("ioitems", "Items");
			addGuiLabel("ioenergy", "Energy");
			addGuiLabel("iomatter", "Matter");
			addGuiLabel("time", "Time: %s");
			addGuiLabel("usage", "Usage: %s");
			addGuiLabel("usagetick", "Usage: %s/t");
			addGuiLabel("failure", "Failure: %s");
			addGuiLabel("range", "Range: %s Blocks");
			addGuiLabel("storage", "Storage: %s");
			addGuiLabel("soundmuted", "Sound Muffled");
			addGuiLabel("unknown", "Unknown");
			addGuiLabel("xlabel", "X");
			addGuiLabel("ylabel", "Y");
			addGuiLabel("zlabel", "Z");
			addGuiLabel("importpos", "Import");
			addGuiLabel("resetpos", "Reset");
			addGuiLabel("dimensionname", "DIM: %s");
			addGuiLabel("multiplier", "Multiplier: %s");
			addGuiLabel("orderratio", "%1$s / %2$s");
			addGuiLabel("replicatorqueue", "Local Orders");
			addGuiLabel("systemqueue", "Global Orders");
			addGuiLabel("isreciever", "Recieve");
			addGuiLabel("notreciever", "Transmit");
			addGuiLabel("transportermode", "Function");

			addContainer("tritanium_crate", "Tritanium Crate");
			addContainer(TypeMachine.SOLAR_PANEL.id(), "Solar Panel");
			addContainer(TypeMachine.MATTER_DECOMPOSER.id(), "Matter Decomposer");
			addContainer(TypeMachine.MATTER_RECYCLER.id(), "Matter Recycler");
			addContainer(TypeMachine.CHARGER.id(), "Android Charger");
			addContainer(TypeMachine.MICROWAVE.id(), "Microwave");
			addContainer(TypeMachine.INSCRIBER.id(), "Inscriber");
			addContainer(TypeMachine.TRANSPORTER.id(), "Transporter");
			addContainer(TypeMachine.SPACETIME_ACCELERATOR.id(), "Spacetime Accelerator");
			addContainer(TypeMachine.CHUNKLOADER.id(), "Chunkloader");
			addContainer(TypeMachine.PATTERN_MONITOR.id(), "Pattern Monitor");
			addContainer(TypeMachine.PATTERN_STORAGE.id(), "Pattern Storage");
			addContainer(TypeMachine.MATTER_ANALYZER.id(), "Matter Analyzer");
			addContainer(TypeMachine.MATTER_REPLICATOR.id(), "Matter Replicator");
			addContainer(TypeMachine.DISC_MANIPULATOR.id(), "Disc Manipulator");
			addContainer(TypeMachine.HOLO_SIGN.id(), "Holo Sign");

			addCommand("startmattercalc", "Starting Matter calculations...");
			addCommand("endmattercalc", "Finshed Matter calculations. Saved under \"Matter Overdrive/generated.json\"");
			addCommand("manualfailed", "unexpected error");
			addCommand("mainhandempty", "You must be holding an item");
			addCommand("assignedvalue", "Assigned %1$s kM to %2$s");
			addCommand("endmanualassign", "Saved under \"Matter Overdrive/manual.json\"");
			addCommand("startzeroscommand", "Starting Zeros Command...");
			addCommand("endzeroscommand", "Finshed writing zeros file. Saved under \"Matter Overdrive/zeros.json\"");

			addSubtitle("crate_open", "Tritanium Crate Opens");
			addSubtitle("crate_close", "Tritanium Crate Closes");
			addSubtitle("button_expand", "Button Shifts");
			addSubtitle("button_generic", "Button is pressed");
			addSubtitle("matter_decomposer", "Matter Decomposer running");
			addSubtitle("generic_machine", "Machine runs");
			addSubtitle("transporter", "Transporter Build-up");
			addSubtitle("transporter_arrive", "Transported Entity Appears");
			addSubtitle("matter_scanner_running", "Matter Scanner scans");
			addSubtitle("matter_scanner_beep", "Matter Scanner beeps");
			addSubtitle("matter_scanner_fail", "Scan fails");
			addSubtitle("matter_scanner_success", "Scan succeeds");

			addDimension("overworld", "Overworld");
			addDimension("the_nether", "Nether");
			addDimension("the_end", "End");

			addKeyCategory("main", "Matter Overdrive - Main");
			addKeyLabel("togglematterscanner", "Toggle Matter Scanner");
			
			addJei(InscriberRecipe.RECIPE_GROUP, "Inscriber");
			addJei("microwave", "Microwave");
			addJei("matter_recycler", "Matter Recycler");
			addJei("matter_decomposer", "Matter Decomposer");
			addJei("powerconsumed", "Total: %s");
			addJei("usagepertick", "%s/t");
			addJei("processtime", "Time: ");
			
			addDamageSource("android_transformation", "%s became human again");
			
			addChatMessage(ItemCommunicator.CHAT_MESSAGE, "Transporter location corrupted. Attempting Cancelation...");
		}
	}

	public void addItem(DeferredHolder<Item, ? extends Item> item, String translation) {
		add(item.get(), translation);
	}

	public void addBlock(DeferredHolder<Block, ? extends Block> block, String translation) {
		add(block.get(), translation);
	}

	private void addTooltip(String key, String translation) {
		add("tooltip." + References.ID + "." + key, translation);
	}
	/*
	private void addItemDescTooltip(RegistryObject<Item> reg, String translation) {
		addTooltip(name(reg.get()) + ".desc", translation);
	}
	
	private void addBlockItemDescTooltip(RegistryObject<Block> reg, String translation) {
		addTooltip(name(reg.get().asItem()) + ".desc", translation);
	}
*/
	private void addContainer(String key, String translation) {
		add("container." + key, translation);
	}

	private void addCommand(String key, String translation) {
		add("command." + References.ID + "." + key, translation);
	}

	private void addSubtitle(String key, String translation) {
		add("subtitles." + References.ID + "." + key, translation);
	}

	private void addGuiLabel(String key, String translation) {
		add("gui." + References.ID + "." + key, translation);
	}

	private void addDimension(String key, String translation) {
		add("dimension." + References.ID + "." + key, translation);
	}

	private void addKeyCategory(String key, String translation) {
		add("keycategory." + References.ID + "." + key, translation);
	}

	private void addKeyLabel(String key, String translation) {
		add("key." + References.ID + "." + key, translation);
	}
	
	private void addJei(String key, String translation) {
		add("jei." + References.ID + "." + key, translation);
	}
	
	private void addDamageSource(String key, String translation) {
		add("death.attack." + key, translation);
	}
	
	private void addChatMessage(String key, String translation) {
		add("chat." + References.ID + "." + key, translation);
	}

	public static enum Locale {
		EN_US;

		@Override
		public String toString() {
			return super.toString().toLowerCase(java.util.Locale.ROOT);
		}
	}

	private String getNameFromEnum(String baseString) {
		String name = baseString.toLowerCase();
		if (name.contains("_")) {
			String[] split = name.split("_");
			name = "";
			for (String str : split) {
				if (str.length() > 0) {
					name = name + str.substring(0, 1).toUpperCase() + str.substring(1) + " ";
				}
			}
			while (name.charAt(name.length() - 1) == ' ') {
				name = name.substring(0, name.length() - 1);
			}
		} else {
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return name;
	}

}
