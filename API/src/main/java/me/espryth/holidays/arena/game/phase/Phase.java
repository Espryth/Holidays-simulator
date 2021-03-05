package me.espryth.holidays.arena.game.phase;

import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.event.Listener;

public interface Phase extends Listener {
    void onStart();

    void update();

    void onEnd();

    void removeAll();

    void startPhase();

    void endPhase();

    int getTaskId();

    Game getGame();

    ScoreboardManager getScoreboardManager();
}
