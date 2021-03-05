package me.espryth.holidays.user.attributes;

import me.espryth.holidays.cache.Cache;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.inject.Inject;
import javax.inject.Named;

public class AttributesManagerImpl implements AttributesManager {

    @Inject @Named("saved-attributes") private Cache<SavedUserAttributes> attributesCache;

    @Override
    public void saveAttributes(Player player) {
        SavedUserAttributes attributes = new SavedUserAttributesImpl(player);
        attributesCache.get().put(player.getUniqueId().toString(), attributes);
        clearInventory(player);
    }

    @Override
    public void restoreAttributes(Player player) {

        attributesCache.find(player.getUniqueId().toString()).ifPresent(attributes -> {

            player.getInventory().setContents(attributes.getInventoryItems());
            player.getInventory().setArmorContents(attributes.getArmorItems());
            player.setGameMode(attributes.getGameMode());
            player.setAllowFlight(attributes.canFly());
            player.setHealth(attributes.getHealth());
            player.setFoodLevel(attributes.getFoodLevel());
            player.setExp(attributes.getXp());
            player.setLevel(attributes.getLevel());

        });

    }

    @Override
    public void clearInventory(Player player) {

        player.getInventory().clear();
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
        player.getInventory().setChestplate(new ItemStack(Material.AIR));
        player.getInventory().setLeggings(new ItemStack(Material.AIR));
        player.getInventory().setBoots(new ItemStack(Material.AIR));

    }
}
