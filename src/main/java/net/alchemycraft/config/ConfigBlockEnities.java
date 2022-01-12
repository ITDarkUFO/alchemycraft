package net.alchemycraft.config;

import static net.alchemycraft.AlchemyCraft.MOD_ID;

import net.alchemycraft.blocks.mortar.entity.AlchemyMortarEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ConfigBlockEnities {
    public static final BlockEntityType<AlchemyMortarEntity> MORTAR_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "mortar"),
            FabricBlockEntityTypeBuilder.create(AlchemyMortarEntity::new, ConfigBlocks.GRANITE_MORTAR).build(null));

    public static void init() {
    }
}