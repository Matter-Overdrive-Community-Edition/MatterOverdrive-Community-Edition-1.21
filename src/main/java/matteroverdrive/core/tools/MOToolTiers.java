package matteroverdrive.core.tools;

import matteroverdrive.registry.ItemRegistry;
import java.util.function.Supplier;

import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum MOToolTiers implements Tier {
	TRITANIUM(2, 3122, 6.0F, 2.0F, 14, () -> {
		return Ingredient.of(ItemRegistry.ITEM_TRITANIUM_INGOT.get());
	});

	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantmentValue;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private MOToolTiers(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue,
			Supplier<Ingredient> pRepairIngredient) {
		this.level = pLevel;
		this.uses = pUses;
		this.speed = pSpeed;
		this.damage = pDamage;
		this.enchantmentValue = pEnchantmentValue;
		this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
	}

	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public TagKey<Block> getIncorrectBlocksForDrops() {
		// TODO Auto-generated method stub
		return null;
	}
}