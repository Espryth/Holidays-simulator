package me.espryth.holidays.module;

import me.espryth.holidays.arena.Arena;
import me.espryth.holidays.cache.Cache;
import me.espryth.holidays.cache.CacheImpl;
import me.espryth.holidays.scoreboard.PotoScoreboard;
import me.espryth.holidays.user.User;
import me.espryth.holidays.user.attributes.SavedUserAttributes;
import me.yushust.inject.AbstractModule;
import me.yushust.inject.key.TypeReference;

public class CacheModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TypeReference.of(Cache.class, User.class)).named("user").to(CacheImpl.class);
        bind(TypeReference.of(Cache.class, Arena.class)).named("arena").to(CacheImpl.class);
        bind(TypeReference.of(Cache.class, PotoScoreboard.class)).named("scoreboard").to(CacheImpl.class);
        bind(TypeReference.of(Cache.class, SavedUserAttributes.class)).named("saved-attributes").to(CacheImpl.class);
    }
}
