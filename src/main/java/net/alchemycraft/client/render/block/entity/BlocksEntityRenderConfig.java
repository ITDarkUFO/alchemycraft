package net.alchemycraft.client.render.block.entity;

import net.alchemycraft.config.BlockEntityTypesConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class BlocksEntityRenderConfig {
    public void init() {
        BlockEntityRendererFactories.register(BlockEntityTypesConfig.DISAPPEARING_CHEST,
                DisappearingChestBlockEntityRenderer::new);
    }

    public BlocksEntityRenderConfig() {
    }
}
