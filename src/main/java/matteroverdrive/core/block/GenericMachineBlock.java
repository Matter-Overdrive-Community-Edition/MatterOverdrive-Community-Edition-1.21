package matteroverdrive.core.block;

import org.jetbrains.annotations.Nullable;

import matteroverdrive.core.tile.GenericTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public abstract class GenericMachineBlock extends GenericEntityBlock {

	public static final Properties DEFAULT_MACHINE_PROPERTIES = Properties.of().strength(3.5F)
			.sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops();

	protected BlockEntitySupplier<BlockEntity> blockEntitySupplier;

	protected GenericMachineBlock(OverdriveBlockProperties properties, BlockEntitySupplier<BlockEntity> supplier) {
		super(properties);
		blockEntitySupplier = supplier;
	}
    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
    }
    
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return blockEntitySupplier.create(pos, state);
	}

}
