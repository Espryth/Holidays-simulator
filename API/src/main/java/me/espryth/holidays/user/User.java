package me.espryth.holidays.user;

import me.espryth.holidays.Storable;
import me.espryth.holidays.user.statistic.IntegerStatistic;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

public interface User extends Storable {
    UUID getUUID();

    IntegerStatistic getWins();

    IntegerStatistic getLosses();

    IntegerStatistic getTotalGifts();

    default Player getBukkitPlayer() {
        return Bukkit.getPlayer(getUUID());
    }

    default void sendMessage(String message) {
        getBukkitPlayer().sendMessage(message);
    }

    @Override
    default @NotNull Map<String, Object> serialize() {
        return null;
    }
}
