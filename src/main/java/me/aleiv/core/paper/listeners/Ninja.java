package me.aleiv.core.paper.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Ninja {
    Player player;
 
    public void removeInvisibility() {
        player.getActivePotionEffects()
                .stream()
                .filter((effect) -> (effect.getType() == PotionEffectType.INVISIBILITY))
                .forEach(this::removePotionEffect);
    }

    private void removePotionEffect(PotionEffect effect){
        player.removePotionEffect(effect.getType());
    }

    public void giveInvisibility() {
        player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(20 * 5, 0));
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
