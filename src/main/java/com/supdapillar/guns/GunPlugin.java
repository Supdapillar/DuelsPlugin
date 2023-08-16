package com.supdapillar.guns;

import com.supdapillar.guns.Listeners.*;
import com.supdapillar.guns.tasks.StartRunnable;
import jdk.javadoc.internal.tool.Start;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class GunPlugin extends JavaPlugin {

    public HashMap<Player, Classes> playerClasses = new HashMap<>();
    List<Arena> Arenas = new ArrayList<Arena>();
    public GameManager gameManager = new GameManager(this);
    public StartRunnable startRunnable = new StartRunnable(this);
    @Override
    public void onEnable() {
        // Plugin startup logic
        Arenas.add(new Arena("Fortress",
                new Location(Bukkit.getWorld("World"),14.5,-61,5.5,0f,0f),
                new Location(Bukkit.getWorld("World"),14.5,-61,43.5,180f,0f))
        );
        Arenas.add(new Arena("Iron Gates",
                new Location(Bukkit.getWorld("World"),42.5,-62,2.5,0f,0f),
                new Location(Bukkit.getWorld("World"),42.5,-62,46.5,180f,0f))
        );
        Arenas.add(new Arena("Gaming",
                new Location(Bukkit.getWorld("World"),68.5,-58,12.5,0f,0f),
                new Location(Bukkit.getWorld("World"),68.5,-58,35.5,180f,0f))
        );
        Arenas.add(new Arena("Charcoal Shores",
                new Location(Bukkit.getWorld("World"),96.5,-58,2.5,0f,0f),
                new Location(Bukkit.getWorld("World"),96.5,-58,46.5,180f,0f))
        );
        new PlayerJoinListener(this);
        new PlayerClickListener(this);
        new ItemDropListener(this);
        new InventoryInteractListener(this);
        new DeathListener(this);
        new RespawnListener(this);
        new HungerLossListener(this);
        new MovementListener(this);
        new RightClickItemListener(this);

        startRunnable.runTaskTimer(this,0,20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
