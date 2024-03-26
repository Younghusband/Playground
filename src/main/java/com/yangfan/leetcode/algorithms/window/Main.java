package com.yangfan.leetcode.algorithms.window;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();

//        queue.offer(1);
//        queue.offerLast(2);
//        queue.offerLast(3);


        queue.add(1);
        queue.add(2);
        queue.add(3);

//        queue.pollLast();
        System.out.println(queue.peek());
        System.out.println(queue.peekLast());

//        queue.pop();
//        queue.poll();
//        queue.pollLast();

        System.out.println(queue);



    }

}
