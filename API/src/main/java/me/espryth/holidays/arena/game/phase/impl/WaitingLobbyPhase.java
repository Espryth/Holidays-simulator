package me.espryth.holidays.arena.game.phase.impl;

import me.espryth.holidays.arena.ArenaState;
import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.scoreboard.PotoScoreboard;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.plugin.Plugin;

import java.util.Optional;

public class WaitingLobbyPhase extends GamePhase {

    private PotoScoreboard scoreboard;

    public WaitingLobbyPhase(Plugin plugin, ScoreboardManager scoreboardManager, Game game) {
        super(plugin, scoreboardManager, game);
    }

    @Override
    public void onStart() {
        getGame().getArena().setState(ArenaState.WAITING);

        Optional<PotoScoreboard> scoreboardOptional = getScoreboardManager().getCache().find("wait-lobby");

        scoreboardOptional.ifPresent(potoScoreboard -> scoreboard = potoScoreboard);

        getGame().getArena().getPlayers().forEach(player -> scoreboard.setToPlayer(player));

    }

    @Override
    public void update() {
        if(getGame().getArena().getPlayers().size() >= getGame().getArena().getMinPlayers()) {
            endPhase();
        }

        getGame().getArena().getPlayers().forEach(player -> scoreboard.update(player, false));

    }

    @Override
    public void onEnd() {

    }
}
