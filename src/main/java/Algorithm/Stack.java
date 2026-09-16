package Algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

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
    }
}
