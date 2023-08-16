package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GunPlugin;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PlayerJoinListener implements Listener {


    public PlayerJoinListener(GunPlugin plugin){
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        GiveCompass(player);
        player.setGameMode(GameMode.ADVENTURE);

        player.teleport(new Location(player.getWorld(),-7.5f,-62f,-7.5f));
    }

    public static void GiveCompass(Player player){
        ItemStack classPicker = new ItemStack(Material.RECOVERY_COMPASS, 1);
        ItemMeta classPickerMeta = classPicker.getItemMeta();
        classPickerMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Class Picker");
        String[] lore = new String[]{
                ChatColor.GREEN + "[Click] " + ChatColor.WHITE + "To open class menu"
        };
        classPickerMeta.setLore(Arrays.asList(lore));
        classPicker.setItemMeta(classPickerMeta);



        if (player.getInventory().contains(Material.RECOVERY_COMPASS)) return;
        player.getInventory().addItem(classPicker);


    }
}
