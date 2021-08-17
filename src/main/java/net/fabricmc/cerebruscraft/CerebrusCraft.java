package net.fabricmc.cerebruscraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CerebrusCraft implements ModInitializer
{	
	// Добавляем группу для предметов из мода
	public static final ItemGroup CEREBRUS_ITEMS = FabricItemGroupBuilder.create(
		new Identifier("cerebruscraft", "cerebrus_item_group"))
		.icon(() -> new ItemStack(CerebrusCraft.JAR_BRAIN))
		.build();

	// Добавляем банку с мозгом
	public static final Item JAR_BRAIN = new Item(new Item.Settings().group(CerebrusCraft.CEREBRUS_ITEMS));

	
	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("cerebruscraft", "jar_brain"), JAR_BRAIN);
	}
}
