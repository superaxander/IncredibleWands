package alexanders.mods.incrediblewands.item;

import alexanders.mods.incrediblewands.Reference;
import alexanders.mods.incrediblewands.RegistryBaseRenderable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IWItems extends RegistryBaseRenderable<Item>
{
    public IWItems()
    {
        super("IWItems");
        add("basic_wand", new ItemWand("basic_wand", 20, 1));
    }

    @Override
    protected void registerInternal(String name, Item registrant)
    {
        GameRegistry.register(registrant);
    }

    @Override
    protected void registerRenderInternal(String name, Item registrant)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(registrant, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + registrant.getUnlocalizedName().substring(5), "inventory"));
    }
}
