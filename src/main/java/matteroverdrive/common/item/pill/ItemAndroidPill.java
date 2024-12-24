package matteroverdrive.common.item.pill;

import matteroverdrive.References;
import matteroverdrive.client.ClientReferences.Colors;
import matteroverdrive.common.item.utils.OverdriveItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;

public class ItemAndroidPill extends OverdriveItem {

	// For eating or internal damage
	public static final ResourceKey<DamageType> EXAMPLE_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE,
			ResourceLocation.fromNamespaceAndPath(References.ID, "nanites"));
	public static final FoodProperties PILLS = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.3F)
			.alwaysEdible().fast().build();

	private final Colors color;

	public ItemAndroidPill(Properties properties, Colors color, boolean hasShiftTip) {
		super(properties, hasShiftTip);
		this.color = color;
	}

	@Override
	public boolean isColored() {
		return true;
	}

	@Override
	public int getColor(ItemStack item, int index) {
		return index == 0 ? Colors.WHITE.getColor() : color.getColor();
	}

	@Override
	public int getNumOfLayers() {
		return 2;
	}

}
