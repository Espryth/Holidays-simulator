package me.espryth.holidays.user;

import me.espryth.holidays.user.statistic.IntegerStatistic;

import java.util.UUID;

public class SimpleUser implements User {

    private final UUID uuid;

    private final IntegerStatistic wins;
    private final IntegerStatistic losses;
    private final IntegerStatistic totalGifts;

    public SimpleUser(UUID uuid) {
        this.uuid = uuid;
        this.wins = new IntegerStatistic();
        this.losses = new IntegerStatistic();
        this.totalGifts = new IntegerStatistic();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public IntegerStatistic getWins() {
        return wins;
    }

    @Override
    public IntegerStatistic getLosses() {
        return losses;
    }

    @Override
    public IntegerStatistic getTotalGifts() {
        return totalGifts;
    }

    @Override
    public void load(String key) {

    }

    @Override
    public String getName() {
        return getBukkitPlayer().getName();
    }

}
