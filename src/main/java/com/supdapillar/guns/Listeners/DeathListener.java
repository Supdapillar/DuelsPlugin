package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GameManager;
import com.supdapillar.guns.GunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private GunPlugin mainPlugin;


    public DeathListener(GunPlugin plugin){

    }

   @EventHandler
   public void OnPlayerDeath(PlayerDeathEvent event){
        event.getEntity().getInventory().clear();
   }
}
