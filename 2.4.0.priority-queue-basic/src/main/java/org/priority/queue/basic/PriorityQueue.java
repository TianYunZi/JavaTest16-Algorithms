package org.priority.queue.basic;

import java.util.Stack;

public class PriorityQueue {

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(6);
        pq.insert(9);
        pq.insert(21);
        pq.insert(5);
        pq.insert(3);
        pq.insert(2);
        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }
    }
}
