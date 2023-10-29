
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package katana.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import katana.block.LightAirBlock;
import katana.block.HellFurnaceBlock;
import katana.block.BlockofaluminumBlock;
import katana.block.BlockofSteelBlock;
import katana.block.BlockofBerylliumcopperBlock;
import katana.block.BauxiteoreBlock;
import katana.block.AlloyFurnaceBlock;

import katana.EnrichWithKatanaMod;

public class EnrichWithKatanaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EnrichWithKatanaMod.MODID);
	public static final RegistryObject<Block> BAUXITEORE = REGISTRY.register("bauxiteore", () -> new BauxiteoreBlock());
	public static final RegistryObject<Block> BLOCKOFALUMINUM = REGISTRY.register("blockofaluminum", () -> new BlockofaluminumBlock());
	public static final RegistryObject<Block> BLOCKOF_STEEL = REGISTRY.register("blockof_steel", () -> new BlockofSteelBlock());
	public static final RegistryObject<Block> BLOCKOF_BERYLLIUMCOPPER = REGISTRY.register("blockof_berylliumcopper", () -> new BlockofBerylliumcopperBlock());
	public static final RegistryObject<Block> ALLOY_FURNACE = REGISTRY.register("alloy_furnace", () -> new AlloyFurnaceBlock());
	public static final RegistryObject<Block> HELL_FURNACE = REGISTRY.register("hell_furnace", () -> new HellFurnaceBlock());
	public static final RegistryObject<Block> LIGHT_AIR = REGISTRY.register("light_air", () -> new LightAirBlock());
}
