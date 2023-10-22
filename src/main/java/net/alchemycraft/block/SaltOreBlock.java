package net.alchemycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class SaltOreBlock extends OreBlock {
    public SaltOreBlock(Settings settings) {
        super(settings);
    }

    @Override
        super.onStacksDropped(state, world, pos, stack, dropExperience);
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        if (dropExperience && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0) {
            int exp = world.random.nextInt(2);
            this.dropExperience(world, pos, exp); 
        }
    }
}
