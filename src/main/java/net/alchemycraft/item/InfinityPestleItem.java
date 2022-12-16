package net.alchemycraft.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class InfinityPestleItem extends PestleItem {
    public InfinityPestleItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.alchemycraft.tooltip.only_for_creative").formatted(Formatting.DARK_PURPLE));
    }
}
