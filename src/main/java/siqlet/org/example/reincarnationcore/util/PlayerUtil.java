package siqlet.org.example.reincarnationcore.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtil {

    public static boolean checkPlayer(String name) {

        Player target = Bukkit.getServer().getPlayer(name); // プレイヤーオブジェクトを取得

        return target != null;

    }

}
