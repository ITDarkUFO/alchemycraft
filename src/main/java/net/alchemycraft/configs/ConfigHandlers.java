package net.alchemycraft.configs;

import static net.alchemycraft.configs.Config.MOD_ID;

import net.alchemycraft.screens.HandlerMortar;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ConfigHandlers {
    public static final ScreenHandlerType<HandlerMortar> MORTAR_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "mortar"), HandlerMortar::new);
    public static void init() {
    }
}
