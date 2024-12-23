package matteroverdrive.datagen.utils.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;

import matteroverdrive.common.recipe.AbstractOverdriveRecipeSerializer;
import matteroverdrive.core.recipe.ProbableFluid;
import matteroverdrive.core.recipe.ProbableItem;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class AbstractOverdriveFinishedRecipe implements FinishedRecipe {

	private RecipeSerializer<?> serializer;
	private ResourceLocation id;
	
	private List<ProbableItem> itemBiproducts = new ArrayList<>();
	private List<ProbableFluid> fluidBiproducts = new ArrayList<>();
	
	private List<ItemStack> itemIngredients = new ArrayList<>();
	private List<Pair<TagKey<Item>, Integer>> tagItemIngredients = new ArrayList<>();
	private List<FluidStack> fluidIngredients = new ArrayList<>();
	private List<Pair<TagKey<Fluid>, Integer>> tagFluidIngredients = new ArrayList<>();
	
	private double experience = 0.0;
	private double processTime = 0.0;
	private double usagePerTick = 0.0;
	
	protected AbstractOverdriveFinishedRecipe(RecipeSerializer<?> serializer, double experience, double processTime, double usagePerTick) {
		this.serializer = serializer;
		this.experience = experience;
		this.processTime = processTime;
		this.usagePerTick = usagePerTick;
	}
	
	public AbstractOverdriveFinishedRecipe name(RecipeCategory category, String parent, String name) {
		id = new ResourceLocation(parent, category.category() + "/" + name);
		return this;
	}
	
	public AbstractOverdriveFinishedRecipe addItemStackInput(ItemStack stack) {
		itemIngredients.add(stack);
		return this;
	}
	
	public AbstractOverdriveFinishedRecipe addItemTagInput(TagKey<Item> tag, int count) {
		tagItemIngredients.add(Pair.of(tag, count));
		return this;
	}
	
	public AbstractOverdriveFinishedRecipe addFluidStackInput(FluidStack stack) {
		fluidIngredients.add(stack);
		return this;
	}
	
	public AbstractOverdriveFinishedRecipe addFluidTagInput(TagKey<Fluid> tag, int count) {
		tagFluidIngredients.add(Pair.of(tag, count));
		return this;
	}
	
	public AbstractOverdriveFinishedRecipe addItemBiproduct(ProbableItem biproudct) {
		itemBiproducts.add(biproudct);
		return this;
	}
	
	public AbstractOverdriveFinishedRecipe addFluidBiproduct(ProbableFluid biproduct) {
		fluidBiproducts.add(biproduct);
		return this;
	}

	public void complete(Consumer<FinishedRecipe> consumer) {
		consumer.accept(this);
	}
	
	
	@Override
	public void serializeRecipeData(JsonObject recipeJson) {
		boolean inputsFlag = false;
		
		recipeJson.addProperty(AbstractOverdriveRecipeSerializer.TIME, processTime);
		recipeJson.addProperty(AbstractOverdriveRecipeSerializer.USAGE, usagePerTick);
		
		int itemInputsCount = itemIngredients.size() + tagItemIngredients.size();
		if(itemInputsCount > 0) {
			inputsFlag = true;
			JsonObject itemInputs = new JsonObject();
			itemInputs.addProperty(AbstractOverdriveRecipeSerializer.COUNT, itemInputsCount);
			JsonObject itemJson;
			int index = 0;
			for(ItemStack stack : itemIngredients) {
				itemJson = new JsonObject();
				itemJson.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
				itemJson.addProperty(AbstractOverdriveRecipeSerializer.COUNT, stack.getCount());
				itemInputs.add(index + "", itemJson);
				index++;
			}
			for(Pair<TagKey<Item>, Integer> itemTags: tagItemIngredients) {
				itemJson = new JsonObject();
				itemJson.addProperty("tag", itemTags.getFirst().location().toString());
				itemJson.addProperty(AbstractOverdriveRecipeSerializer.COUNT, itemTags.getSecond());
				itemInputs.add(index + "", itemJson);
				index++;
			}
			recipeJson.add(AbstractOverdriveRecipeSerializer.ITEM_INPUTS, itemInputs);
		}
		
		int fluidInputsCount = fluidIngredients.size() + tagFluidIngredients.size();
		if(fluidInputsCount > 0) {
			inputsFlag = true;
			JsonObject fluidInputs = new JsonObject();
			fluidInputs.addProperty(AbstractOverdriveRecipeSerializer.COUNT, fluidInputsCount);
			JsonObject fluidJson;
			int index = 0;
			for(FluidStack stack : fluidIngredients) {
				fluidJson = new JsonObject();
				fluidJson.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(stack.getFluid()).toString());
				fluidJson.addProperty("amount", stack.getAmount());
				fluidInputs.add(index + "", fluidJson);
				index++;
			}
			for(Pair<TagKey<Fluid>, Integer> itemTags: tagFluidIngredients) {
				fluidJson = new JsonObject();
				fluidJson.addProperty("tag", itemTags.getFirst().location().toString());
				fluidJson.addProperty("amount", itemTags.getSecond());
				fluidInputs.add(index + "", fluidJson);
				index++;
			}
			recipeJson.add(AbstractOverdriveRecipeSerializer.FLUID_INPUTS, fluidInputs);
		}
		
		if(!inputsFlag) {
			throw new RuntimeException("You must specify at least one item or fluid input");
		}
		
		writeOutput(recipeJson);
		
		recipeJson.addProperty(AbstractOverdriveRecipeSerializer.EXPERIENCE, experience);
		
		if(itemBiproducts.size() > 0) {
			JsonObject itemBiproducts = new JsonObject();
			itemBiproducts.addProperty(AbstractOverdriveRecipeSerializer.COUNT, this.itemBiproducts.size());
			JsonObject itemJson;
			ItemStack stack;
			int index = 0;
			for(ProbableItem biproduct : this.itemBiproducts) {
				itemJson = new JsonObject();
				stack = biproduct.getFullStack();
				itemJson.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
				itemJson.addProperty(AbstractOverdriveRecipeSerializer.COUNT, stack.getCount());
				itemJson.addProperty("chance", biproduct.getChance());
				itemBiproducts.add(index + "", itemJson);
				index++;
			}
			recipeJson.add(AbstractOverdriveRecipeSerializer.ITEM_BIPRODUCTS, itemBiproducts);
		}
		
		if(fluidBiproducts.size() > 0) {
			JsonObject fluidBiproducts = new JsonObject();
			fluidBiproducts.addProperty(AbstractOverdriveRecipeSerializer.COUNT, this.fluidBiproducts.size());
			JsonObject fluidJson;
			FluidStack stack;
			int index = 0;
			for(ProbableFluid biproduct : this.fluidBiproducts) {
				fluidJson = new JsonObject();
				stack = biproduct.getFullStack();
				fluidJson.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(stack.getFluid()).toString());
				fluidJson.addProperty("amount", stack.getAmount());
				fluidJson.addProperty("chance", biproduct.getChance());
				fluidBiproducts.add(index + "", fluidJson);
				index++;
			}
			recipeJson.add(AbstractOverdriveRecipeSerializer.FLUID_BIPRODUCTS, fluidBiproducts);
		}
		
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getType() {
		return serializer;
	}

	@Override
	@Nullable
	public JsonObject serializeAdvancement() {
		return null;
	}

	@Override
	@Nullable
	public ResourceLocation getAdvancementId() {
		return null;
	}
	
	public abstract void writeOutput(JsonObject recipeJson);
	
	public static enum RecipeCategory {
		ITEM_2_ITEM, ITEM_2_FLUID, FLUID_ITEM_2_ITEM, FLUID_ITEM_2_FLUID, FLUID_2_ITEM, FLUID_2_FLUID;
		
		public String category() {
			return toString().toLowerCase().replaceAll("_", "");
		}
	}

}
