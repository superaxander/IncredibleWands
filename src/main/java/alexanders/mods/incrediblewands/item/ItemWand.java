package alexanders.mods.incrediblewands.item;

import alexanders.mods.incrediblewands.IncredibleWands;
import alexanders.mods.incrediblewands.spell.ISpell;
import alexanders.mods.incrediblewands.spell.SpellContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemWand extends Item
{
    private final int maxEnergy;
    private int currentEnergy;
    private int cooldown;
    private int power;
    private ISpell activeSpell;
    private boolean isCasting;

    public ItemWand(String unlocalizedName, int maxEnergy, int power)
    {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setCreativeTab(IncredibleWands.instance.creativeTabItems);
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
        this.power = power;
        this.cooldown = 0;
        this.activeSpell = null;
        this.isCasting = false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (this.cooldown <= 0 && activeSpell != null)
        {
            isCasting = true;
            activeSpell.cast(new SpellContext(worldIn, playerIn.getPosition(), playerIn, stack, power, currentEnergy));
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
        if (isCasting && entityIn instanceof EntityPlayer)
        {
            activeSpell.update(new SpellContext(worldIn, entityIn.getPosition(), (EntityPlayer) entityIn, stack, power, currentEnergy));
        }
        if (this.cooldown > 0)
        {
            this.cooldown--;
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        super.onPlayerStoppedUsing(stack, worldIn, entityLiving, timeLeft);
        isCasting = false;
        this.cooldown = 40;
    }
}
