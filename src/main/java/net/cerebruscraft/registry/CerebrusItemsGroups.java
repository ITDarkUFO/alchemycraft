package net.cerebruscraft.registry;

import static net.cerebruscraft.CerebrusCraft.MOD_ID;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CerebrusItemsGroups {
    public static final ItemGroup MISC = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "misc"))
            .icon(() -> new ItemStack(CerebrusItems.BRAIN_IN_JAR)).build();

    public static void init() {
    }
}
