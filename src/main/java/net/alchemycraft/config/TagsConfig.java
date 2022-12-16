package net.alchemycraft.config;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class TagsConfig {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(Config.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PESTLES = createCommonTag("pestles");
        public static final TagKey<Item> GRINDABLE = createCommonTag("grindable");
        public static final TagKey<Item> POWDERS = createCommonTag("powders");
        public static final TagKey<Item> POWDER_STORAGES = createCommonTag("powder_storages");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier(Config.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }

    public static void init() {
	}
}
