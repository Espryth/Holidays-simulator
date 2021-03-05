package me.espryth.holidays.user.attributes;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class SavedUserAttributesImpl implements SavedUserAttributes {

    private final UUID uuid;
    private final String name;

    private final ItemStack[] inventoryItems;
    private final ItemStack[] armorItems;
    private final GameMode gameMode;
    private final boolean fly;
    private final double health;
    private final int foodLevel;
    private final float xp;
    private final int level;

    public SavedUserAttributesImpl(Player player) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();
        this.inventoryItems = player.getInventory().getContents();
        this.armorItems = player.getInventory().getArmorContents();
        this.gameMode = player.getGameMode();
        this.fly = player.getAllowFlight();
        this.health = player.getHealth();
        this.foodLevel = player.getFoodLevel();
        this.xp = player.getExp();
        this.level = player.getLevel();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public ItemStack[] getInventoryItems() {
        return inventoryItems;
    }

    @Override
    public ItemStack[] getArmorItems() {
        return armorItems;
    }

    @Override
    public GameMode getGameMode() {
        return gameMode;
    }

    @Override
    public boolean canFly() {
        return fly;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public int getFoodLevel() {
        return foodLevel;
    }


    @Override
    public float getXp() {
        return xp;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getName() {
        return name;
    }
}
