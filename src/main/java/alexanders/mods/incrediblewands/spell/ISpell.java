package alexanders.mods.incrediblewands.spell;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

public interface ISpell extends INBTSerializable<NBTTagCompound>
{
    String getName();

    int getCostPerTick();

    boolean cast(SpellContext spellContext);

    boolean update(SpellContext spellContext);

    @SuppressWarnings ("MethodDoesntCallSuperMethod")
    default ISpell clone() throws CloneNotSupportedException
    {
        try
        {
            return this.getClass().<ISpell>newInstance();
        } catch (InstantiationException | IllegalAccessException e)
        {
            CloneNotSupportedException cnse = new CloneNotSupportedException("Failed to clone spell!");
            cnse.initCause(e);
            throw cnse;
        }
    }

}
