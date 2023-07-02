package me.adarsh.playercraftinggui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuListener implements Listener {

    @EventHandler
    public void clickGUI(InventoryClickEvent event){
        if (!(event.getWhoClicked() instanceof Player)){
            return;
        }
        if (event.getClickedInventory() == null)
            return;

        Player p = (Player) event.getWhoClicked();
        Inventory inventory = p.getOpenInventory().getTopInventory();

        if (inventory.getType() != InventoryType.CRAFTING)
            return;

        setItems(inventory);
        ItemStack itemStack = new ItemStack(Material.CARROT_ITEM);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();

        if (itemMeta != null){
            itemMeta.setDisplayName(ChatColor.GREEN + "Hello");
            lore.add(ChatColor.GRAY + "Sends " + ChatColor.AQUA + "hello " + ChatColor.GRAY + "message to player!");
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
        }

        if (event.getCurrentItem().equals(itemStack)){
            Player player = (Player) event.getWhoClicked();
            player.sendMessage(ChatColor.GREEN + "Hello! " + player.getName());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        if (e.getInventory().getType() != InventoryType.CRAFTING)
            return;

        removeItem(e.getInventory());
    }

    private void setItems(Inventory inventory){
        ItemStack itemStack = new ItemStack(Material.CARROT_ITEM);
        ItemMeta itemMeta = itemStack.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();

        if (itemMeta != null){
            itemMeta.setDisplayName(ChatColor.GREEN + "Hello");
            lore.add(ChatColor.GRAY + "Sends " + ChatColor.AQUA + "hello " + ChatColor.GRAY + "message to player!");
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
        }

        inventory.setItem(1, itemStack);
    }

    private void removeItem(Inventory inventory){
        inventory.setItem(1, null);
    }

}
