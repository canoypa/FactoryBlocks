package factoryblocks.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(FactoryBlocks.MODID)
public class FactoryBlocksItems {

  public static final void registerItems(IForgeRegistry<Item> registry) {
    final Item[] items = {};

    registry.registerAll(items);
  }

  public static final void registerItemBlocks(IForgeRegistry<Item> registry) {
    final Item[] blockItems = {
        new ItemBlock(FactoryBlocksBlocks.catwalks).setRegistryName(FactoryBlocksBlocks.catwalks.getRegistryName()),
        new ItemBlock(FactoryBlocksBlocks.catwalksStairs)
            .setRegistryName(FactoryBlocksBlocks.catwalksStairs.getRegistryName()) };

    registry.registerAll(blockItems);
  }

  private static final Item init(Item item, String registryName, CreativeTabs tab) {
    return item.setRegistryName(FactoryBlocks.MODID, registryName)
        .setTranslationKey(FactoryBlocks.MODID + "." + registryName).setCreativeTab(tab);
  }

}
