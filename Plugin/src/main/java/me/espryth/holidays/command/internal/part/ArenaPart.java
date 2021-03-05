package me.espryth.holidays.command.internal.part;

import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.cache.Cache;
import me.fixeddev.commandflow.CommandContext;
import me.fixeddev.commandflow.exception.ArgumentParseException;
import me.fixeddev.commandflow.part.ArgumentPart;
import me.fixeddev.commandflow.stack.ArgumentStack;
import net.kyori.text.TranslatableComponent;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ArenaPart implements ArgumentPart {

    private final String name;

    private final Cache<Arena> arenaCache;

    public ArenaPart(String name, Cache<Arena> arenaCache) {
        this.name = name;
        this.arenaCache = arenaCache;
    }

    @Override
    public List<Arena> parseValue(CommandContext context, ArgumentStack stack) throws ArgumentParseException {

        Arena arena = arenaCache.find(stack.next()).orElseThrow(()
                -> new ArgumentParseException(TranslatableComponent.of("unknown.arena")).setArgument(this)
        );

        return Collections.singletonList(arena);
    }

    @Override
    public Type getType() {
        return Arena.class;
    }

    @Override
    public String getName() {
        return name;
    }
}
