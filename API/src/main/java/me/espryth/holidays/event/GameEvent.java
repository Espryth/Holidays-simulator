package me.espryth.holidays.event;

import me.espryth.holidays.arena.game.Game;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Game game;

    public GameEvent(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
