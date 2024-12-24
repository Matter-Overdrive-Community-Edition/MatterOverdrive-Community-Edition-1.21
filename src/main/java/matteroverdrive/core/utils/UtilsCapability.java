package matteroverdrive.core.utils;

import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

public class UtilsCapability {

	public static boolean hasEnergyCap(ItemStack stack) {
		return stack.getCapability(ForgeCapabilities.ENERGY).isPresent();
	}

	public static boolean hasMatterCap(ItemStack stack) {
		return stack.getCapability(MatterOverdriveCapabilities.MATTER_STORAGE).isPresent();
	}
	
	public static void fillFluidCap(ItemStack stack, FluidStack fluid) {
		stack.getCapability(getFluidItemCap()).ifPresent(h -> h.fill(fluid, FluidAction.EXECUTE));
	}
	
	public static Capability<IFluidHandlerItem> getFluidItemCap() {
		return ForgeCapabilities.FLUID_HANDLER_ITEM;
	}

}
