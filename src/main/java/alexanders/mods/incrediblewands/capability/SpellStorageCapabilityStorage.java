package alexanders.mods.incrediblewands.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

import javax.annotation.Nullable;

public class SpellStorageCapabilityStorage implements Capability.IStorage<ISpellStorageCapability>
{
    @CapabilityInject (ISpellStorageCapability.class)
    public static Capability<ISpellStorageCapability> SPELL_STORAGE = null;

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ISpellStorageCapability> capability, ISpellStorageCapability instance, EnumFacing side)
    {
        return new SpellStorageCapabilityProvider(instance).serializeNBT();
    }

    @Override
    public void readNBT(Capability<ISpellStorageCapability> capability, ISpellStorageCapability instance, EnumFacing side, NBTBase nbt)
    {
        new SpellStorageCapabilityProvider(instance).deserializeNBT((NBTTagList) nbt);
    }
}
