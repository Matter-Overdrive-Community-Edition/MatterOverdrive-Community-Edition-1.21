package matteroverdrive.core.capability.types.item_pattern;

import javax.annotation.Nullable;

import org.jetbrains.annotations.UnknownNullability;

import matteroverdrive.core.capability.MatterOverdriveCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class CapabilityItemPatternStorage
		implements ICapabilityItemPatternStorage, INBTSerializable<CompoundTag>, ICapabilityProvider {

	private final LazyOptional<ICapabilityItemPatternStorage> lazyOptional = LazyOptional.of(() -> this);

	public CapabilityItemPatternStorage() {
		patterns = new ItemPatternWrapper[] { ItemPatternWrapper.EMPTY, ItemPatternWrapper.EMPTY,
				ItemPatternWrapper.EMPTY };
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == MatterOverdriveCapabilities.STORED_PATTERNS) {
			return lazyOptional.cast();
		}
		return LazyOptional.empty();
	}

	@Nullable
	private ItemPatternWrapper[] patterns;

	@Override
	public ItemPatternWrapper[] getStoredPatterns() {
		return patterns;
	}

	@Override
	public @org.jetbrains.annotations.Nullable Object getCapability(Object object,
			@org.jetbrains.annotations.Nullable Object context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompoundTag serializeNBT(Provider provider) {
		CompoundTag data = new CompoundTag();
		for (int i = 0; i < 3; i++) {
			patterns[i].writeToNbt(data, "pattern" + i);
		}
		return data;
	}

	@Override
	public void deserializeNBT(Provider provider, CompoundTag nbt) {
		patterns = new ItemPatternWrapper[3];
		for (int i = 0; i < 3; i++) {
			patterns[i] = ItemPatternWrapper.readFromNbt(nbt.getCompound("pattern" + i));
		}
		
	}

}
