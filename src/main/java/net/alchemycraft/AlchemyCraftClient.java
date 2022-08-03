package net.alchemycraft;

import net.alchemycraft.configs.ConfigHandlers;
import net.alchemycraft.screens.ScreenMortar;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class AlchemyCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ConfigHandlers.MORTAR_HANDLER, ScreenMortar::new);
    }
}