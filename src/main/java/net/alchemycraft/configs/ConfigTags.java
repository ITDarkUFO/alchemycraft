package net.alchemycraft.configs;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ConfigTags {
    public static class Blocks {
        private static Tag<Block> createTag(String name)
        {
            return TagFactory.BLOCK.create(new Identifier(Config.MOD_ID, name));
        }

        private static Tag<Block> createCommonTag(String name)
        {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {
        public static final Tag<Item> PESTLES = createCommonTag("pestles");

        private static Tag<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(Config.MOD_ID, name));
        }

        private static Tag<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
}
