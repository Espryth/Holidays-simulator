package me.espryth.holidays.scoreboard;

import me.espryth.holidays.cache.Cache;
import me.espryth.holidays.cache.CacheImpl;

public class ScoreboardManagerImpl implements ScoreboardManager {

    private final Cache<PotoScoreboard> cache = new CacheImpl<>();

    @Override
    public Cache<PotoScoreboard> getCache() {
        return cache;
    }

    @Override
    public void register(PotoScoreboard scoreboard) {
        this.cache.get().put(scoreboard.getName(), scoreboard);
    }
}
