package net.alchemycraft.config;

import static net.alchemycraft.AlchemyCraft.MOD_ID;

import net.alchemycraft.blocks.mortar.handler.AlchemyMortarHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ConfigHandlers {
    public static final ScreenHandlerType<AlchemyMortarHandler> MORTAR_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "mortar"), AlchemyMortarHandler::new);
    public static void init() {
    }
}
