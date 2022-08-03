package net.alchemycraft.configs;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerHandler;

import net.alchemycraft.screens.HandlerMortar;
import net.minecraft.screen.ScreenHandlerType;

public class ConfigHandlers {
    public static void init() {
        MORTAR_HANDLER = registerHandler("mortar", new ScreenHandlerType<>(HandlerMortar::new));
    }
    public static ScreenHandlerType<HandlerMortar> MORTAR_HANDLER;
}
