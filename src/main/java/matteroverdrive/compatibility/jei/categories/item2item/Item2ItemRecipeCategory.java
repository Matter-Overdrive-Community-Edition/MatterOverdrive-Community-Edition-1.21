package matteroverdrive.compatibility.jei.categories.item2item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import matteroverdrive.common.recipe.item2item.Item2ItemRecipe;
import matteroverdrive.compatibility.jei.categories.base.OverdriveRecipeCategory;
import matteroverdrive.compatibility.jei.utils.gui.ScreenObjectWrapper;
import matteroverdrive.core.recipe.ProbableFluid;
import matteroverdrive.core.utils.UtilsCapability;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

public abstract class Item2ItemRecipeCategory<T extends Item2ItemRecipe> extends OverdriveRecipeCategory<T> {

	/*
	 * DOCUMENTATION NOTES:
	 * 
	 * > Output items supercede buckets in position 
	 * > All biproducts will be included with the outputSlots field 
	 * > All fluid bucket output slots will be incled with the outputSlots field
	 */

	protected Item2ItemRecipeCategory(IGuiHelper guiHelper, ItemStack inputMachine, ScreenObjectWrapper bWrap, int animTime) {
		super(guiHelper, inputMachine, bWrap, animTime);
	}

	@Override
	public List<List<ItemStack>> getItemInputs(Item2ItemRecipe recipe) {
		List<List<ItemStack>> inputs = new ArrayList<>();
		recipe.getCountedIngredients().forEach(h -> inputs.add(h.fetchCountedStacks()));
		return inputs;
	}

	@Override
	public List<ItemStack> getItemOutputs(Item2ItemRecipe recipe) {
		List<ItemStack> outputs = new ArrayList<>();
		outputs.add(recipe.getResultItem());

		if (recipe.hasItemBiproducts()) {
			outputs.addAll(Arrays.asList(recipe.getFullItemBiStacks()));
		}

		if (recipe.hasFluidBiproducts()) {
			for (ProbableFluid fluid : recipe.getFluidBiproducts()) {
				ItemStack canister = new ItemStack(fluid.getFullStack().getFluid().getBucket(), 1);
                IFluidHandlerItem handler = canister.getCapability(Capabilities.FluidHandler.ITEM);
				outputs.add(canister);
			}
		}
		return outputs;
	}

}
