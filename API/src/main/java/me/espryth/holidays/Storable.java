package me.espryth.holidays;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

public interface Storable extends Nameable, ConfigurationSerializable {
    void load(String key);
}
