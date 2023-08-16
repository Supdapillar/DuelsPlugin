package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.Classes;
import com.supdapillar.guns.GunPlugin;
import com.supdapillar.guns.PlayerClass;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryInteractListener implements Listener {


    GunPlugin mainPlugin;
    public InventoryInteractListener(GunPlugin plugin){
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
        mainPlugin = plugin;
    }

    @EventHandler
    public void InventoryInteract(InventoryClickEvent event){
        if (!(event.getView().getTitle().equals(ChatColor.BOLD + "Class Picker"))) return;
        if (event.getCurrentItem() == null) return;
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        switch ((event.getCurrentItem()).getType()){
            case IRON_AXE:
                if (mainPlugin.playerClasses.containsKey(player))
                {
                    mainPlugin.playerClasses.replace(player,Classes.Warrior);
                }
                else
                {
                    mainPlugin.playerClasses.put(player,Classes.Warrior);
                }
                PlayerClass.givePlayerClassItems(player, Classes.Warrior);
                break;
            case CROSSBOW:
                if (mainPlugin.playerClasses.containsKey(player))
                {
                    mainPlugin.playerClasses.replace(player,Classes.Hunter);
                }
                else
                {
                    mainPlugin.playerClasses.put(player,Classes.Hunter);
                }
                PlayerClass.givePlayerClassItems(player, Classes.Hunter);
                break;
            case NETHERITE_CHESTPLATE:
                if (mainPlugin.playerClasses.containsKey(player))
                {
                    mainPlugin.playerClasses.replace(player,Classes.Tank);
                }
                else
                {
                    mainPlugin.playerClasses.put(player,Classes.Tank);
                }
                PlayerClass.givePlayerClassItems(player, Classes.Tank);
                break;
            case ENCHANTING_TABLE:
                if (mainPlugin.playerClasses.containsKey(player))
                {
                    mainPlugin.playerClasses.replace(player,Classes.Mage);
                }
                else
                {
                    mainPlugin.playerClasses.put(player,Classes.Mage);
                }
                PlayerClass.givePlayerClassItems(player, Classes.Mage);
                break;
        }
    }
}
