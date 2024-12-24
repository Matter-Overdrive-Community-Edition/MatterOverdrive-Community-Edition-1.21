package matteroverdrive.common.block;

import java.util.Arrays;
import java.util.List;

import com.mojang.serialization.MapCodec;

import matteroverdrive.common.block.OverdriveBlockStates.VerticalFacing;
import matteroverdrive.common.block.type.TypeMachine;
import matteroverdrive.core.block.GenericMachineBlock;
import matteroverdrive.core.block.OverdriveBlockProperties;
import matteroverdrive.core.capability.types.item.CapabilityInventory;
import matteroverdrive.core.config.MatterOverdriveConfig;
import matteroverdrive.core.tile.GenericTile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;


public class BlockMachine<T extends GenericTile> extends GenericMachineBlock {

	protected BlockMachine(OverdriveBlockProperties properties, BlockEntitySupplier<BlockEntity> supplier) {
		super(properties, supplier);
		// TODO Auto-generated constructor stub
	}
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public static final BooleanProperty CAN_EMIT = BooleanProperty.create("can_emit");

	public TypeMachine type;
//	private RegistryObject<BlockEntityType<T>> blockEntityType;

  //  public BlockMachine(Properties properties) {
  //      super(properties);

  //      registerDefaultState(this.getStateDefinition().any()
  //              .setValue(FACING, Direction.NORTH).setValue(ACTIVE, false).setValue(CAN_EMIT, false));
  //  }
        


//	public BlockMachine(BlockEntitySupplier<BlockEntity> supplier, TypeMachine type,
	//		DeferredItem<BlockEntityType<T>> entity) {
//		this(type.properties, supplier, type, entity);
	//}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		if (type.hasCustomAABB) {
			if (type.singleShape) {
				return type.omniShape;
			}
			OverdriveBlockProperties stateProperties = (OverdriveBlockProperties) this.properties;
			Direction facing = state.getValue(FACING);
			if (stateProperties.isOmniDirectional()) {
				VerticalFacing vertical = state.getValue(OverdriveBlockStates.VERTICAL_FACING);
				if (vertical.mapped != null) {
					facing = vertical.mapped;
				}
			}
			return type.getShape(facing);
		}
		return super.getShape(state, level, pos, context);
	}
/*
	@Override
	public ItemStack getCloneItemStack(BlockGetter level, BlockPos pPos, BlockState pState) {
		ItemStack stack = super.getCloneItemStack(level, pPos, pState);
		level.getBlockEntity(pPos, blockEntityType.get()).ifPresent(crate -> {
			crate.saveToItem(stack);
		});
		return stack;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		BlockEntity blockentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
		if (blockentity instanceof GenericTile generic
				&& generic.hasCapability(ForgeCapabilities.ITEM_HANDLER)) {
			CapabilityInventory inv = generic.exposeCapability(ForgeCapabilities.ITEM_HANDLER);
			if (MatterOverdriveConfig.MACHINES_DROP_ITEMS.get()) {
				Containers.dropContents(generic.getLevel(), generic.getBlockPos(), inv.getItems());
				return Arrays.asList(new ItemStack(this));
			}
		}
		return super.getDrops(state, builder);
	}*/


	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		// TODO Auto-generated method stub
		return null;
	}

}
