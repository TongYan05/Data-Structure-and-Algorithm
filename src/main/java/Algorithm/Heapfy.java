package Algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Heapfy {
    static void main(String[] args) {
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());//Collections.reverseOrder()
        p.add(5);
        p.add(2);
        p.add(1);
        p.add(3);
        System.out.println(p.remove(3));
        System.out.println(p);

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.containsKey(1)+" "+ map.containsValue("python"));
    }
}
