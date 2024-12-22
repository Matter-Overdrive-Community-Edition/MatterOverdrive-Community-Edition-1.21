package matteroverdrive.common.recipe.item2item;

import java.lang.reflect.Constructor;

import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.common.recipe.AbstractOverdriveRecipeSerializer;
import matteroverdrive.core.recipe.CountableIngredient;
import matteroverdrive.core.recipe.ProbableFluid;
import matteroverdrive.core.recipe.ProbableItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class Item2ItemRecipeSerializer<T extends Item2ItemRecipe> extends AbstractOverdriveRecipeSerializer<T> {

    private final Item2ItemRecipe.Factory<T> factory;
    private final MapCodec<T> codec;
    private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

    public Item2ItemRecipeSerializer(Item2ItemRecipe.Factory<T> factory) {
        this.factory = factory;
        codec = RecordCodecBuilder.mapCodec(instance -> instance.group(
                                //
                                Codec.STRING.fieldOf(GROUP).forGetter(T::getGroup),
                                //
                                CountableIngredient.LIST_CODEC.fieldOf(ITEM_INPUTS).forGetter(T::getCountedIngredients),
                                //
                                ItemStack.CODEC.fieldOf(OUTPUT).forGetter(T::getItemRecipeOutput),
                                //
                                Codec.DOUBLE.optionalFieldOf(EXPERIENCE, 0.0).forGetter(T::getXp),
                                //
                                Codec.INT.fieldOf(TICKS).forGetter(T::getTicks),
                                //
                                Codec.DOUBLE.fieldOf(USAGE_PER_TICK).forGetter(T::getUsagePerTick),
                                //
                                ProbableItem.LIST_CODEC.optionalFieldOf(ITEM_BIPRODUCTS, ProbableItem.NONE).forGetter(T::getItemBiproducts),
                                //
                                ProbableFluid.LIST_CODEC.optionalFieldOf(FLUID_BIPRODUCTS, ProbableFluid.NONE).forGetter(T::getFluidBiproducts)
                                //
                                
                                //

                        )
                        //
                        .apply(instance, factory::create)

        );

        streamCodec = CodecUtils.composite(
                ByteBufCodecs.STRING_UTF8, T::getGroup,
                CountableIngredient.LIST_STREAM_CODEC, T::getCountedIngredients,
                ItemStack.STREAM_CODEC, T::getItemRecipeOutput,
                ByteBufCodecs.DOUBLE, T::getXp,
                ByteBufCodecs.INT, T::getTicks,
                ByteBufCodecs.DOUBLE, T::getUsagePerTick,
                ProbableItem.LIST_STREAM_CODEC, T::getItemBiproducts,
                ProbableFluid.LIST_STREAM_CODEC, T::getFluidBiproducts,
                ProbableGas.LIST_STREAM_CODEC, T::getGasBiproducts,
                factory::create
        );
    }



    @Override
    public MapCodec<T> codec() {
        return codec;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
        return streamCodec;
    }

}
