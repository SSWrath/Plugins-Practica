package me.aleiv.core.paper.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.aleiv.core.paper.Core;

@Data
@AllArgsConstructor(staticName = "of")
public class Ninja {
    Player player;

    public void removeStrength() {
        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        player.sendMessage(Core.getMiniMessage().parse("<rainbow>Ninja mode disable."));
    }

    public void giveSpeed() {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false))
    }

    public void giveStrength() {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));
    }

    public void removeInvisibility() {
        player.removePotionEffect(PotionEffectType.INVISIBILITY);
        player.sendMessage(Core.getMiniMessage().parse("<rainbow>Ninja mode disable."));
    }

    public void giveInvisibility() {
        player.sendMessage(Core.getMiniMessage().parse("<rainbow>Ninja mode enabled."));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0, false, false));
    }

    public boolean isPlayerHidden() {
        return player.hasPotionEffect(PotionEffectType.INVISIBILITY);
    }

    public boolean isPlayerShiftClick(PlayerInteractEvent e) {
        var action = e.getAction();
        switch (action) {
        case RIGHT_CLICK_BLOCK:
        case LEFT_CLICK_BLOCK:
        case RIGHT_CLICK_AIR:
        case LEFT_CLICK_AIR:
            return player.isSneaking();
        default:
            return false;
        }
    }

}
