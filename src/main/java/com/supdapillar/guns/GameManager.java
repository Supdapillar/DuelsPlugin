package com.supdapillar.guns;

import com.supdapillar.guns.Listeners.PlayerJoinListener;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class GameManager {
    private GunPlugin mainPlugin;
    public Arena currentArena;
    public GameManager(GunPlugin plugin){
        mainPlugin = plugin;
    }
    public enum GameState{
        Lobby, InGame, PreGame
    }
    private GameState gameState = GameState.Lobby;

    public void setGameState(GameState gState) {
        gameState = gState;
        World world = Bukkit.getServer().getWorld("World");
        currentArena = mainPlugin.Arenas.get((int)Math.round(Math.random()*4));
        switch(gState){
            case PreGame:
                mainPlugin.startRunnable.SetTimer(5);
                for(Entity entity : world.getEntities()){
                    if (entity instanceof Item){
                        entity.remove();
                    }
                }
                int interator = 0;

                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    if (interator == 0){
                        player.teleport(currentArena.spawnOne);
                    }
                    else
                    {
                        player.teleport(currentArena.spawnTwo);
                    }
                    player.setHealth(20);
                    interator++;
                    player.getInventory().clear();
                    if (!(mainPlugin.playerClasses.containsKey(player)))
                        mainPlugin.playerClasses.put(player, PlayerClass.returnRandomClass());

                    PlayerClass.givePlayerClassItems(player,mainPlugin.playerClasses.get(player));

                    player.getInventory().remove(Material.RECOVERY_COMPASS);
                }
                world.setPVP(true);
                break;
            case InGame:
                break;

            case Lobby:

                world.setPVP(false);

                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.teleport(new Location(world,-7.5f,-62f,-7.5f));
                    player.getInventory().clear();
                    PlayerJoinListener.GiveCompass(player);
                }
                mainPlugin.startRunnable.SetTimer(10);
                break;
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}
