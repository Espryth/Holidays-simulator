package me.espryth.holidays.arena;

import me.espryth.holidays.Storable;
import me.espryth.holidays.arena.game.Game;
import me.espryth.holidays.arena.gift.Gift;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;

public interface Arena extends Storable {

    void restartArena();

    void declareWinners();

    ArenaState getState();

    void setState(ArenaState state);

    int getMinPlayers();

    void setMinPlayers(int minPlayers);

    int getMaxPlayers();

    void setMaxPlayers(int maxPlayers);

    Location getWaitLobby();

    void setWaitLobby(Location waitLobby);

    Location getPlayersSpawn();

    void setPlayersSpawn(Location playersSpawn);

    List<Player> getWinners();

    List<Player> getPlayers();

    List<Gift> getGifts();

    Game getGame();

    @Override
    default Map<String, Object> serialize() {
        return null;
    }
}
