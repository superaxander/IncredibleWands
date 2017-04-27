package alexanders.mods.incrediblewands.capability;

import java.util.concurrent.Callable;

public class SpellStorageCapabilityFactory implements Callable<ISpellStorageCapability>
{
    @Override
    public ISpellStorageCapability call() throws Exception
    {
        return new SpellStorage();
    }
}
