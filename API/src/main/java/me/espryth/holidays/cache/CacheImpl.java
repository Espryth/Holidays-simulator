package me.espryth.holidays.cache;

import me.espryth.holidays.Nameable;

import java.util.HashMap;
import java.util.Map;

public class CacheImpl<T extends Nameable> implements Cache<T>{

    public final Map<String, T> cacheMap = new HashMap<>();

    @Override
    public Map<String, T> get() {
        return cacheMap;
    }
}
