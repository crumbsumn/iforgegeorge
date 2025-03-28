
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.iforgegorege.block.SUNBlock;
import net.mcreator.iforgegorege.block.LevodidPortalBlock;
import net.mcreator.iforgegorege.block.DontBlock;
import net.mcreator.iforgegorege.block.BedrockStairsBlock;
import net.mcreator.iforgegorege.IForgeGoregeMod;

import java.util.function.Function;

public class IForgeGoregeModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(IForgeGoregeMod.MODID);
	public static final DeferredBlock<Block> SUN = register("sun", SUNBlock::new);
	public static final DeferredBlock<Block> LEVODID_PORTAL = register("levodid_portal", LevodidPortalBlock::new);
	public static final DeferredBlock<Block> BEDROCK_STAIRS = register("bedrock_stairs", BedrockStairsBlock::new);
	public static final DeferredBlock<Block> DONT = register("dont", DontBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}
