package me.aleiv.core.paper.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class NinjaListener implements Listener {

    @EventHandler
    public void onShiftClick(PlayerInteractEvent e) {
        var ninja = Ninja.of(e.getPlayer());
        var player = e.getPlayer();
        var inv = new SkillTree();
       // if (ninja.isPlayerShiftClick(e)) {
           // inv.open(player);
            if (!ninja.isPlayerHidden()) {
                ninja.giveInvisibility();
                ninja.giveStrength();
                ninja.giveSpeed();

            } else {
                ninja.removeInvisibility();
                ninja.removeStrength();
            }
        }
    }
}
