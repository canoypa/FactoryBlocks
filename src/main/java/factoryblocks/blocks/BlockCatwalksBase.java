package factoryblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCatwalksBase extends Block {

  public BlockCatwalksBase() {
    super(Material.IRON);

    setSoundType(SoundType.STONE);
  }

  // ブロックが catwalks かどうか
  protected boolean isCatwalks(Block block) {
    return block == this;
  }

  @Override
  public boolean isFullCube(IBlockState state) {
    return false;
  }

  @Override
  public boolean isOpaqueCube(IBlockState state) {
    return false;
  }

  @Override
  public int getMetaFromState(IBlockState state) {
    return 0;
  }

}
