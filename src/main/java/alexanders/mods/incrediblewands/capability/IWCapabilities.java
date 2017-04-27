package alexanders.mods.incrediblewands.capability;

import alexanders.mods.incrediblewands.RegistryBase;
import alexanders.mods.incrediblewands.util.Triple;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;

import java.util.concurrent.Callable;

public class IWCapabilities extends RegistryBase<Triple<Class, Capability.IStorage, Callable>>
{
    public IWCapabilities()
    {
        super("IWCapabilities");
        add("spell_storage", new Triple<>(ISpellStorageCapability.class, new SpellStorageCapabilityStorage(), new SpellStorageCapabilityFactory()));
    }

    @SuppressWarnings ("unchecked")
    @Override
    protected void registerInternal(String name, Triple<Class, Capability.IStorage, Callable> registrant)
    {
        CapabilityManager.INSTANCE.register(registrant.l, registrant.m, registrant.r);
    }
}
