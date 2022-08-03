package net.alchemycraft.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class ItemInfinityPestle extends ItemPestle {
    public ItemInfinityPestle(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.alchemycraft.tooltip.only_for_creative").formatted(Formatting.DARK_PURPLE));
    }
}
