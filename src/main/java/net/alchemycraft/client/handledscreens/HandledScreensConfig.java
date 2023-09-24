package net.alchemycraft.client.handledscreens;

import net.alchemycraft.config.HandlersConfig;
import net.alchemycraft.screen.mortar.MortarScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class HandledScreensConfig {
    public void init() {
        HandledScreens.register(HandlersConfig.MORTAR_HANDLER, MortarScreen::new);
    }

    public HandledScreensConfig() {
    }
}
