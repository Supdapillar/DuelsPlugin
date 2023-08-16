package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GunPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class PlayerClickListener implements Listener {

    public PlayerClickListener(GunPlugin plugin){
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }


    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        PlayerInventory playerInventory = player.getInventory();

        if ((event.getAction() == Action.PHYSICAL)) return;
        if (!(playerInventory.getItemInMainHand().getType() == Material.RECOVERY_COMPASS)) return;

        Inventory classPicker = Bukkit.createInventory(player, 9, ChatColor.BOLD + "Class Picker");
        addItemIcon(classPicker, Material.IRON_AXE, ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Warrior");
        addItemIcon(classPicker, Material.CROSSBOW, ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Hunter");
        addItemIcon(classPicker, Material.NETHERITE_CHESTPLATE, ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Tank");
        addItemIcon(classPicker, Material.ENCHANTING_TABLE, ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Mage");

        player.openInventory(classPicker);

    }


    private void addItemIcon(Inventory inv, Material mat, String name){
        ItemStack item = new ItemStack(mat);

        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        item.setItemMeta(itemMeta);


        inv.addItem(item);
    }
}
