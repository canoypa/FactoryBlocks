package factoryblocks.blocks;

import factoryblocks.blocks.tile.TileCatwalks;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockCatwalks extends BlockContainer {

  public BlockCatwalks() {
    super(Material.IRON);

    setSoundType(SoundType.STONE);
  }

  @Override
  public TileEntity createNewTileEntity(World world, int meta) {
    return new TileCatwalks();
  }

  @Override
  public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
  }

}
