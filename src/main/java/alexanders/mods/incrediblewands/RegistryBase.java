package alexanders.mods.incrediblewands;

import java.util.HashMap;

public abstract class RegistryBase<T>
{
    protected final HashMap<String, T> registry;
    protected final String name;

    protected boolean hasRegistered;

    protected RegistryBase(String name)
    {
        this.name = name;
        this.registry = new HashMap<>();
    }

    protected void addAll(HashMap<String, T> base)
    {
        registry.putAll(base);
        if (hasRegistered)
            base.forEach(this::register);
    }

    protected void add(String name, T registrant)
    {
        registry.put(name, registrant);
        if (hasRegistered)
            register(name, registrant);
    }

    public void register()
    {
        this.hasRegistered = true;
        registerInternal();
    }

    protected void registerInternal()
    {
        IncredibleWands.instance.logger.debug("Registry " + name + " is using standard registry methods");
        registry.forEach(this::register);
    }

    private void register(String name, T registrant)
    {
        IncredibleWands.instance.logger.debug("Registry " + name + " is registering: " + registrant.toString());
        registerInternal(name, registrant);
    }

    protected abstract void registerInternal(String name, T registrant);

    public T get(String name)
    {
        return registry.get(name);
    }
}
