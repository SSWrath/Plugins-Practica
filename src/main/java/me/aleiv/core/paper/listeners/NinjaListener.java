package me.aleiv.core.paper.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class NinjaListener implements Listener {
    
    @EventHandler
    public void onShiftClick(PlayerInteractEvent e){
        var ninja = Ninja.of(e.getPlayer());
        if(ninja.isPlayerShiftClick(e)){
            if(!ninja.isPlayerHidden()){
               ninja.giveInvisibility();
            }
            else{
                ninja.removeInvisibility();
            }
        }
    }

    
}
