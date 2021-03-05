package me.espryth.holidays.command.internal.part.factory;

import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.cache.Cache;
import me.espryth.holidays.command.internal.part.ArenaPart;
import me.fixeddev.commandflow.annotated.part.PartFactory;
import me.fixeddev.commandflow.part.CommandPart;

import java.lang.annotation.Annotation;
import java.util.List;

public class ArenaPartFactory implements PartFactory {

    private final Cache<Arena> arenaCache;

    public ArenaPartFactory(Cache<Arena> arenaCache) {
        this.arenaCache = arenaCache;
    }

    @Override
    public CommandPart createPart(String name, List<? extends Annotation> list) {
        return new ArenaPart(name, arenaCache);
    }
}
