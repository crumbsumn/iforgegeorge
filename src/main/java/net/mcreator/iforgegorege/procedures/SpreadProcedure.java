package net.mcreator.iforgegorege.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.iforgegorege.init.IForgeGoregeModBlocks;

public class SpreadProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.1) {
			if (!((world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get() || (world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get()
					|| (world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 0))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 0))).getBlock() == Blocks.AIR)) {
				world.setBlock(BlockPos.containing(x + 0, y + 1, z + 0), Blocks.AIR.defaultBlockState(), 3);
			} else if (!((world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get() || (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get()
					|| (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == Blocks.AIR)) {
				world.setBlock(BlockPos.containing(x + 0, y - 1, z - 0), Blocks.AIR.defaultBlockState(), 3);
			} else if (!((world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get() || (world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get()
					|| (world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x + 1, y + 0, z + 0))).getBlock() == Blocks.AIR)) {
				world.setBlock(BlockPos.containing(x + 1, y + 0, z + 0), IForgeGoregeModBlocks.DONT.get().defaultBlockState(), 3);
			} else if (!((world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get() || (world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == IForgeGoregeModBlocks.DONT.get()
					|| (world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x - 1, y + 0, z + 0))).getBlock() == Blocks.AIR)) {
				world.setBlock(BlockPos.containing(x - 1, y + 0, z + 0), Blocks.AIR.defaultBlockState(), 3);
			} else if (!((world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 1))).getBlock() == IForgeGoregeModBlocks.DONT.get() || (world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 1))).getBlock() == IForgeGoregeModBlocks.DONT.get()
					|| (world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 1))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 1))).getBlock() == Blocks.AIR)) {
				world.setBlock(BlockPos.containing(x + 0, y + 0, z + 1), Blocks.AIR.defaultBlockState(), 3);
			} else if (!((world.getBlockState(BlockPos.containing(x + 0, y + 0, z - 1))).getBlock() == IForgeGoregeModBlocks.DONT.get() || (world.getBlockState(BlockPos.containing(x + 0, y + 0, z - 1))).getBlock() == IForgeGoregeModBlocks.DONT.get()
					|| (world.getBlockState(BlockPos.containing(x + 0, y + 0, z - 1))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x + 0, y + 0, z - 1))).getBlock() == Blocks.AIR)) {
				world.setBlock(BlockPos.containing(x + 0, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
			} else {
				world.setBlock(BlockPos.containing(x + 0, y + 0, z + 0), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}
}
