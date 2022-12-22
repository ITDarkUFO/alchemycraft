package net.alchemycraft.block;

import net.alchemycraft.screen.mortar.MortarHandler;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MortarBlock extends Block {
    public String name;

    public MortarBlock(Settings settings, String name) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState());
        BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout());
        this.name = name;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.success(world.isClient());
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            // player.incrementStat(Stats.INTERACT_WITH_MORTAR);
            return ActionResult.CONSUME_PARTIAL;
        }
    }

    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (syncId, inventory, player) -> new MortarHandler(syncId, inventory,
                        ScreenHandlerContext.create(world, pos)),
                Text.translatable(name));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.2, 0.0, 0.2, 0.8, 0.38, 0.8);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        return VoxelShapes.cuboid(0.2, 0.0, 0.2, 0.8, 0.38, 0.8);
    }
}
