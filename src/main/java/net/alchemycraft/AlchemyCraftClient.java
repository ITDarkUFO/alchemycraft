package net.alchemycraft;

import net.alchemycraft.blocks.mortar.screen.AlchemyMortarScreen;
import net.alchemycraft.config.ConfigHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class AlchemyCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ConfigHandlers.MORTAR_HANDLER, AlchemyMortarScreen::new);
    }
}