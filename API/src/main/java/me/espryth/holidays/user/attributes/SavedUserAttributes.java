package me.espryth.holidays.user.attributes;

import me.espryth.holidays.Nameable;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public interface SavedUserAttributes extends Nameable {

    UUID getUUID();

    ItemStack[] getInventoryItems();

    ItemStack[] getArmorItems();

    GameMode getGameMode();

    boolean canFly();

    double getHealth();

    int getFoodLevel();

    float getXp();

    int getLevel();



}
