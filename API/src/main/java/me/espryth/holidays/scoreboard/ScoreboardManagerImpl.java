package me.espryth.holidays.scoreboard;

import me.espryth.holidays.cache.Cache;

import javax.inject.Inject;
import javax.inject.Named;

public class ScoreboardManagerImpl implements ScoreboardManager {

    @Inject @Named("scoreboard") private Cache<PotoScoreboard> scoreboardCache;

    @Override
    public Cache<PotoScoreboard> getCache() {
        return scoreboardCache;
    }

    @Override
    public void register(PotoScoreboard scoreboard) {
        scoreboardCache.get().put(scoreboard.getName(), scoreboard);
    }
}
