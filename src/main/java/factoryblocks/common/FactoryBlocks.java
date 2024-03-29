package factoryblocks.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FactoryBlocks.MODID, name = FactoryBlocks.MODNAME, version = FactoryBlocks.MODVERSION, acceptedMinecraftVersions = FactoryBlocks.MCVERSION)
@EventBusSubscriber()
public class FactoryBlocks {

  public static final String MODID = "factoryblocks";
  public static final String MODNAME = "Factory Blocks";
  public static final String MODVERSION = "0.0.1";
  public static final String MCVERSION = "[1.12.2]";

  public static final Logger logger = LogManager.getLogger(MODNAME);

  public static final CreativeTabs creativeTabFactoryBlocks = new CreativeTabFactoryBlocks();

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(new EventBusFactoryBlocks());

    if (event.getSide().isClient()) {
      OBJLoader.INSTANCE.addDomain(MODID); // モデルのあるドメインを登録
    }
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
  }

}
