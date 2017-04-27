package alexanders.mods.incrediblewands.capability;

import alexanders.mods.incrediblewands.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerCapabilityHandler
{
    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        Entity entity = event.getObject();
        if (entity instanceof EntityPlayer)
        {
            event.addCapability(new ResourceLocation(Reference.MOD_ID, "spell_storage"), new SpellStorageCapabilityProvider(new SpellStorage()));
        }
    }

    @SubscribeEvent
    public void playerCloneEvent(PlayerEvent.Clone event)
    {
        if (event.getOriginal().hasCapability(SpellStorageCapabilityStorage.SPELL_STORAGE, null))
            //noinspection ConstantConditions
            event.getEntityPlayer().getCapability(SpellStorageCapabilityStorage.SPELL_STORAGE, null).addSpells(event.getOriginal().getCapability(SpellStorageCapabilityStorage.SPELL_STORAGE, null).getSpells());
    }
}
