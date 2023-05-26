package siqlet.org.example.reincarnationcore.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemUtil {

    public static ItemStack redGlass() {
        ItemStack redGlassStack = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta redGlassMeta = redGlassStack.getItemMeta();

        redGlassMeta.setDisplayName("§f");
        redGlassStack.setItemMeta(redGlassMeta);

        return redGlassStack;
    }
    public static ItemStack blackGlass() {
        ItemStack blackGlassStack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta blackGlassMeta = blackGlassStack.getItemMeta();

        blackGlassMeta.setDisplayName("§f");
        blackGlassStack.setItemMeta(blackGlassMeta);

        return blackGlassStack;
    }

    public static ItemStack goldIngot() {
        ItemStack goldIngotStack = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldIngotMeta = goldIngotStack.getItemMeta();

        goldIngotMeta.setDisplayName("§eお金を入れる§8: §f" + "0 (変数入れる)" + "§8円");
        goldIngotStack.setItemMeta(goldIngotMeta);

        return goldIngotStack;
    }
    public static ItemStack yellowGlass() {
        ItemStack yellowGlassStack = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta yellowGlassMeta = yellowGlassStack.getItemMeta();

        yellowGlassMeta.setDisplayName("§f");
        yellowGlassStack.setItemMeta(yellowGlassMeta);

        return yellowGlassStack;
    }
    public static ItemStack greenGlass() {
        ItemStack greenGlassStack = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta greenGlassMeta = greenGlassStack.getItemMeta();

        greenGlassMeta.setDisplayName("§f");
        greenGlassStack.setItemMeta(greenGlassMeta);

        return greenGlassStack;
    }
    public static ItemStack getPlayerHead(Player p) {
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) playerHead.getItemMeta();

        skullMeta.setOwningPlayer(p);
        playerHead.setItemMeta(skullMeta);

        return playerHead;
    }




}
