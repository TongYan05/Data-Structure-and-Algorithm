package Algorithm;

import java.util.*;

public class Stack {
    static void main(String[] args) {
        //Stack is deque
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= 10; i++) deque.push(i);
        System.out.println(deque.pop());// pop() return the value removed, throw NullPointException
        System.out.println(deque.peek());// peek() return the top value of the Stack
        System.out.println(deque.poll());// pull() return the value removed, return null
        System.out.println("the real time staus: " + deque);

        Deque<Integer> deque1 = new ArrayDeque<>();
        System.out.println(deque1.isEmpty());
        System.out.println(deque1.poll());
        System.out.println(deque1.pop());// NullPointException!!!!! pop pop pop pop pop pop!!!!




        //347. 前 K 个高频元素
        class Solution1 {
            public int[] topKFrequent(int[] nums, int k) {
                Map<Integer,Integer> map=new HashMap<>();
                for(int i : nums){
                    if(map.containsKey(i)){
                        map.put(i,map.get(i)+1);
                    }else{
                        map.put(i,1);
                    }
                }
                PriorityQueue<Integer> p=new PriorityQueue<>((a, b)->map.get(a)-map.get(b));
                for(int x : map.keySet()){
                    if(p.size()<k){// the = will make the size is p.size()+1
                        p.offer(x);
                        continue;
                    }

                    if(map.get(x)>map.get(p.peek())){
                        p.poll();
                        p.offer(x);
                    }

                }

                int[] result=new int[p.size()];
                for(int i=0;i<result.length;i++){
                    result[i]=p.poll();
                }

                return result;

            }
        }








    }
}
