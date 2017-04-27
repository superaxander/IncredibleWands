package alexanders.mods.incrediblewands.block;

import alexanders.mods.incrediblewands.Reference;
import alexanders.mods.incrediblewands.RegistryBaseRenderable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IWBlocks extends RegistryBaseRenderable<Block>
{
    public static BlockWandShelf wand_shelf;

    public IWBlocks()
    {
        super("IWBlocks");
        this.add("wand_shelf", new BlockWandShelf("wand_shelf"));
    }

    @Override
    protected void registerInternal(String name, Block registrant)
    {
        GameRegistry.register(registrant);
        ItemBlock item = new ItemBlock(registrant);
        //noinspection ConstantConditions
        item.setRegistryName(registrant.getRegistryName());
        GameRegistry.register(item);
    }

    @Override
    protected void registerRenderInternal(String name, Block registrant)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ItemBlock.getItemFromBlock(registrant), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + registrant.getUnlocalizedName().substring(5), "inventory"));
    }
}
