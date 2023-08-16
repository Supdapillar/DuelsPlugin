package com.supdapillar.guns;

import com.supdapillar.guns.Listeners.PlayerJoinListener;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class PlayerClass {
    public static void givePlayerClassItems(Player player, Classes classes){
        List<ItemStack> classItems = new ArrayList<>();
        switch(classes){
            case Warrior:
                player.getInventory().clear();
                classItems.add(new ItemStack(Material.CHAINMAIL_HELMET));
                classItems.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                classItems.add(new ItemStack(Material.IRON_LEGGINGS));
                classItems.add(new ItemStack(Material.IRON_BOOTS));
                classItems.add(new ItemStack(Material.IRON_AXE));
                classItems.add(new ItemStack(Material.SHIELD));
                classItems.add(new ItemStack(Material.GOLDEN_APPLE,3));
                break;
            case Hunter:
                player.getInventory().clear();
                classItems.add(new ItemStack(Material.CHAINMAIL_HELMET));
                classItems.add(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                classItems.add(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                classItems.add(new ItemStack(Material.CHAINMAIL_BOOTS));
                classItems.add(new ItemStack(Material.CROSSBOW));
                classItems.add(new ItemStack(Material.BOW));
                classItems.add(new ItemStack(Material.ARROW,16));
                classItems.add(new ItemStack(Material.IRON_SWORD));
                classItems.add(new ItemStack(Material.GOLDEN_APPLE,3));
                break;
            case Tank:
                player.getInventory().clear();
                classItems.add(new ItemStack(Material.IRON_HELMET));
                classItems.add(new ItemStack(Material.DIAMOND_CHESTPLATE));
                classItems.add(new ItemStack(Material.IRON_LEGGINGS));
                classItems.add(new ItemStack(Material.IRON_BOOTS));
                classItems.add(new ItemStack(Material.STONE_SWORD));
                classItems.add(new ItemStack(Material.GOLDEN_APPLE,3));
                break;
            case Mage:
                player.getInventory().clear();
                classItems.add(new ItemStack(Material.TURTLE_HELMET));
                classItems.add(new ItemStack(Material.GOLDEN_CHESTPLATE));
                classItems.add(new ItemStack(Material.GOLDEN_LEGGINGS));
                classItems.add(new ItemStack(Material.GOLDEN_BOOTS));
                classItems.add(new ItemStack(Material.WOODEN_AXE));
;
                ItemStack fireStaff = new ItemStack(Material.TORCHFLOWER);
                ItemMeta fsMeta = fireStaff.getItemMeta();
                fsMeta.setDisplayName("Fire Staff");
                fireStaff.setItemMeta(fsMeta);

                ItemStack levitationBook = new ItemStack(Material.BOOK,3);
                ItemMeta lbMeta = levitationBook.getItemMeta();
                lbMeta.setDisplayName("Levitation Spell");
                lbMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true);
                lbMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                levitationBook.setItemMeta(lbMeta);

                classItems.add(fireStaff);
                classItems.add(levitationBook);

                classItems.add(new ItemStack(Material.GOLDEN_APPLE,3));
                break;
        }

        PlayerJoinListener.GiveCompass(player);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9999, 1f);
        for (ItemStack itemStack : classItems){
            player.getInventory().addItem(itemStack);
        }
    }

    public static Classes returnRandomClass(){
        double randomvalue = Math.random();
        if (randomvalue > 0.66){
            return Classes.Warrior;
        }
        else if (randomvalue > 0.33)
        {
            return Classes.Hunter;
        }
        else {
            return Classes.Tank;

        }
    }

}
