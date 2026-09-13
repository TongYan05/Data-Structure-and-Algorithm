import Algorithm.circlelinkedlist;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class circlelinkedlisttest {

    @Test
    @Order(1)
    public void addFirst() {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addFirst(i);
        for (int x : c) System.out.print(x + " ");
        System.out.println();
    }

    @Test
    @Order(2)
    public void addLast() {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addLast(i);
        for (int x : c) System.out.print(x + " ");
        System.out.println();
    }

    @Test
    @Order(3)
    public void removeFirst() throws IllegalAccessException {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addLast(i);
        System.out.println("before remove first");
        for (int x : c) System.out.print(x + " ");
        c.removeFirst();
        System.out.println("\nafter remove first");
        for (int x : c) System.out.print(x + " ");
        System.out.println();
    }

    @Test
    @Order(4)
    public void removeLast() throws IllegalAccessException {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addLast(i);
        System.out.println("before remove last");
        for (int x : c) System.out.print(x + " ");
        c.removeLast();
        System.out.println("\nafter remove last");
        for (int x : c) System.out.print(x + " ");
        System.out.println();
    }

    @Test
    @Order(5)
    public void removeByValue() throws IllegalAccessException {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addLast(i);
        System.out.println("before remove 10");
        for (int x : c) System.out.print(x + " ");
        c.removeByValue(10);
        System.out.println("\nafter remove 10");
        for (int x : c) System.out.print(x + " ");
        System.out.println();
    }

    @Test
    @Order(6)
    public void findByValue() throws IllegalAccessException {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addLast(i);
        System.out.println("before find 10");
        for (int x : c) System.out.print(x + " ");
        System.out.println("print the Node: \n" + c.findByValue(10));
    }

    @Test
    @Order(7)
    public void recursion() throws IllegalAccessException {
        circlelinkedlist c = new circlelinkedlist();
        for (int i = 0; i < 20; i++) c.addLast(i);
        System.out.println("recursion");
        c.recursion(c.getSentinelNext());
    }
}
