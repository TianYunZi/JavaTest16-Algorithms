package org.priority.queue.multiple.merge;

import org.priority.queue.basic.MaxPQ;

/**
 * 使用优先队列的多项归并
 */
public class MultiWay {

    public static void merge(Comparable[] a) {
        int N = a.length;
        MaxPQ<Integer> pq = new MaxPQ<>(N);
        for (int i = 0; i < N; i++) {
            if (a[i] != null) {
                pq.insert((Integer) a[i]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = {9, 1, 6, 3, 2, 5, 4, 11, 13, 21};
        merge(arr);
    }
}
