package me.espryth.holidays.listener;

import me.espryth.holidays.scoreboard.PotoScoreboard;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.inject.Inject;
import java.util.Optional;

public class PlayerJoinListener implements Listener {

    @Inject private ScoreboardManager scoreboardManager;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        Optional<PotoScoreboard> scoreboardOptional = scoreboardManager.getCache().find("lobby");

        if(scoreboardOptional.isPresent()) {

            PotoScoreboard scoreboard = scoreboardOptional.get();
            scoreboard.setToPlayer(player);

        }

    }
}
