package me.espryth.holidays.listener;

import me.espryth.holidays.cache.Cache;
import me.espryth.holidays.event.PlayerQuitGameEvent;
import me.espryth.holidays.user.User;
import me.espryth.holidays.user.attributes.AttributesManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import javax.inject.Inject;
import javax.inject.Named;

public class PlayerQuitGameListener implements Listener {

    @Inject private AttributesManager attributesManager;

    @EventHandler
    public void onPlayerQuitGame(PlayerQuitGameEvent event) {

        User user = event.getUser();

        attributesManager.restoreAttributes(user.getBukkitPlayer());

    }
}
