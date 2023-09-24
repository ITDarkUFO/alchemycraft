package net.alchemycraft.config;

import net.alchemycraft.client.handledscreens.HandledScreensConfig;
import net.alchemycraft.client.render.block.entity.BlocksEntityRenderConfig;
import net.alchemycraft.client.render.item.ItemsRenderConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ClientConfig {
    private final HandledScreensConfig handledScreensConfig;
    private final BlocksEntityRenderConfig blocksEntityRenderConfig;
    private final ItemsRenderConfig itemsRenderConfig;


    public void init() {
        handledScreensConfig.init();
        blocksEntityRenderConfig.init();
        itemsRenderConfig.init();
    }

    public ClientConfig() {
        handledScreensConfig = new HandledScreensConfig();
        blocksEntityRenderConfig = new BlocksEntityRenderConfig();
        itemsRenderConfig = new ItemsRenderConfig();
    }
}
