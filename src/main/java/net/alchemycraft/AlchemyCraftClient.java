package net.alchemycraft;

import net.alchemycraft.block.mortar.screen.AlchemyMortarScreen;
import net.alchemycraft.registry.AlchemyHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class AlchemyCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(AlchemyHandlers.MORTAR_HANDLER, AlchemyMortarScreen::new);
    }
}