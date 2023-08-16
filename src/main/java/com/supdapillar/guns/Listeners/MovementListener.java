package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GameManager;
import com.supdapillar.guns.GunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {

    private GunPlugin mainPlugin;
    public MovementListener(GunPlugin plugin){
        mainPlugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent event){
        if (mainPlugin.gameManager.getGameState() == GameManager.GameState.PreGame){
            event.setCancelled(true);
        }
    }
}
