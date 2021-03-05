package me.espryth.holidays.arena.game.phase;

import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

public abstract class AbstractPhase implements Phase{

    private final Game game;
    private final Plugin plugin;
    private int taskId;

    private ScoreboardManager scoreboardManager;

    public AbstractPhase(Plugin plugin, ScoreboardManager scoreboardManager, Game game) {
        this.plugin = plugin;
        this.scoreboardManager = scoreboardManager;
        this.game = game;
    }

    @Override
    public abstract void onStart();

    @Override
    public abstract void update();

    @Override
    public abstract void onEnd();

    @Override
    public void removeAll() {
        Bukkit.getScheduler().cancelTask(taskId);
        HandlerList.unregisterAll(this);
    }

    @Override
    public void startPhase() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this::update, 0L, 20L);
        onStart();
    }

    @Override
    public void endPhase() {
        onEnd();
        removeAll();
        game.nextPhase();
    }

    @Override
    public int getTaskId() {
        return taskId;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
}
