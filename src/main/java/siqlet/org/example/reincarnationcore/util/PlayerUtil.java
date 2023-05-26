package siqlet.org.example.reincarnationcore.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;

public class PlayerUtil {

    public static boolean checkPlayer(String name) {

        Player target = Bukkit.getServer().getPlayer(name);

        return target != null;

    }

    public static String checkPlayerName(String name) {

        Player target = Bukkit.getServer().getPlayer(name);

        return Objects.requireNonNull(target).getName();

    }

}
