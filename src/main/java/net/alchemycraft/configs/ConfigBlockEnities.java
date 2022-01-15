package net.alchemycraft.configs;

import static net.alchemycraft.configs.Config.MOD_ID;

import net.alchemycraft.enities.EntityMortar;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ConfigBlockEnities {
    public static final BlockEntityType<EntityMortar> GRANITE_MORTAR_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "granite_mortar"),
            FabricBlockEntityTypeBuilder.create(EntityMortar::new, ConfigBlocks.GRANITE_MORTAR).build(null));

    public static final BlockEntityType<EntityMortar> ANDESITE_MORTAR_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "andesite_mortar"),
            FabricBlockEntityTypeBuilder.create(EntityMortar::new, ConfigBlocks.ANDESITE_MORTAR).build(null));

    public static final BlockEntityType<EntityMortar> DIORITE_MORTAR_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "diorite_mortar"),
            FabricBlockEntityTypeBuilder.create(EntityMortar::new, ConfigBlocks.DIORITE_MORTAR).build(null));
            
    public static void init() { 
    }
}