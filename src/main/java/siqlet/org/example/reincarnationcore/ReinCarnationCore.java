package siqlet.org.example.reincarnationcore;

import org.bukkit.plugin.java.JavaPlugin;
import siqlet.org.example.reincarnationcore.command.TradeCommand;
import siqlet.org.example.reincarnationcore.register.Register;

import java.util.Objects;

public final class ReinCarnationCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // if ( ymlが無い ) {
            getLogger().info("ymlが存在しない為生成しました");
        // }

        getLogger().info("Event登録中...");

        getServer().getPluginManager().registerEvents(new Register(), this);

        getLogger().info("Event登録完了");

        getLogger().info("Command登録中");

        Objects.requireNonNull(getServer().getPluginCommand("trade")).setExecutor(new TradeCommand());

        getLogger().info("Command登録完了");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

