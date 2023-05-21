package siqlet.org.example.reincarnationcore.register;

import io.lumine.mythic.bukkit.events.MythicConditionLoadEvent;
import io.lumine.mythic.bukkit.events.MythicMechanicLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import siqlet.org.example.reincarnationcore.condition.RealTimeCondition;
import siqlet.org.example.reincarnationcore.mechanic.BossBarMechanic;
import siqlet.org.example.reincarnationcore.mechanic.ModifyBossBarMechanic;
import siqlet.org.example.reincarnationcore.mechanic.ParticleVerticalRingMechanic;
import siqlet.org.example.reincarnationcore.mechanic.RemoveBossBarMechanic;

public class Register implements Listener {

    @EventHandler
    public void onMythicMechanicLoad(MythicMechanicLoadEvent e) {

        String mechanic = e.getMechanicName();

        if ( mechanic.equalsIgnoreCase("particleverticalring") || mechanic.equalsIgnoreCase("pvr") || mechanic.equalsIgnoreCase("pvring") ) {
            e.register(new ParticleVerticalRingMechanic(e.getConfig()));
        }
        if ( mechanic.equalsIgnoreCase("bossbar") ) {
            e.register(new BossBarMechanic(e.getConfig()));
        }
        if ( mechanic.equalsIgnoreCase("removebossbar") || mechanic.equalsIgnoreCase("bossbarremove") ) {
            e.register(new RemoveBossBarMechanic(e.getConfig()));
        }
        if ( mechanic.equalsIgnoreCase("modifybossbar") || mechanic.equalsIgnoreCase("bossbarmodify")) {
            e.register(new ModifyBossBarMechanic(e.getConfig()));
        }
    }

    @EventHandler
    public void onMythicConditionLoad(MythicConditionLoadEvent e) {

        String condition = e.getConditionName();

        if ( condition.equalsIgnoreCase("realtime") ) {
            e.register(new RealTimeCondition(e.getConfig()));
        }

    }

}
