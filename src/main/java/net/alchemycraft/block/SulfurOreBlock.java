package net.alchemycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class SulfurOreBlock extends OreBlock {
    private int min_exp = 2;
    private int max_exp = 5;

    public SulfurOreBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack,
            boolean dropExperience) {
        super.onStacksDropped(state, world, pos, stack, dropExperience);
        if (dropExperience) {
            if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                int experience = MathHelper.nextInt(world.random, min_exp, max_exp);
                this.dropExperience(world, pos, experience);
            }
        }
    }
}
