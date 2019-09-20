package factoryblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCatwalksStairs extends BlockCatwalksBase {

  // ブロックのステータスプロパティ
  private static final PropertyDirection Facing = BlockHorizontal.FACING;
  private static final PropertyBool Ascending = PropertyBool.create("ascending");
  private static final PropertyBool Descent = PropertyBool.create("descent");

  public BlockCatwalksStairs() {
    super();

    final IBlockState defaultState = this.getDefaultState().withProperty(Facing, EnumFacing.NORTH)
        .withProperty(Ascending, false).withProperty(Descent, false);

    this.setDefaultState(defaultState);
  }

  @Override
  public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
    world.setBlockState(pos, state.withProperty(Facing, placer.getHorizontalFacing()));

    super.onBlockPlacedBy(world, pos, state, placer, stack);
  }

  @Override
  public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
    world.setBlockState(pos, this.getActualState(state, world, pos));

    super.onBlockAdded(world, pos, state);
  }

  @Override
  public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
    // Block blockNorth = world.getBlockState(pos.north()).getBlock();

    return state.withProperty(Ascending, false).withProperty(Descent, false);
  }

  // blockstate
  @Override
  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, new IProperty[] { Facing, Ascending, Descent });
  }

}
