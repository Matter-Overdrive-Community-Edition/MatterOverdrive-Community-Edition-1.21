package matteroverdrive.common.recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Pair;

import matteroverdrive.core.capability.types.item.CapabilityInventory;
import matteroverdrive.core.recipe.CountableIngredient;
import matteroverdrive.core.recipe.FluidIngredient;
import matteroverdrive.core.recipe.ProbableFluid;
import matteroverdrive.core.recipe.ProbableItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;

public abstract class AbstractOverdriveRecipe implements Recipe<RecipeWrapper> {

	/*
	 * Need to know: > does it have fluid and item biproducts ; store as booleans >
	 * the number of fluid and item biproducts ; store as ints > the arrangement of
	 * the items in the machine's inventory ; store as int list
	 * 
	 * store item and fluid biproducts here as well
	 */

	private final String id;

	private boolean hasItemBi;
	private boolean hasFluidBi;
	// not initialized unless in use; no need to create a bunch of Objects if there
	// never even used!
	private int itemBiCount;
	private int fluidBiCount;

	private double xp;

	//private ProbableItem[] itemBiProducts;
	private final List<ProbableItem> itemBiproducts;
	private final List<ProbableFluid> fluidBiproducts;

	private double processTime;
	private double usagePerTick;

	private HashMap<Integer, List<Integer>> itemArrangements = new HashMap<>();
	private List<Integer> fluidArrangement;

	public AbstractOverdriveRecipe(String recipeGroup, double experience, int ticks, double usagePerTick, List<ProbableItem> itemBiproducts, List<ProbableFluid> fluidBiproducts) {
	        id = recipeGroup;
	        xp = experience;
	        this.usagePerTick = usagePerTick;
	        this.itemBiproducts = itemBiproducts;
	        this.fluidBiproducts = fluidBiproducts;
	    }

	/**
	 * NEVER USE THIS METHOD!
	 */
	@Override
	public boolean matches(RecipeWrapper inv, Level world) {
		return false;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return false;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

    @Override
    public String getGroup() {
        return id;
    }

	// ALWAYS call these methods before trying to get any other info on biproducts
    public boolean hasItemBiproducts() {
        return itemBiproducts.size() != 0;
    }

    public boolean hasFluidBiproducts() {
        return fluidBiproducts.size() != 0;
    }

    @Nullable
    public List<ProbableItem> getItemBiproducts() {
        return itemBiproducts;
    }

    @Nullable
    public List<ProbableFluid> getFluidBiproducts() {
        return fluidBiproducts;
    }

    public ItemStack[] getFullItemBiStacks() {
        ItemStack[] items = new ItemStack[getItemBiproductCount()];
        for (int i = 0; i < getItemBiproductCount(); i++) {
            items[i] = itemBiproducts.get(i).getFullStack();
        }
        return items;
    }

    public FluidStack[] getFullFluidBiStacks() {
        FluidStack[] fluids = new FluidStack[getFluidBiproductCount()];
        for (int i = 0; i < getFluidBiproductCount(); i++) {
            fluids[i] = fluidBiproducts.get(i).getFullStack();
        }
        return fluids;
    }

	public int getItemBiproductCount() {
		if (!hasItemBiproducts()) {
			throw new UnsupportedOperationException("This recipe has no Item Biproducts. Do not get the count");
		}
		return itemBiCount;
	}

	public int getFluidBiproductCount() {
		if (!hasFluidBiproducts()) {
			throw new UnsupportedOperationException("This recipe has no Fluid Biproducts. Do not get the count!");
		}
		return fluidBiCount;
	}

	public void setItemArrangement(Integer procNumber, List<Integer> arrangement) {
		itemArrangements.put(procNumber, arrangement);
	}

	public List<Integer> getItemArrangment(Integer procNumber) {
		return itemArrangements.get(procNumber);
	}

	public void setFluidArrangement(List<Integer> arrangement) {
		fluidArrangement = arrangement;
	}

	public List<Integer> getFluidArrangement() {
		return fluidArrangement;
	}

	public double getXp() {
		return xp;
	}

	public double getProcessTime() {
		return processTime;
	}

	public double getUsagePerTick() {
		return usagePerTick;
	}

    public static List<RecipeHolder<AbstractOverdriveRecipe>> findRecipesbyType(RecipeType<? extends AbstractOverdriveRecipe> typeIn, Level world) {
        return world != null ? world.getRecipeManager().getAllRecipesFor((RecipeType<AbstractOverdriveRecipe>) typeIn) : Collections.emptyList();
    }

	@Nullable
	public static AbstractOverdriveRecipe getRecipe(CapabilityInventory inv, List<AbstractOverdriveRecipe> recipes,
			int procNum) {
		for (AbstractOverdriveRecipe recipe : recipes) {
			if (recipe.matchesRecipe(inv, procNum)) {
				return recipe;
			}
		}
		return null;
	}

    public static Pair<List<Integer>, Boolean> areItemsValid(List<CountableIngredient> ingredients, List<ItemStack> stacks) {
        Boolean valid = true;
        List<Integer> slotOreintation = new ArrayList<>();
        for (int i = 0; i < ingredients.size(); i++) {
            CountableIngredient ing = ingredients.get(i);
            int slotNum = -1;
            for (int j = 0; j < stacks.size(); j++) {
                if (ing.testStack(stacks.get(j))) {
                    slotNum = j;
                    break;
                }
            }
            if (slotNum > -1 && !slotOreintation.contains(slotNum)) {
                slotOreintation.add(slotNum);
            }
        }
        if (slotOreintation.size() < ingredients.size()) {
            valid = false;
        }
        return Pair.of(slotOreintation, valid);
    }

	public static Pair<List<Integer>, Boolean> areFluidsValid(List<FluidIngredient> ingredients,
			FluidTank[] fluidTanks) {
		Boolean valid = true;
		List<Integer> tankOrientation = new ArrayList<>();
		for (int i = 0; i < ingredients.size(); i++) {
			FluidIngredient ing = ingredients.get(i);
			int tankNum = -1;
			for (int j = 0; j < fluidTanks.length; j++) {
				if (ing.testFluid(fluidTanks[i].getFluid())) {
					tankNum = j;
					break;
				}
			}
			if (tankNum > -1 && !tankOrientation.contains(tankNum)) {
				tankOrientation.add(tankNum);
			}
		}
		if (tankOrientation.size() < ingredients.size()) {
			valid = false;
		}
		return Pair.of(tankOrientation, valid);
	}

	public abstract boolean matchesRecipe(CapabilityInventory inv, int procNum);

}
