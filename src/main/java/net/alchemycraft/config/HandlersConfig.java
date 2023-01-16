package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerHandler;

import net.alchemycraft.screen.mortar.MortarHandler;
import net.minecraft.screen.ScreenHandlerType;

public class HandlersConfig {
    public static ScreenHandlerType<MortarHandler> MORTAR_HANDLER;

    public static void init() {
        MORTAR_HANDLER = registerHandler("mortar", new ScreenHandlerType<>(MortarHandler::new));
    }
}
