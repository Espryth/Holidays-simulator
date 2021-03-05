package me.espryth.holidays.arena.game.phase.impl;

import me.espryth.holidays.arena.ArenaState;
import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import me.espryth.holidays.utils.Countdown;
import org.bukkit.plugin.Plugin;

public class StartingGamePhase extends GamePhase {

    private final Plugin plugin;

    public StartingGamePhase(Plugin plugin, ScoreboardManager scoreboardManager, Game game) {
        super(plugin, scoreboardManager, game);
        this.plugin = plugin;
    }

    @Override
    public void onStart() {

        getGame().getArena().setState(ArenaState.STARTING);

        Countdown countdown = new Countdown(plugin, 10,
            () ->
                getGame().broadcastToAll("el juego esta comenzando!"),
            () ->
                getGame().nextPhase(),
            task -> {
                if(getGame().getArena().getPlayers().size() < getGame().getArena().getMinPlayers()) {
                    task.cancelTask();
                    getGame().previousPhase();
                    return;
                }
                getGame().broadcastToAll(task.getSecondsLeft());
            }

        );

        countdown.scheduleTimer();
    }

    @Override
    public void update() {

    }

    @Override
    public void onEnd() {
        getGame().broadcastToAll("Se ha cancelado el inicio!");
    }
}
