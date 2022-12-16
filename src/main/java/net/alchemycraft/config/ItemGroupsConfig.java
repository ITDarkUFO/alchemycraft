package net.alchemycraft.config;

import static net.alchemycraft.config.Config.MOD_ID;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroupsConfig {
	public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "building_blocks"))
			.icon(() -> new ItemStack(ItemsConfig.SALT_ORE)).build();

	public static final ItemGroup DECORATIONS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "decorations"))
			.icon(() -> new ItemStack(BlocksConfig.GRANITE_MORTAR)).build();

	public static final ItemGroup FOOD = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "food"))
			.icon(() -> new ItemStack(ItemsConfig.SALTED_COD)).build();

	public static final ItemGroup MISC = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "misc"))
			.icon(() -> new ItemStack(ItemsConfig.BOWL_OF_SALT)).build();

	public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "tools"))
			.icon(() -> new ItemStack(ItemsConfig.SILVER_PICKAXE)).build();

	public static final ItemGroup COMBAT = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "combat"))
			.icon(() -> new ItemStack(ItemsConfig.SILVER_CHESTPLATE)).build();

	public static void init() {
	}
}
