package me.espryth.holidays.cache;

import me.espryth.holidays.Nameable;

import java.util.Map;
import java.util.Optional;

public interface Cache<T extends Nameable> {
    Map<String, T> get();

    default Optional<T> find(String key) {
        return Optional.ofNullable(get().get(key));
    }
}
