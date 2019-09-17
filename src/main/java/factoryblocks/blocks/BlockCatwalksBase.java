package factoryblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCatwalksBase extends Block {

  public BlockCatwalksBase() {
    super(Material.IRON);

    setSoundType(SoundType.STONE);
  }

}
