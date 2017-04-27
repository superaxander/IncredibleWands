package alexanders.mods.incrediblewands;

import java.util.HashMap;

public abstract class RegistryBaseRenderable<T> extends RegistryBase<T>
{
    private boolean hasRegisteredRender;

    protected RegistryBaseRenderable(String name)
    {
        super(name);
        this.hasRegistered = this.hasRegisteredRender = false;
    }

    protected void addAll(HashMap<String, T> base)
    {
        super.addAll(base);
        if (hasRegisteredRender)
        {
            base.forEach((name, registrant) ->
                         {
                             if (hasRegisteredRender)
                             {
                                 registerRender(name, registrant);
                             }
                         });
        }
    }

    protected void add(String name, T registrant)
    {
        super.add(name, registrant);
        if (hasRegisteredRender)
        {
            registerRender(name, registrant);
        }
    }

    public void registerRender()
    {
        this.hasRegisteredRender = true;
        registerRenderInternal();
    }

    private void registerRender(String name, T registrant)
    {
        IncredibleWands.instance.logger.debug("Registry " + name + " is registering render: " + registrant.toString());
        registerRenderInternal(name, registrant);
    }

    protected void registerRenderInternal()
    {
        IncredibleWands.instance.logger.debug("Registry " + name + " is using standard render registry methods");
        registry.forEach(this::registerRender);
    }

    protected abstract void registerRenderInternal(String name, T registrant);
}
