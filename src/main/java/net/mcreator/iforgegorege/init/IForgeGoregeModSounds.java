
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.iforgegorege.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.iforgegorege.IForgeGoregeMod;

public class IForgeGoregeModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, IForgeGoregeMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> UNFUNNY = REGISTRY.register("unfunny", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("i_forge_gorege", "unfunny")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SMARTRACE = REGISTRY.register("smartrace", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("i_forge_gorege", "smartrace")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BURENYUU = REGISTRY.register("burenyuu", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("i_forge_gorege", "burenyuu")));
}
