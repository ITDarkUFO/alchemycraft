package net.alchemycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class SulfurOreBlock extends OreBlock {
    private int minExp = 2;
    private int maxExp = 5;

    public SulfurOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack,
            boolean dropExperience) {
        super.onStacksDropped(state, world, pos, stack, dropExperience);
        if (dropExperience && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            int exp = minExp + world.random.nextInt(maxExp);
            this.dropExperience(world, pos, exp);
        }
    }
}
