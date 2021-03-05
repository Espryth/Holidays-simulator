package me.espryth.holidays.loader;

import me.espryth.holidays.file.YamlFile;
import me.espryth.holidays.scoreboard.PotoScoreboard;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import me.espryth.holidays.scoreboard.SimplePotoScoreboard;
import org.bukkit.Bukkit;

import javax.inject.Inject;
import javax.inject.Named;

public class ScoreboardLoader implements Loader{

    @Inject private ScoreboardManager scoreboardManager;
    @Inject @Named("config") private YamlFile config;

    @Override
    public void load() {

        scoreboardManager.register(
                createScoreboard("lobby"),
                createScoreboard("wait-lobby"),
                createScoreboard("in-game")
        );

    }

    private PotoScoreboard createScoreboard(String path) {

        PotoScoreboard.Builder builder = new SimplePotoScoreboard.Builder()
                .name(path)
                .title(config.getString("scoreboard." + path + ".title"));

        for(String key : config.getConfigurationSection("scoreboard." + path + ".lines").getKeys(false)) {
            builder.addLine(key, config.getString("scoreboard." + path + ".lines." + key), Integer.parseInt(key));
        }

        builder.scoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        return builder.build();
    }
}
