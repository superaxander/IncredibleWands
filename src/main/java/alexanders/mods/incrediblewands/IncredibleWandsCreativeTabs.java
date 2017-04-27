package alexanders.mods.incrediblewands;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class IncredibleWandsCreativeTabs extends CreativeTabs
{
    public enum TabType
    {
        BLOCKS, ITEMS, WANDS
    }

    private TabType tabType;

    public IncredibleWandsCreativeTabs(TabType type)
    {
        super("tab_" + type.toString());
        tabType = type;
    }

    @Override
    public ItemStack getTabIconItem()
    {
        switch (this.tabType)
        {
            case BLOCKS:
                return new ItemStack(Blocks.ENCHANTING_TABLE);
            case ITEMS:
                return new ItemStack(Items.ENCHANTED_BOOK);
            case WANDS:
                NBTTagCompound enchantedNbt = new NBTTagCompound();
                NBTTagCompound enchNbt = new NBTTagCompound();
                enchNbt.setString("DUMMY", "DUMMY");
                enchantedNbt.setTag("ench", enchNbt);
                return new ItemStack(Items.STICK, 1, 0, enchantedNbt);
        }
        return null;
    }
}
