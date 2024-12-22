package matteroverdrive.core.matter.generator;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.BiPredicate;

import javax.annotation.Nonnull;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeManager;

/**
 * 
 * Extend this class and provide implementation for any RecipeType. See {@link CraftingMaterValueGenerator} or any
 * other generator under the /base package for examples of implementations. 
 * 
 * @author skip999
 *
 */
public abstract class AbstractMatterValueGenerator {

	//Default implementation of corrections; can be ignored for custom implementation if needed
	private final HashMap<Item, BiPredicate<Integer, HashMap<Item, Double>>> corrections;
	
	public AbstractMatterValueGenerator() {
		corrections = new HashMap<>();
	}
	
	/**
	 * Use this method to assign values to the results of a given recipe type. See See {@link CraftingMaterValueGenerator}
	 * for an example.
	 * 
	 * @param generatedValues: The values generated by all generators at command runtime.
	 * @param recipeManager: The recipe manager for the world at command runtime.
	 * @param loopIteration: The current iteration the loop is on in the command.
	 */
	public abstract void run(HashMap<Item, Double> generatedValues, RecipeManager recipeManager, int loopIteration);
	
	
	/**
	 * 
	 * @param map: The resulting item:value map after a generator has run.
	 * @param loopInterval: The current iteration the loop is on in the command. 
	 */
	public void applyGeneratorCorrections(HashMap<Item, Double> map, int loopInterval) {
		for(Entry<Item, BiPredicate<Integer, HashMap<Item, Double>>> entry : corrections.entrySet()) {
			if(entry.getValue().test(loopInterval, map)) {
				map.remove(entry.getKey());
			}
		}
	}
	
	/*
	 * Default implementation; override for custom correction handling 
	 */
	
	public void addGeneratorCorrection(@Nonnull Item item, @Nonnull BiPredicate<Integer, HashMap<Item, Double>> predicate) {
		corrections.put(item, predicate);
	}
	
	public void addGeneratorCorrection(@Nonnull Item item) {
		addGeneratorCorrection(item, (loopInterval, existingValueMap) -> true);
	}
	
	public void removeGeneratorCorrection(@Nonnull Item item) {
		corrections.remove(item);
	}
	
}