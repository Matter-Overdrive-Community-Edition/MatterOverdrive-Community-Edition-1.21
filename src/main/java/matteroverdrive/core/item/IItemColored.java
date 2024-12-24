package matteroverdrive.core.item;

import java.util.List;

import matteroverdrive.client.ClientReferences.Colors;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public interface IItemColored {

	default int getColor(ItemStack item, int layer) {
		return Colors.WHITE.getColor();
	}
	
	default boolean isColored() {
		return false;
	}

	default int getNumOfLayers() {
		return 0;
	}

	void appendHoverText(ItemStack stack, Level world, List<Component> tooltips, TooltipFlag flag);
	
}
