package siqlet.org.example.reincarnationcore.mechanic;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.ITargetedEntitySkill;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.SkillResult;
import io.lumine.mythic.bukkit.BukkitAdapter;
import org.bukkit.entity.Player;

public class RemoveBossBarMechanic implements ITargetedEntitySkill {

    protected final String id;

    public RemoveBossBarMechanic(MythicLineConfig config) {

        this.id = config.getString(new String[]{"id", "i"}, "def");

    }

    @Override
    public SkillResult castAtEntity(SkillMetadata skillMetadata, AbstractEntity target) {
        Player bukkitTarget = (Player) BukkitAdapter.adapt(target);

        BossBarMechanic.bars.get(id).removePlayer(bukkitTarget);

        return SkillResult.SUCCESS;
    }
}
