package siqlet.org.example.reincarnationcore.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import siqlet.org.example.reincarnationcore.command.TradeCommand;

import java.util.Map;

public class TradeGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        Inventory clickInv = e.getClickedInventory();
        int slot = e.getSlot() + 5;

        if ( clickInv == null ) return;

        Map<Player, Inventory> requesterGUI = TradeCommand.requesterGUI;
        Map<Player, Inventory> targetGUI = TradeCommand.targetGUI;

        if ( targetGUI.containsKey(player) ) {
            Inventory requester = requesterGUI.get(player);
            requester.setItem(slot, e.getCurrentItem());
        }
        if ( requesterGUI.containsKey(player) ) {
            Inventory target = targetGUI.get(player);
            target.setItem(slot, e.getCurrentItem());
        }

        e.setCancelled(true);
    }

}
