package me.aleiv.core.paper.listeners;

import us.jcedeno.libs.rapidinv.RapidInv;
import us.jcedeno.libs.rapidinv.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class SkillTree extends RapidInv {

    private boolean preventClose = false;

    public SkillTree() {
        super(45, ChatColor.GOLD + "SkillTree");

        setItem(22, new ItemStack(Material.BOOK).name("Strength"),
                e -> e.getWhoClicked().sendMessage("+1 Strength Level"));

        setItem(32, new ItemStack(Material.BOOK).name("Speed"), e -> e.getWhoClicked().sendMessage("+1 Speed Level"));

        setItems(getBorders(), new ItemBuilder(Material.STRUCTURE_BLOCK).name(" ").build());

        setItem(34, new ItemBuilder(Material.BARRIER).name(ChatColor.RED + "Prevent close").build(), e -> {
            this.preventClose = !this.preventClose;
        });
        
        setCloseFilter(p -> this.preventClose);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        event.getPlayer().sendMessage(ChatColor.GOLD + "You opened the inventory");
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        event.getPlayer().sendMessage(ChatColor.GOLD + "You closed the inventory");
    }

    @Override
    public void onClick(InventoryClickEvent event) {

    }
}
