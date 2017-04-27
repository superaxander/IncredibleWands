package alexanders.mods.incrediblewands.tile;

import alexanders.mods.incrediblewands.RegistryBaseRenderable;
import alexanders.mods.incrediblewands.render.WandShelfRenderer;
import javafx.util.Pair;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IWTileEntities extends RegistryBaseRenderable<Pair<Class<? extends TileEntity>, TileEntitySpecialRenderer>>
{
    public IWTileEntities()
    {
        super("IWTileEntities");
        add("wand_shelf", new Pair<>(TileEntityWandShelf.class, new WandShelfRenderer()));
    }

    @Override
    protected void registerInternal(String name, Pair<Class<? extends TileEntity>, TileEntitySpecialRenderer> registrant)
    {
        GameRegistry.registerTileEntity(registrant.getKey(), name);
    }

    @SuppressWarnings ("unchecked")
    @Override
    protected void registerRenderInternal(String name, Pair<Class<? extends TileEntity>, TileEntitySpecialRenderer> registrant)
    {
        TileEntitySpecialRenderer renderer = registrant.getValue();
        if (renderer != null)
        {
            ClientRegistry.bindTileEntitySpecialRenderer(registrant.getKey(), renderer);
        }
    }
}
