package net.albhon.starbound.block.custom;

import net.albhon.starbound.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Random;

import static java.lang.Boolean.TRUE;

public class CellHelixBlock extends BushBlock implements BonemealableBlock, net.minecraftforge.common.IForgeShearable, SimpleWaterloggedBlock {
    protected static final float AABB_OFFSET = 4.0F;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 12.0D, 8.0D, 12.0D);

    public CellHelixBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(BlockTags.DIRT) || pState.is(ModBlocks.FLESH_BLOCK.get());
    }

    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    public boolean isBonemealSuccess(Level pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, Random pRandom, BlockPos pPos, BlockState pState) {
        BlockState blockstate = ModBlocks.TALL_CELL_HELIX.get().defaultBlockState();
        BlockState blockstate1 = blockstate.setValue(TallCellHelixBlock.HALF, DoubleBlockHalf.UPPER);
        BlockPos blockPos = pPos.above();
        if (pLevel.getBlockState(blockPos).is(Blocks.AIR)) {
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.setBlock(blockPos, blockstate1, 2);
        }
        if (pLevel.getBlockState(blockPos).is(Blocks.WATER)) {
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.setBlock(blockPos, blockstate1, 2);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XYZ;
    }
}
