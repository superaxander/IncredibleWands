package alexanders.mods.incrediblewands.capability;

import alexanders.mods.incrediblewands.spell.ISpell;

import java.util.ArrayList;
import java.util.List;

public interface ISpellStorageCapability
{
    void addSpell(ISpell spell);

    void addSpells(List<ISpell> spells);

    ISpell getSpell(int id);

    ArrayList<ISpell> getSpells();

    boolean hasSpell(String name);

    void removeAll();
}
