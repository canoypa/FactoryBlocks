package factoryblocks.common;

import factoryblocks.blocks.BlockCatwalks;
import factoryblocks.blocks.BlockCatwalksStairs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(FactoryBlocks.MODID)
public class FactoryBlocksBlocks {

  public static final Block catwalks = null;
  public static final Block catwalksStairs = null;

  public static final void registerBlocks(IForgeRegistry<Block> registry) {
    final Block[] blocks = { init(new BlockCatwalks(), "catwalks", FactoryBlocks.creativeTabFactoryBlocks),
        init(new BlockCatwalksStairs(), "catwalksStairs", FactoryBlocks.creativeTabFactoryBlocks) };

    registry.registerAll(blocks);
  }

  private static final Block init(Block block, String registryName, CreativeTabs tab) {
    return block.setRegistryName(FactoryBlocks.MODID, registryName)
        .setTranslationKey(FactoryBlocks.MODID + "." + registryName).setCreativeTab(tab);
  };

}
