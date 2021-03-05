package me.espryth.holidays.command.subcommand;

import me.espryth.holidays.HolidaysSimulator;
import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.arena.ArenaState;
import me.espryth.holidays.arena.SimpleArena;
import me.espryth.holidays.cache.Cache;
import me.espryth.holidays.scoreboard.ScoreboardManager;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import javax.inject.Named;

@Command(
        names = "arena"
)
public class ArenaSubCommand implements CommandClass {

    @Inject @Named("arena") private Cache<Arena> arenaCache;
    @Inject private HolidaysSimulator plugin;
    @Inject private ScoreboardManager scoreboardManager;

    @Command(names = "")
    public void runArenaCommand() {

    }

    @Command(names = "create")
    public void runArenaCreateCommand(@Sender Player sender, String name) {

        if(arenaCache.find(name).isPresent()) {
            sender.sendMessage("ya existe esa arena");
            return;
        }

        Arena arena = new SimpleArena(plugin, scoreboardManager, name);

        arenaCache.get().put(name, arena);

    }

    @Command(names = "delete")
    public void runArenaDeleteCommand(@Sender Player sender, Arena arena) {

        arenaCache.get().remove(arena.getName());

        sender.sendMessage("has eliminado la arena " + arena.getName());

    }

    @Command(names = "setmin")
    public void runArenaSetMinCommand(@Sender Player sender, Arena arena, Integer min) {
        arena.setMinPlayers(min);
        sender.sendMessage("min");
    }

    @Command(names = "setmax")
    public void runArenaSetMaxCommand(@Sender Player sender, Arena arena, Integer max) {
        arena.setMaxPlayers(max);
        sender.sendMessage("Max");
    }

    @Command(names = "setwaitlobby")
    public void runArenaSetWaitLobbyCommand(@Sender Player sender, Arena arena) {
        arena.setWaitLobby(sender.getLocation());
        sender.sendMessage("Has colocado el wait lobby");
    }

    @Command(names = "setplayersspawn")
    public void runArenaSetPlayerSpawnCommand(@Sender Player sender, Arena arena) {
        arena.setPlayersSpawn(sender.getLocation());
        sender.sendMessage("Spawn colocado");
    }

}
