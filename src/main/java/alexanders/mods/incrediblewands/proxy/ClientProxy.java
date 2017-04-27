package alexanders.mods.incrediblewands.proxy;

import alexanders.mods.incrediblewands.IncredibleWands;
import alexanders.mods.incrediblewands.render.WandShelfRenderer;
import alexanders.mods.incrediblewands.tile.TileEntityWandShelf;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        IncredibleWands iw = IncredibleWands.instance;
        iw.blockRegistry.registerRender();
        iw.tileEntityRegistry.registerRender();
        iw.itemRegistry.registerRender();
    }

    //<editor-fold desc="ServerProxy">
    @Override
    public void serverAboutToStart(FMLServerAboutToStartEvent event)
    {

    }

    @Override
    public void serverStarting(FMLServerStartingEvent event)
    {

    }

    @Override
    public void serverStarted(FMLServerStartedEvent event)
    {

    }

    @Override
    public void serverStopping(FMLServerStoppingEvent event)
    {

    }

    @Override
    public void serverStopped(FMLServerStoppedEvent event)
    {

    }
    //</editor-fold>
}
