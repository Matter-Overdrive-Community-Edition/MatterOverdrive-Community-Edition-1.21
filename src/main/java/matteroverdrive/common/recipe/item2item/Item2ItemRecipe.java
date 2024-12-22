package matteroverdrive.common.recipe.item2item;

import java.util.ArrayList;
import java.util.List;

import com.mojang.datafixers.util.Pair;

import matteroverdrive.common.recipe.AbstractOverdriveRecipe;
import matteroverdrive.core.capability.types.item.CapabilityInventory;
import matteroverdrive.core.recipe.CountableIngredient;
import matteroverdrive.core.recipe.ProbableFluid;
import matteroverdrive.core.recipe.ProbableItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public abstract class Item2ItemRecipe extends AbstractOverdriveRecipe {

    private List<CountableIngredient> inputItems;
    private ItemStack outputItem;

    public Item2ItemRecipe(String group, List<CountableIngredient> inputs, ItemStack output, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts, List<ProbableGas> gasBiproducts) {
        super(group, experience, ticks, usagePerTick, itemBiproducts, fluidBiproducts, gasBiproducts);
        inputItems = inputs;
        outputItem = output;
    }

	@Override
	public boolean matchesRecipe(CapabilityInventory inv, int procNum) {
		Pair<List<Integer>, Boolean> pair = areItemsValid(getCountedIngredients(), inv.getInputs());
		if (pair.getSecond()) {
			setItemArrangement(procNum, pair.getFirst());
			return true;
		}
		return false;
	}

	@Override
	public ItemStack assemble(RecipeWrapper inv) {
		return getItemRecipeOutput();
	}

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return getItemRecipeOutput();
    }

    public ItemStack getItemRecipeOutput() {
        return outputItem;
    }


	public List<CountableIngredient> getCountedIngredients() {
        return inputItems;
    }

    public interface Factory<T extends Item2ItemRecipe> {

        T create(String group, List<CountableIngredient> inputs, ItemStack output, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts);

    }
}
