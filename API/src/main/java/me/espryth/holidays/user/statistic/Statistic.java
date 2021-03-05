package me.espryth.holidays.user.statistic;

public interface Statistic<T extends Number> {
    void increase(T value);

    void decrement(T value);

    T getValue();

    void setValue(T value);
}
