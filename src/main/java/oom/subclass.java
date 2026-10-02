package oom;

import javax.lang.model.element.Name;

public class subclass extends superclass{
    private String name="yantong";
    @Override
    void printLength(){
        System.out.println(name.length());
    }
}
