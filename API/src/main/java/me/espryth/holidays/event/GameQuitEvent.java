package me.espryth.holidays.event;

import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.user.User;
import org.bukkit.event.HandlerList;

public class GameQuitEvent extends GameEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final User user;

    public GameQuitEvent(Game game, User user) {
        super(game);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
