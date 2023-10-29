
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import katana.block.entity.LightAirBlockEntity;
import katana.block.entity.HellFurnaceBlockEntity;
import katana.block.entity.AlloyFurnaceBlockEntity;

import katana.EnrichWithKatanaMod;

public class EnrichWithKatanaModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ALLOY_FURNACE = register("alloy_furnace", EnrichWithKatanaModBlocks.ALLOY_FURNACE, AlloyFurnaceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HELL_FURNACE = register("hell_furnace", EnrichWithKatanaModBlocks.HELL_FURNACE, HellFurnaceBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LIGHT_AIR = register("light_air", EnrichWithKatanaModBlocks.LIGHT_AIR, LightAirBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
