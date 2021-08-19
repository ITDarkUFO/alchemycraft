package net.cerebruscraft.block;

import static net.minecraft.state.property.Properties.FACING;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CerebrusClusterBlock extends Block {
    public CerebrusClusterBlock(Settings settings) {
        super(settings.nonOpaque());
        setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
        BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch (dir) {
            case UP:
                return VoxelShapes.cuboid(0.2f, 0.0f, 0.2f, 0.8f, 0.5f, 0.8f);
            case DOWN:
                return VoxelShapes.cuboid(0.2f, 0.5f, 0.2f, 0.8f, 1.0f, 0.8f);
            case NORTH:
                return VoxelShapes.cuboid(0.2f, 0.2f, 0.5f, 0.8f, 0.8f, 1.0f);
            case SOUTH:
                return VoxelShapes.cuboid(0.2f, 0.2f, 0.0f, 0.8f, 0.8f, 0.5f);
            case EAST:
                return VoxelShapes.cuboid(0.0f, 0.2f, 0.2f, 0.5f, 0.8f, 0.8f);
            case WEST:
                return VoxelShapes.cuboid(0.5f, 0.2f, 0.2f, 1.0f, 0.8f, 0.8f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getSide());
    }
}

// Форма плиты
// case UP:
// return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
// case DOWN:
// return VoxelShapes.cuboid(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
// case NORTH:
// return VoxelShapes.cuboid(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
// case SOUTH:
// return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
// case EAST:
// return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
// case WEST:
// return VoxelShapes.cuboid(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);