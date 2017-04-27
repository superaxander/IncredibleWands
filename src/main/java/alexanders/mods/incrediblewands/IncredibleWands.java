package alexanders.mods.incrediblewands;

import alexanders.mods.incrediblewands.block.IWBlocks;
import alexanders.mods.incrediblewands.capability.IWCapabilities;
import alexanders.mods.incrediblewands.item.IWItems;
import alexanders.mods.incrediblewands.proxy.CommonProxy;
import alexanders.mods.incrediblewands.spell.IWSpells;
import alexanders.mods.incrediblewands.tile.IWTileEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

import static alexanders.mods.incrediblewands.Reference.*;

@Mod (modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, acceptedMinecraftVersions = MINECRAFT_VERSION)
public class IncredibleWands
{
    @Mod.Instance
    public static IncredibleWands instance;

    @SidedProxy (modId = MOD_ID, serverSide = SERVER_PROXY, clientSide = CLIENT_PROXY)
    public static CommonProxy proxy;

    public IncredibleWandsCreativeTabs creativeTabBlocks = new IncredibleWandsCreativeTabs(IncredibleWandsCreativeTabs.TabType.BLOCKS);
    public IncredibleWandsCreativeTabs creativeTabItems = new IncredibleWandsCreativeTabs(IncredibleWandsCreativeTabs.TabType.ITEMS);
    public IncredibleWandsCreativeTabs creativeTabWands = new IncredibleWandsCreativeTabs(IncredibleWandsCreativeTabs.TabType.WANDS);

    public IWBlocks blockRegistry;
    public IWTileEntities tileEntityRegistry;
    public IWCapabilities capabilityRegistry;
    public IWItems itemRegistry;

    public IWSpells spellRegistry;

    public Logger logger;

    //<editor-fold desc="Event Handlers">
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    @EventHandler
    public void serverAboutToStart(FMLServerAboutToStartEvent event)
    {
        proxy.serverAboutToStart(event);
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        proxy.serverStarting(event);
    }

    @EventHandler
    public void serverStarted(FMLServerStartedEvent event)
    {
        proxy.serverStarted(event);
    }

    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event)
    {
        proxy.serverStopping(event);
    }

    @EventHandler
    public void serverStopped(FMLServerStoppedEvent event)
    {
        proxy.serverStopped(event);
    }
    //</editor-fold>

}
