package me.espryth.holidays.arena.game;

import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.arena.ArenaState;
import me.espryth.holidays.arena.game.phase.Phase;
import me.espryth.holidays.arena.game.phase.impl.InGamePhase;
import me.espryth.holidays.arena.game.phase.impl.StartingGamePhase;
import me.espryth.holidays.arena.game.phase.impl.WaitingLobbyPhase;
import me.espryth.holidays.event.PlayerJoinGameEvent;
import me.espryth.holidays.event.PlayerQuitGameEvent;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameImpl implements Game {

    private final List<Phase> phases;
    private final Arena arena;
    private Phase actualPhase;

    private int index;

    public GameImpl(Plugin plugin, ScoreboardManager scoreboardManager,Arena arena) {

        this.arena = arena;
        this.index = 0;
        this.phases = new ArrayList<>(Arrays.asList(
                new WaitingLobbyPhase(plugin, scoreboardManager, this),
                new StartingGamePhase(plugin, scoreboardManager, this),
                new InGamePhase(plugin, scoreboardManager, this)
        ));
    }

    @Override
    public List<Phase> getPhases() {
        return phases;
    }

    @Override
    public Arena getArena() {
        return arena;
    }

    @Override
    public Phase getActualPhase() {
        return actualPhase;
    }

    @Override
    public void nextPhase() {

        index++;

        if (index > phases.size()) {
            endGame();
        }

        actualPhase = phases.get(index);
        actualPhase.startPhase();
    }

    @Override
    public void previousPhase() {

        if (index==0) {
            return;
        }

        index--;

        actualPhase = phases.get(index);
        actualPhase.startPhase();
    }

    @Override
    public int getActualIndex() {
        return index;
    }

    @Override
    public void playerJoin(Player player) {
        arena.getPlayers().add(player);
        Bukkit.getPluginManager().callEvent(new PlayerJoinGameEvent(this, player));
    }

    @Override
    public void playerLeave(Player player) {
        arena.getPlayers().remove(player);
        Bukkit.getPluginManager().callEvent(new PlayerQuitGameEvent(this, player));
    }

    @Override
    public void broadcastToAll(String message) {
        arena.getPlayers().forEach(
                player -> player.sendMessage(message)
        );
    }

    @Override
    public void startGame() {
        arena.setState(ArenaState.STARTING);
        actualPhase.startPhase();
    }

    @Override
    public void endGame(Player... players) {

        arena.setState(ArenaState.RESTARTING);

        index = 0;

        actualPhase.removeAll();
        actualPhase = phases.get(0);

        arena.declareWinners();

        arena.restartArena();

    }
}
