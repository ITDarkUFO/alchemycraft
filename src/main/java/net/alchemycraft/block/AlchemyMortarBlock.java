package net.alchemycraft.block;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AlchemyMortarBlock extends Block {
    public AlchemyMortarBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState());
        BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout());
    }

    public final VoxelShape SHAPE = this.generateShape();
    
    private VoxelShape generateShape() {
        List<VoxelShape> blockshape = new ArrayList<>();

        blockshape.add(Block.createCuboidShape(0.312, 0, 0.375, 0.688, 0.062, 0.625)); // LAYER_0_C
        blockshape.add(Block.createCuboidShape(0.375, 0, 0.312, 0.625, 0.062, 0.375)); // LAYER_0_N
        blockshape.add(Block.createCuboidShape(0.375, 0, 0.625, 0.625, 0.062, 0.688)); // LAYER_0_S
        blockshape.add(Block.createCuboidShape(0.375, 0.062, 0.688, 0.625, 0.375, 0.75)); // LAYER_12_S
        blockshape.add(Block.createCuboidShape(0.375, 0.062, 0.25, 0.625, 0.375, 0.312)); // LAYER_12_N
        blockshape.add(Block.createCuboidShape(0.25, 0.062, 0.375, 0.312, 0.375, 0.625)); // LAYER_12_W
        blockshape.add(Block.createCuboidShape(0.688, 0.062, 0.375, 0.75, 0.375, 0.625)); // LAYER_12_E
        blockshape.add(Block.createCuboidShape(0.312, 0.062, 0.625, 0.375, 0.375, 0.688)); // LAYER_12_SW
        blockshape.add(Block.createCuboidShape(0.312, 0.062, 0.312, 0.375, 0.375, 0.375)); // LAYER_12_NW
        blockshape.add(Block.createCuboidShape(0.625, 0.062, 0.312, 0.688, 0.375, 0.375)); // LAYER_12_NE
        blockshape.add(Block.createCuboidShape(0.625, 0.062, 0.625, 0.688, 0.375, 0.688)); // LAYER_12_SE
        blockshape.add(Block.createCuboidShape(0.312, 0.125, 0.25, 0.375, 0.375, 0.312)); // LAYER_2_NNW
        blockshape.add(Block.createCuboidShape(0.25, 0.125, 0.312, 0.312, 0.375, 0.375)); // LAYER_2_NWW
        blockshape.add(Block.createCuboidShape(0.625, 0.125, 0.25, 0.688, 0.375, 0.312)); // LAYER_2_NNE
        blockshape.add(Block.createCuboidShape(0.688, 0.125, 0.312, 0.75, 0.375, 0.375)); // LAYER_2_NEE
        blockshape.add(Block.createCuboidShape(0.688, 0.125, 0.625, 0.75, 0.375, 0.688)); // LAYER_2_SEE
        blockshape.add(Block.createCuboidShape(0.625, 0.125, 0.688, 0.688, 0.375, 0.75)); // LAYER_2_SSE
        blockshape.add(Block.createCuboidShape(0.312, 0.125, 0.688, 0.375, 0.375, 0.75)); // LAYER_2_SSW
        blockshape.add(Block.createCuboidShape(0.25, 0.125, 0.625, 0.312, 0.375, 0.688)); // LAYER_2_SWW

        VoxelShape result = VoxelShapes.empty();

        for (VoxelShape shape : blockshape) {
            VoxelShapes.combine(result, shape, BooleanBiFunction.OR);
        }

        return result.simplify();
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return SHAPE;
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

