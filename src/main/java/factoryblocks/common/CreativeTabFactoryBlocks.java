
package factoryblocks.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CreativeTabFactoryBlocks extends CreativeTabs {

  public CreativeTabFactoryBlocks() {
    super("factoryblocks");
  }

  @Override
  public ItemStack createIcon() {
    return new ItemStack(Item.getItemFromBlock(FactoryBlocksBlocks.catwalks));
  }

}
