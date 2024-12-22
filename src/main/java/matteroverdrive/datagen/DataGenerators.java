package matteroverdrive.datagen;

import matteroverdrive.References;
import matteroverdrive.datagen.client.OverdriveBlockModelsProvider;
import matteroverdrive.datagen.client.OverdriveBlockStateProvider;
import matteroverdrive.datagen.client.OverdriveItemModelsProvider;
import matteroverdrive.datagen.client.OverdriveLangKeyProvider;
import matteroverdrive.datagen.client.OverdriveLangKeyProvider.Locale;
import matteroverdrive.datagen.server.OverdriveBlockTagsProvider;
import matteroverdrive.datagen.server.OverdriveItemTagsProvider;
import matteroverdrive.datagen.server.OverdriveLootTablesProvider;
import matteroverdrive.datagen.server.OverdriveMatterValueGenerator;
import matteroverdrive.datagen.server.OverdriveRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {

		DataGenerator generator = event.getGenerator();

		PackOutput output = generator.getPackOutput();

		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			OverdriveBlockTagsProvider blockProvider = new OverdriveBlockTagsProvider(generator, event.getExistingFileHelper());
			generator.addProvider(true, blockProvider);
			generator.addProvider(true, new OverdriveItemTagsProvider(generator, blockProvider, event.getExistingFileHelper()));
			generator.addProvider(true, new OverdriveLootTablesProvider(generator));
			generator.addProvider(true, new OverdriveMatterValueGenerator(generator));
			generator.addProvider(true, new OverdriveRecipeProvider(generator));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new OverdriveBlockStateProvider(output, helper));
			generator.addProvider(true, new OverdriveBlockModelsProvider(output, helper));
			generator.addProvider(true, new OverdriveItemModelsProvider(output, helper));
			generator.addProvider(true, new OverdriveLangKeyProvider(output, Locale.EN_US));
		}
	}

}
