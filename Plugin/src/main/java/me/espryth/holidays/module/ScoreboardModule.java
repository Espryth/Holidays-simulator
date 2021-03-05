package me.espryth.holidays.module;

import me.espryth.holidays.scoreboard.ScoreboardManager;
import me.espryth.holidays.scoreboard.ScoreboardManagerImpl;
import me.yushust.inject.AbstractModule;

public class ScoreboardModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ScoreboardManager.class).to(ScoreboardManagerImpl.class);
    }
}
