
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.iforgegorege.IForgeGoregeMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class IForgeGoregeModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IForgeGoregeMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS = REGISTRY.register("items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.i_forge_gorege.items")).icon(() -> new ItemStack(IForgeGoregeModItems.IPHONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IForgeGoregeModItems.FLASHLIGHT.get());
				tabData.accept(IForgeGoregeModItems.IPHONE.get());
				tabData.accept(IForgeGoregeModItems.LEVODID.get());
				tabData.accept(IForgeGoregeModItems.FLOPPA_SPAWN_EGG.get());
				tabData.accept(IForgeGoregeModItems.SMART.get());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IFG_TOOLS = REGISTRY.register("ifg_tools",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.i_forge_gorege.ifg_tools")).icon(() -> new ItemStack(IForgeGoregeModItems.WALMART_OBSIDIAN_PICKAXE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IForgeGoregeModItems.WALMART_OBSIDIAN_PICKAXE.get());
				tabData.accept(IForgeGoregeModItems.ACTUAL_OBSIDIAN_PAXEL.get());
				tabData.accept(IForgeGoregeModItems.BEDROCK_PICK.get());
			}).withTabsBefore(ITEMS.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IFGBLOCKS = REGISTRY.register("ifgblocks",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.i_forge_gorege.ifgblocks")).icon(() -> new ItemStack(IForgeGoregeModBlocks.SUN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IForgeGoregeModBlocks.BEDROCK_STAIRS.get().asItem());
				tabData.accept(IForgeGoregeModBlocks.DONT.get().asItem());
			}).withSearchBar().withTabsBefore(IFG_TOOLS.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WEAPONS = REGISTRY.register("weapons",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.i_forge_gorege.weapons")).icon(() -> new ItemStack(IForgeGoregeModItems.BEDROCK_ARMOR_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IForgeGoregeModItems.BEDROCK_ARMOR_HELMET.get());
				tabData.accept(IForgeGoregeModItems.BEDROCK_ARMOR_CHESTPLATE.get());
				tabData.accept(IForgeGoregeModItems.BEDROCK_ARMOR_LEGGINGS.get());
				tabData.accept(IForgeGoregeModItems.BEDROCK_ARMOR_BOOTS.get());
				tabData.accept(IForgeGoregeModItems.LEMINIGUN.get());
				tabData.accept(IForgeGoregeModItems.ROCKETLAUNCHER.get());
			}).withTabsBefore(IFGBLOCKS.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXPERIMENTAL = REGISTRY.register("experimental",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.i_forge_gorege.experimental")).icon(() -> new ItemStack(IForgeGoregeModItems.PURPLE_BEAN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IForgeGoregeModItems.JELLYBEAN_SPAWN_EGG.get());
				tabData.accept(IForgeGoregeModItems.PURPLE_BEAN.get());
			}).withSearchBar().withTabsBefore(WEAPONS.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOODS = REGISTRY.register("foods",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.i_forge_gorege.foods")).icon(() -> new ItemStack(IForgeGoregeModItems.BEANS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(IForgeGoregeModItems.BEANS.get());
				tabData.accept(IForgeGoregeModItems.GOD_BEANS.get());
				tabData.accept(IForgeGoregeModItems.BORGIR.get());
			}).withSearchBar().withTabsBefore(EXPERIMENTAL.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(IForgeGoregeModBlocks.SUN.get().asItem());
		}
	}
}
