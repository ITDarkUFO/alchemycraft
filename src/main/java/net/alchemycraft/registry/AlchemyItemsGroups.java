package net.alchemycraft.registry;

import static net.alchemycraft.AlchemyCraft.MOD_ID;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AlchemyItemsGroups {
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "building_blocks"))
            .icon(() -> new ItemStack(AlchemyItems.SALT_ORE)).build();

    public static final ItemGroup DECORATIONS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "decorations"))
            .icon(() -> new ItemStack(AlchemyBlocks.MORTAR)).build();

    // public static final ItemGroup CRYSTALS = FabricItemGroupBuilder.create(new
    // Identifier(MOD_ID, "crystals"))
    // .icon(() -> new ItemStack(AlchemyItems.SALT_CRYSTAL)).build();

    public static final ItemGroup MISC = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "misc"))
            .icon(() -> new ItemStack(AlchemyItems.BRAIN_IN_JAR)).build();

    public static void init() {
    }
}
