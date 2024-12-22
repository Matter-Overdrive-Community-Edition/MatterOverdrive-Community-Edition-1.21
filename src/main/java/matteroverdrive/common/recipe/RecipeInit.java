package matteroverdrive.common.recipe;

import matteroverdrive.References;
import matteroverdrive.common.recipe.item2item.Item2ItemRecipeSerializer;
import matteroverdrive.common.recipe.item2item.Item2ItemRecipeTypes;
import matteroverdrive.common.recipe.item2item.specific_machines.InscriberRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.common.crafting.IngredientType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class RecipeInit {

	// Deferred Register
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, References.ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, References.ID);
	/* RECIPE TYPES */

	// Item2Item
	public static final DeferredHolder<RecipeType<?>, RecipeType<InscriberRecipe>> INSCRIBER_TYPE = RECIPE_TYPES.register(InscriberRecipe.RECIPE_GROUP, CustomRecipeType::new);

	/* SERIALIZERS */

	// Item2Item
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<?>> INSCRIBER_SERIALIZER = RECIPE_SERIALIZER.register(InscriberRecipe.RECIPE_GROUP, () -> new Item2ItemRecipeSerializer<>(InscriberRecipe::new));
	//public static final RegistryObject<RecipeSerializer<?>> INSCRIBER_SERIALIZER = RECIPE_SERIALIZER.register(InscriberRecipe.RECIPE_GROUP, () -> Item2ItemRecipeTypes.INSCRIBER_JSON_SERIALIZER);

	/* Functional Methods */

	public static class CustomRecipeType<T extends Recipe<?>> implements RecipeType<T> {
        @Override
        public String toString() {
            return BuiltInRegistries.RECIPE_TYPE.getKey(this).toString();
        }
    }

}
