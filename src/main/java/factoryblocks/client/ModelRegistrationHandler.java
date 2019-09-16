
package factoryblocks.client;

import factoryblocks.common.FactoryBlocksBlocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ModelRegistrationHandler {

  private static final void registerModel(Item item, int meta) {
    ModelLoader.setCustomModelResourceLocation(item, meta,
        new ModelResourceLocation(item.getRegistryName(), "inventory"));
  }

  public static final void registerBlockModels() {
    registerModel(Item.getItemFromBlock(FactoryBlocksBlocks.catwalks), 0);
  }

  public static final void registerItemModels() {
  }

}
