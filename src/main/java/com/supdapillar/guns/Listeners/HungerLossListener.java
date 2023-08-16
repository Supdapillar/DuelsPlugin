package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerLossListener implements Listener {

    private GunPlugin mainPlugin;
    public HungerLossListener(GunPlugin plugin){
        mainPlugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }


    @EventHandler
    public void OnHungerLoss(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }



}
