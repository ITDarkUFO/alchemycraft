package net.alchemycraft.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.alchemycraft.screen.alchemynomicon.AlchemynomiconScreen;

public class AlchemynomiconItem extends Item {
    public AlchemynomiconItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (world.isClient)
            MinecraftClient.getInstance().setScreenAndRender(new AlchemynomiconScreen(stack));

        return TypedActionResult.success(stack);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }
}
