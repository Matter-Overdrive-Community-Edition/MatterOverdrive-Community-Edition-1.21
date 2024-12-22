package matteroverdrive.datagen.client;

import matteroverdrive.References;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class OverdriveBlockModelsProvider extends BlockModelProvider {

	public OverdriveBlockModelsProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
		super(generator, References.ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {

	}

/*	private void blockTopBottom(RegistryObject<Block> block, String top, String bottom, String side) {
		cubeBottomTop(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), new ResourceLocation(References.ID, side),
				new ResourceLocation(References.ID, bottom), new ResourceLocation(References.ID, top));
	}
*/
}
