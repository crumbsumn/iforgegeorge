
package net.mcreator.iforgegorege.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.iforgegorege.procedures.SummonnutProcedure;

public class WalmartObsidianPickaxeItem extends PickaxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 25000, 25f, 0, 21, TagKey.create(Registries.ITEM, ResourceLocation.parse("i_forge_gorege:walmart_obsidian_pickaxe_repair_items")));

	public WalmartObsidianPickaxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 70f, -3.5f, properties.fireResistant());
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		SummonnutProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}
