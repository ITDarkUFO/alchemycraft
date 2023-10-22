package net.alchemycraft.block;

import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class SaltOreBlock extends ExperienceDroppingBlock {
    public SaltOreBlock(Settings settings) {
        super(settings, UniformIntProvider.create(0, 2));
    }

    // @Override
    //     super.onStacksDropped(state, world, pos, stack, dropExperience);
    // public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
    //     if (dropExperience && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0) {
    //         int exp = world.random.nextInt(2);
    //         this.dropExperience(world, pos, exp); 
    //     }
    // }
}
