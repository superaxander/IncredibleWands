package alexanders.mods.incrediblewands.proxy;

import alexanders.mods.incrediblewands.IncredibleWands;
import alexanders.mods.incrediblewands.block.IWBlocks;
import alexanders.mods.incrediblewands.capability.IWCapabilities;
import alexanders.mods.incrediblewands.item.IWItems;
import alexanders.mods.incrediblewands.spell.IWSpells;
import alexanders.mods.incrediblewands.tile.IWTileEntities;
import net.minecraftforge.fml.common.event.*;

public abstract class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        IncredibleWands iw = IncredibleWands.instance;
        iw.logger = event.getModLog();
        iw.blockRegistry = new IWBlocks();
        iw.tileEntityRegistry = new IWTileEntities();
        iw.itemRegistry = new IWItems();
        iw.spellRegistry = new IWSpells();
        iw.capabilityRegistry = new IWCapabilities();
        iw.capabilityRegistry.register();
        iw.blockRegistry.register();
        iw.tileEntityRegistry.register();
        iw.itemRegistry.register();
        iw.spellRegistry.register();
    }

    public void init(FMLInitializationEvent event)
    {
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

    public abstract void serverAboutToStart(FMLServerAboutToStartEvent event);

    public abstract void serverStarting(FMLServerStartingEvent event);

    public abstract void serverStarted(FMLServerStartedEvent event);

    public abstract void serverStopping(FMLServerStoppingEvent event);

    public abstract void serverStopped(FMLServerStoppedEvent event);

}
