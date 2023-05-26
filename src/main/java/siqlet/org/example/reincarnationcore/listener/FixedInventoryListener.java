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

import java.util.Objects;

public class FixedInventoryListener implements Listener {

    private static void Barrier(Player p) {

        if (SabaminFile.isEnabled(p.getUniqueId())) {

            Inventory inv = p.getInventory();
            ItemStack barrierStack = new ItemStack(Material.BARRIER);
            ItemMeta barrierMeta = barrierStack.getItemMeta();
            NamespacedKey nbtKey = new NamespacedKey(ReinCarnationCore.inst(), "FixedBarrier");

            barrierMeta.setDisplayName("§f");
            barrierMeta.getPersistentDataContainer().set(nbtKey, PersistentDataType.STRING, "1");

            barrierStack.setItemMeta(barrierMeta);

            inv.setItem(5, barrierStack);
            inv.setItem(6, barrierStack);
            inv.setItem(7, barrierStack);
            inv.setItem(8, barrierStack);

        }
    }

    private static void ClearBarrier(Player p) {

        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null && item.getType() == Material.BARRIER) {

                ItemMeta itemMeta = item.getItemMeta();
                NamespacedKey nbtKey = new NamespacedKey(ReinCarnationCore.inst(), "FixedBarrier");
                String nbtValue = itemMeta.getPersistentDataContainer().get(nbtKey, PersistentDataType.STRING);
                Inventory inv = p.getInventory();

                if (nbtValue != null && nbtValue.equals("1")) {

                    if (!Objects.requireNonNull(inv.getItem(5)).equals(item) || !Objects.requireNonNull(inv.getItem(6)).equals(item) ||
                            !Objects.requireNonNull(inv.getItem(7)).equals(item) || !Objects.requireNonNull(inv.getItem(8)).equals(item)) {
                        p.getInventory().remove(item);
                    }

                }
            }

        }
    }

    public static void Fixed() {
        Bukkit.getOnlinePlayers().forEach(FixedInventoryListener::Barrier);
        Bukkit.getOnlinePlayers().forEach(FixedInventoryListener::ClearBarrier);
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
