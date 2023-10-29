package katana.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import katana.init.EnrichWithKatanaModItems;
import katana.init.EnrichWithKatanaModBlocks;

public class SL_have_prProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		double SX = 0;
		double SY = 0;
		double SZ = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EnrichWithKatanaModItems.STEEL_LANTERN.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == EnrichWithKatanaModItems.STEEL_LANTERN.get()) {
			if (world.isClientSide()) {
				distance = 0;
				for (int index0 = 0; index0 < 1; index0++) {
					if (distance == 0) {
						SX = entity.getX();
						SY = entity.getY() + 1;
						SZ = entity.getZ();
					} else if (distance == 1) {
						SX = entity.getX();
						SY = entity.getY() + 2;
						SZ = entity.getZ();
					} else {
						SX = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
						SY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
						SZ = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
					}
					if ((world.getBlockState(new BlockPos(SX, SY, SZ))).getBlock() == EnrichWithKatanaModBlocks.LIGHT_AIR.get() && new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(SX, SY, SZ), "Delay") < 3) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(SX, SY, SZ);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("Delay", 3);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else {
						if ((world.getBlockState(new BlockPos(SX, SY, SZ))).getMaterial() == net.minecraft.world.level.material.Material.AIR && !(Blocks.DIRT_PATH == (world.getBlockState(new BlockPos(SX, SY - 1, SZ))).getBlock())
								&& !(Blocks.MYCELIUM == (world.getBlockState(new BlockPos(SX, SY - 1, SZ))).getBlock()) && !(Blocks.FARMLAND == (world.getBlockState(new BlockPos(SX, SY - 1, SZ))).getBlock())) {
							world.setBlock(new BlockPos(SX, SY, SZ), EnrichWithKatanaModBlocks.LIGHT_AIR.get().defaultBlockState(), 3);
						}
					}
					distance = distance + 1;
				}
			}
		}
	}
}
