package net.alchemycraft.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.alchemycraft.inventory.alchemybook.AlchemynomiconInventory;
import net.alchemycraft.screen.alchemynomicon.AlchemynomiconHandler;

public class AlchemynomiconItem extends Item {
    public AlchemynomiconItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        NbtCompound nbt = stack.getOrCreateNbt();

        if (!nbt.contains("Pages")) {
            nbt.putInt("Pages", 3);
            stack.setNbt(nbt);
        }

        user.openHandledScreen(createScreenHandlerFactory(stack));
        return TypedActionResult.success(stack);
    }

    private NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack stack) {
        NbtCompound nbt = stack.getNbt();
        String pages = Integer.toString(nbt.getInt("Pages")) + " страниц";

        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
            return new AlchemynomiconHandler(syncId, inventory, new AlchemynomiconInventory(/* stack */));
        }, Text.translatable("item.alchemycraft.alchemynomicon", pages));
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }
}
