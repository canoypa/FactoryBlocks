package factoryblocks.common;

import factoryblocks.client.ModelRegistrationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventBusFactoryBlocks {

  @SubscribeEvent
  public void registerBlocks(Register<Block> event) {
    FactoryBlocksBlocks.registerBlocks(event.getRegistry());
  }

  @SubscribeEvent
  public void registerItems(Register<Item> event) {
    FactoryBlocksItems.registerItems(event.getRegistry());
    FactoryBlocksItems.registerItemBlocks(event.getRegistry());
  }

  @SubscribeEvent
  public final void registerModels(ModelRegistryEvent event) {
    ModelRegistrationHandler.registerBlockModels();
    ModelRegistrationHandler.registerItemModels();
  }

}
