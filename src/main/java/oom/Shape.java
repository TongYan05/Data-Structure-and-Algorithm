package oom;

public abstract class Shape {
    protected String name;
    abstract double perimeter();
    abstract double area();
    String summary(){
        return "Shape{"+name+", area="+area()+", perimeter="+perimeter()+"}";
    }
}
