package me.espryth.holidays.user.attributes;

import org.bukkit.entity.Player;

public interface AttributesManager {

    void saveAttributes(Player player);

    void restoreAttributes(Player player);

    void clearInventory(Player player);

}
