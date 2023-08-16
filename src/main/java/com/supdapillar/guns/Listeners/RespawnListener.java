package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GameManager;
import com.supdapillar.guns.GunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RespawnListener implements Listener {

    private GunPlugin mainPlugin;
    public RespawnListener(GunPlugin plugin){
        mainPlugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }



    @EventHandler
    public void OnPlayerRespawn(PlayerRespawnEvent event){
        if (Bukkit.getServer().getOnlinePlayers().size() > 1){
            System.out.println("MORE THAN 1 PLAYER");
            Player alivePlayer = null;
            for (Player player: Bukkit.getServer().getOnlinePlayers()){
                   if (player != event.getPlayer()) alivePlayer = player;
            }
            for (Player player: Bukkit.getServer().getOnlinePlayers()){
                player.sendTitle(ChatColor.GREEN + "" + ChatColor.BOLD + alivePlayer.getDisplayName() + " Wins","",0,2,1);
            }
            mainPlugin.gameManager.setGameState(GameManager.GameState.Lobby);
        }
        else
        {
            System.out.println("MORE THAN 1 PLAYERNTNTNTNTNNTNSADNDSANDSANDSANSSDNDSANSADNDSA");
            Bukkit.broadcastMessage(ChatColor.GREEN + "" + ChatColor.BOLD + event.getPlayer().getName() + " WAS ALL ALONE");
            mainPlugin.gameManager.setGameState(GameManager.GameState.Lobby);
        }


        PlayerJoinListener.GiveCompass(event.getPlayer());

        event.setRespawnLocation(new Location(event.getPlayer().getWorld(),-7.5f,-62f,-7.5f));
    }
}
