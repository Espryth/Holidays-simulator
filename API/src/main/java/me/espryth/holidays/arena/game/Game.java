package me.espryth.holidays.arena.game;

import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.arena.game.phase.Phase;
import org.bukkit.entity.Player;

import java.util.List;

public interface Game {

    List<Phase> getPhases();

    Arena getArena();

    Phase getActualPhase();

    void nextPhase();

    void previousPhase();

    int getActualIndex();

    void playerJoin(Player player);

    void playerLeave(Player player);

    void broadcastToAll(String message);

    void startGame();

    void endGame(Player... players);

}
