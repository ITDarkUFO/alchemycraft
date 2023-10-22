package net.alchemycraft.libs.utils;

import static net.alchemycraft.config.Config.MOD_ID;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;

public class AlchemyRegistryList {
    public static Block registerBlock(final String id, final Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, id), block);
    }

    public static Item registerItem(final String id, final Item item) {
        if (item instanceof BlockItem)
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);

        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, id), item);
    }

    public static ToolItem registerItem(final String id, final ToolItem item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, id), item);
    }

    public static <T extends ScreenHandler> ScreenHandlerType<T> registerHandler(final String id,
            final ScreenHandlerType<T> type) {
        return Registry.register(Registry.SCREEN_HANDLER, new Identifier(MOD_ID, id), type);
    }

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityHandler(String id,
            BlockEntityType<T> entityType) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, id), entityType);
    }

    public static RegistryKey<PlacedFeature> registerPlacedFeature(String id) {
        return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MOD_ID, id));
    }
}