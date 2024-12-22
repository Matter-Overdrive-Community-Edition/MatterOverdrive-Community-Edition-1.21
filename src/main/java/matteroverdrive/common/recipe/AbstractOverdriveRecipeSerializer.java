package matteroverdrive.common.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;


public abstract class AbstractOverdriveRecipeSerializer<T extends AbstractOverdriveRecipe>
		implements RecipeSerializer<T> {

	public static final String COUNT = "count";
	public static final String ITEM_INPUTS = "iteminputs";
	public static final String FLUID_INPUTS = "fluidinputs";
	public static final String ITEM_BIPRODUCTS = "itembi";
	public static final String FLUID_BIPRODUCTS = "fluidbi";
	public static final String OUTPUT = "output";
	public static final String EXPERIENCE = "experience";
	public static final String TIME = "time";
	public static final String USAGE = "usage";

}
