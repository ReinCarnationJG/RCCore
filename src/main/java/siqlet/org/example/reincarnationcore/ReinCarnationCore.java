package siqlet.org.example.reincarnationcore;

import io.lumine.mythic.bukkit.utils.random.VariableAmount;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import siqlet.org.example.reincarnationcore.command.SabaminCommand;
import siqlet.org.example.reincarnationcore.command.TradeCommand;
import siqlet.org.example.reincarnationcore.listener.FixedInventoryListener;
import siqlet.org.example.reincarnationcore.register.Register;

import java.util.Objects;

public final class ReinCarnationCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("Event登録中...");

        getServer().getPluginManager().registerEvents(new Register(), this);
        getServer().getPluginManager().registerEvents(new FixedInventoryListener(), this);

        getLogger().info("Event登録完了");
        getLogger().info("Command登録中");

        Objects.requireNonNull(getServer().getPluginCommand("trade")).setExecutor(new TradeCommand());
        Objects.requireNonNull(getServer().getPluginCommand("sabamin")).setExecutor(new SabaminCommand());

        getLogger().info("Command登録完了");

        Bukkit.getScheduler().runTaskTimer(this, FixedInventoryListener::Fixed, 0, 1);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

