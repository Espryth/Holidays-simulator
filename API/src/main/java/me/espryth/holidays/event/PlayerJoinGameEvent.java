package me.espryth.holidays.event;

import me.espryth.holidays.arena.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerJoinGameEvent extends GameEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Player player;

    public PlayerJoinGameEvent(Game game, Player player) {
        super(game);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }
}
