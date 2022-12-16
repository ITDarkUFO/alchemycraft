package net.alchemycraft.libs.utils;

import static net.alchemycraft.config.Config.MOD_ID;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AlchemyRegistryList {
    
    public static Block registerBlock(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, id), block);
    }

    public static Item registerItem(String id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, id), item);
    }

    public static ToolItem registerItem(String id, ToolItem item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, id), item);
    }

    public static <T extends ScreenHandler> ScreenHandlerType<T> registerHandler(String id, ScreenHandlerType<T> type) {
        return Registry.register(Registry.SCREEN_HANDLER, new Identifier(MOD_ID, id), type);
    }
}