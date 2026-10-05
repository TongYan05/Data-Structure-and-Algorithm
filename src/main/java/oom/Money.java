package oom;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money m)) return false;
        return dollars == m.dollars && cents == m.cents;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(dollars, cents);
    }

    @Override
    public String toString() {
        return String.format("$%d.%02d", dollars, cents);
        // %02d 补零，负号跟着 dollars
    }

    @Override
    public int compareTo(Money o) {
        if (dollars != o.dollars) return Integer.compare(dollars, o.dollars);
        return Integer.compare(cents, o.cents);
        // 不许减法
    }

    static void main(String[] args) {
//        System.out.println(find());

        System.out.println(new Object() instanceof String);
        Object o = "hello";
        if (o instanceof String s) System.out.print(s.length());
        if (o instanceof String s) System.out.print(" again");
        String s = null;
        System.out.println(s instanceof Object);
//        System.out.println(Double instanceof String);
    }

    public static List find() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a random number: ");
        int num = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        if (num == 0) return list;
        list.add(1);
        if (num == 1) return list;
        int i = 2;
        int j = 2;
        int times = 0;
        while (i <= num) {//i<=20
            while (j < i) {//j->2 3 4 5 6... i
                if (i % j == 0) {
                    times++;
                    break;
                }
                j++;
            }
            if (times != 0) {
                times = 0;
                j=2;
                i++;
            }else {
                list.add(i);
                i++;
                j = 2;
            }
        }
        return list;
    }
}