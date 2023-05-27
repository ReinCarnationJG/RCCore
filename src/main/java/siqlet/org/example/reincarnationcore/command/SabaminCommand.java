package siqlet.org.example.reincarnationcore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import siqlet.org.example.reincarnationcore.ReinCarnationCore;
import siqlet.org.example.reincarnationcore.config.ConfigFile;

import java.io.File;


public class SabaminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if ( !(sender instanceof Player player) ) return true;

        String prefix = "§d[§eRCCore§d] §f";
        File sabamin = new File("plugins/ReinCarnationCore", "sabamin.yml");
        YamlConfiguration sabaminYml = YamlConfiguration.loadConfiguration(sabamin);

        ConfigFile.load(ReinCarnationCore.inst(), "sabamin.yml");

        if ( sabaminYml.getBoolean("players." + player.getUniqueId(), true) ) {
            player.sendMessage(prefix + "鯖民モードを有効化");
            sabaminYml.set("players." + player.getUniqueId(), true);
            ConfigFile.save(ReinCarnationCore.inst(), "sabamin.yml");
        } else {
            player.sendMessage(prefix + "鯖民モードを無効化");
            sabaminYml.set("players." + player.getUniqueId(), false);
            ConfigFile.save(ReinCarnationCore.inst(), "sabamin.yml");
        }

        return true;
    }
}
