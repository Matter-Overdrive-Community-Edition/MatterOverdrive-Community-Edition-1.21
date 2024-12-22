package matteroverdrive.common.block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import matteroverdrive.References;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext.Builder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

public class BlockColored extends BlockOverdrive {

	private static final List<BlockColored> BLOCKS = new ArrayList<>();

	private int color;

	public BlockColored(Properties properties, int color) {
		super(properties);
		this.color = color;
		BLOCKS.add(this);
	}

	public int getColor() {
		return color;
	}

	public List<ItemStack> getDrops(BlockState pState, Builder pBuilder) {
		return Arrays.asList(new ItemStack(this));
	}

	@EventBusSubscriber(modid = References.ID, bus = EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
	private static class ColorHandler {

		@SubscribeEvent
		public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
			BLOCKS.forEach(block -> event.register((state, level, pos, tintIndex) -> block.getColor(), block));
		}
	}

}
