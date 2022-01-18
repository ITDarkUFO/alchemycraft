package net.alchemycraft.configs;

import static net.alchemycraft.configs.Config.MOD_ID;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ConfigItemsGroups {
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "building_blocks"))
            .icon(() -> new ItemStack(ConfigItems.SALT_ORE)).build();

    public static final ItemGroup DECORATIONS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "decorations"))
            .icon(() -> new ItemStack(ConfigBlocks.GRANITE_MORTAR)).build();

    public static final ItemGroup FOOD = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "food"))
            .icon(() -> new ItemStack(ConfigItems.SALTED_COD)).build();

    public static final ItemGroup MISC = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "misc"))
            .icon(() -> new ItemStack(ConfigItems.BRAIN_IN_JAR)).build();

    public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "tools"))
            .icon(() -> new ItemStack(ConfigItems.WOOD_PESTLE)).build();

    public static void init() {
    }
}
