package oom;

public class Money implements Comparable<Money> {
    private final int dollars;
    private final int cents;
    public Money(int dollars, int cents) {
        int extra = Math.floorDiv(cents, 100);
        // -5 → -1；105 → 1
        this.cents = Math.floorMod(cents, 100);
        // -5 → 95；105 → 5
        this.dollars = dollars + extra;
    }
    public int getDollars() {
        return dollars;
    }
    public int getCents() {
        return cents;
    }
    public boolean isPositive() {
        return dollars > 0 || (dollars == 0 && cents > 0);
    }
    @Override public boolean equals(Object o) {
        if (!(o instanceof Money m)) return false;
        return dollars == m.dollars && cents == m.cents;
    }
    @Override public int hashCode() {
        return java.util.Objects.hash(dollars, cents);
    }
    @Override public String toString() {
        return String.format("$%d.%02d", dollars, cents);
        // %02d 补零，负号跟着 dollars
    }
    @Override public int compareTo(Money o) {
        if (dollars != o.dollars) return Integer.compare(dollars, o.dollars);
        return Integer.compare(cents, o.cents);
        // 不许减法
    }
}