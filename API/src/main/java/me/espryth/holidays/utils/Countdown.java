package me.espryth.holidays.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;

public class Countdown implements Runnable {

    private final Plugin plugin;

    private Integer assignedTaskId;

    private final int seconds;

    private int secondsLeft;

    private final Consumer<Countdown> everySecond;

    private final Runnable beforeTimer;

    private final Runnable afterTimer;

    public Countdown(Plugin plugin, int seconds, Runnable beforeTimer, Runnable afterTimer, Consumer<Countdown> everySecond) {
        this.plugin = plugin;
        this.seconds = seconds;
        this.secondsLeft = seconds;
        this.beforeTimer = beforeTimer;
        this.afterTimer = afterTimer;
        this.everySecond = everySecond;
    }

    public void run() {
        if (this.secondsLeft < 1) {
            this.afterTimer.run();
            if (this.assignedTaskId != null)
                Bukkit.getScheduler().cancelTask(this.assignedTaskId);
            return;
        }
        if (this.secondsLeft == this.seconds)
            this.beforeTimer.run();
        this.everySecond.accept(this);
        this.secondsLeft--;
    }

    public void cancelTask() {
        Bukkit.getScheduler().cancelTask(this.assignedTaskId);
    }

    public int getTotalSeconds() {
        return this.seconds;
    }

    public String getSecondsLeft() {
        return Integer.toString(this.secondsLeft);
    }

    public void scheduleTimer() {
        this.assignedTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, this, 0L, 20L);
    }
}
