package net.alchemycraft.config;

import static net.alchemycraft.libs.utils.AlchemyRegistryList.registerBlockEntityHandler;

import net.alchemycraft.entity.DisappearingChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;

public class BlockEntityTypesConfig {
    public static final BlockEntityType<DisappearingChestBlockEntity> DISAPPEARING_CHEST = registerBlockEntityHandler("disappearing_chest", FabricBlockEntityTypeBuilder.create(DisappearingChestBlockEntity::new, BlocksConfig.DISAPPEARING_CHEST).build());

    private BlockEntityTypesConfig() {
    }

    public static void init() {
    }
}