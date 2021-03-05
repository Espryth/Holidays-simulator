package me.espryth.holidays.scoreboard;

import me.espryth.holidays.Nameable;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;

public interface PotoScoreboard extends Nameable {

    void setToPlayer(Player player);

    void setDefaults();

    void update(Player player, boolean placeholderApi);

    String getTitle();

    List<ScoreboardLine> getLines();

    Scoreboard getLinkedScoreboard();

    interface Builder {

        Builder name(String name);

        Builder title(String title);

        Builder addLine(ScoreboardLine line);

        Builder addLine(String name, String text, int score);

        Builder addLines(List<ScoreboardLine> lines);

        Builder scoreboard(Scoreboard scoreboard);

        PotoScoreboard build();
    }
}