
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.iforgegorege.item.inventory.IphoneInventoryCapability;
import net.mcreator.iforgegorege.item.WalmartObsidianPickaxeItem;
import net.mcreator.iforgegorege.item.SmartItem;
import net.mcreator.iforgegorege.item.RocketlauncherItem;
import net.mcreator.iforgegorege.item.PurpleBeanItem;
import net.mcreator.iforgegorege.item.LevodidItem;
import net.mcreator.iforgegorege.item.LeminigunItem;
import net.mcreator.iforgegorege.item.IphoneItem;
import net.mcreator.iforgegorege.item.GodBeansItem;
import net.mcreator.iforgegorege.item.FlashlightItem;
import net.mcreator.iforgegorege.item.BorgirItem;
import net.mcreator.iforgegorege.item.BedrockPickItem;
import net.mcreator.iforgegorege.item.BedrockArmorItem;
import net.mcreator.iforgegorege.item.BeansItem;
import net.mcreator.iforgegorege.item.ActualObsidianPaxelItem;
import net.mcreator.iforgegorege.IForgeGoregeMod;

import java.util.function.Function;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class IForgeGoregeModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(IForgeGoregeMod.MODID);
	public static final DeferredItem<Item> FLASHLIGHT = register("flashlight", FlashlightItem::new);
	public static final DeferredItem<Item> SUN = block(IForgeGoregeModBlocks.SUN);
	public static final DeferredItem<Item> WALMART_OBSIDIAN_PICKAXE = register("walmart_obsidian_pickaxe", WalmartObsidianPickaxeItem::new);
	public static final DeferredItem<Item> IPHONE = register("iphone", IphoneItem::new);
	public static final DeferredItem<Item> ACTUAL_OBSIDIAN_PAXEL = register("actual_obsidian_paxel", ActualObsidianPaxelItem::new);
	public static final DeferredItem<Item> LEVODID = register("levodid", LevodidItem::new);
	public static final DeferredItem<Item> BEDROCK_STAIRS = block(IForgeGoregeModBlocks.BEDROCK_STAIRS);
	public static final DeferredItem<Item> BEDROCK_PICK = register("bedrock_pick", BedrockPickItem::new);
	public static final DeferredItem<Item> BEDROCK_ARMOR_HELMET = register("bedrock_armor_helmet", BedrockArmorItem.Helmet::new);
	public static final DeferredItem<Item> BEDROCK_ARMOR_CHESTPLATE = register("bedrock_armor_chestplate", BedrockArmorItem.Chestplate::new);
	public static final DeferredItem<Item> BEDROCK_ARMOR_LEGGINGS = register("bedrock_armor_leggings", BedrockArmorItem.Leggings::new);
	public static final DeferredItem<Item> BEDROCK_ARMOR_BOOTS = register("bedrock_armor_boots", BedrockArmorItem.Boots::new);
	public static final DeferredItem<Item> JELLYBEAN_SPAWN_EGG = register("jellybean_spawn_egg", properties -> new SpawnEggItem(IForgeGoregeModEntities.JELLYBEAN.get(), properties));
	public static final DeferredItem<Item> PURPLE_BEAN = register("purple_bean", PurpleBeanItem::new);
	public static final DeferredItem<Item> DONT = block(IForgeGoregeModBlocks.DONT);
	public static final DeferredItem<Item> BEANS = register("beans", BeansItem::new);
	public static final DeferredItem<Item> GOD_BEANS = register("god_beans", GodBeansItem::new);
	public static final DeferredItem<Item> FLOPPA_SPAWN_EGG = register("floppa_spawn_egg", properties -> new SpawnEggItem(IForgeGoregeModEntities.FLOPPA.get(), properties));
	public static final DeferredItem<Item> BORGIR = register("borgir", BorgirItem::new);
	public static final DeferredItem<Item> LEMINIGUN = register("leminigun", LeminigunItem::new);
	public static final DeferredItem<Item> SMART = register("smart", SmartItem::new);
	public static final DeferredItem<Item> ROCKETLAUNCHER = register("rocketlauncher", RocketlauncherItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.registerItem(block.getId().getPath(), properties -> new BlockItem(block.get(), properties), new Item.Properties());
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new IphoneInventoryCapability(stack), IPHONE.get());
	}
}
