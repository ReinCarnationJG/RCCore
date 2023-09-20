package siqlet.org.example.reincarnationcore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import siqlet.org.example.reincarnationcore.ReinCarnationCore;
import siqlet.org.example.reincarnationcore.config.ConfigFile;

public class GachaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if ( !(sender instanceof Player player) ) return true;

        String prefix = "§d[§eRCCore§d] §f";
        YamlConfiguration gachaYml = ConfigFile.load(ReinCarnationCore.inst(), "gacha.yml");

        String title = gachaYml.getString("gacha.title.", "gacha_title");
        String lore = gachaYml.getString("gacha.title.lore.", "gacha_lore");
        String prob = gachaYml.getString("gacha.title.prob.", "gacha_prob");




        return true;
    }
}
