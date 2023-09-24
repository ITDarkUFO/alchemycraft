package net.alchemycraft.client.render.item;

import net.alchemycraft.config.BlocksConfig;
import net.alchemycraft.entity.DisappearingChestBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class ItemsRenderConfig {
    private final BuiltinItemRendererRegistry itemRegistry;

    private static final DisappearingChestBlockEntity DISAPPEARING_CHEST_ENTITY = new DisappearingChestBlockEntity(
            BlockPos.ORIGIN,
            BlocksConfig.DISAPPEARING_CHEST.getDefaultState());

    public void init() {
        itemRegistry.register(BlocksConfig.DISAPPEARING_CHEST.asItem(),
                (stack, mode, matrices, vertexConsumers, light, overlay) -> {
                    MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(DISAPPEARING_CHEST_ENTITY,
                            matrices, vertexConsumers, light, overlay);
                });
    }

    public ItemsRenderConfig() {
        itemRegistry = BuiltinItemRendererRegistry.INSTANCE;
    }

    // DisappearingChestBlockEntity renderDisappearingChest = new
    // DisappearingChestBlockEntity(
    // BlockPos.ORIGIN,
    // BlocksConfig.DISAPPEARING_CHEST.getDefaultState());

    // BuiltinItemRendererRegistry.INSTANCE.register(BlocksConfig.DISAPPEARING_CHEST.asItem(),
    // (stack, mode, matrices, vertexConsumers, light, overlay) -> {
    // MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(renderDisappearingChest,
    // matrices, vertexConsumers, light, overlay);
    // });
}