package me.espryth.holidays.arena;

import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.arena.gift.Gift;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class AbstractArena implements Arena {

    private String name;

    private ArenaState state;

    private int minPlayers;
    private int maxPlayers;
    private Location waitLobby;
    private Location playersSpawn;
    private List<Player> players;
    private List<Gift> gifts;
    private Game game;

    public AbstractArena() {

    }


    @Override
    public ArenaState getState() {
        return state;
    }

    @Override
    public void setState(ArenaState state) {
        this.state = state;
    }

    @Override
    public int getMinPlayers() {
        return minPlayers;
    }

    @Override
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    @Override
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Override
    public Location getWaitLobby() {
        return waitLobby;
    }

    @Override
    public void setWaitLobby(Location waitLobby) {
        this.waitLobby = waitLobby;
    }

    @Override
    public Location getPlayersSpawn() {
        return playersSpawn;
    }

    @Override
    public void setPlayersSpawn(Location playersSpawn) {
        this.playersSpawn = playersSpawn;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public List<Gift> getGifts() {
        return gifts;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void load(String key) {

    }

    @Override
    public String getName() {
        return name;
    }

}
