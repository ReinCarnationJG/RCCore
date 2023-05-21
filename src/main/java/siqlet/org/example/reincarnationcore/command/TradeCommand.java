package siqlet.org.example.reincarnationcore.command;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import siqlet.org.example.reincarnationcore.util.PlayerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TradeCommand implements CommandExecutor {

    private final Map<Player, Player> tradeRequests = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        /*

        player: コマンド送信者
        targetPlayer: args[0]で指定されているPlayer
        tradeRequests: trade申請が送られているか確認するHashMap

        */

        if (!(sender instanceof Player player)) return true;

        String arg = args[0];
        String prefix = "§d[§eRCCore§d] §f";

        if (arg.equalsIgnoreCase("accept")) {

            if ( !tradeRequests.containsKey(player) ) {
                player.sendMessage(prefix + "届いている申請がありません。");
                return true;
            }

            Player target = tradeRequests.remove(player);
            target.sendMessage(prefix + "tradeが承認されました");

        } else {

            if (!PlayerUtil.checkPlayer(arg)) {
                player.sendMessage(prefix + "指定されたプレイヤーは存在しません");
            }

            Player targetPlayer = Bukkit.getServer().getPlayer(arg);
            String messageText = prefix + "§nトレードの申請が届きました！§7クリックして承認する";

            tradeRequests.put(targetPlayer, player);

            BaseComponent[] message = new ComponentBuilder(messageText)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/trade accept"))
                    .create();

            Objects.requireNonNull(targetPlayer).spigot().sendMessage(message);

            return true;
        }
        return true;
    }
}
