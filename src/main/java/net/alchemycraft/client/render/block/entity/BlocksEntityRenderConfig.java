package net.alchemycraft.client.render.block.entity;

import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.alchemycraft.config.BlockEntityTypesConfig;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class BlocksEntityRenderConfig {
    public void init() {
        BlockEntityRendererRegistry.register(BlockEntityTypesConfig.DISAPPEARING_CHEST,
                DisappearingChestBlockEntityRenderer::new);
    }

    public BlocksEntityRenderConfig() {
    }
}
