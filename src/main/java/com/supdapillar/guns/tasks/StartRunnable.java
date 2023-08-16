package com.supdapillar.guns.tasks;

import com.supdapillar.guns.GameManager;
import com.supdapillar.guns.GunPlugin;
import jdk.javadoc.internal.tool.Start;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartRunnable extends BukkitRunnable {

    GunPlugin gunPlugin;

    public StartRunnable(GunPlugin plugin){
        gunPlugin = plugin;
    }
    private int countDown = 10;
    @Override
    public void run()
    {
        if (gunPlugin.gameManager.getGameState() == GameManager.GameState.Lobby){
            if (Bukkit.getServer().getOnlinePlayers().size() > 1){
                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Game will start in: " + ChatColor.GREEN + countDown));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP,9999, 1);
                }
                countDown--;
                if (countDown == 0)
                {
                    gunPlugin.gameManager.setGameState(GameManager.GameState.PreGame);
                }
            }
            else {
                for(Player player : Bukkit.getServer().getOnlinePlayers())
                {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Need 1 more player to start"));
                }
                countDown = 10;
            }
        }
        else if (gunPlugin.gameManager.getGameState() == GameManager.GameState.PreGame) {
            countDown--;
            for(Player player : Bukkit.getServer().getOnlinePlayers()){
                player.sendTitle(ChatColor.WHITE + "" + ChatColor.BOLD + gunPlugin.gameManager.currentArena.arenaName,"Starts in " + ChatColor.GREEN + countDown,0,20,20);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP,9999, 1);
            }
            if (countDown == 0)
            {
                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.sendTitle(ChatColor.WHITE + "" + ChatColor.BOLD + gunPlugin.gameManager.currentArena.arenaName,"Begin!",0,0,20);
                    player.playSound(player.getLocation(), Sound.ENTITY_GUARDIAN_DEATH,9999, 1);
                }
                gunPlugin.gameManager.setGameState(GameManager.GameState.InGame);
            }
        }
    }

    public void SetTimer(int timer){
        countDown = timer;
    }
}
