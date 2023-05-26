package siqlet.org.example.reincarnationcore.command;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import siqlet.org.example.reincarnationcore.util.ItemUtil;
import siqlet.org.example.reincarnationcore.util.PlayerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TradeCommand implements CommandExecutor {

    private final Map<Player, Player> tradeRequests = new HashMap<>();
    public static Map<Player, Inventory> requesterGUI = new HashMap<>();
    public static Map<Player, Inventory> targetGUI = new HashMap<>();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        /*

        player: コマンド送信者
        targetPlayer: args[0]で指定されているPlayer
        tradeRequests: trade申請が送られているか確認するHashMap

        */

        String prefix = "§d[§eRCCore§d] §f";

        if (!(sender instanceof Player player)) return true;

        if ( args.length == 0 ) {
            player.sendMessage(prefix + "引数を指定してください");
            return true;
        }

        String arg = args[0];

        if (arg.equalsIgnoreCase("accept")) {

            Player requester = tradeRequests.get(player);

            if ( requester == null ) {
                player.sendMessage(prefix + "届いている申請がありません。");
                return true;
            }

            player.sendMessage(prefix + "trade画面に移行します");
            requester.sendMessage(prefix + "tradeが承認されました");

            openTargetGUI(player, requester);
            openRequesterGUI(requester, player);

            tradeRequests.remove(player);

        } else {

            if ( !PlayerUtil.checkPlayer(arg) ) {
                player.sendMessage(prefix + "指定されたプレイヤーは存在しません");
                return true;
            }
            if( PlayerUtil.checkPlayerName(arg).equals(player.getName()) ) {
                player.sendMessage(prefix + "自分にtrade申請を送る事は出来ません。");
//                return true;
            }
            if ( tradeRequests.containsKey(player) ) {
                player.sendMessage(prefix + "申請を受け取っている時は新たに申請を送れません。");
                return true;
            }

            Player targetPlayer = Bukkit.getServer().getPlayer(arg);
            String messageText = prefix + "§c§nトレードの申請が届きました！§7§lクリックして承認する";

            tradeRequests.put(targetPlayer, player);

            BaseComponent[] message = new ComponentBuilder(messageText)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/trade accept"))
                    .create();

            Objects.requireNonNull(targetPlayer).spigot().sendMessage(message);

            player.sendMessage(prefix + "§e" + arg + "§fにtrade申請を送信しました！");

            return true;
        }
        return true;
    }

    public static void openTargetGUI(Player target, Player requester) {

        Inventory gui = Bukkit.createInventory(null, 6 * 9, "Trade GUI");

        setGUI(gui, requester, target);
        targetGUI.put(target, gui);
        target.openInventory(gui);
    }

    public static void openRequesterGUI(Player requester, Player target) {

        Inventory gui = Bukkit.createInventory(null, 6 * 9, "Trade GUI");

        setGUI(gui, requester, target);
        requesterGUI.put(requester, gui);
        requester.openInventory(gui);
    }

    private static void setGUI(Inventory gui, Player requester, Player target) {

        for ( int i = 0; i <= 53; i++ ) {
            if ( i <= 9 || i >= 44 ) {
                gui.setItem(i, ItemUtil.redGlass());
            }
            if ( i == 4 || i == 13 || i == 22 || i == 31 || i == 40 || i == 49 ) {
                gui.setItem(i, ItemUtil.blackGlass());
            }
            if ( requesterGUI.containsKey(requester) ) {
                if (i == 2) {
                    gui.setItem(i, ItemUtil.getPlayerHead(requester));
                }
                if (i == 6) {
                    gui.setItem(i, ItemUtil.getPlayerHead(target));
                }
            } else if ( targetGUI.containsKey(target) ) {
                if (i == 2) {
                    gui.setItem(i, ItemUtil.getPlayerHead(target));
                }
                if (i == 6) {
                    gui.setItem(i, ItemUtil.getPlayerHead(requester));
                }
            }
            if ( i == 47 || i == 51 ) {
                gui.setItem(i, ItemUtil.goldIngot());
            }
            if ( i == 48 || i == 50 ) {
                gui.setItem(i, ItemUtil.yellowGlass());
            }
        }

    }
}
