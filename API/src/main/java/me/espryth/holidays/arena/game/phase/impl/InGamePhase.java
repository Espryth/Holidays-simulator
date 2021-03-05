package me.espryth.holidays.arena.game.phase.impl;

import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.scoreboard.PotoScoreboard;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import java.util.Optional;

public class InGamePhase extends GamePhase {

    private PotoScoreboard scoreboard;

    public InGamePhase(Plugin plugin, ScoreboardManager scoreboardManager, Game game) {
        super(plugin, scoreboardManager, game);
    }

    @Override
    public void onStart() {

        Optional<PotoScoreboard> scoreboardOptional = getScoreboardManager().getCache().find("in-game");

        scoreboardOptional.ifPresent(potoScoreboard -> scoreboard = potoScoreboard);

        getGame().getArena().getPlayers().forEach(player -> scoreboard.setToPlayer(player));

    }

    @Override
    public void update() {
        getGame().getArena().getPlayers().forEach(player -> scoreboard.update(player, false));
    }

    @Override
    public void onEnd() {
        Optional<PotoScoreboard> scoreboardOptional = getScoreboardManager().getCache().find("lobby");

        scoreboardOptional.ifPresent(potoScoreboard -> scoreboard = potoScoreboard);

        getGame().getArena().getPlayers().forEach(player -> scoreboard.setToPlayer(player));
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

    }
}
