package net.alchemycraft.blocks;

import net.minecraft.block.Block;

public class BlockLead extends Block {
    public BlockLead(Settings settings) {
        super(settings);
    }

    // @Override
    // public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    //     entity.sendMessage(Text.literal("stepped"));
    //     entity.damage(DamageSource.HOT_FLOOR, 1.0F);
    // }
    
    // @Override
    // public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
    //         BlockHitResult hit) {
    //     player.unlockRecipes();
    // }
}
