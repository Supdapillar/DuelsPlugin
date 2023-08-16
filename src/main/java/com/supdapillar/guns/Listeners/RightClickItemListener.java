package com.supdapillar.guns.Listeners;

import com.supdapillar.guns.GunPlugin;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.checkerframework.checker.units.qual.Angle;

public class RightClickItemListener implements Listener {

    public RightClickItemListener(GunPlugin plugin)
    {
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }



    @EventHandler
    public void OnRightClickItem(PlayerInteractEvent event){
        boolean rightClickAir = (event.getAction() == Action.RIGHT_CLICK_AIR);
        boolean rightClickBlock = (event.getAction() == Action.RIGHT_CLICK_AIR);

        Player player = event.getPlayer();

        if (!(rightClickAir || rightClickBlock)) return;
        //Levitation book
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (heldItem.getType() == Material.BOOK){
            event.setCancelled(true);

            heldItem.setAmount(heldItem.getAmount()-1);
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL,999, 1);
            player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,25,0,true,false, false));
        }

        //Fire Staff
        if (heldItem.getType() == Material.TORCHFLOWER){
            event.setCancelled(true);
            for(Player targetPlayer : Bukkit.getOnlinePlayers()){
                if (player != targetPlayer){
                    if (player.hasLineOfSight(targetPlayer)){
                        if (player.getLocation().distance(targetPlayer.getLocation()) < 12){
                            targetPlayer.setFireTicks(5);
                            targetPlayer.damage(1);
                            player.playSound(event.getPlayer(), Sound.ITEM_FIRECHARGE_USE,999, 1);
                        }
                    }
                }
            }
        }

    }
}
