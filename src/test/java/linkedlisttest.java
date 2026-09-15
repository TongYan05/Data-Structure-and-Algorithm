import Algorithm.singlelinkedlist;
import org.junit.jupiter.api.Test;

public class linkedlisttest {

    @Test
    public void iteratelinkedlist() throws IllegalAccessException {
        singlelinkedlist linkedlist = new singlelinkedlist();
        for (int i = 0; i < 20; i++) {
            linkedlist.addfirst(i);
        }
        linkedlist.iteratelinkedlist(x -> System.out.print(x + " "));

        System.out.println("\n=======for========");
        linkedlist.forloop();

        System.out.println("\n=======iterator========");//增强for循环底层就是调用迭代器
        for (int x : linkedlist) System.out.print(x + " ");

        System.out.println("\n=======iterator========");
        linkedlist.addlast(50);
        for (int x : linkedlist) System.out.print(x + " ");

        System.out.println("\n=======get========");
        System.out.println(linkedlist.get(0));
        System.out.println(linkedlist.get(3));
//        System.out.println(linkedlist.get(30));


        System.out.println("\n=======insert========");
//        linkedlist.insert(100,2005);
        for (int x : linkedlist) System.out.print(x + " ");


        System.out.println("\n=======removeFirst========");
        linkedlist.removeFirst();
        for (int x : linkedlist) System.out.print(x + " ");


        System.out.println("\n=======removeindex========");
//        linkedlist.removeindex(21);
        for (int x : linkedlist) System.out.print(x + " ");


    }
}
