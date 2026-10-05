package oom;
interface Flyer {
    default void move() {
        System.out.print("fly ");
    }
}
interface Speedster {
    default void move() {
        System.out.print("run ");
    }
}
interface Invisible extends Flyer {
    default void vanish() {
        System.out.print("poof ");
    }
}
public class Hero implements Speedster,Invisible {
    public void move(){
        Invisible.super.move();
        Speedster.super.move();
    }
}
