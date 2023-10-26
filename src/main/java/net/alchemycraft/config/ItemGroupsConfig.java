package net.alchemycraft.config;

import static net.alchemycraft.config.Config.MOD_ID;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroupsConfig {
	public static final RegistryKey<ItemGroup> BLOCKS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "building_blocks"));
	public static final RegistryKey<ItemGroup> DECORATIONS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "decorations"));
	public static final RegistryKey<ItemGroup> FOOD = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "food"));
	public static final RegistryKey<ItemGroup> MISC = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "misc"));
	public static final RegistryKey<ItemGroup> TOOLS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "tools"));
	public static final RegistryKey<ItemGroup> COMBAT = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "combat"));

	public static void init() {
		Registry.register(Registries.ITEM_GROUP, BLOCKS, FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemsConfig.SALT_ORE))
		.displayName(Text.translatable(MOD_ID + ".group.building_blocks"))
		.build());

		Registry.register(Registries.ITEM_GROUP, DECORATIONS, FabricItemGroup.builder()
		.icon(() -> new ItemStack(BlocksConfig.GRANITE_MORTAR))
		.displayName(Text.translatable(MOD_ID + ".group.decorations"))
		.build());

		Registry.register(Registries.ITEM_GROUP, FOOD, FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemsConfig.SALTED_COD))
		.displayName(Text.translatable(MOD_ID + ".group.food"))
		.build());

		Registry.register(Registries.ITEM_GROUP, MISC, FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemsConfig.BOWL_OF_SALT))
		.displayName(Text.translatable(MOD_ID + ".group.misc"))
		.build());

		Registry.register(Registries.ITEM_GROUP, TOOLS, FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemsConfig.SILVER_PICKAXE))
		.displayName(Text.translatable(MOD_ID + ".group.tools"))
		.build());

		Registry.register(Registries.ITEM_GROUP, COMBAT, FabricItemGroup.builder()
		.icon(() -> new ItemStack(ItemsConfig.SILVER_CHESTPLATE))
		.displayName(Text.translatable(MOD_ID + ".group.combat"))
		.build());

		registerItemsInGroups();
	}

	private static void registerItemsInGroups()
	{
		ItemGroupEvents.modifyEntriesEvent(BLOCKS).register(entries -> {
			// Ores
			entries.add(ItemsConfig.SALT_ORE);
			entries.add(ItemsConfig.DEEPSLATE_SALT_ORE);
			entries.add(ItemsConfig.CINNABAR_ORE);
			entries.add(ItemsConfig.DEEPSLATE_CINNABAR_ORE);
			entries.add(ItemsConfig.SULFUR_ORE);
			entries.add(ItemsConfig.SILVER_ORE);
			entries.add(ItemsConfig.DEEPSLATE_SILVER_ORE);
			entries.add(ItemsConfig.LEAD_ORE);
			entries.add(ItemsConfig.DEEPSLATE_LEAD_ORE);

			// Raw ore blocks
			entries.add(ItemsConfig.RAW_SILVER_BLOCK);
			entries.add(ItemsConfig.RAW_LEAD_BLOCK);

			// Ore blocks
			entries.add(ItemsConfig.SALT_BLOCK);
			entries.add(ItemsConfig.CINNABAR_BLOCK);
			entries.add(ItemsConfig.SULFUR_BLOCK);
			entries.add(ItemsConfig.SILVER_BLOCK);
			entries.add(ItemsConfig.LEAD_BLOCK);
		});

		ItemGroupEvents.modifyEntriesEvent(DECORATIONS).register(entries -> {
			entries.add(ItemsConfig.GRANITE_MORTAR);
			entries.add(ItemsConfig.DIORITE_MORTAR);
			entries.add(ItemsConfig.ANDESITE_MORTAR);

			entries.add(ItemsConfig.DISAPPEARING_CHEST);
		});

		ItemGroupEvents.modifyEntriesEvent(FOOD).register(entries -> {
			entries.add(ItemsConfig.SALTED_COD);
			entries.add(ItemsConfig.SALTED_SALMON);
		});

		ItemGroupEvents.modifyEntriesEvent(MISC).register(entries -> {
			entries.add(ItemsConfig.SALT_CRYSTAL);
			entries.add(ItemsConfig.CINNABAR_CRYSTAL);
			entries.add(ItemsConfig.SULFUR_CRYSTAL);
			entries.add(ItemsConfig.RAW_SILVER);
			entries.add(ItemsConfig.RAW_LEAD);
			entries.add(ItemsConfig.SILVER_INGOT);
			entries.add(ItemsConfig.LEAD_INGOT);
			entries.add(ItemsConfig.SILVER_NUGGET);
			entries.add(ItemsConfig.LEAD_NUGGET);

			entries.add(ItemsConfig.BOWL_OF_SALT);
			entries.add(ItemsConfig.BOWL_OF_CINNABAR);
			entries.add(ItemsConfig.BOWL_OF_SULFUR);
			
			entries.add(ItemsConfig.ALCHEMYNOMICON);
			entries.add(ItemsConfig.BRAIN_IN_JAR);
		});

		ItemGroupEvents.modifyEntriesEvent(TOOLS).register(entries -> {
			entries.add(ItemsConfig.SILVER_PICKAXE);
			entries.add(ItemsConfig.SILVER_SWORD);
			entries.add(ItemsConfig.SILVER_SHOVEL);
			entries.add(ItemsConfig.SILVER_HOE);
			entries.add(ItemsConfig.SILVER_AXE);
		});

		ItemGroupEvents.modifyEntriesEvent(COMBAT).register(entries -> {
			entries.add(ItemsConfig.SILVER_HELMET);
			entries.add(ItemsConfig.SILVER_CHESTPLATE);
			entries.add(ItemsConfig.SILVER_LEGGINGS);
			entries.add(ItemsConfig.SILVER_BOOTS);
		});
	}
}
