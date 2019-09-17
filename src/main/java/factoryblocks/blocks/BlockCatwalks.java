package factoryblocks.blocks;

import factoryblocks.util.AxisAligned;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCatwalks extends BlockCatwalksBase {

  // ホバー時のやつのサイズ
  protected static final AxisAlignedBB BoundingBox = AxisAligned.create(0, 0, 0, 16, 2, 16);

  // 当たり判定のサイズ
  private static final AxisAlignedBB MainHitBox = AxisAligned.create(0, 0, 0, 16, 1, 16);
  private static final AxisAlignedBB NorthHitBox = AxisAligned.create(0, 0, 0, 16, 16, 1);
  private static final AxisAlignedBB EastHitBox = AxisAligned.create(15, 0, 0, 1, 16, 16);
  private static final AxisAlignedBB SouthHitBox = AxisAligned.create(0, 0, 15, 16, 16, 1);
  private static final AxisAlignedBB WestHitBox = AxisAligned.create(0, 0, 0, 1, 16, 16);

  // ブロックのステータスプロパティ
  private static final PropertyBool North = PropertyBool.create("north");
  private static final PropertyBool East = PropertyBool.create("east");
  private static final PropertyBool South = PropertyBool.create("south");
  private static final PropertyBool West = PropertyBool.create("west");

  public BlockCatwalks() {
    super();

    IBlockState defaultState = this.blockState.getBaseState().withProperty(North, false).withProperty(East, false)
        .withProperty(South, false).withProperty(West, false);

    this.setDefaultState(defaultState);
  }

  // ブロック設置時
  @Override
  public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
    world.setBlockState(pos, this.getActualState(state, world, pos));

    super.onBlockAdded(world, pos, state);
  }

  // チャンク読み込み時のブロック処理で呼ばれる？ ブロックの状態を取得するメソッド
  @Override
  public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
    Block blockNorth = world.getBlockState(pos.north()).getBlock();
    Block blockEast = world.getBlockState(pos.east()).getBlock();
    Block blockSouth = world.getBlockState(pos.south()).getBlock();
    Block blockWest = world.getBlockState(pos.west()).getBlock();

    return state.withProperty(North, this.isCatwalks(blockNorth)).withProperty(East, this.isCatwalks(blockEast))
        .withProperty(South, this.isCatwalks(blockSouth)).withProperty(West, this.isCatwalks(blockWest));
  }

  // 当たり判定のやつ
  @Override
  public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
    return MainHitBox;
  }

  // ホバー時のあれのやつ
  @Override
  public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
    return BoundingBox;
  }

  // blockstate
  @Override
  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, new IProperty[] { North, East, West, South });
  }

}
