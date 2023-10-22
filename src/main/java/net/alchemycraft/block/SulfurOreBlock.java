package net.alchemycraft.block;

import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SulfurOreBlock extends ExperienceDroppingBlock {
    public SulfurOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(2, 5));
    }

    // @Override
    // public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool,
    //         boolean dropExperience) {
    //     super.onStacksDropped(state, world, pos, stack, dropExperience);
    //     if (dropExperience && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0) {
    //         int exp = 2 + world.random.nextInt(3);
    //         this.dropExperience(world, pos, exp);
    //     }
    // }
}
