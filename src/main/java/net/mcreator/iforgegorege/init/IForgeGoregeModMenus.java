
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.iforgegorege.world.inventory.IphoneGUIMenu;
import net.mcreator.iforgegorege.world.inventory.BeanselectMenu;
import net.mcreator.iforgegorege.IForgeGoregeMod;

public class IForgeGoregeModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, IForgeGoregeMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<IphoneGUIMenu>> IPHONE_GUI = REGISTRY.register("iphone_gui", () -> IMenuTypeExtension.create(IphoneGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BeanselectMenu>> BEANSELECT = REGISTRY.register("beanselect", () -> IMenuTypeExtension.create(BeanselectMenu::new));
}
