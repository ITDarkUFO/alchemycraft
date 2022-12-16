package net.alchemycraft;

import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.screen.mortar.ScreenMortar;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class AlchemyCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(HandlersConfig.MORTAR_HANDLER, ScreenMortar::new);
    }
}