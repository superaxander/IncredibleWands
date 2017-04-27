package alexanders.mods.incrediblewands.capability;

import alexanders.mods.incrediblewands.spell.ISpell;
import alexanders.mods.incrediblewands.util.BooleanContainer;

import java.util.ArrayList;
import java.util.List;

public class SpellStorage implements ISpellStorageCapability
{
    private ArrayList<ISpell> spells;

    public SpellStorage()
    {
        this.spells = new ArrayList<>();
    }

    @Override
    public void addSpell(ISpell spell)
    {
        this.spells.add(spell);
    }

    @Override
    public void addSpells(List<ISpell> spells)
    {
        this.spells.addAll(spells);
    }

    @Override
    public ISpell getSpell(int id)
    {
        return this.spells.get(id);
    }

    @Override
    public ArrayList<ISpell> getSpells()
    {
        //noinspection unchecked
        return (ArrayList<ISpell>) this.spells.clone();
    }

    @Override
    public boolean hasSpell(String name)
    {
        BooleanContainer found = new BooleanContainer(false);
        this.spells.forEach((spell) ->
                            {
                                if (spell.getName().equals(name))
                                    found.setBool(true);
                            });
        return found.bool;
    }

    @Override
    public void removeAll()
    {
        this.spells.clear();
    }
}
