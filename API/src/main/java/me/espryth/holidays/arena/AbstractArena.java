package me.espryth.holidays.arena;

import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.arena.game.GameImpl;
import me.espryth.holidays.arena.gift.Gift;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArena implements Arena {

    private final String name;

    private ArenaState state;

    private int minPlayers;
    private int maxPlayers;
    private Location waitLobby;
    private Location playersSpawn;
    private final List<Player> winners;
    private final List<Player> players;
    private final List<Gift> gifts;
    private final Game game;

    public AbstractArena(Plugin plugin, ScoreboardManager scoreboardManager, String name) {
        this.name = name;

        this.minPlayers = 2;
        this.maxPlayers = 8;
        this.waitLobby = null;
        this.playersSpawn = null;
        this.winners = new ArrayList<>();
        this.players = new ArrayList<>();
        this.gifts = new ArrayList<>();

        this.game = new GameImpl(plugin, scoreboardManager, this);

    }

    @Override
    public void restartArena() {

    }

    @Override
    public void declareWinners() {

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
    public List<Player> getWinners() {
        return winners;
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
