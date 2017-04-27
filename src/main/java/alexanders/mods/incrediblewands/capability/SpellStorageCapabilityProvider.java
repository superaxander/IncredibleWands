package alexanders.mods.incrediblewands.capability;

import alexanders.mods.incrediblewands.IncredibleWands;
import alexanders.mods.incrediblewands.spell.ISpell;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class SpellStorageCapabilityProvider implements ICapabilitySerializable<NBTTagList>
{
    private ISpellStorageCapability spellStorage;

    public SpellStorageCapabilityProvider(ISpellStorageCapability spellStorage)
    {
        this.spellStorage = spellStorage;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == SpellStorageCapabilityStorage.SPELL_STORAGE;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        //noinspection unchecked
        return capability == SpellStorageCapabilityStorage.SPELL_STORAGE ? (T) spellStorage : null;
    }

    @Override
    public NBTTagList serializeNBT()
    {
        NBTTagList tagList = new NBTTagList();
        ArrayList<ISpell> spells = this.spellStorage.getSpells();
        for (int i = 0, spellsSize = spells.size(); i < spellsSize; i++)
        {
            ISpell spell = spells.get(i);
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("type", spell.getName());
            compound.setTag("data", spell.serializeNBT());
            tagList.set(i, compound);
        }
        return tagList;
    }

    @Override
    public void deserializeNBT(NBTTagList nbt)
    {
        this.spellStorage.removeAll();
        for (int i = nbt.tagCount() - 1; i >= 0; i--)
        {
            NBTTagCompound tagCompound = (NBTTagCompound) nbt.get(i);
            try
            {
                ISpell spell = IncredibleWands.instance.spellRegistry.get(tagCompound.getString("type")).clone();
                spell.deserializeNBT(tagCompound.getCompoundTag("data"));
                this.spellStorage.addSpell(spell);
            } catch (CloneNotSupportedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
