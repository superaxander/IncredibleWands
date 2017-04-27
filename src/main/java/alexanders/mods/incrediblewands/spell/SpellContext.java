package alexanders.mods.incrediblewands.spell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpellContext
{
    public World world;
    public BlockPos position;
    public EntityPlayer player;
    public ItemStack stack;
    public int power;
    public int remainingEnergy;

    public SpellContext(World world, BlockPos position, EntityPlayer player, ItemStack stack, int power, int remainingEnergy)
    {
        this.world = world;
        this.position = position;
        this.player = player;
        this.stack = stack;
        this.power = power;
        this.remainingEnergy = remainingEnergy;
    }
}
