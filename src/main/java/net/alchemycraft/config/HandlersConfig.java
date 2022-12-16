package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerHandler;

import net.alchemycraft.screen.mortar.HandlerMortar;
import net.minecraft.screen.ScreenHandlerType;

public class HandlersConfig {
    public static ScreenHandlerType<HandlerMortar> MORTAR_HANDLER;

    public static void init() {
        MORTAR_HANDLER = registerHandler("mortar", new ScreenHandlerType<>(HandlerMortar::new));
    }
}
