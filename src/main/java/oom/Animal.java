package oom;

public interface Animal {
    public static final String name="Animal";
    default void tostring(){
        System.out.println(name);
    }





}
