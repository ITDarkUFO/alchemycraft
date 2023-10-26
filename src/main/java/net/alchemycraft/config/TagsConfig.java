package net.alchemycraft.config;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.tag.TagManagerLoader.RegistryTags;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class TagsConfig {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registries.BLOCK.getKey(), new Identifier(Config.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name) {
            return TagKey.of(Registries.BLOCK.getKey(), new Identifier("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PESTLES = createCommonTag("pestles");
        public static final TagKey<Item> GRINDABLE = createCommonTag("grindable");
        public static final TagKey<Item> POWDERS = createCommonTag("powders");
        public static final TagKey<Item> POWDER_STORAGES = createCommonTag("powder_storages");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(Registries.ITEM.getKey(), new Identifier(Config.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registries.ITEM.getKey(), new Identifier("c", name));
        }
    }

    public static void init() {
	}
}
