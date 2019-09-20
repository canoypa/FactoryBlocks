package factoryblocks.blocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

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

  // blockstate
  @Override
  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, new IProperty[] { Facing, Ascending, Descent });
  }

}
