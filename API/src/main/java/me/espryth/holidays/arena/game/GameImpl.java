package me.espryth.holidays.arena.game;

import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.arena.ArenaState;
import me.espryth.holidays.arena.game.phase.Phase;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {

    private final List<Phase> phases;
    private final Arena arena;
    private Phase actualPhase;

    private int index;

    public GameImpl(Arena arena) {
        this.phases = new ArrayList<>();
        this.arena = arena;
        this.index = 0;
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
    }

    @Override
    public void playerLeave(Player player) {

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
