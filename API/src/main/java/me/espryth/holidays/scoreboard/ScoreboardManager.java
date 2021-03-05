package me.espryth.holidays.scoreboard;

import me.espryth.holidays.cache.Cache;

public interface ScoreboardManager {

    Cache<PotoScoreboard> getCache();

    void register(PotoScoreboard scoreboard);

    default void register(PotoScoreboard... scoreboards) {
        for (PotoScoreboard scoreboard : scoreboards) {
            register(scoreboard);
        }
    }

}
