package me.espryth.holidays.listener;

import me.espryth.holidays.cache.Cache;
import me.espryth.holidays.event.PlayerJoinGameEvent;
import me.espryth.holidays.user.User;
import me.espryth.holidays.user.attributes.AttributesManager;
import me.espryth.holidays.user.attributes.SavedUserAttributes;
import me.espryth.holidays.user.attributes.SavedUserAttributesImpl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import javax.inject.Inject;
import javax.inject.Named;

public class PlayerJoinGameListener implements Listener {

    @Inject private AttributesManager attributesManager;

    @EventHandler
    public void onPlayerJoinGame(PlayerJoinGameEvent event) {

        User user = event.getUser();

        attributesManager.saveAttributes(user.getBukkitPlayer());

    }
}
