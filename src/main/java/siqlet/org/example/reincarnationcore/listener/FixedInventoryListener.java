package siqlet.org.example.reincarnationcore.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import siqlet.org.example.reincarnationcore.ReinCarnationCore;
import siqlet.org.example.reincarnationcore.config.SabaminFile;

public class FixedInventoryListener implements Listener {

    private static void Barrier(Player p) {

        if (SabaminFile.isEnabled(p.getUniqueId())) {

            ItemStack barrierStack = new ItemStack(Material.BARRIER);
            ItemMeta barrierMeta = barrierStack.getItemMeta();
            NamespacedKey nbtKey = new NamespacedKey(ReinCarnationCore.inst(), "FixedBarrier");

            barrierMeta.setDisplayName("§f");
            barrierMeta.getPersistentDataContainer().set(nbtKey, PersistentDataType.STRING, "1");

            barrierStack.setItemMeta(barrierMeta);

            p.getInventory().setItem(7, barrierStack);
            p.getInventory().setItem(8, barrierStack);
            p.getInventory().setItem(9, barrierStack);

        }
    }

    public static void Fixed() {
        Bukkit.getOnlinePlayers().forEach(FixedInventoryListener::Barrier);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Inventory inv = e.getInventory();
        int slot = e.getRawSlot();

        if ( inv.getHolder() == null && slot >= 7 && slot <= 9 ) {
            e.setCancelled(true);
        }

    }

}
