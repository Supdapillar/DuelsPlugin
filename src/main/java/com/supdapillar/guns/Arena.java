package com.supdapillar.guns;

import org.bukkit.Location;

public class Arena {
    public Location spawnOne;
    public Location spawnTwo;
    public String arenaName;

    public Arena(String name,Location s1, Location s2){
        spawnOne = s1;
        spawnTwo = s2;
        arenaName = name;
    }

}
