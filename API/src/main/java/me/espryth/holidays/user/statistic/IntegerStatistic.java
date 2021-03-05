package me.espryth.holidays.user.statistic;

public class IntegerStatistic implements Statistic<Integer> {

    private int value;

    public IntegerStatistic(int value) {
        this.value = value;
    }

    public IntegerStatistic() {
        this(0);
    }

    @Override
    public void increase(Integer value) {
        this.value += value;
    }

    @Override
    public void decrement(Integer value) {
        this.value -= value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
