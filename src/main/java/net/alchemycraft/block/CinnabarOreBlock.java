package net.alchemycraft.block;

import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class CinnabarOreBlock extends ExperienceDroppingBlock {
    public CinnabarOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(1, 4));
    }

    // @Override
    // public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack,
    //         boolean dropExperience) {
    //     super.onStacksDropped(state, world, pos, stack, dropExperience);
    //     if (dropExperience && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
    //         int exp = 1 + world.random.nextInt(3);
    //         this.dropExperience(world, pos, exp);
    //     }
    // }
}
