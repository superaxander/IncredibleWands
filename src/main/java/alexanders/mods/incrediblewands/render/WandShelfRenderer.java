package alexanders.mods.incrediblewands.render;

import alexanders.mods.incrediblewands.tile.TileEntityWandShelf;
import javafx.geometry.Point3D;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

public class WandShelfRenderer extends TileEntitySpecialRenderer<TileEntityWandShelf>
{
    private static HashMap<Point3D, ItemStack> wands = new HashMap<>();

    static
    {
        wands.put(new Point3D(0, 1f, 0), new ItemStack(Items.STICK, 1));
    }

    //TODO: insert wands into shelf!

    @Override
    public void renderTileEntityAt(TileEntityWandShelf te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        wands.forEach((p, stack) ->
                      {
                          EntityItem entItem = new EntityItem(Minecraft.getMinecraft().world, 0, 0, 0, stack);
                          GL11.glPushMatrix();
                          entItem.hoverStart = 0;
                          entItem.setGlowing(true);
                          GL11.glTranslatef((float) x + 0.5f, (float) y + 1.0f, (float) z + 0.3f);
                          GL11.glRotatef(te.rotation, 0, 1, 0);
                          Minecraft.getMinecraft().getRenderManager().doRenderEntity(entItem, p.getX(), p.getY() - 1.5f, p.getZ(), 0, 0, false);
                          GL11.glPopMatrix();
                      });
    }
}
