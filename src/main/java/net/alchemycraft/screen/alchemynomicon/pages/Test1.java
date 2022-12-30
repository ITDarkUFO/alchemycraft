package net.alchemycraft.screen.alchemynomicon.pages;

import net.alchemycraft.screen.AbstractPage;
import net.alchemycraft.screen.alchemynomicon.AlchemynomiconHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class Test1 extends AbstractPage {
    public Test1(AlchemynomiconHandler handler) {
        super(handler, new Identifier("textures/gui/container/dispenser.png"));
    }

    @Override
    public void draw(ScreenHandler handler) {
        super.draw(handler);

        if (handler instanceof AlchemynomiconHandler) {
            AlchemynomiconHandler instance = (AlchemynomiconHandler) handler;

            instance.addSlot(new Slot(instance.getInventory(), 0, 0, 0));

            for (int y = 0; y < 3; ++y)
                for (int x = 0; x < 9; ++x)
                    instance.addSlot(new Slot(instance.getPlayerInventory(), x + y * 9 + 9, 8 + x * 18, 84 + y * 18));

            for (int i = 0; i < 9; ++i)
                instance.addSlot(new Slot(instance.getPlayerInventory(), i, 8 + i * 18, 142));
        }
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        return newStack;
    }
}
